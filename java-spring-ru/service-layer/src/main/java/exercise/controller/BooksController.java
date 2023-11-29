package exercise.controller;

import java.util.List;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    // BEGIN
    @GetMapping(path = "")
    public List<BookDTO> index() {
        return bookService.findAll();
    }

    @GetMapping(path = "/{id}")
    public BookDTO show(@PathVariable long id) {
        return bookService.findById(id);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@Valid @RequestBody BookCreateDTO bookData) {
        return bookService.create(bookData);
    }

    @PutMapping(path = "/{id}")
    public BookDTO update(@PathVariable long id, @Valid @RequestBody BookUpdateDTO bookData) {
        return bookService.update(id, bookData);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable long id) {
        bookService.delete(id);
    }

    // END
}
