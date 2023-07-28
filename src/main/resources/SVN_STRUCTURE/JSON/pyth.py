import json
import os

def create_folder_structure(data, parent_path):
    folder_name = data['name']
    folder_path = os.path.join(parent_path, folder_name)
    os.mkdir(folder_path)

    for subfolder in data['subfolders']:
        create_folder_structure(subfolder, folder_path)

def main():
    # Specify the parent directory where the folders will be created
    parent_directory = '/home/rayenhedfi/Bureau/ApplicationMigration_lastversion/PFE/src/main/resources/SVN_STRUCTURE/JSON'

    # Read the JSON file
    json_file = os.path.join(parent_directory, 'structure.json')
    try:
        with open(json_file) as f:
            data = json.load(f)
    except FileNotFoundError:
        print('The specified JSON file was not found.')
        return
    except json.JSONDecodeError:
        print('Invalid JSON file format.')
        return

    # Create the folder structure
    create_folder_structure(data, parent_directory)

    print('Folder structure created successfully.')

if __name__ == '__main__':
    main()
