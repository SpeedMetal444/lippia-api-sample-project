package services;

import com.crowdar.api.rest.Response;
import com.google.gson.GsonBuilder;

public class BaseService {

    public static final ThreadLocal<String> X_API_KEY = new ThreadLocal<>();
    public static final ThreadLocal<String> WORKSPACE_ID = new ThreadLocal<>();
    public static final ThreadLocal<String> USER_ID = new ThreadLocal<>();
    public static final ThreadLocal<String> PROJECT_ID = new ThreadLocal<>();
    private static final ThreadLocal<Response> LAST_RESPONSE = new ThreadLocal<>();

    public static void setApiKey(String value) { X_API_KEY.set(value); }
    public static void setWorkspaceId(String value) { WORKSPACE_ID.set(value); }
    public static void setUserId(String value) { USER_ID.set(value); }
    public static void setProjectId(String value) { PROJECT_ID.set(value);}

    public static String getApiKey() { return X_API_KEY.get(); }
    public static String getWorkspaceId() { return WORKSPACE_ID.get(); }
    public static String getUserId() { return USER_ID.get(); }
    public static String getProjectId() { return PROJECT_ID.get(); }

    public static void setLastResponse(Response response) {
        LAST_RESPONSE.set(response);
    }

    public static Response getLastResponse() {
        return LAST_RESPONSE.get();
    }


}
