package com.empatkepala.utility;

import com.empatkepala.entity.Fpk;
import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.User;
import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.Role;
import com.empatkepala.repository.FpkRepository;
import com.empatkepala.repository.MppRepository;
import com.empatkepala.repository.UserRepository;
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
        user2.setDepartment(Department.Finance);
        userRepository.save(user2);

        User user3 = new User();
        user3.setName("Dummy Team Member Department");
        user3.setSurname("Dummy Member");
        user3.setRole(Role.DepartmentTeamMember);
        user3.setPassword("member-department");
        user3.setDepartment(Department.Finance);
        user3.setEmail("dummy-memberd@account.com");
        userRepository.save(user3);

        User user4 = new User();
        user4.setName("Human Resource");
        user4.setSurname("Account Human Resource");
        user4.setRole(Role.HR);
        user4.setPassword("dummy-hrd");
        user4.setEmail("dummy-hrd@account.com");
        userRepository.save(user4);

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
        fpk.setDateNeeded(new Date(2017,12,3));
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
        fpk2.setDateNeeded(new Date(2017,12,3));
        fpk2.setJobPositionRequester("Senior Developer");
        fpkRepository.save(fpk2);


    }

}
