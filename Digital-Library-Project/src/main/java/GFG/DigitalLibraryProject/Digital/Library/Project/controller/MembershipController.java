package GFG.DigitalLibraryProject.Digital.Library.Project.controller;

import GFG.DigitalLibraryProject.Digital.Library.Project.adapter.MembershipAdapter;
import GFG.DigitalLibraryProject.Digital.Library.Project.entity.input.MembershipInputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.MembershipModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membership")
public class MembershipController {

    private MembershipAdapter membershipAdapter;

    @Autowired
    public MembershipController(MembershipAdapter membershipAdapter)
    {
        this.membershipAdapter=membershipAdapter;
    }

    @PostMapping("/addmembership")
    public MembershipModel addMembership(@Valid @RequestBody MembershipInputEntity membershipInputEntity)
    {
        return this.membershipAdapter.addMembership(membershipInputEntity);
    }

    @GetMapping("/getMembershipDetails/{id}")
    public MembershipModel getMembershipDetails(@Valid @PathVariable int id)
    {
        return this.membershipAdapter.getMembershipDetails(id);
    }
}
