package org.lyb.demo1.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
    @GetMapping("index")
    public void sample(){

    }
}
