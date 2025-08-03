package GFG.DigitalLibraryProject.Digital.Library.Project.service;

import GFG.DigitalLibraryProject.Digital.Library.Project.entity.output.MembershipOutputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.enums.MembershipStatus;
import GFG.DigitalLibraryProject.Digital.Library.Project.exceptions.MembershipAlreadyExistsException;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.MembershipModel;
import GFG.DigitalLibraryProject.Digital.Library.Project.repository.jpa.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MembershipService {
    private MembershipRepository membershipRepository;

    @Autowired
    public MembershipService(MembershipRepository membershipRepository)
    {

        this.membershipRepository=membershipRepository;
    }

    @Transactional
    public MembershipModel addMembership(MembershipModel membershipModel)
    {
        //Here in this function there are 2 database calls
        //and in case of multiple database calls present inside a single function
        //it may lead to a race condition
        //In order to handle this we must add transactional annotation
        if(this.getActiveMembershipStatus(membershipModel.getUser().getId()))
        {
            throw new MembershipAlreadyExistsException();
        }
        else
        {
            return this.membershipRepository.addMembership(membershipModel);
        }

    }

    public MembershipModel updateMembershipStatus(long membershipId, MembershipStatus membershipStatus)
    {
        return this.membershipRepository.updateMembershipStatus(membershipId,membershipStatus);
    }

    public MembershipModel getMembershipDetails(long id)

    {
        return this.membershipRepository.getMembershipDetails(id);
    }

    public boolean getActiveMembershipStatus(long userId)
    {
        if(this.membershipRepository.getNonExpiredMembershipForUser(userId).isPresent())
        {

            return true;
        }

        return false;
    }
}
