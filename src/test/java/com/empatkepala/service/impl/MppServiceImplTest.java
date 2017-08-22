package com.empatkepala.service.impl;

import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddMppRequest;
import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.Role;
import com.empatkepala.repository.MppDetailRepository;
import com.empatkepala.repository.MppRepository;
import com.empatkepala.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class MppServiceImplTest {

    @InjectMocks
    MppServiceImpl mppService;

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
        User user = new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL);
        Mpp mpp = new Mpp(user , DEPARTMENT);
        when(mppRepository.findOne(mpp.getId())).thenReturn(mpp);


    }

    @Test
    public void getMppById()
    {
        User user = new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL);
        Mpp mpp = new Mpp(user , DEPARTMENT);

        when(mppRepository.findOne(mpp.getId())).thenReturn(mpp);

        Mpp resp = mppRepository.findOne(mpp.getId());
        assertEquals(resp.getId() , mpp.getId());
        assertEquals(resp.getDepartment() , mpp.getDepartment());
        assertEquals(resp.getRequestedBy() , user);
        assertEquals(resp , mpp);

        verify(mppRepository).findOne(mpp.getId());
    }

    @Test
    public void getAllMpp()
    {
        User user = new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL);
        when(mppRepository.findAll()).thenReturn(Arrays.asList(new Mpp(user, DEPARTMENT)));

        List<Mpp> resp = (List<Mpp>) mppService.getAllMpp();
        assertEquals(1, resp.size());
        assertEquals(DEPARTMENT , resp.get(0).getDepartment());
        assertEquals(user , resp.get(0).getRequestedBy());

        verify(mppRepository).findAll();
    }

    @Test
    public void approveMppTrue()
    {
        User user = new User(ROLE, DEPARTMENT, NAME, SURNAME, PASSWORD, EMAIL);
        Mpp mpp = new Mpp(user , DEPARTMENT);

        when(mppRepository.findOne(mpp.getId())).thenReturn(mpp);

        user.setRole(Role.CEO);

        boolean resp = mppService.approveMpp(mpp , user);
        assertTrue(resp);

        verify(mppRepository).findOne(mpp.getId());

    }


}
