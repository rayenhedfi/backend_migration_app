package tn.actia.pfe.Pfe_App.Demande_Migration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.fs.FSRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;
import tn.actia.pfe.Pfe_App.REPO_SVN.Svn;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;


@Service
public class DemandemigrationServiceImpl implements DemandemigrationService {

    @Autowired
    DemandemigrationRepository demandemigrationRepository;

    @Override
    public Demandemigration savedemandemigratoin(Demandemigration demandemigration) {
        return demandemigrationRepository.save(demandemigration);
    }

    @Override
    public Demandemigration getdemandemigrationById(Long id) {
        return demandemigrationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Demandemigration> getAllDemandemigration() {
        return demandemigrationRepository.findAll();
    }

    @Override
    public void deletedemandemigrationById(Long id) {
        demandemigrationRepository.deleteById(id);
    }


    @Override
    public Demandemigration updatestatus(Long id, String newStatus) {
        Demandemigration demandemigration = demandemigrationRepository.findById(id).orElse(null);
        if (demandemigration != null) {
            demandemigration.setStatus(newStatus);
            return demandemigrationRepository.save(demandemigration);
        }
        return null;
    }
    @Override
    public Demandemigration updateStatus(Demandemigration demandemigration){
        return demandemigrationRepository.save(demandemigration);
    }
    @Override
    public List<Demandemigration> retrieveDemandeMigrartionByName(String nom_projet) {
        return demandemigrationRepository.Demandemigrationbyname(nom_projet);
    }
   /* @Override
    public Demandemigration checkAndUpdateStatus(Long id) {
        Demandemigration demandemigration = demandemigrationRepository.findById(id).orElse(null);
        if (demandemigration != null && "approuvee".equals(demandemigration.getStatus())) {
            try {
                // Chemin d'accès complet au script shell sur votre machine locale
                String scriptPath = "/home/rayenhedfi/Bureau/testt/svndepot/svn2git.sh";

                // valeur à passer au script
                // String chemin = "/home/rayenhedfi/Bureau/testtt";
                // String nomProjet= demandemigration.getNom_projet();
              // String gitlabUrl = demandemigration.getUrlGit();
               //String svnUsername = demandemigration.getSvnUsername();
               //String svnPassword = demandemigration.getSvnPassword();
              // String gitlabToken = demandemigration.getToken();
               //String svnRepoUrl = demandemigration.getUrlSvn();


                // Exécuter le script shell
                ProcessBuilder processBuilder= new ProcessBuilder("bash",scriptPath);
                Process process= processBuilder.start();
                //Process process = Runtime.getRuntime().exec(scriptPath);
                BufferedReader errorReader= new BufferedReader(new InputStreamReader(process.getErrorStream()));
                String line;
                StringBuilder errorMessage = new StringBuilder();
                while ((line = errorReader.readLine()) !=null){
                    errorMessage.append("\n");
                }

                // Attendre la fin de l'exécution du script
                int exitCode = process.waitFor();

                if (exitCode == 0) {
                    // Mise à jour du statut de la demande après l'exécution réussie du scrip

                } else {
                    // En cas d'échec de l'exécution du script, vous pouvez effectuer d'autres actions appropriées
                System.out.println("le script a echoue");
                System.out.println(errorMessage.toString());
                }
            } catch (IOException | InterruptedException e) {
                // Gérer les exceptions liées à l'exécution du script
                e.printStackTrace();
            }
        }
        return demandemigration;
    }*/

   /* @Override
    public Demandemigration checkAndUpdateStatus(Long id) {
        Demandemigration demandemigration = demandemigrationRepository.findById(id).orElse(null);
        if (demandemigration != null && "approuvee".equals(demandemigration.getStatus())) {

            try {
                TestScript testScript = new TestScript();
                testScript.runScript("sh /root/Desktop/testScript.sh");
                System.out.println("le script a echoué");
                // Récupérer les informations de la demande de migration
                String svnRepoUrl = demandemigration.getUrlSvn();
                String svnUsername = demandemigration.getSvnUsername();
                String svnPassword = demandemigration.getSvnPassword();
                String svnScriptPath = "/scripts/pyh.py";
                // Construction de la commande à exécuter
//                String command = "cmd.exe /c cd "+svnScriptPath+" && start python script.py";

                String command = "cmd.exe /c start python "+svnScriptPath;
                Runtime runtime = Runtime.getRuntime();
                // Exécution de la commande
                Process process = runtime.exec(command);

                // Attendre la fin de l'exécution du processus
                int exitCode = process.waitFor();

                if (exitCode == 0) {
                    // Mise à jour du statut de la demande après l'exécution réussie du script
                   // demandemigrationRepository.save(demandemigration);

                } else {

                    // En cas d'échec de l'exécution du script, vous pouvez effectuer d'autres actions appropriées

                    System.out.println("le script a echoué");
                }
            } catch (IOException | InterruptedException e) {
                // Gérer les exceptions liées à l'exécution du script
            }
        }
        return demandemigration;
    }*/

//tekhdem
   /*@Override
   public Demandemigration checkAndUpdateStatus(Long id) {
       Demandemigration demandemigration = demandemigrationRepository.findById(id).orElse(null);
       if (demandemigration != null && "approuvee".equals(demandemigration.getStatus())) {
           try {
               // Chemin d'accès complet au script shell sur votre machine locale
               String scriptPath = "/home/rayenhedfi/Bureau/testtt/svndepot/scrop.sh";
               String nomProjet = demandemigration.getNom_projet();
               //String command[] = {"bash", scriptPath,projectName};
                String command = " bash " + scriptPath + " " +nomProjet;
               Process process = Runtime.getRuntime().exec(command);

               // Attendre la fin de l'exécution du script
               int exitCode = process.waitFor();

               if (exitCode == 0) {
                   // L'exécution du script est réussie
                   // Vous pouvez effectuer d'autres actions appropriées ici
               } else {
                   // En cas d'échec de l'exécution du script, vous pouvez effectuer d'autres actions appropriées
               }
           } catch (IOException | InterruptedException e) {
               // Gérer les exceptions liées à l'exécution du script
           }
       }
       return demandemigration;
   }*/
/*@Override
public Demandemigration checkAndUpdateStatus(Long id) {
    Demandemigration demandemigration = demandemigrationRepository.findById(id).orElse(null);
    if (demandemigration != null && "approuvee".equals(demandemigration.getStatus())) {
        try {
            // Chemin d'accès complet au script shell sur votre machine locale
            String scriptPath = "/home/rayenhedfi/Bureau/testtt/test.sh";
            ProcessBuilder processBuilder = new ProcessBuilder("bash",scriptPath);
            Map<String,String>environment = processBuilder.environment();
            //String nomProjet = demandemigration.getNom_projet();
            String svnPath="/usr/bin/svn";
            String existingPath = environment.get("PATH");
            environment.put("PATH",svnPath + ":" + existingPath);
            //String command[] = {"bash", scriptPath};
            //String command = " bash " + scriptPath + " " +nomProjet;
            //Process process = Runtime.getRuntime().exec(command);
            Process process = processBuilder.start();
            // Attendre la fin de l'exécution du script
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                // L'exécution du script est réussie
                // Vous pouvez effectuer d'autres actions appropriées ici
            } else {
                // En cas d'échec de l'exécution du script, vous pouvez effectuer d'autres actions appropriées
            }
        } catch (IOException | InterruptedException e) {
            // Gérer les exceptions liées à l'exécution du script
        }
    }
    return demandemigration;
}*/
/*@Override
public Demandemigration checkAndUpdateStatus(Long id) {
    Demandemigration demandemigration = demandemigrationRepository.findById(id).orElse(null);
    if (demandemigration != null && "approuvee".equals(demandemigration.getStatus())) {
        try {
            // Chemin d'accès complet au script shell sur votre machine locale

            String scriptPath = getClass().getClassLoader().getResourceAsStream("/scripts/scriptt.sh").getPath();

            // Créer une instance de ProcessBuilder avec la commande bash et le chemin du script
            ProcessBuilder processBuilder = new ProcessBuilder("bash", scriptPath);

            // Démarrer le processus en utilisant le ProcessBuilder
            Process process = processBuilder.start();

            // Lire les sorties standard du processus
            BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String stdoutLine;
            while ((stdoutLine = stdoutReader.readLine()) != null) {
                System.out.println(stdoutLine);
            }

            // Lire les sorties d'erreur du processus
            BufferedReader stderrReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String stderrLine;
            while ((stderrLine = stderrReader.readLine()) != null) {
                System.err.println(stderrLine);
            }

            // Attendre la fin de l'exécution du script
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                // L'exécution du script est réussie
                // Vous pouvez effectuer d'autres actions appropriées ici
            } else {
                // En cas d'échec de l'exécution du script, vous pouvez effectuer d'autres actions appropriées
            }
        } catch (IOException | InterruptedException e) {
            // Gérer les exceptions liées à l'exécution du script
        }
    }
    return demandemigration;
}*/
/*@Override
public Demandemigration checkAndUpdateStatus(Long id) {
    Demandemigration demandemigration = demandemigrationRepository.findById(id).orElse(null);
    if (demandemigration != null && "approuvee".equals(demandemigration.getStatus())) {
        try {
            // Load the script file as an input stream
            InputStream scriptStream = getClass().getClassLoader().getResourceAsStream("scriptt.sh");

            // Create a temporary file to write the script to
            File scriptFile = File.createTempFile("script", ".sh");
            scriptFile.deleteOnExit();

            // Write the script to the temporary file
            assert scriptStream != null;
            Files.copy(scriptStream, scriptFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Create a ProcessBuilder with the command to run the script
            ProcessBuilder processBuilder = new ProcessBuilder("bash", "-x", scriptFile.getAbsolutePath());

            // Start the process
            Process process = processBuilder.start();

            BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String stdoutLine;
            while ((stdoutLine = stdoutReader.readLine()) != null) {
                System.out.println(stdoutLine);
            }

            BufferedReader stderrReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String stderrLine;
            while ((stderrLine = stderrReader.readLine()) != null) {
                System.err.println(stderrLine);
            }
            // Wait for the process to finish
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                // Script ran successfully
            } else {
                // Script failed
            }
        } catch (IOException | InterruptedException e) {
            // Handle exceptions
        }
    }
    return demandemigration;
}

 */


   // correct function
/*@Override
public Demandemigration checkAndUpdateStatus(Long id) {
    Demandemigration demandemigration = demandemigrationRepository.findById(id).orElse(null);
    if (demandemigration != null && "approuvee".equals(demandemigration.getStatus())) {
        try {
            // Load the script file as an input stream
            InputStream scriptStream = getClass().getClassLoader().getResourceAsStream("scriptt.sh");

            // Create a temporary file to write the script to
            File scriptFile = File.createTempFile("script", ".sh");
            scriptFile.deleteOnExit();

            // Write the script to the temporary file
            assert scriptStream != null;
            Files.copy(scriptStream, scriptFile.toPath(), StandardCopyOption.REPLACE_EXISTING);


            String urlSvn = demandemigration.getUrlSvn();
            String urlGit = demandemigration.getUrlGit();
            String svnPassword = demandemigration.getSvnPassword();
            String svnUsername = demandemigration.getSvnUsername();
            // Create a ProcessBuilder with the command to run the script
            ProcessBuilder processBuilder = new ProcessBuilder("bash", "-x", scriptFile.getAbsolutePath(),urlSvn, urlGit);

            // Start the process
            Process process = processBuilder.start();

            BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String stdoutLine;
            while ((stdoutLine = stdoutReader.readLine()) != null) {
                System.out.println(stdoutLine);
            }

            BufferedReader stderrReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String stderrLine;
            while ((stderrLine = stderrReader.readLine()) != null) {
                System.err.println(stderrLine);
            }
            // Wait for the process to finish
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                // Script ran successfully
            } else {
                // Script failed
            }
        } catch (IOException | InterruptedException e) {
            // Handle exceptions
        }
    }
    return demandemigration;
}*/
   @Override
 public Demandemigration checkAndUpdateStatus(Long id) {
Demandemigration demandemigration = demandemigrationRepository.findById(id).orElse(null);

 if (demandemigration != null && "approuvee".equals(demandemigration.getStatus())) {
 try {
 // Load the first script file "scriptt.sh" as an input stream
InputStream firstScriptStream = getClass().getClassLoader().getResourceAsStream("scriptt.sh");

 // Create a temporary file to write the first script to
 File firstScriptFile = File.createTempFile("script", ".sh");
 firstScriptFile.deleteOnExit();

 // Write the first script to the temporary file
assert firstScriptStream != null;
 Files.copy(firstScriptStream, firstScriptFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

 // Extract relevant information from the Demandemigration object
 String urlSvn = demandemigration.getUrlSvn();
  String urlGit = demandemigration.getUrlGit();
 String svnPassword = demandemigration.getSvnPassword();
String svnUsername = demandemigration.getSvnUsername();

 // Create a ProcessBuilder with the command to run the first script with given arguments
 ProcessBuilder firstScriptProcessBuilder = new ProcessBuilder("bash", "-x", firstScriptFile.getAbsolutePath(), urlSvn, urlGit);

 // Start the first script process
 Process firstScriptProcess = firstScriptProcessBuilder.start();

 // Read and display the standard output of the first script (if needed)
 BufferedReader firstStdoutReader = new BufferedReader(new InputStreamReader(firstScriptProcess.getInputStream()));
 String firstStdoutLine;
 while ((firstStdoutLine = firstStdoutReader.readLine()) != null) {
 System.out.println(firstStdoutLine);
 }

 // Read and display the standard error of the first script (if needed)
 BufferedReader firstStderrReader = new BufferedReader(new InputStreamReader(firstScriptProcess.getErrorStream()));
 String firstStderrLine;
 while ((firstStderrLine = firstStderrReader.readLine()) != null) {
System.err.println(firstStderrLine);
 }

 // Wait for the first script process to finish and get the exit code
 int firstExitCode = firstScriptProcess.waitFor();

if (firstExitCode == 0) {
 // First script ran successfully, now you can execute the second script
 String secondScriptPath = "/home/rayenhedfi/Bureau/ApplicationMigration_lastversion/PFE/src/main/resources/delete.py";

 // Create a ProcessBuilder for the second script with any necessary arguments
 ProcessBuilder secondScriptProcessBuilder = new ProcessBuilder("python3", secondScriptPath);

 // Start the second script process
 Process secondScriptProcess = secondScriptProcessBuilder.start();

// Read and display the standard output of the second script (if needed)
BufferedReader secondStdoutReader = new BufferedReader(new InputStreamReader(secondScriptProcess.getInputStream()));
String secondStdoutLine;
 while ((secondStdoutLine = secondStdoutReader.readLine()) != null) {
 System.out.println(secondStdoutLine);
 }
 // Read and display the standard error of the second script (if needed)
 BufferedReader secondStderrReader = new BufferedReader(new InputStreamReader(secondScriptProcess.getErrorStream()));
 String secondStderrLine;
 while ((secondStderrLine = secondStderrReader.readLine()) != null) {
 System.err.println(secondStderrLine);
}

// Wait for the second script process to finish and get the exit code
 int secondExitCode = secondScriptProcess.waitFor();

 // Check if the second script ran successfully based on the exit code
 if (secondExitCode == 0) {
 // Second script ran successfully
 } else {
 // Second script failed
 }
 } else {
 // First script failed
 }
 } catch (IOException | InterruptedException e) {
// Handle exceptions that may occur during the process
 }
 }

 return demandemigration;
 }
}

