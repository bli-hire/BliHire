package com.empatkepala.service.impl;


import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddUserRequest;
import com.empatkepala.entity.request.LoginRequest;
import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.Role;
import com.empatkepala.repository.UserRepository;
import org.junit.After;
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
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class UserServiceImplTest {

    @MockBean
    private UserRepository userRepository;

    @LocalServerPort
    private int serverPort;

    private static final Role ROLE = Role.CEO;
    private static final Department DEPARTMENT = Department.HumanResource;
    private static final String NAME = "Dummy";
    private static final String SURNAME = "Account";
    private static final String PASSWORD = "dummy";
    private static final String EMAIL = "dummy@account.com";

    @Test
    public void getAllUser()
    {
        when(userRepository.findAll()).thenReturn(Arrays.asList(new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL)));

        given()
                .contentType("application/json")
                .when()
                .port(serverPort)
                .get("/users")
                .then()
                .body(containsString(NAME))
                .statusCode(200);

        verify(userRepository).findAll();
    }

    @Test
    public void addUser()
    {
        AddUserRequest addUserRequest = new AddUserRequest(NAME, SURNAME, PASSWORD, EMAIL, ROLE, DEPARTMENT);

        User user = new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL);

        given()
                .contentType("application/json")
                .content(addUserRequest)
                .when()
                .port(serverPort)
                .post("/users/add")
                .then()
                .statusCode(200);
        //verify(userRepository).save(user);
    }

    @Test
    public void login()
    {
        User user = new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL);

        LoginRequest loginRequest = new LoginRequest();

        loginRequest.setEmail(EMAIL);
        loginRequest.setPassword(PASSWORD);

        when(userRepository.findOneByEmailAndPassword(EMAIL, PASSWORD)).thenReturn(user);

        given().
                contentType("application/json")
                .content(loginRequest)
                .when()
                .port(serverPort)
                .post("/users/login")
                .then()
                .statusCode(200);

        verify(userRepository).findOneByEmailAndPassword(EMAIL, PASSWORD);
    }

    @After
    public void tearDown()
    {
        //verifyNoMoreInteractions(this.userRepository);
    }

}
