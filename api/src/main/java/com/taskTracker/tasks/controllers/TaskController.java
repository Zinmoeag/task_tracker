package com.taskTracker.tasks.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {
    @GetMapping(path = "/")
        public ResponseEntity<?> index() {
            return ResponseEntity.ok().build();
        }
}
