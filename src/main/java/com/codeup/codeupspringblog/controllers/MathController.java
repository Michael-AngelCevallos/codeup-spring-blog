package com.codeup.codeupspringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{x}/and/{y}") // end of url to get this response
    @ResponseBody // returns to page this response underneath
    // have to make method in order to get response
    public int add(@PathVariable int x, @PathVariable int y){
        return x + y ;
    }

    @GetMapping("/subtract/{x}/from/{y}") // end of url to get this response
    @ResponseBody // returns to page this response underneath
    // have to make method in order to get response
    public int subtract(@PathVariable int x, @PathVariable int y){
        return x - y;
    }

    @GetMapping("/multiply/{x}/and/{y}") // end of url to get this response
    @ResponseBody // returns to page this response underneath
    // have to make method in order to get response
    public int multiply(@PathVariable int x, @PathVariable int y){
        return x * y ;
    }

    @GetMapping("/divide/{x}/by/{y}") // end of url to get this response
    @ResponseBody // returns to page this response underneath
    // have to make method in order to get response
    public int divide(@PathVariable int x, @PathVariable int y){
        return x / y ;
    }


}
