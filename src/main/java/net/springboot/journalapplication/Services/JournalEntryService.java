package net.springboot.journalapplication.Services;

import net.springboot.journalapplication.Entity.JournalEntry;
import net.springboot.journalapplication.Repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Transactional
    public ResponseEntity<JournalEntry> CreateEntry(JournalEntry journalEntry) {
        JournalEntry saveEntry = journalEntryRepository.save(journalEntry);
        return new ResponseEntity<>(saveEntry, HttpStatus.CREATED);
    }

    public ResponseEntity<List<JournalEntry>> GetAllEntries() {
        List<JournalEntry> journalEntries = journalEntryRepository.findAll();
        return new ResponseEntity<>(journalEntries, HttpStatus.OK);
    }

    public ResponseEntity<JournalEntry> DeleteEntry(String id) {
        if (journalEntryRepository.existsById(id)) {
            journalEntryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
