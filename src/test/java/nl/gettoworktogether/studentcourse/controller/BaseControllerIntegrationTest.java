package nl.gettoworktogether.studentcourse.controller;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class BaseControllerIntegrationTest {
    private static final Logger logger =  LoggerFactory.getLogger(BaseControllerIntegrationTest.class);

    @Autowired
    private MockMvc mvc;

    @Test
    void testBaseController() throws Exception {
        //Show the full request by using doPrint()
        //MvcResult result = mvc.perform(get("/")).andDo(print()).andReturn();
        MvcResult result = mvc.perform(get("/")).andReturn();

        //Show only the body:
        logger.info(result.getResponse().getContentAsString());
    }




}
