package GFG.DigitalLibraryProject.Digital.Library.Project.entity.output;

import GFG.DigitalLibraryProject.Digital.Library.Project.enums.UserRole;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.MembershipModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class UserOutputEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "firstname",nullable = false)
    private String firstName;

    @Column(name = "lastname",nullable = false)
    private String lastName;

    @Column(name = "dob",nullable = false)
    private LocalDate dob;

    @Column(name = "password")
    private String password;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "number")
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name="userrole")
    private UserRole role;

    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<MembershipOutputEntity> memberships;
}
