package com.efostach.pwm.repository;

import com.efostach.pwm.model.Project;
import com.efostach.pwm.repository.exceptions.ConnectionFailException;

import java.sql.SQLException;
import java.util.List;

public interface ProjectRepository extends GenericRpository<Project, Integer>  {

    List<Project> getByTeamId(Integer teamId) throws ConnectionFailException, SQLException;

    List<Project> getByCost(Integer cost) throws ConnectionFailException, SQLException;

    List<Project> getBySkill(Integer skillId) throws ConnectionFailException, SQLException;

}