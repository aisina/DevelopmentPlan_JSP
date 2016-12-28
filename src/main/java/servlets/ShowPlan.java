package servlets;

import controllers.ControllerForAdminPlans;
import controllers.ControllerForUserPlans;
import dao.PlanDAO;
import db.DatabaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.Plan;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by innopolis on 27.12.2016.
 */
public class ShowPlan extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShowPlan.class);
    private final ControllerForAdminPlans controller = new ControllerForAdminPlans();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String planYear = req.getParameter("planYear");

        req.setAttribute("adminPlan", this.controller.getValues(planYear));
        req.getRequestDispatcher("pages/adminPlan.jsp").forward(req, resp);

        //resp.sendRedirect("pages/adminPlan.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String planYear = req.getParameter("planYear");

        req.setAttribute("adminPlan", this.controller.getValues(planYear));
        req.getRequestDispatcher("pages/adminPlan.jsp").forward(req, resp);
    }
}
