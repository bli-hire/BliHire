package com.empatkepala.service.impl;

import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.User;
import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.Role;
import com.empatkepala.repository.MppDetailRepository;
import com.empatkepala.repository.MppRepository;
import com.empatkepala.service.UserService;
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
public class MppServiceImplTest {

    @MockBean
    MppRepository mppRepository;

    @MockBean
    MppDetailRepository mppDetailRepository;

    @MockBean
    UserService userService;

    @LocalServerPort
    private int serverPort;

    private static final Role ROLE = Role.CEO;
    private static final String NAME = "Dummy";
    private static final String SURNAME = "Account";
    private static final String PASSWORD = "dummy";
    private static final String EMAIL = "dummy@account.com";

    private static final Department DEPARTMENT = Department.Finance;

    @Test
    public void getRequestedByByMppId()
    {

    }

    @Test
    public void getMppById()
    {
        Mpp mpp = new Mpp(new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL), DEPARTMENT);
        when(mppRepository.findOne(mpp.getId())).thenReturn(mpp);

        given()
                .contentType("application/json")
                .when()
                .port(serverPort)
                .get("/mpp/" + String.valueOf(mpp.getId()))
                .then()
                .body(containsString(DEPARTMENT.name()))
                .statusCode(200);

        verify(mppRepository).findOne(mpp.getId());
    }

    @Test
    public void getAllMpp()
    {
        when(mppRepository.findAll()).thenReturn(Arrays.asList(new Mpp(new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL), DEPARTMENT)));

        given()
                .contentType("application/json")
                .when()
                .port(serverPort)
                .get("/mpp")
                .then()
                .body(containsString(DEPARTMENT.name()))
                .statusCode(200);

        verify(mppRepository).findAll();
    }




}
