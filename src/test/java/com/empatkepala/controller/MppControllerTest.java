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
                .body(containsString("Success Add Mpp"))
                .statusCode(200);
        verify(mppService).addMpp(addMppRequest);
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

    @Test
    public void findMppByDepartmentHistory()
    {
        Mpp mpp = new Mpp(new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL), DEPARTMENT);
        Collection<Mpp> data = new ArrayList<>();
        data.add(mpp);

        when(mppService.getMppHistoryByDepartment(DEPARTMENT)).thenReturn(data);

        given()
                .contentType("application/json")
                .when()
                .header("Department", DEPARTMENT)
                .port(serverPort)
                .get("/mpp/byDepartment/history")
                .then()
                .body(containsString(mpp.getDepartment().name()))
                .statusCode(200);

        verify(mppService).getMppHistoryByDepartment(DEPARTMENT);
    }

    @Test
    public void findMppByDepartmentAccepted()
    {
        Mpp mpp = new Mpp(new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL), DEPARTMENT);
        Collection<Mpp> data = new ArrayList<>();
        data.add(mpp);

        when(mppService.getMppAcceptedByDepartment(DEPARTMENT)).thenReturn(data);

        given()
                .contentType("application/json")
                .when()
                .header("Department", DEPARTMENT)
                .port(serverPort)
                .get("/mpp/byDepartment/accepted")
                .then()
                .body(containsString(mpp.getDepartment().name()))
                .statusCode(200);

        verify(mppService).getMppAcceptedByDepartment(DEPARTMENT);
    }

    @Test
    public void findMppByDepartmentAcceptedNotPublished()
    {
        Mpp mpp = new Mpp(new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL), DEPARTMENT);
        Collection<Mpp> data = new ArrayList<>();
        data.add(mpp);

        when(mppService.getMppAcceptedByDepartmentNotPublished(DEPARTMENT)).thenReturn(data);

        given()
                .contentType("application/json")
                .when()
                .header("Department", DEPARTMENT)
                .port(serverPort)
                .get("/mpp/byDepartment/acceptedNotPublished")
                .then()
                .body(containsString(mpp.getDepartment().name()))
                .statusCode(200);

        verify(mppService).getMppAcceptedByDepartmentNotPublished(DEPARTMENT);
    }

    @Test
    public void findByRequestedBy()
    {
        User user = new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL);
        Mpp mpp = new Mpp(user , DEPARTMENT);
        Collection<Mpp> data = new ArrayList<>();
        data.add(mpp);

        when(mppService.getMppByRequestedBy(userService.getUser(user.getId()))).thenReturn(data);

        given()
                .contentType("application/json")
                .when()
                .header("userId", user.getId())
                .port(serverPort)
                .get("/mpp/requestedBy")
                .then()
                .body(containsString(mpp.getDepartment().name()))
                .statusCode(200);

        verify(mppService).getMppByRequestedBy(userService.getUser(user.getId()));
    }

    @Test
    public void edit()
    {

    }

    @Test
    public void findMppByRequestedPending()
    {
        User user = new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL);
        Mpp mpp = new Mpp(user , DEPARTMENT);
        Collection<Mpp> data = new ArrayList<>();
        data.add(mpp);

        when(mppService.getMppByRequestedByPending(userService.getUser(user.getId()))).thenReturn(data);

        given()
                .contentType("application/json")
                .when()
                .header("userId", user.getId())
                .port(serverPort)
                .get("/mpp/byRequested/pending")
                .then()
                .body(containsString(mpp.getDepartment().name()))
                .statusCode(200);

        verify(mppService).getMppByRequestedByPending(userService.getUser(user.getId()));
    }

    @Test
    public void findMppByRequestedAccepted()
    {
        User user = new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL);
        Mpp mpp = new Mpp(user , DEPARTMENT);
        Collection<Mpp> data = new ArrayList<>();
        data.add(mpp);

        when(mppService.getMppByRequestedByAccepted(userService.getUser(user.getId()))).thenReturn(data);

        given()
                .contentType("application/json")
                .when()
                .header("userId", user.getId())
                .port(serverPort)
                .get("/mpp/byRequested/accepted")
                .then()
                .body(containsString(mpp.getDepartment().name()))
                .statusCode(200);

        verify(mppService).getMppByRequestedByAccepted(userService.getUser(user.getId()));
    }

    @Test
    public void findMppByRequestedRejected()
    {
        User user = new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL);
        Mpp mpp = new Mpp(user , DEPARTMENT);
        Collection<Mpp> data = new ArrayList<>();
        data.add(mpp);

        when(mppService.getMppByRequestedByRejected(userService.getUser(user.getId()))).thenReturn(data);

        given()
                .contentType("application/json")
                .when()
                .header("userId", user.getId())
                .port(serverPort)
                .get("/mpp/byRequested/rejected")
                .then()
                .body(containsString(mpp.getDepartment().name()))
                .statusCode(200);

        verify(mppService).getMppByRequestedByRejected(userService.getUser(user.getId()));
    }

    @Test
    public void findAcceptedMppByAcceptorAndDepartment()
    {
        User user = new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL);
        Mpp mpp = new Mpp(user , DEPARTMENT);
        Collection<Mpp> data = new ArrayList<>();
        data.add(mpp);

        when(mppService.getAcceptedMppByAcceptorAndDepartment(userService.getUser(user.getId()) , DEPARTMENT)).thenReturn(data);

        given()
                .contentType("application/json")
                .when()
                .header("userId", user.getId())
                .and()
                .header("department", DEPARTMENT)
                .port(serverPort)
                .get("/mpp/byDepartment/accepted/ceo")
                .then()
                .body(containsString("Success Get Accepted Mpp By Acceptor"))
                .statusCode(200);

        verify(mppService).getAcceptedMppByAcceptorAndDepartment(userService.getUser(user.getId()) , DEPARTMENT);
    }

    @Test
    public void findRejectedMppByRejectorAndDepartment()
    {
        User user = new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL);
        Mpp mpp = new Mpp(user , DEPARTMENT);
        Collection<Mpp> data = new ArrayList<>();
        data.add(mpp);

        when(mppService.getRejectedMppByRejectorAndDepartment(userService.getUser(user.getId()) , DEPARTMENT)).thenReturn(data);

        given()
                .contentType("application/json")
                .when()
                .header("userId", user.getId())
                .and()
                .header("department", DEPARTMENT)
                .port(serverPort)
                .get("/mpp/byDepartment/rejected/ceo")
                .then()
                .body(containsString("Success Get Rejected Mpp By Rejector"))
                .statusCode(200);

        verify(mppService).getRejectedMppByRejectorAndDepartment(userService.getUser(user.getId()) , DEPARTMENT);
    }

    @Test
    public void publishJobVacancy()
    {

    }

    @Test
    public void findMppByDepartmentPublished()
    {
        User user = new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL);
        Mpp mpp = new Mpp(user , DEPARTMENT);
        Collection<Mpp> data = new ArrayList<>();
        data.add(mpp);

        when(mppService.getPublishedMppByDepartment(DEPARTMENT)).thenReturn(data);

        given()
                .contentType("application/json")
                .when()
                .header("department", DEPARTMENT)
                .port(serverPort)
                .get("/mpp/byDepartment/published")
                .then()
                .body(containsString("Success Get Published Mpp By Department"))
                .statusCode(200);

        verify(mppService).getPublishedMppByDepartment(DEPARTMENT);
    }

    @After
    public void tearDown()
    {
        //verifyNoMoreInteractions(this.mppService);
    }


}
