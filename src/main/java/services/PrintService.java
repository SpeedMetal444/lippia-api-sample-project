package services;

import com.crowdar.api.rest.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

public class PrintService {

    private static final Logger LOG = Logger.getLogger(PrintService.class);

    public static void print(Response response) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonPretty = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(response.getResponse());
            LOG.info("\n===== RESPONSE BODY =====\n" + jsonPretty);
        } catch (Exception e) {
            LOG.error("Could not print response", e);
        }
    }
}
