/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empatkepala.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.empatkepala.service.FpkService;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.http.client.MockClientHttpRequest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author D
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FpkControllerTest {
    //1 pemanggilan 1 function 1 hasil 1 skeneraio
    //Mock MVC -> Controller
    private MockMvc mvc;
    @InjectMocks
    private FpkController controller;

    @Mock
    private FpkService fpkService;
    
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        //MockitoAnnotiations = untuk init mock , kalau autowired memanggil secara real, mockitoannotations.init hanya untuk test
       
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    
    @Test 
    //sukses
    public void testGetAllFpk() throws Exception { 
        //UNTUK GET
        mvc.perform(get("/internal/fpk")).andExpect(status().isOk());
    }
    
    @Test
    //fail
    public void testGetAllFpkFail(){
        
    }

    @Test
    public void testGetFpk() throws Exception {
        mvc.perform(get("/internal/fpk")).andExpect(status().isOk());
    }

    @Test
    public void testInsertFpk() {
    }

    @Test
    public void testUpdateFpk() {
    }

    @Test
    public void testDeleteFpk() {
    }
    
}
