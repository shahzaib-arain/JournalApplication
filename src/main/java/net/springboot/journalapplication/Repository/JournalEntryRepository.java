
    package net.springboot.journalapplication.Repository;

    import net.springboot.journalapplication.Entity.JournalEntry;
    import org.springframework.data.mongodb.repository.MongoRepository;

        public interface JournalEntryRepository extends MongoRepository <JournalEntry,String>{

    }