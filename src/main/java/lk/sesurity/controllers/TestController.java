package lk.sesurity.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "my")
@CrossOrigin
public class TestController {

    @GetMapping(value = "/haha")
    public String getValue(){

        return "OK WORK ";
    }

}
