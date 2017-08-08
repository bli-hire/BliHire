package com.empatkepala.utility;

import com.empatkepala.entity.Fpk;
import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.User;
import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.Role;
import com.empatkepala.repository.FpkRepository;
import com.empatkepala.repository.MppRepository;
import com.empatkepala.repository.UserRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;


@Component
public class DatabaseSeeder {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FpkRepository fpkRepository;

    @Autowired
    private MppRepository mppRepository;
    @PostConstruct
    private void initDataTest(){

        User user = new User();
        user.setName("Dummy");
        user.setSurname("Account");
        user.setRole(Role.CEO);
        user.setPassword("dummy");
        user.setEmail("dummy@account.com");
        userRepository.save(user);

        User user2 = new User();
        user2.setName("Dummy Head Department");
        user2.setSurname("Dummy Head");
        user2.setRole(Role.DepartmentHead);
        user2.setPassword("head-department");
        user2.setEmail("dummy-head@account.com");
        user2.setDepartment(Department.Technology);
        userRepository.save(user2);

        User user3 = new User();
        user3.setName("Dummy Team Member Department");
        user3.setSurname("Dummy Member");
        user3.setRole(Role.DepartmentTeamMember);
        user3.setPassword("member-department");
        user3.setDepartment(Department.Technology);
        user3.setEmail("dummy-member@account.com");
        userRepository.save(user3);

        User user4 = new User();
        user4.setName("Human Resource");
        user4.setSurname("Account Human Resource");
        user4.setRole(Role.HR);
        user4.setDepartment(Department.HumanResource);
        user4.setPassword("dummy-hrd");
        user4.setEmail("dummy-hrd@account.com");
        userRepository.save(user4);

        User user5 = new User();
        user5.setName("Human Resource Head");
        user5.setSurname("Account Human Resource");
        user5.setRole(Role.HeadHR);
        user5.setDepartment(Department.HumanResource);
        user5.setPassword("dummy-hrd-head");
        user5.setEmail("dummy-hrd-head@account.com");
        userRepository.save(user5);

        /**
         * Data Seed for FPK
         * */
        Fpk fpk = new Fpk();
        fpk.setCompleteness("Tes");
        fpk.setReason("Tes");
        fpk.setDepartment(Department.Finance);
        fpk.setEmployeeStatus("Tes");
        fpk.setFitnessWithMpp("Tes");
        fpk.setNumberOfPerson(5);
        fpk.setSchool("Tes");
        fpk.setSkillKnowledge("Tes");
        fpk.setWorkExperience("Tes");
        fpk.setDateNeeded(new DateTime(2017,12,30,0,0));
        fpk.setJobPositionRequester("Senior Developer");
        fpkRepository.save(fpk);

        Mpp mpp = new Mpp();
        mpp.setReason("Tes");
        mpp.setDepartment(Department.Finance);
        mpp.setEmployeeStatus("Tes");
        mppRepository.save(mpp);

        Mpp mpp2 = new Mpp();
        mpp2.setReason("Tes");
        mpp2.setDepartment(Department.Finance);
        mpp2.setEmployeeStatus("Tes");
        mpp2.setAccept(true);
        mppRepository.save(mpp2);

        Mpp mpp3 = new Mpp();
        mpp3.setReason("Tes");
        mpp3.setDepartment(Department.Finance);
        mpp3.setEmployeeStatus("Tes");
        mpp3.setAccept(true);
        mppRepository.save(mpp3);

        Fpk fpk2 = new Fpk();
        fpk2.setCompleteness("Tes2");
        fpk2.setReason("Tes2");
        fpk2.setDepartment(Department.HumanResource);
        fpk2.setEmployeeStatus("Tes2");
        fpk2.setFitnessWithMpp("Tes2");
        fpk2.setNumberOfPerson(5);
        fpk2.setSchool("Tes2");
        fpk2.setSkillKnowledge("Tes2");
        fpk2.setWorkExperience("Tes2");
        fpk2.setDateNeeded(new DateTime(2017,12,3,0,0));
        fpk2.setJobPositionRequester("Senior Developer");
        fpk2.setApproveCeo(false);
        fpk2.setApproveHead(false);
        fpk2.setStatusHeadApprove(false);
        fpk2.setStatusCeoApprove(false);
        fpk2.setAccept(false);
        fpk2.setStatusAccept(false);
        fpkRepository.save(fpk2);

        Fpk fpk3 = new Fpk();
        fpk3.setCompleteness("Ready To Publish");
        fpk3.setReason("Ready To Publish");
        fpk3.setDepartment(Department.HumanResource);
        fpk3.setEmployeeStatus("Ready To Publish");
        fpk3.setFitnessWithMpp("Ready To Publish");
        fpk3.setNumberOfPerson(5);
        fpk3.setSchool("Ready To Publish");
        fpk3.setSkillKnowledge("Ready To Publish");
        fpk3.setWorkExperience("Ready To Publish");
        fpk3.setDateNeeded(new DateTime(2017,12,3,0,0));
        fpk3.setJobPositionRequester("Ready To Publish");
        fpk3.setApproveCeo(true);
        fpk3.setApproveHead(true);
        fpk3.setStatusHeadApprove(true);
        fpk3.setStatusCeoApprove(true);
        fpk3.setAccept(false);
        fpk3.setStatusAccept(false);
        fpkRepository.save(fpk3);

        Fpk fpk4 = new Fpk();
        fpk4.setCompleteness("Published");
        fpk4.setReason("Published");
        fpk4.setDepartment(Department.HumanResource);
        fpk4.setEmployeeStatus("Published");
        fpk4.setFitnessWithMpp("Published");
        fpk4.setNumberOfPerson(5);
        fpk4.setSchool("Published");
        fpk4.setSkillKnowledge("Published");
        fpk4.setWorkExperience("Published");
        fpk4.setDateNeeded(new DateTime(2017,12,3,0,0));
        fpk4.setJobPositionRequester("Published");
        fpk4.setApproveCeo(true);
        fpk4.setApproveHead(true);
        fpk4.setStatusHeadApprove(true);
        fpk4.setStatusCeoApprove(true);
        fpk4.setAccept(true);
        fpk4.setStatusAccept(true);
        fpkRepository.save(fpk4);

    }

}
