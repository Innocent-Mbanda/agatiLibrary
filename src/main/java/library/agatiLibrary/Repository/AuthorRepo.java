package library.agatiLibrary.Repository;

import library.agatiLibrary.Model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepo extends MongoRepository<Author, String> {
}
