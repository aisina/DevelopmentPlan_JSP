package servlets;

import db.DatabaseConnection;
import pojo.User;
import services.users.ServiceOfUsers;
import services.users.ServiceOfUsersImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by innopolis on 27.12.2016.
 */
public class UserLogon extends HttpServlet {

    private static final Map<String, User> users = getUsers();
    public ServiceOfUsers userService = new ServiceOfUsersImpl();

    private static Map<String, User> getUsers() {
        Map<String, User> users = new HashMap<String, User>();

        Connection connection = DatabaseConnection.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
            while(rs.next()){
                User user = new User();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                users.put(user.getUsername(), user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     * аутентиикация пользователей
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd;
        String name = req.getParameter("username");
        String password = req.getParameter("password");

        //User user = validateLogin(name, password);
        User user = userService.validateLogin(name, password, users.get(name));

        if (user == null){
            rd = req.getRequestDispatcher(String.format("%s%s", req.getContextPath(), "pages/loginError.jsp"));
            rd.forward(req, resp);
        }
        else{
            HttpSession session = req.getSession();
            session.setAttribute("logged", user);
            session.setAttribute("username", user.getUsername());
            session.setAttribute("id", user.getId());

            if("admin".contains(user.getUsername())){
               //rd = req.getRequestDispatcher(String.format("%s%s", req.getContextPath(), "pages/adminPage.jsp"));
                //rd = req.getRequestDispatcher("pages/adminPage.jsp");

                //без редиректа url = алиас сервлета, переходы вперед-назад работают неправильно
                //в методе doGet можно forward ом
                resp.sendRedirect("pages/adminPage.jsp");
            }
            else{
                //rd = req.getRequestDispatcher(String.format("%s%s", req.getContextPath(), "pages/employeePage.jsp"));
                //resp.sendRedirect("pages/employeePage.jsp");
                resp.sendRedirect("/userPlanViewServlet");
            }
        }

        //rd.forward(req, resp);
    }




}
