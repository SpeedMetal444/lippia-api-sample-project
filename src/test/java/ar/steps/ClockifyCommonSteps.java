package ar.steps;

import io.cucumber.java.en.Given;
import services.BaseService;
import services.ClockifyUserService;
import services.WorkspaceService;

public class ClockifyCommonSteps {

    @Given("With an account and a '(.*)' api key on Clockify")
    public void withAnAccountAndApiKeyOnClockify(String apikey) {
        BaseService.setApiKey(apikey);
    }
    @Given("With the authenticated Clockify user '(.*)'")
    public void selectTheUserNamed(String name) {
        String userId = ClockifyUserService.getAuthenticatedUserId("request/userJson", name);
        BaseService.setUserId(userId);
    }
}
