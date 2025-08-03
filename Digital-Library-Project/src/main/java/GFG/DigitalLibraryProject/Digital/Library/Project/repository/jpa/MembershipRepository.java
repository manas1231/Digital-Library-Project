package GFG.DigitalLibraryProject.Digital.Library.Project.repository.jpa;

import GFG.DigitalLibraryProject.Digital.Library.Project.entity.output.MembershipOutputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.enums.MembershipStatus;
import GFG.DigitalLibraryProject.Digital.Library.Project.exceptions.ResourceNotFoundException;
import GFG.DigitalLibraryProject.Digital.Library.Project.mappers.output.MembershipOutputMapper;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.MembershipModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MembershipRepository {
    private MembershipJPARepository membershipJPARepository;
    private MembershipOutputMapper membershipOutputMapper;

    @Autowired
    public MembershipRepository(MembershipJPARepository membershipJPARepository,MembershipOutputMapper membershipOutputMapper)
    {
        this.membershipJPARepository=membershipJPARepository;
        this.membershipOutputMapper=membershipOutputMapper;
    }
    public MembershipModel addMembership(MembershipModel membershipModel)
    {
        //To add membership we must check whether current user is already an active member or not
        //In case of active member we cannot add membership
        MembershipOutputEntity membershipOutputEntity=membershipOutputMapper.mapFromModel(membershipModel);
        MembershipOutputEntity savedEntity=this.membershipJPARepository.save(membershipOutputEntity);
        return membershipOutputMapper.mapToModel(savedEntity);
    }
    public MembershipModel getMembershipDetails(long id)
    {
        Optional<MembershipOutputEntity> optional =this.membershipJPARepository.findById(id);
        if(optional.isPresent())
        {
            return membershipOutputMapper.mapToModel(optional.get());
        }
        else
        {
            throw new ResourceNotFoundException("Membership details of given id not found");
        }
    }
    public MembershipModel updateMembershipStatus(long id, MembershipStatus membershipStatus)
    {
        Optional<MembershipOutputEntity> optional =this.membershipJPARepository.findById(id);
        MembershipOutputEntity membershipOutputEntity;
        if(optional.isPresent())
        {
            membershipOutputEntity=optional.get();
        }
        else
        {
            throw new ResourceNotFoundException("Membership details of given id not found");
        }
        membershipOutputEntity.setStatus(membershipStatus);
        return membershipOutputMapper.mapToModel
                (membershipJPARepository.save(membershipOutputEntity));
    }
    public Optional<MembershipOutputEntity> getNonExpiredMembershipForUser(long userId)
    {
        return this.membershipJPARepository.
                findByUser_IdAndUser_Memberships_StatusNot(userId,MembershipStatus.EXPIRED);
    }
}
