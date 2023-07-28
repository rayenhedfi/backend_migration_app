package tn.actia.pfe.Pfe_App.REPO_SVN;

import java.io.IOException;
import java.util.List;

public interface SvnService {
    Svn addsvnrepo(Svn svn);
    void deleteSvnRepo(Long id);
    Svn retriveSvnRepo(Long id);
    List<Svn> retreivelistofSvn();
    List<Svn>retrieveSvnByName(String nomSvn);

    Svn updateSvn(Svn s);
    //void createAndImportDirectory(Svn svn) throws IOException, InterruptedException;
    void createAndImportDirectory(String lien_branche, String nom_branche, String username_svn, String pswd_svn) throws IOException, InterruptedException;
}