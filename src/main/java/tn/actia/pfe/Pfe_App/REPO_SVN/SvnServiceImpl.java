package tn.actia.pfe.Pfe_App.REPO_SVN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmatesoft.svn.core.SVNCommitInfo;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.ISVNEditor;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

import java.io.IOException;
import java.util.List;



@Service

public class SvnServiceImpl implements SvnService {
    @Autowired
    SvnRepository svnRepository;


    @Override
    public Svn addsvnrepo(Svn svn) {
        svnRepository.save(svn);
        return null;
    }

    @Override
    public void deleteSvnRepo(Long id) {
        svnRepository.deleteById(id);
    }

    @Override
    public Svn retriveSvnRepo(Long svnId) {
        return svnRepository.findById(svnId).get();
    }

    @Override
    public List<Svn> retreivelistofSvn() {
        return svnRepository.findAll();
    }

    @Override
    public Svn updateSvn(Svn s) {
        return svnRepository.save(s);
    }
   /* public void createAndImportDirectory(Svn svn) throws IOException, InterruptedException {
// Get the branch name
String nom_branche = svn.getNom_branche();

// Run Python script to create directory
ProcessBuilder processBuilder = new ProcessBuilder("python3", "/home/rayenhedfi/Bureau/JSON/svn_branche/create.py", nom_branche);
 Process process = processBuilder.start();
 process.waitFor();

// Connect to SVN repository
 DAVRepositoryFactory.setup();
 SVNRepository repository = null;
 try {
 repository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(svn.getLien_branche()));
 } catch (Exception e) {
 e.printStackTrace();
 }

ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(svn.getUsername_svn(), svn.getPswd_svn());
 repository.setAuthenticationManager(authManager);

 // Import directory
 try {
 ISVNEditor editor = repository.getCommitEditor("commit message", null);
 editor.openRoot(-1);
editor.addDir(nom_branche, null, -1);
 editor.closeDir();
 SVNCommitInfo commitInfo = editor.closeEdit();
 System.out.println("The directory was imported at revision: " + commitInfo.getNewRevision());
} catch (Exception e) {
 e.printStackTrace();
 }

 // Run Python script to delete directory
 ProcessBuilder processBuilder2 = new ProcessBuilder("python3", "/home/rayenhedfi/Bureau/JSON/svn_branche/rem.py", nom_branche);
Process process2 = processBuilder2.start();
 process2.waitFor();
    }*/


    //la methode correcte
    public void createAndImportDirectory(String lien_branche, String nom_branche, String username_svn, String pswd_svn) throws IOException, InterruptedException {
// Run Python script to create directory
  ProcessBuilder processBuilder = new ProcessBuilder("python3", "/home/rayenhedfi/Bureau/ApplicationMigration_lastversion/PFE/src/main/resources/SVN_STRUCTURE/JSON/svn_branche/create.py", nom_branche);
 Process process = processBuilder.start();
process.waitFor();

// Connect to SVN repository
 DAVRepositoryFactory.setup();
 SVNRepository repository = null;
try {
 repository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(lien_branche));
} catch (Exception e) {
 e.printStackTrace();
 }

ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(username_svn, pswd_svn);
 repository.setAuthenticationManager(authManager);

// Import directory
 try {
 ISVNEditor editor = repository.getCommitEditor("commit message", null);
 editor.openRoot(-1);
 editor.addDir(nom_branche, null, -1);
 editor.closeDir();
SVNCommitInfo commitInfo = editor.closeEdit();
 System.out.println("The directory was imported at revision: " + commitInfo.getNewRevision());
} catch (Exception e) {
 e.printStackTrace();
 }

 // Run Python script to delete directory
 ProcessBuilder processBuilder2 = new ProcessBuilder("python3", "/home/rayenhedfi/Bureau/ApplicationMigration_lastversion/PFE/src/main/resources/SVN_STRUCTURE/JSON/svn_branche/rem.py", nom_branche);
 Process process2 = processBuilder2.start();
 process2.waitFor();
    }

    @Override
    public List<Svn> retrieveSvnByName(String nomSvn) {
        return svnRepository.SvnByName(nomSvn);
    }


}
