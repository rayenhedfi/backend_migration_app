package tn.actia.pfe.Pfe_App.REPO_SVN;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Svn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long svnId;
    private String urlSvn;
    private String nomSvn;
    private int nbre_branches;
    private int nbre_tags;
    //private String lien_branche;
    //private String nom_branche;
    //private String Username_svn;
    //private String pswd_svn;
}