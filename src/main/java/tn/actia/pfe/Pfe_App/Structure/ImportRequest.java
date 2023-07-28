package tn.actia.pfe.Pfe_App.Structure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ImportRequest {
    private String username;
    private String password;
    private String svnUrl;

}