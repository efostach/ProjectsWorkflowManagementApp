package com.efostach.pwm.controller;

import com.efostach.pwm.model.Team;
import com.efostach.pwm.repository.exceptions.ConnectionFailException;
import com.efostach.pwm.repository.io.JDBCTeamRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class TeamController {

    private JDBCTeamRepoImpl ioTeam = new JDBCTeamRepoImpl();

    public List<Team> showTeams() throws ConnectionFailException, SQLException {

        return ioTeam.getAll();
    }

    public List<Team> getTeamsBySkill(Integer skillId) throws ConnectionFailException, SQLException {

        return ioTeam.getBySkill(skillId);
    }
}
