package com.efostach.pwm.repository.io;

class JDBCUtilSQL {

    // Customers

    static final String CUSTOMER_GETBY_ID_SQL = "SELECT * FROM customers WHERE id = ?";

    static final String CUSTOMER_GET_ALL_SQL = "SELECT * FROM customers";

    static final String CUSTOMER_CREATE_SQL = "INSERT INTO customers (name) VALUES (?)";

    static final String CUSTOMER_UPDATE_SQL = "UPDATE customers SET name = ? WHERE id = ?";

    static final String CUSTOMER_DELETE_SQL = "DELETE FROM customers WHERE id = ?";


    // Employees

    static final String EMPLOYEES_GETBY_ID_SQL = "SELECT * FROM employees WHERE id = ?";

    static final String EMPLOYEES_GET_ALL_SQL = "SELECT * FROM employees";

    static final String EMPLOYEES_CREATE_SQL = "INSERT INTO employees (first_name, last_name, work_experience, team_id) VALUES (?,?,?,?)";

    static final String EMPLOYEES_UPDATE_SQL = "UPDATE employees SET first_name = ?, last_name = ?, work_experience = ?, team_id = ? WHERE id = ?";

    static final String EMPLOYEES_DELETE_SQL = "DELETE FROM employees WHERE id = ?";


    // Projects

    static final String PROJECT_GETBY_ID_SQL = "SELECT * FROM projects WHERE id = ?";

    static final String PROJECT_GETBY_TEAM_SQL = "SELECT \n" +
            "    id, name, cost, status\n" +
            "FROM\n" +
            "    project_teams pt\n" +
            "        LEFT JOIN projects p ON pt.project_id = p.id\n" +
            "WHERE\n" +
            "    pt.team_id = ?";

    static final String PROJECT_GETBY_COST_SQL = "SELECT * FROM projects WHERE cost = ?";

    static final String PROJECT_GETBY_SKILL_SQL = "SELECT \n" +
            "    id, name, cost, status\n" +
            "FROM\n" +
            "    (SELECT DISTINCT\n" +
            "        project_id\n" +
            "    FROM\n" +
            "        (SELECT \n" +
            "        e.team_id\n" +
            "    FROM\n" +
            "        employee_skills es\n" +
            "    LEFT JOIN employees e ON es.employee_id = e.id\n" +
            "    WHERE\n" +
            "        es.skill_id = ? ) result\n" +
            "    LEFT JOIN project_teams pt ON result.team_id = pt.team_id) project_set\n" +
            "        LEFT JOIN\n" +
            "    projects p ON project_set.project_id = p.id\n" +
            "ORDER BY id\n";

    static final String PROJECT_GET_ALL_SQL = "SELECT * FROM projects";

    static final String PROJECT_CREATE_SQL = "INSERT INTO projects (name, cost, status) VALUES (?,?,?)";

    static final String PROJECT_UPDATE_SQL = "UPDATE projects SET name = ?, cost = ?, status = ? WHERE id = ?";

    static final String PROJECT_DELETE_SQL = "DELETE FROM projects WHERE id = ?";


    // Skills

    static final String SKILLS_GETBY_ID_SQL = "SELECT * FROM skills WHERE id = ?";

    static final String SKILLS_GET_ALL_SQL = "SELECT * FROM skills";

    static final String SKILLS_CREATE_SQL = "INSERT INTO skills (name) VALUES (?)";

    static final String SKILLS_UPDATE_SQL = "UPDATE skills SET name = ? WHERE id = ?";

    static final String SKILLS_DELETE_SQL = "DELETE FROM skills WHERE id = ?";


    // Teams

    static final String TEAMS_GETBY_ID_SQL = "SELECT * FROM teams WHERE id = ?";

    static final String TEAMS_GETBY_SKILL_SQL = "SELECT DISTINCT\n" +
            "    id, name\n" +
            "FROM\n" +
            "    (SELECT \n" +
            "        e.team_id\n" +
            "    FROM\n" +
            "        employee_skills es\n" +
            "    LEFT JOIN employees e ON es.employee_id = e.id\n" +
            "    WHERE\n" +
            "        es.skill_id = ?) result\n" +
            "        LEFT JOIN\n" +
            "    teams t ON result.team_id = t.id\n" +
            "ORDER BY id";

    static final String TEAMS_GET_ALL_SQL = "SELECT * FROM teams";

    static final String TEAMS_CREATE_SQL = "INSERT INTO teams (name) VALUES (?)";

    static final String TEAMS_UPDATE_SQL = "UPDATE teams SET name = ? WHERE id = ?";

    static final String TEAMS_DELETE_SQL = "DELETE FROM teams WHERE id = ?";
}
