package com.example.littlebackend;

import com.example.littlebackend.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class BookControllerTest extends AbstractTest{
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void getBooks() throws Exception {
        String uri = "/api/books";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status  = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Book[] BookList= super.mapFromJson(content, Book[].class);
        assertTrue(BookList.length>0);
    }
//   [ @Test
//    public void addBook() throws Exception {
//        String uri = "/books";
//        Book book = new Book();
//
//        book.setBookTitle("Ginger");
//        book.setAuthorName("Robert Patterson");
//
//        String inputJson = super.mapToJson(book);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(201, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "Book is added successfully");
//    }]
//    @Test
//    public void updateBook() throws Exception {
//        String uri = "/api/books/2";
//        Book book = new Book();
//        book.setBookTitle("Lemon");
//
//        String inputJson = super.mapToJson(book);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "Book is updated successfully");
//    }
    @Test
    public void deleteBook() throws Exception {
        String uri = "/api/books/2";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Book is deleted successfully");
    }
}
