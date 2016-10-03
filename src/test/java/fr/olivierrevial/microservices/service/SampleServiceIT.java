package fr.olivierrevial.microservices.service;

import static org.assertj.core.api.Assertions.assertThat;

import fr.olivierrevial.microservices.AbstractTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
        assertThat(sampleService.getCustomBooleanParamValue()).isFalse();
    }

}
