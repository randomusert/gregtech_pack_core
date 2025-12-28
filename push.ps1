echo pushing to github
git push -u origin 1.21.1

echo pushing to gitlab
git push --all gitlab
git push --tags gitlab
echo complete
pause