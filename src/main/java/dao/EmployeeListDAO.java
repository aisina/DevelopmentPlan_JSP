package dao;

import db.DatabaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by innopolis on 27.12.2016.
 */
public class EmployeeListDAO extends AbstractDAO<Employee, String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeListDAO.class);
    private  List<Employee> employeeList = new ArrayList<>();

    @Override
    public List<Employee> getAll() {
        Connection connection = DatabaseConnection.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
            while(rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getString("id"));
                employee.setName(rs.getString("name"));
                employee.setDepartment(rs.getString("department"));
                employee.setPosition(rs.getString("position"));
                employee.setEmail(rs.getString("email"));
                employeeList.add(employee);
            }

        } catch (SQLException e) {
            EmployeeListDAO.LOGGER.info(e.getMessage());
        }
        return (ArrayList<Employee>) this.employeeList;
    }

    @Override
    public Employee getEntityById(String key) {
        Employee employee = new Employee();
        Connection connection = DatabaseConnection.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE ID='" + key + "'");
            while(rs.next()){
                employee.setId(rs.getString("id"));
                employee.setName(rs.getString("name"));
                employee.setDepartment(rs.getString("department"));
                employee.setPosition(rs.getString("position"));
                employee.setEmail(rs.getString("email"));
            }

        } catch (SQLException e) {
            EmployeeListDAO.LOGGER.info(e.getMessage());
        }
        return employee;
    }

    @Override
    public Employee update(Employee entity) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM EMPLOYEE WHERE ID='" + id + "'");
            return true;

        } catch (SQLException e) {
            EmployeeListDAO.LOGGER.info(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean create(Employee entity) {
        return false;
    }
}
