package GFG.DigitalLibraryProject.Digital.Library.Project.adapter;

import GFG.DigitalLibraryProject.Digital.Library.Project.entity.input.MembershipInputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.enums.MembershipStatus;
import GFG.DigitalLibraryProject.Digital.Library.Project.mappers.input.MembershipInputMapper;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.MembershipModel;
import GFG.DigitalLibraryProject.Digital.Library.Project.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MembershipAdapter {
    private MembershipService membershipService;
    private MembershipInputMapper membershipInputMapper;

    @Autowired
    public MembershipAdapter(MembershipService membershipService,MembershipInputMapper membershipInputMapper)
    {
        this.membershipService=membershipService;
        this.membershipInputMapper=membershipInputMapper;
    }

    public MembershipModel addMembership(MembershipInputEntity membershipInputEntity)
    {

        MembershipModel membershipModel=membershipInputMapper.mapToModel(membershipInputEntity);
        return this.membershipService.addMembership(membershipModel);
    }

    public MembershipModel getMembershipDetails(long id)
    {
        return this.membershipService.getMembershipDetails(id);
    }

    public MembershipModel changeMembershipStatus(long membershipId, MembershipStatus status) {
        return this.membershipService.updateMembershipStatus(membershipId, status);
    }

}
