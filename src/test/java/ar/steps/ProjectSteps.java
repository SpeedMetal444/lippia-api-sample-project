package ar.steps;

import io.cucumber.java.en.Given;
import services.BaseService;
import services.ProjectService;

public class ProjectSteps {

    @Given("With the project named '(.*)' selected")
    public void SelectTheProjectNamed(String name) {
        String projectId = ProjectService.getProjectIdByName("request/projectsJson", name);
        BaseService.setProjectId(projectId);
    }
}
