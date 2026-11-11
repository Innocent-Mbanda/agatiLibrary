package library.agatiLibrary.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "libraries")
public class Library {

    @Id
    private String id;

    private String name;

    private String address;

    private Date establishedDate;

    private Date openTime;

    private Date closeTime;
}
