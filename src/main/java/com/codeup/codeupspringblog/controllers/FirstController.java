package com.codeup.codeupspringblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


//when user goes to locolhost:8081/hello, we want the user to see Hello World




@Controller
public class FirstController {


    @GetMapping("/hello") // end of url to get this response
    @ResponseBody // returns to page this response underneath
    // have to make method in order to get response
    public String returnHelloWorld(){
        return "Hello World";
    }

    // pass in a specific namew
    @GetMapping("/hello/{name}") // end of url to get this response
    @ResponseBody
    public String greetName(@PathVariable String name){ // @PathVariable to enter whatever name you want in url/ EX: http://localhost:8081/hello/mike
        return "Hello " + name.toUpperCase();
    }
    // OR

//    @GetMapping("/hello/{name}") // end of url to get this response
//    @ResponseBody
//    public String greetName1(@RequestParam boolean uppercase) { // @PathVariable to enter whatever name you want in url/ EX: http://localhost:8081/hello/mike/ can also maked it default to true by (@RequestParam(defaultValue=true) boolean uppercase)
//
//        if (uppercase) {
//            return "HELLO ZENITH";
//        } else {
//            return "Hello Zenith";
//        }
//    }


    @GetMapping("/zenith")
    @ResponseBody
    public String returnHelloZenith(){
        return "<h1>Hello Zenith</h1>";
    }

    // pass in a specific name
    @GetMapping("/hello/{fname}/{lname}") // end of url to get this response
    @ResponseBody
    public String greetName(@PathVariable String fname, @PathVariable String lname){ // @PathVariable to enter whatever name you want in url/ EX: http://localhost:8081/hello/mike
        return "Hello " + fname + " " + lname;
    }

}
