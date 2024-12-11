PACKAGE_VERSION=$(node -p  "require('./package.json').version")
git status

if [ -z "$(git status --porcelain)" ]; then 
  echo "No Changes detected for the version ${PACKAGE_VERSION} from the previous tag"
else 

  git add . -- ':!.gitlab-ci.yml' ':!update-github-remote.sh'
  git commit -m "Updating github remote for ${PACKAGE_VERSION}"
  git push
fi
 