package nl.gettoworktogether.studentcourse.controller;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@Profile("nosec")
public class StudentDtoControllerTest {
    private static final Logger logger =  LoggerFactory.getLogger(StudentDtoControllerTest.class);

    @Autowired
    private MockMvc mvc;

    @Test
    void whenEmptyNameStudent_thenThrowsConstraintViolationException() throws Exception {
        /** TODO
         *  This will return an internal server error in the response.
         *  How to capture this response in the test?
         *  Now only the validation constraint exception is captured caused by the service.
         */
        Exception exception = assertThrows(Exception.class, () -> {
            mvc.perform(post("/dto/students").contentType(MediaType.APPLICATION_JSON)
                    .content("{\"name\":\"\"}"))
                    .andExpect(status().isInternalServerError());
        });

        logger.info(exception.getMessage());

    }

}
