package GFG.DigitalLibraryProject.Digital.Library.Project.entity.input;

import GFG.DigitalLibraryProject.Digital.Library.Project.entity.output.UserOutputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.enums.MembershipPlan;
import GFG.DigitalLibraryProject.Digital.Library.Project.enums.MembershipStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.time.Instant;

@Data
@With
@Builder
public class MembershipInputEntity {

    private long id;

    @NotNull(message = "User Id is mandatory")
    private long user_id;

    @NotNull
    private MembershipPlan planName;

    private Instant startDate;
    private Instant endDate;
    private MembershipStatus status;

}
