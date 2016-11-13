package fr.olivierrevial.microservices.web;

import fr.olivierrevial.microservices.model.SearchRequest;
import fr.olivierrevial.microservices.model.SearchResult;
import fr.olivierrevial.microservices.service.SampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sample controllers with example methods
 */
@RestController
@RequestMapping("/sample-controller")
@Api(tags = "Sample Controller")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    /**
     * Return a sample String parameter
     * @return one of the custom string settings
     */
    @RequestMapping(method = RequestMethod.GET, value = "/method1")
    @ApiOperation(value = "Method 1", notes = "Return a sample String parameter")
    public String method1() {
        return sampleService.getCustomStringParamValue();
    }

    /**
     * Return a sample boolean parameter
     * @return one of the custom boolean settings
     */
    @RequestMapping(method = RequestMethod.POST, value = "/searchProducts")
    @ApiOperation(value = "Search Products", notes = "Returns products matching given search request")
    public SearchResult search(@RequestBody SearchRequest searchRequest) {
        return sampleService.searchProducts(searchRequest);
    }
}