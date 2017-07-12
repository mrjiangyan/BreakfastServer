package com.beyondh.breakfast.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ewan on 12/07/2017.
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping(method = RequestMethod.GET)
    public Object get() {
        return "123";
    }
}
