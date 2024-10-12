package net.springboot.journalapplication.Controller;

import net.springboot.journalapplication.Entity.JournalEntry;
import net.springboot.journalapplication.Services.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {


    @GetMapping("/health-check")
    public String healthCheck(){
        return "ok";
    }
    


}


