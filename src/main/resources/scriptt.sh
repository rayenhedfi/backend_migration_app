#!/bin/bash

# Specify the destination Git repository path
git_repo_path="/home/rayenhedfi/Bureau/ApplicationMigration_lastversion/PFE/src/main/resources/script"

# Retrieve the migration information from the command-line arguments
url_svn="$1"
url_git="$2"
svn_password="$3"
svn_username="$4"

# Change the working directory to the Git repository path
cd "$git_repo_path"

# Initialize the Git-SVN migration
#git svn init "$url_svn" --stdlayout --prefix=svn/

# Fetch the SVN data
#git svn fetch

#pass the password in parameter
SVN2GIT_PASSWORD="$svn_password" svn2git "$url_svn" --username "$svn_username"


# Push all the branches to GitLab
git branch -r | grep -v tags | sed -rne 's, *([^@]+)$,\1,p' | while read branch; do echo "git branch $branch $branch"; done | sh

# Push all the tags to GitLab
for tag in `git branch -r | grep "tags/" | sed 's/ tags\///'`; do
git tag -a -m"Converting SVN tags" $tag refs/remotes/$tag
done

# Add the GitLab remote
git remote add origin "$url_git"

# Push all the branches and tags to GitLab
git push --all
git push --tags

# Clean up the Git-SVN metadata
git config --unset svn-remote.svn.url
git config --unset svn-remote.svn.fetch
git config --unset svn-remote.svn.branches
git config --unset svn-remote.svn.tags

# Remove the remote and fetch settings
git config --unset remote.origin.url
git config --unset remote.origin.fetch

# Remove the Git repository
rm -rf .git
