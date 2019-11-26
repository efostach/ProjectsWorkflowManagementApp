package com.efostach.pwm.repository.io;

import com.efostach.pwm.model.Team;
import com.efostach.pwm.repository.TeamRepository;
import com.efostach.pwm.repository.exceptions.ConnectionFailException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.efostach.pwm.repository.io.JDBCUtilSQL.*;

public class JDBCTeamRepoImpl implements TeamRepository {

    public Team getById(Integer id) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(TEAMS_GETBY_ID_SQL);
        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();

        Team team = Team.newBuilder()
                .setId(rs.getInt("id"))
                .setName(rs.getString("name"))
                .build();

        rs.close();
        statement.close();

        return team;
    }

    public List<Team> getBySkill(Integer skillId) throws ConnectionFailException, SQLException {

        List<Team> teamSet = new ArrayList<Team>();

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(TEAMS_GETBY_SKILL_SQL);
        statement.setInt(1, skillId);

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            teamSet.add(Team.newBuilder()
                    .setId(rs.getInt("id"))
                    .setName(rs.getString("name"))
                    .build());
        }

        rs.close();
        statement.close();

        return teamSet;
    }

    public List<Team> getAll() throws SQLException, ConnectionFailException {

        List<Team> teamSet = new ArrayList<Team>();

        Statement statement = JDBCConnection.getConnection().createStatement();

        ResultSet rs = statement.executeQuery(TEAMS_GET_ALL_SQL);

        while (rs.next()) {
            teamSet.add(Team.newBuilder()
                    .setId(rs.getInt("id"))
                    .setName(rs.getString("name"))
                    .build());
        }

        rs.close();
        statement.close();

        return teamSet;
    }

    public void create(Team team) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(TEAMS_CREATE_SQL);
        statement.setString(1, team.getName());

        statement.executeQuery();

        statement.close();
    }

    public void update(Team team) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(TEAMS_UPDATE_SQL);
        statement.setString(1, team.getName());
        statement.setInt(2, team.getId());

        statement.executeQuery();

        statement.close();
    }

    public void delete(Team team) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(TEAMS_DELETE_SQL);
        statement.setInt(1, team.getId());

        statement.executeQuery();

        statement.close();
    }
}
