package com.example.springlogin.Controller;

import com.example.springlogin.StartupListener;
import com.example.springlogin.WordMeaning;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/getAllWords")
    public List<WordMeaning> getAllWords(){
        return StartupListener.getTotalWordMeanings();
    }
}
