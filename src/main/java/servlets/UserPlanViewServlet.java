package servlets;

import controllers.ControllerForUserPlans;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by innopolis on 28.12.2016.
 */
public class UserPlanViewServlet extends HttpServlet {

    private final ControllerForUserPlans controller = new ControllerForUserPlans();

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     * просмотр сотрудником планов, в которые он внесен
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        User user = new User((String) session.getAttribute("id"), (String) session.getAttribute("username"));


        if (user == null) {
            req.getRequestDispatcher("/loginError.jsp").forward(req, resp);
        } else {
            req.setAttribute("plans", this.controller.getValues(user.getId()));
            req.getRequestDispatcher("pages/employeePage.jsp").forward(req, resp);
        }
    }
}
