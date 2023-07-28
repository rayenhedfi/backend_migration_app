package tn.actia.pfe.Pfe_App.REPO_SVN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@Validated
@RestController
@RequestMapping("/api/svn")
public class SvnController {
    @Autowired
    SvnService svnService;

    @PostMapping("/add_svnRepo")
    @ResponseBody
    public Svn addsvnRepo(@RequestBody Svn svn) {
        return  svnService.addsvnrepo(svn);
    }
    @GetMapping("/retrieve_svnRepo")
    @ResponseBody
    public List<Svn> getAllSvnRepo(){
        return svnService.retreivelistofSvn();
    }


    @DeleteMapping("/delete_svnRepo/{svn-id}")
    @ResponseBody
    public void removesvnRepo(@PathVariable("svn-id")Long svnId){
        svnService.deleteSvnRepo(svnId);
    }

    @PutMapping("/update_svnRepo/{svnId}")
    @ResponseBody
    public ResponseEntity<Svn> modifysvnRepo(@RequestBody Svn s, @PathVariable Long svnId){
        Svn sv= svnService.retriveSvnRepo(svnId);
        sv.setNomSvn(s.getNomSvn());
        sv.setUrlSvn(s.getUrlSvn());
        sv.setNbre_branches(s.getNbre_branches());
        sv.setNbre_tags(s.getNbre_tags());
        /*sv.setLien_branche(s.getLien_branche());
        sv.setNom_branche(s.getNom_branche());
        sv.setUsername_svn(s.getUsername_svn());
        sv.setPswd_svn(s.getPswd_svn());*/
        Svn updatesvnRepo=svnService.updateSvn(sv);
        return ResponseEntity.ok(updatesvnRepo);
    }
    /*@PostMapping("/create_and_import_directory")
    public ResponseEntity<String> createAndImportDirectory(@RequestBody Svn svn) {
        try {
            svnService.createAndImportDirectory(svn);
            return new ResponseEntity<>("Directory created and imported successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
    @PostMapping("/createAndImport")
    @ResponseBody
    public ResponseEntity<String> createAndImport(@RequestParam String lien_branche, @RequestParam String nom_branche, @RequestParam String username_svn, @RequestParam String pswd_svn) {
        try {
            svnService.createAndImportDirectory(lien_branche, nom_branche, username_svn, pswd_svn);
            return ResponseEntity.ok("Directory created and imported successfully");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error while creating and importing directory: " + e.getMessage());
        }
    }
    @GetMapping("/retrieve-retrieveSvnByName/{svn-nom}")
    public List <Svn> retrieveTransporteurByNom(@PathVariable("svn-nom") String svnname) {
        return svnService.retrieveSvnByName(svnname);
    }

}