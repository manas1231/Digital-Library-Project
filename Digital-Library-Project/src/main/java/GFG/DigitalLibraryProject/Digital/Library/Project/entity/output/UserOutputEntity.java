package GFG.DigitalLibraryProject.Digital.Library.Project.entity.output;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "number")
    private String number;
}
