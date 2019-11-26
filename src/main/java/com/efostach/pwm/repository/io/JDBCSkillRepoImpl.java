package com.efostach.pwm.repository.io;

import com.efostach.pwm.model.Skill;
import com.efostach.pwm.repository.SkillRepository;
import com.efostach.pwm.repository.exceptions.ConnectionFailException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.efostach.pwm.repository.io.JDBCUtilSQL.*;

public class JDBCSkillRepoImpl implements SkillRepository {

    public Skill getById(Integer id) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(SKILLS_GETBY_ID_SQL);
        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();

        Skill skill = new Skill(rs.getInt("id"), rs.getString("name"));

        rs.close();
        statement.close();

        return skill;
    }

    public List<Skill> getAll() throws SQLException, ConnectionFailException {

        List<Skill> skillSet = new ArrayList<Skill>();

        Statement statement = JDBCConnection.getConnection().createStatement();

        ResultSet rs = statement.executeQuery(SKILLS_GET_ALL_SQL);

        while (rs.next()) {
            skillSet.add(new Skill(rs.getInt("id"), rs.getString("name")));
        }

        rs.close();
        statement.close();

        return skillSet;
    }

    public void create(Skill skill) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(SKILLS_CREATE_SQL);
        statement.setString(1, skill.getName());

        statement.executeQuery();

        statement.close();
    }

    public void update(Skill skill) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(SKILLS_UPDATE_SQL);
        statement.setString(1, skill.getName());
        statement.setInt(2, skill.getId());

        statement.executeQuery();

        statement.close();
    }

    public void delete(Skill skill) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(SKILLS_DELETE_SQL);
        statement.setInt(1, skill.getId());

        statement.executeQuery();

        statement.close();
    }
}
