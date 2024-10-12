package net.springboot.journalapplication.Services;
import org.springframework.dao.DuplicateKeyException;

import net.springboot.journalapplication.Entity.JournalEntry;
import net.springboot.journalapplication.Entity.UserEntry;
import net.springboot.journalapplication.Repository.JournalEntryRepository;
import net.springboot.journalapplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JournalEntryRepository journalEntryRepository;



    @Transactional
    public ResponseEntity<UserEntry> CreateEntry(UserEntry userEntry) {
        try {
            // Check if a user with the same username already exists
            if (userRepository.findByuserName(userEntry.getUserName()) != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409 Conflict
            }

            UserEntry saveEntry = userRepository.save(userEntry);

            // Create a journal entry associated with the user
            JournalEntry journalEntry = new JournalEntry();
            journalEntry.setTitle("Default Title");
            journalEntry.setContent("Default Content");

            // Save the journal entry
            JournalEntry savedJournalEntry = journalEntryRepository.save(journalEntry);

            // Add the saved journal entry to the user's journal entries
            saveEntry.getJournalEntries().add(savedJournalEntry);

            // Save the updated user entry with the new journal entry
            userRepository.save(saveEntry);

            return new ResponseEntity<>(saveEntry, HttpStatus.CREATED);
        } catch (DuplicateKeyException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Handle duplicate key error
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    public ResponseEntity<List<UserEntry>> GetAllEntries() {
        List<UserEntry> userEntries = userRepository.findAll();
        return new ResponseEntity<>(userEntries, HttpStatus.OK);
    }

    public ResponseEntity<UserEntry> DeleteEntry(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public UserEntry findByuserName(String userName) {
        return userRepository.findByuserName(userName);
    }
}
