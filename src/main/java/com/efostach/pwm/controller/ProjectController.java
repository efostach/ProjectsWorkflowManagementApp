package com.efostach.pwm.controller;

import com.efostach.pwm.model.Project;
import com.efostach.pwm.model.ProjectStatus;
import com.efostach.pwm.repository.exceptions.ConnectionFailException;
import com.efostach.pwm.repository.exceptions.NotFoundObjectsException;
import com.efostach.pwm.repository.io.JDBCProjectRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class ProjectController {

    private JDBCProjectRepoImpl ioProject = new JDBCProjectRepoImpl();

    public void createProject(String name, Integer cost) throws ConnectionFailException, SQLException {

        ioProject.create(Project.newBuilder()
                .setName(name)
                .setCost(cost)
                .setStatus(ProjectStatus.IN_PROGRESS)
                .build());
    }

    public void completeProject(Integer id) throws ConnectionFailException, SQLException, NotFoundObjectsException {
        Project project = ioProject.getById(id);
        project.setStatus(ProjectStatus.COMPLETED);
        ioProject.update(project);
    }

    public List<Project> showProjects() throws ConnectionFailException, SQLException {

        return ioProject.getAll();
    }

    public List<Project> findProjectsByCost(Integer cost) throws ConnectionFailException, SQLException {

        return ioProject.getByCost(cost);
    }

    public List<Project> findProjectsBySkill(Integer skill) throws ConnectionFailException, SQLException {

        return ioProject.getBySkill(skill);
    }

    public List<Project> findProjectsByTeam(Integer teamId) throws ConnectionFailException, SQLException {

        return ioProject.getByTeamId(teamId);
    }
}
