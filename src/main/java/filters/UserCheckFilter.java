package filters;

import pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by innopolis on 26.12.2016.
 */
@WebFilter(servletNames = {"AddEmployeeServlet", "AddPlanServlet", "AdminPlanViewServlet", "DeleteEmployeeServlet", "ShowPlan", "UserChangeLoginAndPassword", "UserPlanViewServlet"})
//urlPatterns = {"/pages/*"}
public class UserCheckFilter implements Filter {

    private static Set<String> adminList = new HashSet<>();
    private static Set<String> userList = new HashSet<>();


    static {
        adminList.add("/pages/addEmployee.jsp");
        adminList.add("/pages/addPlan.jsp");
        adminList.add("/pages/adminPage.jsp");
        adminList.add("/pages/employeeList.jsp");
        adminList.add("/pages/plansList.jsp");

        adminList.add("/addEmployee");
        adminList.add("/deleteEmployee");
        //adminList.add("/userLogon");
        adminList.add("/addPlan");
        adminList.add("/showPlan");

        userList.add("/pages/employeePage.jsp");
        userList.add("/pages/changePassAndLogin.jsp");
        userList.add("/userPlanViewServlet");
        userList.add("/userChangeLoginAndPassword");


        //whiteList.add("/");
        //whiteList.add("/servlets/addEmployee");
        //whiteList.add("/login.jsp");
        //whiteList.add("/register.jsp");
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        String query = httpRequest.getRequestURI();

        System.out.println(query);
        System.out.println(session.getAttribute("username"));
        System.out.println(httpRequest.getContextPath());

        if ((session == null || session.getAttribute("logged") == null))
                /*&& !query.matches("/public/.*(.css|.js|.png|.jpg|.jsp)")*/
                //&& whiteList.contains(query))
        {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");

        } else {

            if("admin".equals(session.getAttribute("username"))){
                if(! adminList.contains(query)){
                    //без localhost вообще не работает
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "localhost:8080/pages/adminPage.jsp");
                }
                else{
                    chain.doFilter(httpRequest, httpResponse);
                }

            }
            else{
                if(! userList.contains(query)){
                    //без localhost выдает "Привет, null"
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "localhost:8080/pages/employeePage.jsp");
                }
                else{
                    chain.doFilter(httpRequest, httpResponse);
                }
            }

        }
    }


    public void destroy() {
    }
}
