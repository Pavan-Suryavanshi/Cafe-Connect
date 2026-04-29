package com.yash.cafe_connect.controller;

import com.yash.cafe_connect.entity.Thali;
import com.yash.cafe_connect.service.ThaliService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thali")
public class ThaliController {

    private final ThaliService thaliService;

    public ThaliController(ThaliService thaliService) {
        this.thaliService = thaliService;
    }

    @PostMapping
    public Thali createThali(@RequestBody Thali thali) {
        return thaliService.createThali(thali);
    }

    @GetMapping
    public List<Thali> getAllThali() {
        return thaliService.getAllThali();
    }
}