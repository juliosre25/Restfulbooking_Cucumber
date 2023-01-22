package com.company;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber-pretty",
        "json:cucumber-reports/json-reports/Cucumber.json",
        "junit:cucumber-reports/xml-reports/Cucumber.xml"},
        tags = "@ApiRest",
        glue = {"com.company"},
        features ={"src/test/resources/com/company"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class RunCucumberTest {
}
