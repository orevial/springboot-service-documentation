package fr.olivierrevial.microservices.documentation;

import static org.springframework.restdocs.http.HttpDocumentation.httpRequest;
import static org.springframework.restdocs.http.HttpDocumentation.httpResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import fr.olivierrevial.microservices.AbstractTest;
import fr.olivierrevial.microservices.Swagger2MarkupResultHandler;
import io.github.robwin.swagger2markup.GroupBy;

/**
 * A test class that generates REST API documentation, including :
 * - Swagger basic documentation
 * - Spring restdoc documentation (REST API snippets, examples)
 */
public class DocumentationIT extends AbstractTest {

    public static final String APIDOC_SNIPPETS_OUTPUT_FOLDER = "src/docs/asciidoc/apidoc/generated-snippets";
    public static final String APIDOC_OUTPUT_FOLDER = "src/docs/asciidoc/apidoc";
    public static final String API_DOCS_URL = "/v2/api-docs";

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation(APIDOC_OUTPUT_FOLDER);

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
    public void convertSwaggerToAsciiDoc() throws Exception {
        mockMvc.perform(get(API_DOCS_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(Swagger2MarkupResultHandler
                        .outputDirectory(APIDOC_OUTPUT_FOLDER)
                        .withPathsGroupedBy(GroupBy.TAGS)
                        .withExamples(APIDOC_SNIPPETS_OUTPUT_FOLDER).build())
                .andExpect(status().isOk());
    }
}
