package services;

import api.model.workspace.Root;
import com.crowdar.api.rest.MethodsService;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class WorkspaceService extends MethodsService {

    public static Response get(String jsonName) {
        return get(jsonName, Root[].class, setParams());
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<>();
        params.put("baseUrl", PropertyManager.getProperty("base.api.url"));
        params.put("apiKey", BaseService.getApiKey());
        return params;
    }

    public static Root[] getAllWorkspaces(String jsonName) {
        Response r = get(jsonName);
        return (Root[]) r.getResponse();
    }

    public static String getWorkspaceIdByName(String jsonName, String workspaceName) {
        Root[] list = getAllWorkspaces(jsonName);
        for (Root w : list) {
            if (w.name.equalsIgnoreCase(workspaceName)) {
                return w.id;
            }
        }
        throw new RuntimeException("Workspace not found: " + workspaceName);
    }
}

