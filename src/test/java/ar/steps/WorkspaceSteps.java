package ar.steps;

import io.cucumber.java.en.Given;
import services.BaseService;
import services.WorkspaceService;

public class WorkspaceSteps {
    @Given("With the workspace named (.*) selected")
    public void SelectTheWorkspaceNamed(String name) {
        String workspaceId = WorkspaceService.getWorkspaceIdByName("request/workspacesJson", name);
        BaseService.setWorkspaceId(workspaceId);
    }
}
