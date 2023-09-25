package spring.servlet.web.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import spring.servlet.web.frontcontroller.v1.controller.ControllerV1;
import spring.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import spring.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import spring.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name ="frontControllerServletV1" ,urlPatterns = "/front-controller/v1/*")
public class FrontControllerServlet extends HttpServlet {
    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerServlet() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServlet.service");

        String requestURI = request.getRequestURI();
        ControllerV1 controller = controllerMap.get(requestURI);
        if (controller == null){
            response.setStatus(HttpServletResponse.SC_FOUND);
            return;
        }
        controller.process(request,response);
    }
}
