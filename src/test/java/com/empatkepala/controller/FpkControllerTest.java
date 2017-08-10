package com.empatkepala.controller;


import com.empatkepala.entity.Fpk;
import com.empatkepala.enumeration.Department;
import com.empatkepala.service.FpkService;
import com.empatkepala.service.JobVacancyService;
import com.empatkepala.service.UserService;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class FpkControllerTest {

    @MockBean
    FpkService fpkService;
    @MockBean
    UserService userService;
    @MockBean
    JobVacancyService jobVacancyService;

    @LocalServerPort
    private int serverPort;

    @Test
    public void getAllFpk(){

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

        when(fpkService.getAllData()).thenReturn(Arrays.asList(fpk));

        given()
                .contentType("application/json")
                .when()
                .port(serverPort)
                .get("/fpk/getAllFpk")
                .then()
                .body(containsString("Tes"))
                .statusCode(200);

        verify(fpkService).getAllData();
    }

    @Test
    public void findMppById()
    {
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
        when(fpkService.getFpk(fpk.getIdFpk())).thenReturn(fpk);

        given()
                .contentType("application/json")
                .when()
                .port(serverPort)
                .get("/fpk/" + String.valueOf(fpk.getIdFpk()))
                .then()
                .body(containsString("Tes"))
                .statusCode(200);

        verify(fpkService).getFpk(fpk.getIdFpk());

    }


}