package tn.actia.pfe.Pfe_App.REPO_SVN;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SvnRepository extends JpaRepository<Svn,Long> {
    @Query("SELECT s FROM Svn s WHERE s.nomSvn LIKE %:nomSvn%")
    List<Svn> SvnByName(@Param("nomSvn") String nomSvn);
}