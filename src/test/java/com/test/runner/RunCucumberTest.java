package com.test.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(	plugin = { 
								"pretty",
                            }, 
					features = { 
							"src/test/resources/cartcheckout/features/Shopping.feature" 
							}, 
					glue= {
							"shared.steps","shoppingcart.steps"
					},
//					dryRun = true, 
					monochrome = true
					)
public class RunCucumberTest {
}