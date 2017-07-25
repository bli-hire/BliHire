/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empatkepala.controller;

<<<<<<< HEAD
import com.empatkepala.entity.Fpk;
import com.empatkepala.service.FpkService;
import org.junit.Test;
=======
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.empatkepala.service.FpkService;
import org.junit.Test;
import static org.junit.Assert.*;
>>>>>>> cc3bc4a63548346012f298c8001d1a4b37575c18
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
<<<<<<< HEAD
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

=======
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

>>>>>>> cc3bc4a63548346012f298c8001d1a4b37575c18
/**
 *
 * @author D
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FpkControllerTest {
<<<<<<< HEAD
    /**
     * 1 pemanggilan 1 function 1 hasil 1 skeneraio
     * Mock MVC -> Controller
     **/
    private MockMvc mvc;
    @InjectMocks
    private FpkController fpkController;
    @Mock
    private FpkService fpkService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        /**
         * MockitoAnnotiations = untuk init mock ,
         * kalau autowired memanggil secara real,
         * mockitoannotations.init hanya untuk test
         **/
        mvc = MockMvcBuilders.standaloneSetup(fpkController).build();
    }
    
    @Test
    public void testGetAllFpk() throws Exception {
        Fpk first = new Fpk();
        Fpk second = new Fpk();
        first.setReason("For Testing");
        second.setReason("For Testing");
        List<Fpk> result = new ArrayList<>();
        result.add(first);
        result.add(second);

        fpkService.save(first);
        fpkService.save(second);

//        mvc.perform(get("/internal/fpk"))
//                .andExpect(status().isOk());

        Mockito.when(fpkService.getAllData()).thenReturn(result);

        Mockito.verify(fpkService.getAllData(),Mockito.times(1));
        Mockito.verifyNoMoreInteractions(fpkService);
    }

    @Test
    public void testGetFpk() throws Exception {
        mvc.perform(get("internal/fpk",1L))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetFpk_NotFound() throws Exception{
        mvc.perform(get("internal/fpk/{id}",49L))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testInsertFpk() throws Exception{
        mvc.perform(post("/internal/fpk"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateFpk() throws Exception{
        mvc.perform(put("/internal/fpk"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testDeleteFpk() throws Exception{
        mvc.perform(delete("/internal/fpk"))
                .andExpect(status().isCreated());
    }


=======
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
>>>>>>> cc3bc4a63548346012f298c8001d1a4b37575c18
    
}
