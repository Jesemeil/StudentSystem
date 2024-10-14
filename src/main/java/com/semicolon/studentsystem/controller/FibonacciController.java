package com.semicolon.studentsystem.controller;

import com.semicolon.studentsystem.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fibonacci")
public class FibonacciController {

    @Autowired
    private FibonacciService fibonacciService;

    @GetMapping("/{n}")
    public ResponseEntity<?> getFibonacci(@PathVariable int n) {
        try {
            int result = fibonacciService.fibonacci(n);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
