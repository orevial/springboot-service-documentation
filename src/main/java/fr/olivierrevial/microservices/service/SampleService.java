package fr.olivierrevial.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.olivierrevial.microservices.settings.ServiceDocumentationSettings;

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
         * Get the custom boolean parameter from settings
         * @return the param "isCustomParam2" from settings
         */
        public boolean getCustomBooleanParamValue() {
                return settings.isCustomParam2();
        }
}
