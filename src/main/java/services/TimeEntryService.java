package services;

import api.model.timeentry.Root;
import com.crowdar.api.rest.MethodsService;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class TimeEntryService extends MethodsService {

    public static Response get(String jsonName) {
        return get(jsonName, Root[].class, setParams());
    }

    public static Response get(String jsonName, Map<String, String> replaceValues) {
        return get(jsonName, Root.class, mergeParams(replaceValues));
    }

    public static Response post(String jsonName) {
        return post(jsonName, Root.class, setParams());
    }

    public static Response post(String jsonName, Map<String, String> replaceValues) {
        return post(jsonName, Root.class, mergeParams(replaceValues));
    }

    public static Response put(String jsonName, Map<String, String> replaceValues) {
        return put(jsonName, Root.class, mergeParams(replaceValues));
    }

    public static Response delete(String jsonName, Map<String, String> replaceValues) {
        return delete(jsonName, Root.class, mergeParams(replaceValues));
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<>();
        params.put("baseUrl", PropertyManager.getProperty("base.api.url"));
        params.put("apiKey", BaseService.getApiKey());
        params.put("workspaceId", BaseService.getWorkspaceId());
        params.put("userId", BaseService.getUserId());
        return params;
    }

    private static Map<String, String> mergeParams(Map<String, String> dynamicValues) {
        Map<String, String> finalParams = setParams();

        if (BaseService.getProjectId() != null) {
            finalParams.put("projectId", BaseService.getProjectId());
        }

        if (dynamicValues != null) {
            finalParams.putAll(dynamicValues);
        }

        return finalParams;
    }
}
