package GFG.DigitalLibraryProject.Digital.Library.Project.repository.jpa;

import GFG.DigitalLibraryProject.Digital.Library.Project.entity.output.MembershipOutputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.enums.MembershipStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface MembershipJPARepository extends JpaRepository<MembershipOutputEntity,Long> {
    /**
     * Finds if the user with ID has any membership that is not of the status given as the argument.
     *
     * @param id     The User ID
     * @param status The membership status that the user does not have
     * @return Optional of MembershipOutputEntity
     */
    Optional<MembershipOutputEntity> findByUser_IdAndUser_Memberships_StatusNot(long id, MembershipStatus status);
}
