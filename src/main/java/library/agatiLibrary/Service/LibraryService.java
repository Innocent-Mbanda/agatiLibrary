package library.agatiLibrary.Service;

import library.agatiLibrary.Model.Author;
import library.agatiLibrary.Model.Book;
import library.agatiLibrary.Model.Library;
import library.agatiLibrary.Repository.AuthorRepo;
import library.agatiLibrary.Repository.BookRepo;
import library.agatiLibrary.Repository.LibraryRep;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private final LibraryRep libraryRep;

    private final BookRepo bookRepo;

    private final AuthorRepo authorRepo;

    public LibraryService(LibraryRep libraryRep, BookRepo bookRepo, AuthorRepo authorRepo) {
        this.libraryRep = libraryRep;
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    public void saveLibrary(Library library){
        libraryRep.save(library);
    }

    public Book saveBook(Book book){
        return bookRepo.save(book);
    }

    private Author saveAuthor(Author author){
        return authorRepo.save(author);
    }

    public List<Book> findAllBooks (){
        return bookRepo.findAll();
    }

    public Book findBookById(String id){
        return bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Book updateBookById(String id, Book book){
        Book existedBook = bookRepo.findById(id) .orElseThrow(() -> new RuntimeException("Book not found"));
        existedBook.setTitle(book.getTitle());
        existedBook.setAuthor(book.getAuthor());
        existedBook.setIsbn(book.getIsbn());
        existedBook.setPublicationYear(book.getPublicationYear());
        return bookRepo.save(existedBook);
    }

    public Page<Book> getBookWithPagination(int page, int size){
      return bookRepo.findAll(PageRequest.of(page, size));
    }
}
