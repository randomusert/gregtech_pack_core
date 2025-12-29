import os
import shutil
import subprocess
import sys


# command runner helper function
def run_cmd(cmd, cwd=None):
    try:
        print(f"> {' '.join(cmd)}")
        subprocess.run(cmd, check=True, cwd=cwd)
    except subprocess.CalledProcessError as e:
        print(f"[ERROR] Command failed: {' '.join(cmd)}")
        print(f"[ERROR] Return code: {e.returncode}")
        sys.exit(e.returncode)
    except FileNotFoundError as e:
        print(f"[ERROR] Command not found: {cmd[0]}")
        sys.exit(1)


def main():
    if sys.platform.startswith('win32'):
        run_cmd("gradlew build")
    if sys.platform.startswith('linux'):
        run_cmd("./gradlew build")
    if sys.platform.startswith('darwin'):
        run_cmd("./gradlew build")

if __name__ == "__main__":
    main()
