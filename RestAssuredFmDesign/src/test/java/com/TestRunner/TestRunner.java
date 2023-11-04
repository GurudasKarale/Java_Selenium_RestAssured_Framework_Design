package com.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="classpath:com/features/APIFeatures.feature",glue= {"com.stepDefs"})
public class TestRunner {

	
	
	
}
