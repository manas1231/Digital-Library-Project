package GFG.DigitalLibraryProject.Digital.Library.Project.controller;

import GFG.DigitalLibraryProject.Digital.Library.Project.adapter.UserAdapter;
import GFG.DigitalLibraryProject.Digital.Library.Project.entity.input.UserInputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.entity.output.UserOutputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.UserModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserAdapter userAdapter;

    @Autowired
    public UserController(UserAdapter userAdapter)
    {
        this.userAdapter=userAdapter;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserInputEntity userInputEntity)
    {
        return new ResponseEntity<>(this.userAdapter.save(userInputEntity), HttpStatus.CREATED);
    }

    @GetMapping("/getUserById/{id}")
    public UserModel getUserById(@PathVariable long id)
    {
        return this.userAdapter.findUserById(id);
    }

    @GetMapping("/getAllUsers")
    public List<UserModel> getAllUsers()
    {
        return this.userAdapter.getAllUsers();
    }

    @DeleteMapping("/deleteUserById/{id}")
    public void deleteUserById(@PathVariable long id)
    {
        this.userAdapter.deleteUserById(id);
    }
}
