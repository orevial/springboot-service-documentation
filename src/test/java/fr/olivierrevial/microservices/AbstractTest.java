package fr.olivierrevial.microservices;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Marker for all tests. It just defines some common tests annotations and loads main app's configuration
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(properties = "classpath:/application-test.yml")
@ActiveProfiles("test")
public abstract class AbstractTest {
}
