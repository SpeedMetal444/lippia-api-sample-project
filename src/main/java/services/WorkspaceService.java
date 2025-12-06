package services;

import api.model.workspace.Root;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class WorkspaceService extends BaseService {

    public static Response get(String jsonName) {
        return get(jsonName, Root[].class, setParams());
    }

    private static Map<String, String> setParams(){
        Map<String, String> params = new HashMap<>();
        params.put("baseUrl", PropertyManager.getProperty("base.api.url"));
        params.put("apiKey", X_API_KEY.get());
        return params;
    }
    @Override
    public void validateFields(Object expected, Object actual, Map<String, String> parameters) throws Exception {
        validateFields(expected, actual);
    }
}
