package com.example.littlebackend;

import com.example.littlebackend.model.Book;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ControllerTest extends AbstractTest{
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
}
