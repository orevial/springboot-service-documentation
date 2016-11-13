package fr.olivierrevial.microservices.service;

import fr.olivierrevial.microservices.model.ProductResult;
import fr.olivierrevial.microservices.model.SearchRequest;
import fr.olivierrevial.microservices.model.SearchResult;
import fr.olivierrevial.microservices.settings.ServiceDocumentationSettings;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Sample service with dumb methods
 */
@Service
public class SampleService {

    @Autowired
    private ServiceDocumentationSettings settings;

    /**
     * Get the custom String parameter from settings
     * @return the param "customStringParam1" from settings
     */
    public String getCustomStringParamValue() {
        return settings.getCustomStringParam1();
    }

    /**
     * Search products matching given search request
     * @param search the search request
     * @return a list of products matching the search request
     */
    public SearchResult searchProducts(SearchRequest search) {
        Random random = new Random();
        SearchResult searchResult = new SearchResult();
        searchResult.setNbResults(search.getNbResults());
        searchResult.setTook(random.nextInt(15));

        for(int i=0; i<search.getNbResults(); i++) {
            ProductResult product = new ProductResult();
            product.setId(RandomStringUtils.random(12, "abcdefghijklmnopqrstuvwyz"));
            product.setName("Product " + i);
            product.setPrice(random.nextDouble() * 100D);
            product.setSellerid(random.nextInt(100000));
            for(int j=0; j<3; j++) {
                product.getProperties().add(RandomStringUtils.random(10, "abcdefghijklmnopqrstuvwyz"));
            }
            searchResult.getProductsFound().add(product);
        }
        return searchResult;
    }
}
