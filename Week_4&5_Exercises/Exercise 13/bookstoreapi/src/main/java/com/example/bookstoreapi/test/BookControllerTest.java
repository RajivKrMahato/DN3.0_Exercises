package com.example.bookstoreapi.test;

import com.example.bookstoreapi.controller.BookController;
import com.example.bookstoreapi.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void getAllBooksTest() throws Exception {
        List<Book> books = Arrays.asList(new Book(1L, "Book 1", "Author 1", 100),
                                         new Book(2L, "Book 2", "Author 2", 150));

        when(bookService.getAllBooks()).thenReturn(books);

        mockMvc.perform(get("/api/books"))
            .andExpect(status().isOk());
    }
}
