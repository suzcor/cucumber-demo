package com.suzanne.cucumberdemo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import net.masterthought.cucumber.Configuration;

@SpringBootTest
class CucumberDemoApplicationTests {

  @Test
  void contextLoads() {
  }

  @Test
  public void generateDemoReport() throws IOException {
    File reportOutputDirectory = new File("target/demo");
    List<String> jsonFiles = new ArrayList<>();
    jsonFiles.add("target/json-reports/cucumber.json");

    String buildNumber = "101";
    String projectName = "Cucumber Demo Project";
    Configuration configuration = new Configuration(reportOutputDirectory, projectName);
    configuration.setBuildNumber(buildNumber);

    configuration.addClassifications("Browser", "Chrome");
    configuration.addClassifications("Branch", "release/1.0");
    configuration.setSortingMethod(SortingMethod.NATURAL);
    configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
    configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);
    configuration.setQualifier("sample", "Chrome 80, mobile");
    // points to the demo trends which is not used for other tests
    configuration.setTrendsStatsFile(new File("target/test-classes/demo-trends.json"));

    configuration.addCustomCssFiles(Collections.singletonList("src/test/resources/css/stackoverflow-light.min.css"));
    configuration.addCustomJsFiles(Arrays.asList("src/test/resources/js/enable-highlighting.js", "src/test/resources/js/highlight.min.js"));

    ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
    reportBuilder.generateReports();
  }

}
