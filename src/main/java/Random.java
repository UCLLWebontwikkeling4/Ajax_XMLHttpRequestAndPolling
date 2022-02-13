import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Random extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Lector lector = getService().getRandomLector();
        return lectorToJSON(lector);
    }

    private String lectorToJSON(Lector lector) {
        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(lector);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}


