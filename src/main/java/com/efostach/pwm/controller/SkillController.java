package com.efostach.pwm.controller;

import com.efostach.pwm.model.Skill;
import com.efostach.pwm.repository.exceptions.ConnectionFailException;
import com.efostach.pwm.repository.io.JDBCSkillRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class SkillController {

    private JDBCSkillRepoImpl ioSkill = new JDBCSkillRepoImpl();

    public List<Skill> showSkills() throws ConnectionFailException, SQLException {

        return ioSkill.getAll();
    }
}
