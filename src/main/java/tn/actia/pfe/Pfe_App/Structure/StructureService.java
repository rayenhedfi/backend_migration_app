package tn.actia.pfe.Pfe_App.Structure;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.tmatesoft.svn.core.SVNCommitInfo;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.BasicAuthenticationManager;
import org.tmatesoft.svn.core.wc2.SvnImport;
import org.tmatesoft.svn.core.wc2.SvnOperationFactory;
import org.tmatesoft.svn.core.wc2.SvnTarget;

import javax.mail.Folder;
import java.io.File;
import java.io.IOException;

@Service
public class StructureService {
    public String generateJson(FolderData folder) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(folder);
    }

    public Folder parseJson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Folder.class);
    }
    /*public void importFolder(ImportRequest importRequest, String localFolderPath) throws SVNException {
        String svnUsername = importRequest.getUsername();
        String svnPassword = importRequest.getPassword();
        String svnUrl = importRequest.getSvnUrl();

        SVNURL repositoryUrl = SVNURL.parseURIDecoded(svnUrl);
        BasicAuthenticationManager authManager = new BasicAuthenticationManager(svnUsername, svnPassword);

        SvnOperationFactory operationFactory = new SvnOperationFactory();
        operationFactory.setAuthenticationManager(authManager);

        SvnImport importOperation = operationFactory.createImport();
        importOperation.setSource(SvnTarget.fromFile(new File(localFolderPath)).getFile());
        importOperation.setSingleTarget(SvnTarget.fromURL(repositoryUrl));
        importOperation.setCommitMessage("Importing folder to SVN");

        SVNCommitInfo commitInfo = importOperation.run();

        operationFactory.dispose();

        if (commitInfo != null) {
            System.out.println("Folder imported successfully to SVN. Revision: " + commitInfo.getNewRevision());
        } else {
            System.out.println("Failed to import folder to SVN.");
        }
    }*/
    public void importFolder(ImportRequest importRequest, String localFolderPath) throws SVNException, IOException {
        String svnUsername = importRequest.getUsername();
        String svnPassword = importRequest.getPassword();
        String svnUrl = importRequest.getSvnUrl();

        SVNURL repositoryUrl = SVNURL.parseURIDecoded(svnUrl);
        BasicAuthenticationManager authManager = new BasicAuthenticationManager(svnUsername, svnPassword);

        SvnOperationFactory operationFactory = new SvnOperationFactory();
        operationFactory.setAuthenticationManager(authManager);

        SvnImport importOperation = operationFactory.createImport();
        importOperation.setSource(SvnTarget.fromFile(new File(localFolderPath)).getFile());
        importOperation.setSingleTarget(SvnTarget.fromURL(repositoryUrl));
        importOperation.setCommitMessage("Importing folder to SVN");

        SVNCommitInfo commitInfo = importOperation.run();

        operationFactory.dispose();

        if (commitInfo != null) {
            System.out.println("Folder imported successfully to SVN. Revision: " + commitInfo.getNewRevision());

            // Execute Python script after the folder import
            String pythonScriptPath = "/home/rayenhedfi/Bureau/ApplicationMigration_lastversion/PFE/src/main/resources/SVN_STRUCTURE/JSON/remove_file.py"; // Specify the actual path to your Python script

            // Construct the command to execute the Python script
            String command = "python3 " + pythonScriptPath;

            // Execute the command using ProcessBuilder
            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            Process process = processBuilder.start();

            // Wait for the process to complete
            try {
                int exitCode = process.waitFor();
                if (exitCode == 0) {
                    System.out.println("Python script executed successfully.");
                } else {
                    System.out.println("Failed to execute Python script. Exit code: " + exitCode);
                }
            } catch (InterruptedException e) {
                System.out.println("Failed to execute Python script. Error: " + e.getMessage());
            }
        } else {
            System.out.println("Failed to import folder to SVN.");
        }
    }
}
