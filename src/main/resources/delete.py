import os
import shutil

def delete_and_recreate_folder(folder_path):
    # Check if the folder exists
    if os.path.exists(folder_path):
        # Delete the folder and its contents recursively
        try:
            shutil.rmtree(folder_path)
            print(f"The folder '{folder_path}' has been deleted.")
        except OSError as e:
            print(f"Error while deleting the folder '{folder_path}': {e}")

    # Recreate the folder
    try:
        os.makedirs(folder_path)
        print(f"The folder '{folder_path}' has been recreated.")
    except OSError as e:
        print(f"Error while recreating the folder '{folder_path}': {e}")

# Usage of the script
folder_path_script = "/home/rayenhedfi/Bureau/ApplicationMigration_lastversion/PFE/src/main/resources/script"  # Replace this with the actual path of your folder
delete_and_recreate_folder(folder_path_script)

