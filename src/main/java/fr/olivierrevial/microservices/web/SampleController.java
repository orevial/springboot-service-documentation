package fr.olivierrevial.microservices.web;

import fr.olivierrevial.microservices.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
    @RequestMapping(method = RequestMethod.GET, value = "/method2")
    @ApiOperation(value = "Method 2", notes = "Return a sample boolean parameter")
    public boolean method2() {
        return sampleService.getCustomBooleanParamValue();
    }
}