package com.kss;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
        "src/test/java/com/kss"
}, glue = "step_definitions",
        tags = "@test")
public class RunnerClass {
    public RunnerClass() {

    }
}
