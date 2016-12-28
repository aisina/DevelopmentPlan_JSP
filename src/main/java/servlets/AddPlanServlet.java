package servlets;

import db.DatabaseConnection;

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
 * Created by innopolis on 27.12.2016.
 */
public class AddPlanServlet extends HttpServlet {

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
     * добавляет новый план в БД
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));

        String year = req.getParameter("addYear");
        String name = req.getParameter("addName");
        String position = req.getParameter("addPosition");
        String planType = req.getParameter("addPlanType");

        try {
            Connection connection = DatabaseConnection.getConnection();
            try {
                Statement stmt = connection.createStatement();
                System.out.println(year + " " + name + " " + position + " " + planType);
                ResultSet rs = stmt.executeQuery("select id from employee where name='" + name + "' and position='" + position + "'");
                String id="";
                while(rs.next()){
                    id = (String) rs.getString("id");
                }
                stmt.executeUpdate("INSERT INTO PLAN VALUES('" + year + "', '" + name + "', '" + position + "', '" + planType + "', '" + id + "')");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {

        }

        resp.sendRedirect("pages/adminPage.jsp");

    }
}
