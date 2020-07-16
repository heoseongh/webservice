package com.hyeon.book.springboot.web;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired  // Bean 자동 주입
    private MockMvc mvc;   // MockMvc class는 HTTP, GET, POST 등에 대한 웹 API Test를 할 때 사용.

    @Test
    public void hello가_리턴된다() throws  Exception {
        String strTest = "hello";

        // MockMvc를 통해 /hello 주소로 HTTP GET 요청.
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(strTest));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String tname = "hello";
        int tamount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", tname)
                .param("amount", String.valueOf(tamount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(tname)))
                .andExpect(jsonPath("$.amount", is(tamount)));
    }
}