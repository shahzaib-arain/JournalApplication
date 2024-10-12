package net.springboot.journalapplication.Controller;

import net.springboot.journalapplication.Entity.JournalEntry;
import net.springboot.journalapplication.Entity.UserEntry;
import net.springboot.journalapplication.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserControllerV2 {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntry>> GetAllEntries() {
        return userService.GetAllEntries();
    }

    @PostMapping

    public ResponseEntity<UserEntry> CreateEntry(@RequestBody UserEntry userEntry) {
        try {
            return userService.CreateEntry(userEntry);
        } catch (Exception e) {
            System.err.println("Error occurred while creating entry: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserEntry> DeleteEntry(@PathVariable String id) {
        return userService.DeleteEntry(id);
    }

    @PutMapping("/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody UserEntry user, @PathVariable String userName) {
        UserEntry userIndb = userService.findByuserName(userName);
        if (userIndb != null) {
            userIndb.setUserName(user.getUserName());
            userIndb.setPassword(user.getPassword());
            userService.CreateEntry(userIndb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
