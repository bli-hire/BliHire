package com.empatkepala.controller;

import com.empatkepala.entity.CV;
import com.empatkepala.entity.request.CVFormRequest;
import com.empatkepala.service.CVService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan Bagus Susilo on 8/6/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CVControllerTest {
    private MockMvc mvc;
    @InjectMocks
    private CVController cvController;
    @Mock
    private CVService cvService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        /**
         * MockitoAnnotiations = untuk init mock ,
         * kalau autowired memanggil secara real,
         * mockitoannotations.init hanya untuk test
         **/
        mvc = MockMvcBuilders.standaloneSetup(cvController).build();
    }

    @Test
    public void testGetAllCV() throws Exception {
        CVFormRequest first = new CVFormRequest();
        CVFormRequest second = new CVFormRequest();
        first.setTitle("Direktur");
        second.setTitle("Manager");

        ArrayList<CVFormRequest> result = new ArrayList<>();
        result.add(first);
        result.add(second);
        CV resultcv = new CV();
        cvService.addCV(first);
        cvService.addCV(second);

        //Mockito.when(cvService.getAllCV()).thenReturn(result);
        Mockito.verify(cvService.getAllCV(),Mockito.times(1));
        Mockito.verifyNoMoreInteractions(cvService);
    }
}
