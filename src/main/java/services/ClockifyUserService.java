package services;


import api.model.user.Root;
import com.crowdar.api.rest.MethodsService;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class ClockifyUserService extends MethodsService {

    public static Response get(String jsonName) {
        return get(jsonName, Root.class, setParams());
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<>();
        params.put("baseUrl", PropertyManager.getProperty("base.api.url"));
        params.put("apiKey", BaseService.getApiKey());
        return params;
    }

    public static Root getUser(String jsonName) {
        Response r = get(jsonName);
        return (Root) r.getResponse();
    }

    public static String getAuthenticatedUserId(String jsonName, String expectedName) {
        Root user = getUser(jsonName);

        if (!user.name.equalsIgnoreCase(expectedName)) {
            throw new RuntimeException(
                    "Authenticated user is '" + user.name + "' but expected '" + expectedName + "'"
            );
        }
        return user.id;
    }
}
