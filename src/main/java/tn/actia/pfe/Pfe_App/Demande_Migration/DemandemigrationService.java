package tn.actia.pfe.Pfe_App.Demande_Migration;

import tn.actia.pfe.Pfe_App.REPO_SVN.Svn;

import java.util.List;

public interface DemandemigrationService {
    Demandemigration savedemandemigratoin(Demandemigration demandemigration);
    Demandemigration getdemandemigrationById(Long id);
    List<Demandemigration>getAllDemandemigration();
    void deletedemandemigrationById(Long id);
    Demandemigration updatestatus(Long id, String newStatus);
    Demandemigration checkAndUpdateStatus(Long id);
    Demandemigration updateStatus(Demandemigration demandemigration);
    List<Demandemigration>retrieveDemandeMigrartionByName(String nomdemande);
}
