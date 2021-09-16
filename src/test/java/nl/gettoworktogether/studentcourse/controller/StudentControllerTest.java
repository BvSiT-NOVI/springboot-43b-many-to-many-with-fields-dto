package nl.gettoworktogether.studentcourse.controller;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
//@Profile("nosec")
public class StudentControllerTest {
    private static final Logger logger =  LoggerFactory.getLogger(StudentControllerTest.class);

    @Autowired
    private MockMvc mvc;

    @Test
    void testStudentController() throws Exception {
        //Show the full request by using doPrint()
        MvcResult result = mvc.perform(get("/students")).andDo(print()).andReturn();
        //MvcResult result = mvc.perform(get("/students")).andReturn();

        //Show only the body:
        logger.info(result.getResponse().getContentAsString());
    }

    @Test
    void createStudentByPostMapping() throws Exception {
        MvcResult result = mvc.perform(post("/students").contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Kees Jansen\"}"))
                .andDo(print())
                .andReturn();

        String content = result.getResponse().getContentAsString();
    }

}
