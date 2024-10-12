package net.springboot.journalapplication.Repository;

import com.mongodb.client.MongoDatabase;
import net.springboot.journalapplication.Entity.JournalEntry;
import net.springboot.journalapplication.Entity.UserEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntry,String> {
UserEntry findByuserName (String userName);
}

