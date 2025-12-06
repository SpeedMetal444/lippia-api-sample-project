package ar.steps;

import io.cucumber.java.en.Given;
import services.BaseService;

public class ClockifyCommonSteps {

    @Given("With an account and a (.*) api key on Clockify")
    public void withAnAccountAndApiKeyOnClockify(String apikey) {
        BaseService.X_API_KEY.set(apikey);
    }
}
