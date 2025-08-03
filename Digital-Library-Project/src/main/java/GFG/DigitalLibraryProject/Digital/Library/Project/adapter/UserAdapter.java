package GFG.DigitalLibraryProject.Digital.Library.Project.adapter;

import GFG.DigitalLibraryProject.Digital.Library.Project.commons.CommonAdapter;
import GFG.DigitalLibraryProject.Digital.Library.Project.entity.input.UserInputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.mappers.input.UserInputMapper;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.UserModel;
import GFG.DigitalLibraryProject.Digital.Library.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserAdapter implements CommonAdapter<UserInputEntity, UserModel> {

    private UserInputMapper userInputMapper;
    private UserService userService;

    @Autowired
    public UserAdapter(UserInputMapper userInputMapper,UserService userService)
    {
        this.userInputMapper=userInputMapper;
        this.userService=userService;
    }
    @Override
    public UserModel save(UserInputEntity userInputEntity) {
        UserModel userModel=userInputMapper.mapToModel(userInputEntity);
        return this.userService.save(userModel);
    }

    @Override
    public UserModel update(UserInputEntity userInputEntity) {
        return null;
    }


    public UserModel findUserById(long id)
    {
        return userService.findUserById(id);
    }


    public List<UserModel> getAllUsers()
    {
        return this.userService.getAllUsers();
    }


    public void deleteUserById(long id) {
        this.userService.deleteUserById(id);
    }
}
