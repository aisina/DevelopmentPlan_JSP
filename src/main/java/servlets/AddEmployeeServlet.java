package servlets;

import controllers.GeneratePasswordController;
import db.DatabaseConnection;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by innopolis on 26.12.2016.
 */

public class AddEmployeeServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddEmployeeServlet.class);
    GeneratePasswordController controller = new GeneratePasswordController();

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
     * Добавляет нового сотрудника в базу
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));

        String name = req.getParameter("addName");
        String department = req.getParameter("addDepartment");
        String position = req.getParameter("addPosition");
        String email = req.getParameter("addEmail");

        try {
            Connection connection = DatabaseConnection.getConnection();
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT MAX(ID) maxid FROM EMPLOYEE");
                String ids = "";
                 while(rs.next()){
                     ids = rs.getString("maxid");
                 }
                 int id = Integer.parseInt(ids) + 1;
                 ids = "" + id;

                 stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES('" + id + "', '" + name + "', '" + department + "', '" + position + "', '" + email + "')");
                 stmt.executeUpdate("insert into users values('" + id + "', '" + id + "', '" + this.controller.generatePass(ids) +"')");

            } catch (SQLException e) {
                AddEmployeeServlet.LOGGER.info(e.getMessage());
            }
        }finally {

        }
        resp.sendRedirect("pages/employeeList.jsp");
        //req.getRequestDispatcher("pages/employeeList.jsp").forward(req, resp);

    }
}
