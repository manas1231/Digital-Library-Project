package GFG.DigitalLibraryProject.Digital.Library.Project.repository.jpa;

import GFG.DigitalLibraryProject.Digital.Library.Project.entity.output.UserOutputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.mappers.output.UserOutputMapper;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.UserModel;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepository {
    private UserJPARepository userJPARepository;
    private UserOutputMapper userOutputMapper;

    @Autowired
    public UserRepository(UserJPARepository userJPARepository,UserOutputMapper userOutputMapper)
    {
        this.userJPARepository=userJPARepository;
        this.userOutputMapper=userOutputMapper;
    }

    public UserModel save(UserModel userModel)
    {
        UserOutputEntity userOutputEntity=userOutputMapper.mapFromModel(userModel);
        UserOutputEntity savedEntity=this.userJPARepository.save(userOutputEntity);
        return userOutputMapper.mapToModel(savedEntity);
    }
    public UserModel findUserById(long id)
    {
        Optional<UserOutputEntity> optional=this.userJPARepository.findById(id);
        if(optional.isPresent())
        {
            return userOutputMapper.mapToModel(optional.get());
        }
        else
        {
            throw  new RuntimeException("User with given Id not found");
        }
    }
    public List<UserModel> getAllUsers()
    {
        List<UserOutputEntity> list= this.userJPARepository.findAll();
        List<UserModel> finalList=new ArrayList<>();
        for (UserOutputEntity userOutputEntity : list) {
            UserModel userModel = userOutputMapper.mapToModel(userOutputEntity);
            finalList.add(userModel);
        }
        return finalList;
    }
    public UserModel findUserByEmail(String email)
    {
        Optional<UserOutputEntity> optional=this.userJPARepository.findByEmail(email);
        if(optional.isPresent())
        {
            return userOutputMapper.mapToModel(optional.get());
        }
        else
        {
            throw  new RuntimeException("User with given Email not found");
        }

    }
    public void deleteUserById(long id) {
        this.userJPARepository.deleteById(id);
    }
}
