package ru.study.client;

import ru.study.IDirectory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import static ru.study.IFormConstants.*;
import static ru.study.client.DemoRS.ResultType.ERROR;

@WebServlet(name = "start", urlPatterns = {"/start"})
public class DemoRS extends HttpServlet {

    public enum ResultType {
        ERROR, RESULT
    }

    private Client client;
    private WebTarget basic;

    @Override
    public void init() {
        client = ClientBuilder.newClient();
        basic = client.target("http://localhost:8080/lab03-1.0-SNAPSHOT/api/demo");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        Map<String, String[]> map = request.getParameterMap();
        try (PrintWriter out = response.getWriter()) {
            if (map.containsKey("find")) {
                String directoryForSearch = request.getParameter("directoryForSearch");
                String name = request.getParameter("name");
                if (directoryForSearch == null || directoryForSearch.trim().isEmpty()) {
                    out.println(printMainPageWithResultMessage(EMPTY_CATALOG_ERROR, ERROR));
                    return;
                }
                if (name == null || name.trim().isEmpty()) {
                    out.println(printMainPageWithResultMessage(EMPTY_NAME_ERROR, ERROR));
                    return;
                }
                Invocation.Builder builder = basic.path("/find/{directory}")
                        .resolveTemplate("directory", directoryForSearch)
                        .queryParam("file", name)
                        .request(MediaType.APPLICATION_JSON);
                Map<String, IDirectory.Type> reply = builder.get(Map.class);
                out.println(printMainPageWithResultMessage(reply.toString(), ResultType.RESULT));
            } else if (map.containsKey("viewContent")) {
                String directoryForView = request.getParameter("directoryForView");

                if (directoryForView == null || directoryForView.trim().isEmpty()) {
                    out.println(printMainPageWithResultMessage(EMPTY_CATALOG_ERROR, ERROR));
                    return;
                }
                Invocation.Builder builder = basic.path("{directory}").resolveTemplate("directory", directoryForView).request(MediaType.APPLICATION_JSON);
                Map<String, IDirectory.Type> reply = builder.get(Map.class);
                out.println(printMainPageWithResultMessage(reply.toString(), ResultType.RESULT));
            }
        } catch (Exception e) {
            log(">>> ERROR: " + e.getMessage());
            response.sendRedirect("index.html");
        }
    }

    private String printMainPageWithResultMessage(String message, ResultType msgType) {
        String msgStyle = ERROR.equals(msgType) ? "<p style='color:red;'>" : "<p>";
        return HEADER + TABLE1 + TABLE2 + msgStyle + message + "</p>" + FOOTER;
    }

    @Override
    public void destroy() {
        if (client != null) {
            client.close();
        }
    }
}
