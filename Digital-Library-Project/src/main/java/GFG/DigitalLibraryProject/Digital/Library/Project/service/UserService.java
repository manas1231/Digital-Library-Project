package GFG.DigitalLibraryProject.Digital.Library.Project.service;

import GFG.DigitalLibraryProject.Digital.Library.Project.exceptions.ResourceNotFoundException;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.UserModel;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.UserPrincipal;
import GFG.DigitalLibraryProject.Digital.Library.Project.repository.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    public UserModel save(UserModel userModel)
    {
        return this.userRepository.save(userModel);
    }

    public UserModel findUserById(long id)
    {
        return this.userRepository.findUserById(id);
    }

    public List<UserModel> getAllUsers()
    {
        return this.userRepository.getAllUsers();
    }

    public void deleteUserById(long id) {
        this.userRepository.deleteUserById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
         UserModel usermodel=this.userRepository.findUserByEmail(username);
         return new UserPrincipal(usermodel);
        }catch (ResourceNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
