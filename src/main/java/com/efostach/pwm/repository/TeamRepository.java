package com.efostach.pwm.repository;

import com.efostach.pwm.model.Team;
import com.efostach.pwm.repository.exceptions.ConnectionFailException;

import java.sql.SQLException;
import java.util.List;

public interface TeamRepository extends GenericRpository<Team, Integer> {

    List<Team> getBySkill(Integer skillId) throws ConnectionFailException, SQLException;
}
