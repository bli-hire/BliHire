package com.empatkepala.controller;


import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.MppDetail;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddMppRequest;
import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.Role;
import com.empatkepala.service.JobVacancyService;
import com.empatkepala.service.MppService;
import com.empatkepala.service.UserService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class MppControllerTest {

    @MockBean
    private MppService mppService;
    @MockBean
    private UserService userService;
    @MockBean
    private JobVacancyService jobVacancyService;

    @LocalServerPort
    private int serverPort;

    private static final Role ROLE = Role.CEO;
    private static final String NAME = "Dummy";
    private static final String SURNAME = "Account";
    private static final String PASSWORD = "dummy";
    private static final String EMAIL = "dummy@account.com";

    private static final Department DEPARTMENT = Department.Finance;

    @Test
    public void addMpp()
    {
        AddMppRequest addMppRequest = new AddMppRequest();

        given()
                .contentType("application/json")
                .content(addMppRequest)
                .when()
                .port(serverPort)
                .post("/mpp")
                .then()
                .statusCode(200);
        //verify(mppService).addMpp(addMppRequest);
    }

    @Test
    public void findAllMpp()
    {
        when(mppService.getAllMpp()).thenReturn(Arrays.asList(new Mpp(new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL), DEPARTMENT)));

        given()
                .contentType("application/json")
                .when()
                .port(serverPort)
                .get("/mpp")
                .then()
                .body(containsString(DEPARTMENT.name()))
                .statusCode(200);

        verify(mppService).getAllMpp();
    }

    @Test
    public void findMppById()
    {
        Mpp mpp = new Mpp(new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL), DEPARTMENT);
        when(mppService.getMppById(mpp.getId())).thenReturn(mpp);

        given()
                .contentType("application/json")
                .when()
                .port(serverPort)
                .get("/mpp/" + String.valueOf(mpp.getId()))
                .then()
                .body(containsString(DEPARTMENT.name()))
                .statusCode(200);

        verify(mppService).getMppById(mpp.getId());

    }

    @Test
    public void approveMpp()
    {

    }

    @Test
    public void rejectMpp()
    {

    }

    @Test
    public void findMppByDepartment()
    {
        Mpp mpp = new Mpp(new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL), DEPARTMENT);
        Collection<Mpp> data = new ArrayList<>();
        data.add(mpp);

        when(mppService.getMppByDepartment(DEPARTMENT)).thenReturn(data);

        given()
                .contentType("application/json")
                .when()
                .header("Department", DEPARTMENT)
                .port(serverPort)
                .get("/mpp/byDepartment")
                .then()
                .body(containsString(mpp.getDepartment().name()))
                .statusCode(200);

        verify(mppService).getMppByDepartment(DEPARTMENT);
    }

    @Test
    public void findMppByDepartmentActive()
    {
        Mpp mpp = new Mpp(new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL), DEPARTMENT);
        Collection<Mpp> data = new ArrayList<>();
        data.add(mpp);

        when(mppService.getMppActiveByDepartment(DEPARTMENT)).thenReturn(data);

        given()
                .contentType("application/json")
                .when()
                .header("Department", DEPARTMENT)
                .port(serverPort)
                .get("/mpp/byDepartment/active")
                .then()
                .body(containsString(mpp.getDepartment().name()))
                .statusCode(200);

        verify(mppService).getMppActiveByDepartment(DEPARTMENT);
    }

    

    @After
    public void tearDown()
    {
        //verifyNoMoreInteractions(this.mppService);
    }


}
