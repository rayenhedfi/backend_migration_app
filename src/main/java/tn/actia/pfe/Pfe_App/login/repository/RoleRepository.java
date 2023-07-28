package tn.actia.pfe.Pfe_App.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.actia.pfe.Pfe_App.login.models.ERole;
import tn.actia.pfe.Pfe_App.login.models.Role;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

}
