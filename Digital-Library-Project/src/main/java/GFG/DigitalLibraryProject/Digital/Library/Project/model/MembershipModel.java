package GFG.DigitalLibraryProject.Digital.Library.Project.model;

import GFG.DigitalLibraryProject.Digital.Library.Project.entity.output.UserOutputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.enums.MembershipPlan;
import GFG.DigitalLibraryProject.Digital.Library.Project.enums.MembershipStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.time.Instant;

@Data
@Builder
@With

public class MembershipModel {

    private long id;


    private UserModel user;
    private MembershipPlan membershipPlan;
    private Instant startDate;
    private Instant endDate;
    private MembershipStatus status;
}
