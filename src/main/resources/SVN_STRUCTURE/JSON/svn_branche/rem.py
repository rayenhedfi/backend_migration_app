# delete_directory.py

import os
import shutil
import sys

def delete_directory(dir_name):
    # Deleting a directory named dir_name
    try:
        shutil.rmtree(dir_name)
        print("Directory ", dir_name,  " Deleted ")
    except FileNotFoundError:
        print("Directory ", dir_name,  " not found")

if __name__ == "__main__":
    # Expecting directory name as a command line argument
    if len(sys.argv) != 2:
        print("Directory name missing")
        sys.exit(1)

    delete_directory(sys.argv[1])

