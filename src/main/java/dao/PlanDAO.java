package dao;

import db.DatabaseConnection;
import pojo.Employee;
import pojo.Plan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by innopolis on 27.12.2016.
 */
public class PlanDAO implements myDAO<Plan> {

    private  List<Plan> plansList = new ArrayList<>();

    @Override
    public List<Plan> getAll() {
        Connection connection = DatabaseConnection.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PLAN");
            while(rs.next()){
                Plan plan = new Plan();
                plan.setYear(rs.getString("year"));
                plan.setEmployeeName(rs.getString("empl_name"));
                plan.setEmployeePosition(rs.getString("position"));
                plan.setPlanType(rs.getString("plan_type"));
                plansList.add(plan);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.plansList;
    }

    public List<String> getPlanYear() {
        Connection connection = DatabaseConnection.getConnection();
        List<String> years = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT YEAR FROM PLAN ORDER BY YEAR DESC");
            while(rs.next()){
                years.add(rs.getString("year"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return years;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void add() {

    }


    public List<Plan> getPlanByYear(String year) {
        Connection connection = DatabaseConnection.getConnection();
        List<Plan> plans = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PLAN WHERE YEAR = '" + year + "'");
            while(rs.next()){
                Plan plan = new Plan();
                //plan.setYear(year);
                plan.setYear(rs.getString("year"));
                plan.setEmployeeName(rs.getString("empl_name"));
                plan.setEmployeePosition(rs.getString("position"));
                plan.setPlanType(rs.getString("plan_type"));
                plans.add(plan);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plans;
    }

    public List<Plan> getPlanByEmplId(String id) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PLAN WHERE EMPLOYEE_ID = '" + id + "'");
            while(rs.next()){
                Plan plan = new Plan();
                plan.setYear(rs.getString("year"));
                plan.setEmployeeName(rs.getString("empl_name"));
                plan.setEmployeePosition(rs.getString("position"));
                plan.setPlanType(rs.getString("plan_type"));
                plansList.add(plan);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.plansList;
    }
}
