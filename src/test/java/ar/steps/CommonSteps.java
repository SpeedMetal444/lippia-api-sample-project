package ar.steps;

import api.config.EntityConfiguration;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import com.google.api.client.repackaged.com.google.common.base.Splitter;
import cucumber.api.java.en.When;
import org.apache.commons.lang.StringUtils;
import services.BaseService;
import services.PrintService;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class CommonSteps extends PageSteps {

    @When("^I perform a '(.*)' to '(.*)' endpoint with the '(.*)' and '(.*)'$")
    public void doRequest(String methodName, String entity, String jsonName, String jsonReplacementValues)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException {

        Class entityService = EntityConfiguration.valueOf(entity).getEntityService();
        Map<String, String> parameters = getParameters(jsonReplacementValues);
        String jsonPath = "request/".concat(jsonName);

        Object result;

        if (parameters == null) {
            result = entityService
                    .getMethod(methodName.toLowerCase(), String.class)
                    .invoke("", jsonPath);
        } else {
            result = entityService
                    .getMethod(methodName.toLowerCase(), String.class, Map.class)
                    .invoke("", jsonPath, parameters);
        }
        BaseService.setLastResponse((com.crowdar.api.rest.Response) result);
    }

    @Then("Print response")
    public void printResponse() {
        PrintService.print(BaseService.getLastResponse());
    }


    private Map<String, String> getParameters(String jsonReplacementValues) {
        Map<String, String> parameters = null;
        if (!StringUtils.isEmpty(jsonReplacementValues)) {
            parameters = Splitter.on(",").withKeyValueSeparator(":").split(jsonReplacementValues);
        }
        return parameters;
    }
}
