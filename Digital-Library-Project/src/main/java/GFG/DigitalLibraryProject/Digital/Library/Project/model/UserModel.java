package GFG.DigitalLibraryProject.Digital.Library.Project.model;

import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.time.LocalDate;

@Data
@Builder
@With
public class UserModel {

    private long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String email;
    private String number;
}
