package GFG.DigitalLibraryProject.Digital.Library.Project.mappers.output;

import GFG.DigitalLibraryProject.Digital.Library.Project.adapter.UserAdapter;
import GFG.DigitalLibraryProject.Digital.Library.Project.entity.output.MembershipOutputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.MembershipModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MembershipOutputMapper {

    private UserAdapter userAdapter;
    private UserOutputMapper userOutputMapper;
    @Autowired
    public MembershipOutputMapper(UserAdapter userAdapter,UserOutputMapper userOutputMapper)
    {
        this.userAdapter=userAdapter;
        this.userOutputMapper=userOutputMapper;
    }

    public MembershipModel mapToModel(MembershipOutputEntity membershipOutputEntity)
    {
        return MembershipModel.builder()
                .id(membershipOutputEntity.getId())
                .user(userOutputMapper.mapToModel(membershipOutputEntity.getUser()))
                .startDate(membershipOutputEntity.getStartData())
                .endDate(membershipOutputEntity.getEndDate())
                .status(membershipOutputEntity.getStatus())
                .membershipPlan(membershipOutputEntity.getPlan())
                .build();

    }

    public MembershipOutputEntity mapFromModel(MembershipModel membershipModel)
    {
        return MembershipOutputEntity.builder()
                .id(membershipModel.getId())
                .user(userOutputMapper.mapFromModel(membershipModel.getUser()))
                .startData(membershipModel.getStartDate())
                .endDate(membershipModel.getEndDate())
                .status(membershipModel.getStatus())
                .plan(membershipModel.getMembershipPlan())
                .build();
    }
}
