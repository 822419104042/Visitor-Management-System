package newproject.visitor.filter;

import newproject.visitor.service.EmployeeService;
import newproject.visitor.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
@WebFilter(urlPatterns = {"/*"})
public class JwtAuthFilter implements Filter {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String authHeader = httpServletRequest.getHeader("Authorization");
//        System.out.println(authHeader);
        String url = httpServletRequest.getRequestURI();
        String token = null;
        String email = null;

        if (url.contains("/api-docs") || url.contains("/v2") || url.equals("/user/login")) {

            chain.doFilter(request, response);
            return;
        }
        try {
            if (authHeader != null) {
                token = authHeader.replace("Bearer ", "");
                System.out.println(authHeader);
                email = jwtUtil.extractEmail(token.trim());
                if (jwtUtil.validateToken(token)) {
                    chain.doFilter(request, response);
                } else {
                    ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token is not valid.");
                }
            } else {
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token is not valid.");
            }

        } catch (Exception ex) {
            // throw ex;
            ex.printStackTrace();
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "401");

        }
    }
}