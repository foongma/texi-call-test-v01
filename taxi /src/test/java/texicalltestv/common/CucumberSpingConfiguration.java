package texicalltestv.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import texicalltestv.TaxiApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { TaxiApplication.class })
public class CucumberSpingConfiguration {}
