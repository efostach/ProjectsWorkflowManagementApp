package com.efostach.pwm.repository.io;

import com.efostach.pwm.model.Project;
import com.efostach.pwm.model.ProjectStatus;
import com.efostach.pwm.repository.ProjectRepository;
import com.efostach.pwm.repository.exceptions.ConnectionFailException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.efostach.pwm.repository.io.JDBCUtilSQL.*;

public class JDBCProjectRepoImpl implements ProjectRepository {

    public Project getById(Integer id) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(PROJECT_GETBY_ID_SQL);
        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery(PROJECT_GETBY_ID_SQL);

        Project project = Project.newBuilder()
                    .setId(rs.getInt("id"))
                    .setName(rs.getString("name"))
                    .setCost(rs.getInt("cost"))
                    .setStatus(ProjectStatus.valueOf(rs.getString("status")))
                    .build();

        rs.close();
        statement.close();

        return project;
    }

    public List<Project> getByTeamId(Integer teamId) throws ConnectionFailException, SQLException {

        List<Project> projectSet = new ArrayList<Project>();

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(PROJECT_GETBY_TEAM_SQL);
        statement.setInt(1, teamId);

        ResultSet rs = statement.executeQuery(PROJECT_GETBY_TEAM_SQL);

        while (rs.next()) {
            projectSet.add(Project.newBuilder()
                    .setId(rs.getInt("id"))
                    .setName(rs.getString("name"))
                    .setCost(rs.getInt("cost"))
                    .setStatus(ProjectStatus.valueOf(rs.getString("status")))
                    .build());
        }

        rs.close();
        statement.close();

        return projectSet;
    }

    public List<Project> getByCost(Integer cost) throws ConnectionFailException, SQLException {

        List<Project> projectSet = new ArrayList<Project>();

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(PROJECT_GETBY_COST_SQL);
        statement.setInt(1, cost);

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            projectSet.add(Project.newBuilder()
                    .setId(rs.getInt("id"))
                    .setName(rs.getString("name"))
                    .setCost(rs.getInt("cost"))
                    .setStatus(ProjectStatus.valueOf(rs.getString("status")))
                    .build());
        }

        rs.close();
        statement.close();

        return projectSet;
    }

    public List<Project> getBySkill(Integer skillId) throws ConnectionFailException, SQLException {

        List<Project> projectSet = new ArrayList<Project>();

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(PROJECT_GETBY_SKILL_SQL);
        statement.setInt(1, skillId);

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            projectSet.add(Project.newBuilder()
                    .setId(rs.getInt("id"))
                    .setName(rs.getString("name"))
                    .setCost(rs.getInt("cost"))
                    .setStatus(ProjectStatus.valueOf(rs.getString("status")))
                    .build());
        }

        rs.close();
        statement.close();

        return projectSet;
    }

    public List<Project> getAll() throws SQLException, ConnectionFailException {

        List<Project> projectSet = new ArrayList<Project>();

        Statement statement = JDBCConnection.getConnection().createStatement();

        ResultSet rs = statement.executeQuery(PROJECT_GET_ALL_SQL);

        while (rs.next()) {
            projectSet.add(Project.newBuilder()
                    .setId(rs.getInt("id"))
                    .setName(rs.getString("name"))
                    .setCost(rs.getInt("cost"))
                    .setStatus(ProjectStatus.valueOf(rs.getString("status")))
                    .build());
        }

        rs.close();
        statement.close();

        return projectSet;
    }

    public void create(Project project) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(PROJECT_CREATE_SQL);
        statement.setString(1, project.getName());
        statement.setInt(2, project.getCost());
        statement.setString(3, String.valueOf(project.getStatus()));

        project.setId(statement.executeUpdate());
        statement.close();
    }

    public void update(Project project) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(PROJECT_UPDATE_SQL);
        statement.setString(1, project.getName());
        statement.setInt(2, project.getCost());
        statement.setString(3, String.valueOf(project.getStatus()));
        statement.setInt(4, project.getId());

        statement.executeUpdate();

        statement.close();
    }

    public void delete(Project project) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(PROJECT_DELETE_SQL);
        statement.setInt(1, project.getId());

        statement.executeQuery();

        statement.close();
    }
}
