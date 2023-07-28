package tn.actia.pfe.Pfe_App.Demande_Migration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Demandemigration implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom_projet;
    private String plateforme_migration;
    private String type_migration;
    private String status;
    private String UrlSvn;

    private String UrlGit;
    
    private String Token;

    private String SvnUsername;

    private String SvnPassword;


}
