package com.empatkepala.controller;

import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddUserRequest;
import com.empatkepala.entity.request.LoginRequest;
import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.Role;
import com.empatkepala.repository.UserRepository;
import com.empatkepala.service.UserService;
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
import static org.mockito.Mockito.*;

/**
 * Created by ARDI on 7/27/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class UserControllerTest {

    @MockBean
    private UserService userService;


    @LocalServerPort
    private int serverPort;

    private static final Role ROLE = Role.CEO;
    private static final Department DEPARTMENT = Department.HumanResource;
    private static final String NAME = "Dummy";
    private static final String SURNAME = "Account";
    private static final String PASSWORD = "dummy";
    private static final String EMAIL = "dummy@account.com";


    @Test
    public void findAllUserTest()
    {
        when(userService.getAllUser()).thenReturn(Arrays.asList(new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL)));

        given()
                .contentType("application/json")
                .when()
                .port(serverPort)
                .get("/users")
                .then()
                .body(containsString(NAME))
                .statusCode(200);

        verify(userService).getAllUser();
    }

    @Test
    public void addUser()
    {
        User user = new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL);
        AddUserRequest addUserRequest = new AddUserRequest(NAME, SURNAME, PASSWORD, EMAIL, ROLE, DEPARTMENT);


        given()
                .contentType("application/json")
                .content(addUserRequest)
                .when()
                .port(serverPort)
                .post("/users/add")
                .then()
                .statusCode(200);
        //verify(userService, atLeast(1)).addUser(addUserRequest);

    }

    @Test
    public void login()
    {
        User user = new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL);

        LoginRequest loginRequest = new LoginRequest();

        loginRequest.setEmail(EMAIL);
        loginRequest.setPassword(PASSWORD);

        when(userService.getUser(EMAIL, PASSWORD)).thenReturn(user);

        given().
                contentType("application/json")
                .content(loginRequest)
                .when()
                .port(serverPort)
                .post("/users/login")
                .then()
                .statusCode(200);

        verify(userService).getUser(EMAIL, PASSWORD);
    }

    @After
    public void tearDown()
    {
        //verifyNoMoreInteractions(this.userService);
    }


}