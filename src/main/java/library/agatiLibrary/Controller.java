package library.agatiLibrary;

import library.agatiLibrary.Model.Book;
import library.agatiLibrary.Service.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v")
public class Controller {

    private final LibraryService libraryService;

    public Controller(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return libraryService.saveBook(book);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return libraryService.findAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable String id) {
        return libraryService.findBookById(id);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book book) {
        return libraryService.updateBookById(id, book);
    }

    @GetMapping("/books/pagination")
    public Iterable<Book> getBookWithPagination(@RequestParam int page, @RequestParam int size) {
        return libraryService.getBookWithPagination(page, size);
    }

}
