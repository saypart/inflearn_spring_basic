package spring.servlet.web.frontcontroller.v3;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import spring.servlet.web.frontcontroller.ModelView;
import spring.servlet.web.frontcontroller.MyView;

import java.io.IOException;
import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}
