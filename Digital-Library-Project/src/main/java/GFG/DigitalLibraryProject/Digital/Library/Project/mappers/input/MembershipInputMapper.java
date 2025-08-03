package GFG.DigitalLibraryProject.Digital.Library.Project.mappers.input;

import GFG.DigitalLibraryProject.Digital.Library.Project.adapter.UserAdapter;
import GFG.DigitalLibraryProject.Digital.Library.Project.entity.input.MembershipInputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.enums.MembershipPlan;
import GFG.DigitalLibraryProject.Digital.Library.Project.enums.MembershipStatus;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.MembershipModel;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.UserModel;
import GFG.DigitalLibraryProject.Digital.Library.Project.repository.jpa.UserRepository;
import lombok.Builder;
import lombok.Data;
import lombok.With;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static GFG.DigitalLibraryProject.Digital.Library.Project.enums.MembershipPlan.*;

@Component
public class MembershipInputMapper {

    private UserAdapter userAdapter;
    private UserRepository userRepository;
    @Autowired
    public MembershipInputMapper(UserAdapter userAdapter,UserRepository userRepository)
    {

        this.userAdapter=userAdapter;
        this.userRepository=userRepository;
    }
    public MembershipModel mapToModel(MembershipInputEntity membershipInputEntity)
    {
        UserModel userModel = this.userRepository.findUserById(membershipInputEntity.getUser_id());
        Instant[] startEnd = this.getStartAndEndDate(membershipInputEntity);
        return MembershipModel.builder()
                .id(membershipInputEntity.getId())
                .user(userAdapter.findUserById(membershipInputEntity.getUser_id()))
                .startDate(startEnd[0])
                .endDate(startEnd[1])
                .status(MembershipStatus.ACTIVE)
                .membershipPlan(membershipInputEntity.getPlanName())
                .build();
    }
    private Instant[] getStartAndEndDate(MembershipInputEntity membershipInputEntity) {
        MembershipPlan plan = membershipInputEntity.getPlanName();
        Instant start = Instant.now();
        Instant end = null;
        switch (plan) {
            case THREE_MONTHS -> end = this.addMonthsToInstant(start, 3);
            case SIX_MONTHS -> end = this.addMonthsToInstant(start, 6);
            case ONE_YEAR -> end = this.addMonthsToInstant(start, 12);
        }
        return new Instant[]{start, end};
    }
    private Instant addMonthsToInstant(Instant instant, int monthsToAdd) {
        ZoneId zone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        ZonedDateTime updated = zonedDateTime.plusMonths(monthsToAdd);
        return updated.toInstant();
    }
}

