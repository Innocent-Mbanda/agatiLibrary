package library.agatiLibrary.Repository;

import library.agatiLibrary.Model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepo extends MongoRepository<Book, String> {
}
