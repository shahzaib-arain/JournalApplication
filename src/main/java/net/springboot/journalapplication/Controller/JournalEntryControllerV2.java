package net.springboot.journalapplication.Controller;

import net.springboot.journalapplication.Entity.JournalEntry;
import net.springboot.journalapplication.Services.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public ResponseEntity<List<JournalEntry>> GetAllEntries() {
        return journalEntryService.GetAllEntries();
    }

    @PostMapping("/abc")
    public ResponseEntity<JournalEntry> CreateEntry(@RequestBody JournalEntry journalEntry) {
        return journalEntryService.CreateEntry(journalEntry);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JournalEntry> DeleteEntry(@PathVariable String id) {
        return journalEntryService.DeleteEntry(id);
    }
}
