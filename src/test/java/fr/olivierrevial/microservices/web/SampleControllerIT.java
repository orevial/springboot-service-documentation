package fr.olivierrevial.microservices.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.olivierrevial.microservices.AbstractTest;
import fr.olivierrevial.microservices.model.SearchRequest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;

import static org.springframework.restdocs.http.HttpDocumentation.httpRequest;
import static org.springframework.restdocs.http.HttpDocumentation.httpResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Test class for SampleController.
 * This class will basically test that all methods defined in SampleController behave as expected.
 */
public class SampleControllerIT extends AbstractTest {

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("src/docs/asciidoc/apidoc/generated-snippets");

    private ObjectMapper objectMapper = new ObjectMapper();
    private MockMvc mockMvc;

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
    public void testSearch() throws Exception {
        File inputFile = new File("src/test/resources/requests/searchRequest.json");
        SearchRequest searchRequest = objectMapper.readValue(inputFile, SearchRequest.class);
        String searchRequestString = objectMapper.writeValueAsString(searchRequest);

        this.mockMvc.perform(post("/sample-controller/searchProducts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(searchRequestString))
            .andDo(document("search_products"));       // Add HTTP request/response example to Swagger generated documentation
    }
}
