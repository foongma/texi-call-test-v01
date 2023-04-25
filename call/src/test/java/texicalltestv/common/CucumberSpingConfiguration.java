package texicalltestv.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import texicalltestv.CallApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { CallApplication.class })
public class CucumberSpingConfiguration {}
