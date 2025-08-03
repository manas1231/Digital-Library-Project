package GFG.DigitalLibraryProject.Digital.Library.Project.repository.jpa;

import GFG.DigitalLibraryProject.Digital.Library.Project.entity.output.UserOutputEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJPARepository extends JpaRepository<UserOutputEntity,Long> {
    Optional<UserOutputEntity> findByEmail(String username);
}
