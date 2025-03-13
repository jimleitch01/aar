package com.example.aar.controller;

import com.example.aar.model.Abduction;
import com.example.aar.service.AbductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/abductions")
public class AbductionController {

    @Autowired
    private AbductionService abductionService;

    @PostMapping("/register")
    public ResponseEntity<String> registerAbduction(
            @RequestParam("name") String name,
            @RequestParam("time") String time,
            @RequestParam("place") String place,
            @RequestParam("details") String details,
            @RequestParam("photograph") MultipartFile photograph,
            @RequestParam("alienCraftImage") MultipartFile alienCraftImage) {

        try {
            abductionService.saveAbduction(name, time, place, details, photograph, alienCraftImage);
            return new ResponseEntity<>("Abduction registered successfully", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to register abduction", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public List<Abduction> getAllAbductions() {
        return abductionService.getAllAbductions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abduction> getAbductionById(@PathVariable Long id) {
        try {
            Abduction abduction = abductionService.getAbductionById(id);
            return new ResponseEntity<>(abduction, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public List<Abduction> searchAbductions(@RequestParam("query") String query) {
        return abductionService.searchAbductions(query);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return new ResponseEntity<>("Abduction not found", HttpStatus.NOT_FOUND);
    }
}
