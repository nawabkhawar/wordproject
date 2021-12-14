package com.example.springlogin.Controller;

import com.example.springlogin.StartupListener;
import com.example.springlogin.WordMeaning;
import com.example.springlogin.dao.UserRepository;
import com.example.springlogin.dto.User;
import com.example.springlogin.processor.UserProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/wordplay")
public class AppController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProcessor userProcessor;



    @GetMapping("/wordplay")
    public String getHomePage(){
        System.out.println("size from controller:" + StartupListener.getTotalWordMeanings().size());
        return "index";
    }

    @GetMapping("/register")
    public String showSignupForm(Model model){
        model.addAttribute("user",new User());
        return "signupForm";
    }

    @PostMapping("/process_register")
    public String processRegister(User user){
        //model.addAttribute("user",new User());
        userRepository.save(user);
        return "registrationConfirmation";
    }

    @GetMapping("/signin")
    public String showSigninForm(Model model){
        model.addAttribute("user",new User());
        return "signin";
    }

    @PostMapping("/process_signin")
    public String processSignin(User user,Model model){
        //model.addAttribute("user",new User());
        //jpaRepository.save(user);
        //model.addAttribute("user",new User());
        if(userProcessor.isUserPresent(user)){
            List<User> users = userRepository.findAll();
            //model.addAttribute("users",users);
            model.addAttribute("wordmeanings", StartupListener.getTotalWordMeanings());
            return "listwords";
        }
        else{
            return "signin";
        }
    }

    @GetMapping("/listwords")
    public String listUsers(Model model){
        //model.addAttribute("user",new User());
        //List<User> users = userRepository.findAll();
        //model.addAttribute("users",users);
        model.addAttribute("wordmeanings", StartupListener.getTotalWordMeanings());
        return "listwords";
    }

    @GetMapping("/search")
    public String search(Model model){
        //model.addAttribute("user",new User());
        //List<User> users = userRepository.findAll();
        //model.addAttribute("users",users);
        model.addAttribute("wordmeanings", StartupListener.getTotalWordMeanings());
        return "search";
    }
}
