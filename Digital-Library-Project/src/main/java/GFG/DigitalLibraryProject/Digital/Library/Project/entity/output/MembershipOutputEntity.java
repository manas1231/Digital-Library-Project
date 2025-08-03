package GFG.DigitalLibraryProject.Digital.Library.Project.entity.output;

import GFG.DigitalLibraryProject.Digital.Library.Project.enums.MembershipPlan;
import GFG.DigitalLibraryProject.Digital.Library.Project.enums.MembershipStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name="membership")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MembershipOutputEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserOutputEntity user;

    @Column(name = "start_data")
    private Instant startData;

    @Column(name = "end_date")
    private Instant endDate;

    @Column(name = "membership_status")
    private MembershipStatus status;

    @Column(name = "membership_plan")
    private MembershipPlan plan;
}
