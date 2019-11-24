package com.efostach.pwm.repository.io;

public class JDBCUtilSQL {

    // Customers

    public static final String CUSTOMER_GETBYID_SQL = "SELECT * FROM customers WHERE id = ?";

    public static final String CUSTOMER_GETALL_SQL = "SELECT * FROM customers";

    public static final String CUSTOMER_CREATE_SQL = "INSERT INTO customers (name) VALUES (?)";

    public static final String CUSTOMER_UPDATE_SQL = "UPDATE customers SET name = ? WHERE id = ?";

    public static final String CUSTOMER_DELETE_SQL = "DELETE FROM customers WHERE id = ?";


    // Employees

    public static final String EMPLOYEES_GETBYID_SQL = "SELECT * FROM employees WHERE id = ?";

    public static final String EMPLOYEES_GETALL_SQL = "SELECT * FROM employees";

    public static final String EMPLOYEES_CREATE_SQL = "INSERT INTO employees (first_name, last_name, work_experience, team_id) VALUES (?,?,?,?)";

    public static final String EMPLOYEES_UPDATE_SQL = "UPDATE employees SET first_name = ?, last_name = ?, work_experience = ?, team_id = ? WHERE id = ?";

    public static final String EMPLOYEES_DELETE_SQL = "DELETE FROM employees WHERE id = ?";


    // Projects

    public static final String PROJECT_GETBYID_SQL = "SELECT * FROM projects WHERE id = ?";

    public static final String PROJECT_GETALL_SQL = "SELECT * FROM projects";

    public static final String PROJECT_CREATE_SQL = "INSERT INTO projects (name, cost, status) VALUES (?,?,?)";

    public static final String PROJECT_UPDATE_SQL = "UPDATE projects SET name = ?, cost = ?, status = ? WHERE id = ?";

    public static final String PROJECT_DELETE_SQL = "DELETE FROM projects WHERE id = ?";


    // Skills

    public static final String SKILLS_GETBYID_SQL = "SELECT * FROM skills WHERE id = ?";

    public static final String SKILLS_GETALL_SQL = "SELECT * FROM skills";

    public static final String SKILLS_CREATE_SQL = "INSERT INTO skills (name) VALUES (?)";

    public static final String SKILLS_UPDATE_SQL = "UPDATE skills SET name = ? WHERE id = ?";

    public static final String SKILLS_DELETE_SQL = "DELETE FROM skills WHERE id = ?";


    // Teams

    public static final String TEAMS_GETBYID_SQL = "SELECT * FROM teams WHERE id = ?";

    public static final String TEAMS_GETALL_SQL = "SELECT * FROM teams";

    public static final String TEAMS_CREATE_SQL = "INSERT INTO teams (name) VALUES (?)";

    public static final String TEAMS_UPDATE_SQL = "UPDATE teams SET name = ? WHERE id = ?";

    public static final String TEAMS_DELETE_SQL = "DELETE FROM teams WHERE id = ?";

}
