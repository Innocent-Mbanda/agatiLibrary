package library.agatiLibrary.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "books")
public class Book {

    @Id
    private String id;

    private String bookName;

    private String title;
    private Author author;

    private String isbn;

    private int publicationYear;

    private Library library;

}
