import curses
import subprocess
import sys
import os

class GitTUI:
    def __init__(self, stdscr):
        self.stdscr = stdscr
        self.window_height, self.window_width = self.stdscr.getmaxyx()
        self.status = "Ready"
        self.history = []
        self.max_history = 20
        self.history_index = -1

        # Detect current branch
        self.current_branch = self._run_git_command(["rev-parse", "--abbrev-ref", "HEAD"]) or "unknown"

        # Curses setup
        curses.curs_set(1)
        curses.noecho()
        curses.start_color()
        curses.init_pair(1, curses.COLOR_BLACK, curses.COLOR_CYAN)  # status bar
        curses.init_pair(2, curses.COLOR_GREEN, curses.COLOR_BLACK)  # input
        curses.init_pair(3, curses.COLOR_YELLOW, curses.COLOR_BLACK)  # output/errors

        # Create windows
        self.status_win = curses.newwin(1, self.window_width, self.window_height - 1, 0)
        self.input_win = curses.newwin(1, self.window_width, self.window_height - 2, 0)
        self.output_win = curses.newwin(self.window_height - 2, self.window_width, 0, 0)

        # Initial draw
        self._update_status()
        self.output_win.scrollok(True)
        self.output_win.idlok(True)

    def _update_status(self):
        self.status_win.clear()
        status_str = f"Branch: {self.current_branch} | Status: {self.status}"
        self.status_win.addstr(0, 0, status_str[:self.window_width - 1], curses.color_pair(1))
        self.status_win.refresh()

    def _run_git_command(self, command):
        try:
            result = subprocess.run(
                ["git"] + command,
                capture_output=True,
                text=True,
                check=True
            )
            return result.stdout.strip()
        except subprocess.CalledProcessError as e:
            return f"Error: {e.stderr.strip()}"
        except Exception as e:
            return f"Error: {str(e)}"

    def _get_input(self, prompt="> "):
        self.input_win.clear()
        self.input_win.addstr(0, 0, prompt, curses.color_pair(2))
        self.input_win.refresh()
        curses.echo()
        input_bytes = self.input_win.getstr()
        curses.noecho()
        return input_bytes.decode().strip()

    def _process_command(self, cmd):
        if not cmd:
            return

        # Save to history
        self.history.append(cmd)
        if len(self.history) > self.max_history:
            self.history.pop(0)
        self.history_index = len(self.history)

        parts = cmd.split()
        command = parts[0].lower()
        args = parts[1:]

        if command == "commit":
            if args:
                message = " ".join(args)

                # Stage all changes first
                add_result = self._run_git_command(["add", "."])
                if "Error" in add_result:
                    self.status = "Error: failed to stage files"
                    self._write_output(add_result)
                    return

                # Now commit
                commit_result = self._run_git_command(["commit", "-m", message])
                self.status = f"Commit: {message}"
                self._write_output(commit_result)
            else:
                self.status = "Error: commit message required"

        elif command == "push":
            result = self._run_git_command(["push", "origin", self.current_branch])
            self.status = f"Pushed to {self.current_branch}"
            self._write_output(result)

        elif command == "tag":
            if args:
                tag_name = args[0]
                result = self._run_git_command(["tag", tag_name])
                self.status = f"Tag created: {tag_name}"
                self._write_output(result)
            else:
                self.status = "Error: tag name required"

        elif command in ("q", "quit", "exit"):
            self._quit()

        elif command in ("h", "help"):
            self._show_help()

        else:
            self.status = f"Unknown command: {command}"
            self._show_help()

    def _write_output(self, text):
        for line in text.splitlines():
            self.output_win.addstr(line + "\n", curses.color_pair(3))
        self.output_win.refresh()

    def _show_help(self):
        help_text = [
            "Git TUI Help:",
            "  commit <message>  - Stage all changes and create new commit",
            "  push              - Push current branch to origin",
            "  tag <tagname>     - Create new tag",
            "  q / quit / exit   - Quit",
            "  h / help          - Show this help",
        ]
        self._write_output("\n".join(help_text))
        self.status = "Help shown"

    def _quit(self):
        curses.endwin()
        sys.exit(0)

    def run(self):
        while True:
            try:
                self._update_status()
                cmd = self._get_input()
                self._process_command(cmd)
            except Exception as e:
                self.status = f"Error: {e}"
                self._update_status()

def main(stdscr):
    if not os.path.exists(".git"):
        stdscr.addstr(0, 0, "Error: Not in a Git repository")
        stdscr.refresh()
        curses.napms(2000)
        curses.endwin()
        sys.exit(1)

    tui = GitTUI(stdscr)
    tui.run()

if __name__ == "__main__":
    curses.wrapper(main)
