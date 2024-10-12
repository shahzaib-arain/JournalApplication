package net.springboot.journalapplication.Controller;

import net.springboot.journalapplication.Entity.JournalEntry;
import net.springboot.journalapplication.Services.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/health-check")
public class HealthCheck {


    @GetMapping
    public String healthCheck(){
        return "Your Spring boot application is running perfectly";
    }
    


}


