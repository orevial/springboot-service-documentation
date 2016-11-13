package fr.olivierrevial.microservices.service;

import fr.olivierrevial.microservices.AbstractTest;
import fr.olivierrevial.microservices.model.SearchRequest;
import fr.olivierrevial.microservices.model.SearchResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for SampleService.
 * This class will basically test that all methods defined in SampleService behave as expected.
 */
public class SampleServiceIT extends AbstractTest {

    @Autowired
    private SampleService sampleService;

    @Test
    public void getCustomStringParamValue() {
        assertThat(sampleService.getCustomStringParamValue()).isEqualTo("Value for param 1");
    }

    @Test
    public void getCustomBooleanParamValue() {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setNbResults(10);
        searchRequest.setCategories(Arrays.asList("category1", "category2", "category3"));
        searchRequest.setFacets(Arrays.asList("price", "color", "format"));
        searchRequest.setSearchWord("test");

        SearchResult searchResult = sampleService.searchProducts(searchRequest);
        assertThat(searchResult.getNbResults()).isEqualTo(10);
        assertThat(searchResult.getProductsFound()).hasSize(10);
    }

}
