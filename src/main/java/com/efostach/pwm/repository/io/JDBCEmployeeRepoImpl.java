package com.efostach.pwm.repository.io;

import com.efostach.pwm.model.Employee;
import com.efostach.pwm.repository.EmployeeRepository;
import com.efostach.pwm.repository.exceptions.ConnectionFailException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCEmployeeRepoImpl implements EmployeeRepository {

    public Employee getById(Integer integer) {
        return null;
    }

    public List<Employee> getAll() throws SQLException, ConnectionFailException {
        List<Employee> employeeSet = new ArrayList<Employee>();

        Statement statement = JDBCConnection.getConnection().createStatement();
        String query = "SELECT * FROM employees";
        ResultSet rs = statement.executeQuery(query);

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

    public Employee create(Employee employee) {
        return null;
    }

    public Employee update(Employee employee) {
        return null;
    }

    public Employee delete(Employee employee) {
        return null;
    }
}
