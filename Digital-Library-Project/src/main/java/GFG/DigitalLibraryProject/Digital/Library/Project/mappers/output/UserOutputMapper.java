package GFG.DigitalLibraryProject.Digital.Library.Project.mappers.output;

import GFG.DigitalLibraryProject.Digital.Library.Project.entity.output.UserOutputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserOutputMapper {

    public UserModel mapToModel(UserOutputEntity userOutputEntity)
    {
        return UserModel.builder()
                .id(userOutputEntity.getId())
                .firstName(userOutputEntity.getFirstName())
                .lastName(userOutputEntity.getLastName())
                .dob(userOutputEntity.getDob())
                .email(userOutputEntity.getEmail())
                .number(userOutputEntity.getNumber())
                .build();
    }

    public UserOutputEntity mapFromModel(UserModel userModel)
    {
        return UserOutputEntity.builder()
                .id(userModel.getId())
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .dob(userModel.getDob())
                .email(userModel.getEmail())
                .number(userModel.getNumber())
                .build();
    }
}
