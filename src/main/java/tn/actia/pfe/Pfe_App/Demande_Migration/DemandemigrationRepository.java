package tn.actia.pfe.Pfe_App.Demande_Migration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.actia.pfe.Pfe_App.REPO_SVN.Svn;

import java.util.List;

@Repository
public interface DemandemigrationRepository extends JpaRepository<Demandemigration,Long> {
    @Query("SELECT d FROM Demandemigration d WHERE d.nom_projet LIKE %:nom_projet%")
    List<Demandemigration> Demandemigrationbyname(@Param("nom_projet") String nom_projet);
}
