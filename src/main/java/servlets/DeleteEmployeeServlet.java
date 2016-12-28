package servlets;

import db.DatabaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by innopolis on 26.12.2016.
 */
public class DeleteEmployeeServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteEmployeeServlet.class);

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     * удаляет сотрудника из БД
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("employeeID"));

        try {
            Connection connection = DatabaseConnection.getConnection();
            try {
                Statement stmt = connection.createStatement();
                stmt.executeUpdate("DELETE FROM EMPLOYEE WHERE ID=" + id);
                stmt.executeUpdate("DELETE FROM USERS WHERE ID=" + id);

            } catch (SQLException e) {
                DeleteEmployeeServlet.LOGGER.info(e.getMessage());
            }
        }finally {

        }

        //req.getRequestDispatcher("pages/employeeList.jsp").forward(req, resp);
        resp.sendRedirect("pages/employeeList.jsp");
    }
}
