package ro.uvt.sabloane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.uvt.sabloane.lab11.ClientComponent;

@Controller
public class HelloController {

    ClientComponent client1;
    ClientComponent client2;

    @Autowired
    public HelloController(ClientComponent client1, ClientComponent client2) {
        this.client1 = client1;
        this.client2 = client2;
    }

    @RequestMapping("hello1")
    @ResponseBody
    public String hello1() {
        return "Hello from SpringBoot";
    }

    @RequestMapping("hello2")
    @ResponseBody
    public String hello2() {
        return "Hello from Client1 = " + client1.toString() + " and Client2 = " + client2.toString();
    }

}
