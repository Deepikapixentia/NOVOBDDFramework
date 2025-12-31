package com.novo.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("application_features") 
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.novo.stepdefinitions, com.novo.hooks") 
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports.html, json:target/cucumber.json, com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")
public class RegressionRunner {
    
}