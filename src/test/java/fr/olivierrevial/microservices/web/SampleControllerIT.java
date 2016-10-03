package fr.olivierrevial.microservices.web;

import static org.springframework.restdocs.http.HttpDocumentation.httpRequest;
import static org.springframework.restdocs.http.HttpDocumentation.httpResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import fr.olivierrevial.microservices.AbstractTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * Test class for SampleController.
 * This class will basically test that all methods defined in SampleController behave as expected.
 */
public class SampleControllerIT extends AbstractTest {

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("src/docs/asciidoc/apidoc/generated-snippets");

    @Before
    public void initMockMVC() {
        this.mockMvc = webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation).snippets()
                        .withDefaults(
                                httpRequest(),
                                httpResponse()))
                .build();
    }

    @Test
    public void testMethod1() throws Exception {
        mockMvc.perform(get("/sample-controller/method1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Value for param 1"))
                .andDo(document("method_1"));       // Add HTTP request/response example to Swagger generated documentation
    }

    @Test
    public void testMethod2() throws Exception {
        mockMvc.perform(get("/sample-controller/method2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("false"))
                .andDo(document("method_2"));       // Add HTTP request/response example to Swagger generated documentation
    }
}
