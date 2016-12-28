package servlets;

import controllers.GeneratePasswordController;
import db.DatabaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by innopolis on 28.12.2016.
 */
public class UserChangeLoginAndPassword extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserChangeLoginAndPassword.class);
    GeneratePasswordController controller = new GeneratePasswordController();

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     * изменение логина или пароля пользователем
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String login2 = req.getParameter("login2");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");

        if(! login.equals(login2))
            UserChangeLoginAndPassword.LOGGER.info("Логины не совпадают");
        //return
        else{
            if(! password.equals(password2)){
                UserChangeLoginAndPassword.LOGGER.info("Пароли не совпадают");
                //return
            }
            else{

                Connection connection = DatabaseConnection.getConnection();
                try {

                    Statement stmt = connection.createStatement();
                    String sqlQuery = "update users set ";

                    if(login == "" && password != ""){
                        sqlQuery += "password='" + this.controller.generatePass(password) + "' ";
                    }
                    if(login != "" && password == ""){
                        sqlQuery += "login='" + login + "' ";
                    }
                    if(login != "" && password != ""){
                        sqlQuery += "password='" + this.controller.generatePass(password) + "', login = '" + login +"' ";
                    }

                    HttpSession session = req.getSession();
                    String id = (String) session.getAttribute("id");
                    sqlQuery += "where id='" + id + "'";
                    System.out.println(sqlQuery);

                    stmt.executeUpdate(sqlQuery);

                    resp.sendRedirect("pages/loginChangedSuccess.jsp");

                } catch (SQLException e) {
                    resp.sendRedirect("pages/loginChangedError.jsp");
                    UserChangeLoginAndPassword.LOGGER.info(e.getMessage());
                }

            }
        }


    }
}
