package com.suzanne.cucumberdemo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue= {"com.suzanne.cucumberdemo"},
    plugin = {"json:target/json-reports/cucumber.json"},
    monochrome = true,
    tags = ""
)
public class TestRunner {

}
