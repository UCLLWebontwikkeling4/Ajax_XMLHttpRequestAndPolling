import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {
    protected LectorRepository lectorRepository;

    public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response);

    public LectorRepository getService() {
        return lectorRepository;
    }

    public void setService(LectorRepository service) {
        this.lectorRepository = service;
    }
}
