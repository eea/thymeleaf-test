package eea.eprtr.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-mvctest-config.xml", "classpath:spring-dbtest-config.xml"})


/**
 * Test the simple doc controller.
 *
 * @see <a href="http://docs.spring.io/spring-framework/docs/3.2.0.BUILD-SNAPSHOT/reference/htmlsingle/#spring-mvc-test-framework">MVC testing</a>
 * @see <a href="http://docs.spring.io/spring-framework/docs/3.2.0.RC2/api/org/springframework/test/web/servlet/ResultActions.html">Result Actions</a>
 */
public class FileUploadControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testUploadForm() throws Exception {
        this.mockMvc.perform(get("/fileupload"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("breadcrumbs"))
                .andExpect(view().name("fileupload"));
    }
}
