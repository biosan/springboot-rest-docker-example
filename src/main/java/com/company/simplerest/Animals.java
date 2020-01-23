package com.company.simplerest;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/animals")
class Animals {

    private static List<String> animals = Arrays.asList("cat", "dog", "bird");

    @GetMapping("/{id}")
    public String getOne(@PathVariable int id) {
        try {
            System.out.printf("Got a request! id:%d\n", id);
            return animals.get(id);
        } catch (IndexOutOfBoundsException e) {
            // Stupid stuff!
            return "Index out of bound!";
        }
    }
}
