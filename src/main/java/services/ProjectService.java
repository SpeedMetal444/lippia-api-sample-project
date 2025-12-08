package services;

import api.model.workspace.Root;
import com.crowdar.api.rest.MethodsService;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class ProjectService extends MethodsService {
    public static Response get(String jsonName) {
        return get(jsonName, Root[].class, setParams());
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<>();
        params.put("baseUrl", PropertyManager.getProperty("base.api.url"));
        params.put("apiKey", BaseService.getApiKey());
        params.put("workspaceId", BaseService.getWorkspaceId());
        return params;
    }
}
