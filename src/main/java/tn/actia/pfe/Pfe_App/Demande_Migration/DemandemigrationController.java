package tn.actia.pfe.Pfe_App.Demande_Migration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tn.actia.pfe.Pfe_App.REPO_SVN.Svn;

import java.util.List;
@CrossOrigin("*")
@Validated
@RestController
@RequestMapping("/api/mig")
public class DemandemigrationController {

@Autowired
    DemandemigrationService demandemigrationService;
@PostMapping("/add-migration")
public Demandemigration savedemandemigratoin(@RequestBody Demandemigration demandemigration){
    return demandemigrationService.savedemandemigratoin(demandemigration);
}
@GetMapping("/{id}")
    public Demandemigration getdemandemigrationById(@PathVariable Long id){
    return demandemigrationService.getdemandemigrationById(id);

}
@GetMapping("/retrieve-all-migration")
    public List<Demandemigration> getAllDemandemigration(){
    return demandemigrationService.getAllDemandemigration();
}

@DeleteMapping("/delete_migration/{id}")
    public void deletedemandemigrationById(@PathVariable Long id){
    demandemigrationService.deletedemandemigrationById(id);
}
@PutMapping("/{id}/status")
 public Demandemigration updateStatus(@PathVariable Long id, @RequestParam("status")String newStatus)
{
    return demandemigrationService.updatestatus(id,newStatus);
}

@GetMapping("{id}/check")
public Demandemigration checkAndUpdateStatus(@PathVariable Long id)
{
    return demandemigrationService.checkAndUpdateStatus(id);
}

@PutMapping("/modifierstatus/{id}")
    public ResponseEntity<Demandemigration> Modifierstatus(@RequestBody Demandemigration d, @PathVariable Long id){
        Demandemigration Cx= demandemigrationService.getdemandemigrationById(id);
        Cx.setStatus(d.getStatus());
        Demandemigration updateStatus= demandemigrationService.updateStatus(Cx);
        return ResponseEntity.ok(updateStatus);
    }
    @GetMapping("/retrieveDemandeMigrartionByName/{demande-nom}")
    public List <Demandemigration> retrieveDemandeMigrartionByName(@PathVariable("demande-nom") String demandenom) {
        return demandemigrationService.retrieveDemandeMigrartionByName(demandenom);
    }
}




