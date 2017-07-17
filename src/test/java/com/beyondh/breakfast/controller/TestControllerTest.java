package com.beyondh.breakfast.controller;

import com.beyondh.breakfast.controllers.TestController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.ServletContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestControllerTest {

    @Test
    public void TestGet(){
      String testStr=testController.get();
        Assert.assertEquals("成功","123",testStr);
    }

    @Autowired
    TestController  testController;

    @Autowired
    ServletContext context;

    MockMvc mockMvc;
    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(context).build();
    }
}

