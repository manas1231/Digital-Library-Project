package GFG.DigitalLibraryProject.Digital.Library.Project.mappers.input;

import GFG.DigitalLibraryProject.Digital.Library.Project.entity.input.UserInputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserInputMapper {

    public UserModel mapToModel(UserInputEntity userInputEntity)
    {
        return UserModel.builder()
                .id(userInputEntity.getId())
                .firstName(userInputEntity.getFirstName())
                .lastName(userInputEntity.getLastName())
                .dob(userInputEntity.getDob())
                .email(userInputEntity.getEmail())
                .number(userInputEntity.getNumber())
                .build();
    }
}
