import shutil

def delete_folder(folder_path):
    try:
        shutil.rmtree(folder_path)
        print("Folder '{}' deleted successfully.".format(folder_path))
    except Exception as e:
        print("Failed to delete folder '{}'. Error: {}".format(folder_path, e))

# Chemin du dossier "Root" à supprimer
folder_path = "/home/rayenhedfi/Bureau/ApplicationMigration_lastversion/PFE/src/main/resources/SVN_STRUCTURE/JSON/Root"  

# Appel de la fonction pour supprimer le dossier "Root"
delete_folder(folder_path)
