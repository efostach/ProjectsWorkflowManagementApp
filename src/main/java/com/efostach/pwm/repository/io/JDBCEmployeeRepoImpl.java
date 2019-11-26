package com.efostach.pwm.repository.io;

import com.efostach.pwm.model.Employee;
import com.efostach.pwm.repository.EmployeeRepository;
import com.efostach.pwm.repository.exceptions.ConnectionFailException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.efostach.pwm.repository.io.JDBCUtilSQL.*;

public class JDBCEmployeeRepoImpl implements EmployeeRepository {

    public Employee getById(Integer id) throws ConnectionFailException, SQLException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(EMPLOYEES_GETBY_ID_SQL);
        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();

        Employee employee = Employee.newBuilder()
                .setId(rs.getInt("id"))
                .setFirstName(rs.getString("first_name"))
                .setLastName(rs.getString("last_name"))
                .setTeamId(rs.getInt("team_id"))
                .setWorkExperience(rs.getInt("work_experience"))
                .build();

        rs.close();
        statement.close();

        return employee;
    }

    public List<Employee> getAll() throws SQLException, ConnectionFailException {

        List<Employee> employeeSet = new ArrayList<Employee>();

        Statement statement = JDBCConnection.getConnection().createStatement();

        ResultSet rs = statement.executeQuery(EMPLOYEES_GET_ALL_SQL);

        while (rs.next()) {
            employeeSet.add(Employee.newBuilder()
                    .setId(rs.getInt("id"))
                    .setFirstName(rs.getString("first_name"))
                    .setLastName(rs.getString("last_name"))
                    .setTeamId(rs.getInt("team_id"))
                    .setWorkExperience(rs.getInt("work_experience"))
                    .build());
        }

        rs.close();
        statement.close();

        return employeeSet;
    }

    public void create(Employee employee) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(EMPLOYEES_CREATE_SQL);
        statement.setString(1, employee.getFirstName());
        statement.setString(2, employee.getLastName());
        statement.setInt(3, employee.getWorkEcperience());
        statement.setInt(4, employee.getTeamId());

        statement.executeQuery();

        statement.close();
    }

    public void update(Employee employee) throws ConnectionFailException, SQLException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(EMPLOYEES_UPDATE_SQL);
        statement.setString(1, employee.getFirstName());
        statement.setString(2, employee.getLastName());
        statement.setInt(3, employee.getWorkEcperience());
        statement.setInt(4, employee.getTeamId());
        statement.setInt(5, employee.getId());

        statement.executeQuery();

        statement.close();
    }

    public void delete(Employee employee) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(EMPLOYEES_DELETE_SQL);
        statement.setInt(1, employee.getId());

        statement.executeQuery();

        statement.close();
    }
}
