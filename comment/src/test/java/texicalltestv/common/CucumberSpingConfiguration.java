package texicalltestv.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import texicalltestv.CommentApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { CommentApplication.class })
public class CucumberSpingConfiguration {}
