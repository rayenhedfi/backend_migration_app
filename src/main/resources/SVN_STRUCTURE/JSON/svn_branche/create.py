# create_directory.py

import os
import sys

def create_directory(dir_name):
    # Creating a directory named dir_name
    try:
        os.mkdir(dir_name)
        print("Directory ", dir_name,  " Created ")
    except FileExistsError:
        print("Directory ", dir_name,  " already exists")

if __name__ == "__main__":
    # Expecting directory name as a command line argument
    if len(sys.argv) != 2:
        print("Directory name missing")
        sys.exit(1)

    create_directory(sys.argv[1])
