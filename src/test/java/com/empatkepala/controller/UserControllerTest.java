package com.empatkepala.controller;

import com.empatkepala.entity.User;
import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.Role;
import com.empatkepala.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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


//    @Test
//    public void all() {
//        when(userService.getAllUser()).thenReturn(Arrays.asList(new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL)));
//
//        given()
//                .contentType("application/json")
//                .when()
//                .port(serverPort)
//                .get("/users")
//                .then()
//                .body(containsString(NAME))
//                .statusCode(200);
//
//        verify(userService).getAllUser();
//    }



}
