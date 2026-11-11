package library.agatiLibrary.Repository;

import library.agatiLibrary.Model.Library;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibraryRep extends MongoRepository<Library, String> {

}
