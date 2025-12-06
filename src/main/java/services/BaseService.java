package services;

import com.crowdar.api.rest.MethodsService;

public class BaseService extends MethodsService {

    public static ThreadLocal<String> X_API_KEY = new ThreadLocal<>();

    public static ThreadLocal<String> FIRST_WORKSPACE_ID = new ThreadLocal<>();

    public static ThreadLocal<String> CLIENT_NAME = new ThreadLocal<>();
}
