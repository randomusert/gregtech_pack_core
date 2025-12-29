echo "pushing to github"
git push -u origin 1.21.1

echo "pushing to gitlab"
git push --all gitlab
git push --tags gitlab
echo "Finnished pushing to github and gitlab. if any errors occured from git, check them and solve"
pause
