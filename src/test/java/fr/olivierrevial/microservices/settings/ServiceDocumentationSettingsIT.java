package fr.olivierrevial.microservices.settings;

import static org.assertj.core.api.Assertions.assertThat;

import fr.olivierrevial.microservices.AbstractTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Test class for springbootServiceDocumentationSettings.
 * This class will basically test that all defined properties are correctly mapped
 * to the settings class.
 */
public class ServiceDocumentationSettingsIT extends AbstractTest {

    @Autowired
    private ServiceDocumentationSettings settings;

    @Test
    public void testSettings() {
        assertThat(settings.getCustomStringParam1()).isEqualTo("Value for param 1");
        assertThat(settings.isCustomParam2()).isFalse();
        assertThat(settings.getCustomIntParam3()).isEqualTo(100);
    }
}