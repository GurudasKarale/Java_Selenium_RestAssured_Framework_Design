package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"classpath:features/LoginTest.feature"},glue={"com.utilities"},
plugin = { "pretty","html:target/cucumbr/report.html" } ,tags="@tag2")
public class TestRunner {

}
