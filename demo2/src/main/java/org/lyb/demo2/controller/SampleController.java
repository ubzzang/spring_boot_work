package org.lyb.demo2.controller;

import lombok.extern.log4j.Log4j2;
import org.lyb.demo2.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Log4j2
public class SampleController {
    @GetMapping("/ex3")
    public void ex3(){

    }
    @GetMapping("/hello2")
    public void hello2(@RequestParam(name = "types") List<String> types, int age, Model model) {
        model.addAttribute("types", types);
        model.addAttribute("age", age);
    }

    @GetMapping("/hello")
    public void hello(@RequestParam("name") String name, @RequestParam("age") int age, Model model) {
        log.info("hello");
        log.info("name={}", "age={}", name, age);
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("msg", "hello world");
    }

    @GetMapping("/ex1")
    public void ex1(Model model) {
        log.info("ex1");

        List<String> list = Arrays.asList("hello", "world", "String", "String boot");
        model.addAttribute("list", list);
    }
    @GetMapping("/ex2")
    public void ex2(Model model) {
        List<String> strList = IntStream.range(1, 10)
                .mapToObj(i -> "Data" + i)
                .collect(Collectors.toList());
        model.addAttribute("list", strList);
        Map<String,String> map=new HashMap<>();
        map.put("A", "AAA");
        map.put("B", "BBB");
        map.put("C", "CCC");
        model.addAttribute("map", map);

        SampleDTO sampleDTO=SampleDTO.builder()
                .name("홍길동")
                .age(20)
                .address("부산")
                .build();
        model.addAttribute("sampleDTO", sampleDTO);
    }
}
