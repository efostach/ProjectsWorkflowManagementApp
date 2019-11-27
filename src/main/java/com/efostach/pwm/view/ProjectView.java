package com.efostach.pwm.view;

import com.efostach.pwm.controller.ProjectController;
import com.efostach.pwm.model.Project;
import com.efostach.pwm.repository.exceptions.ConnectionFailException;
import com.efostach.pwm.repository.exceptions.NotFoundObjectsException;

import java.sql.SQLException;

class ProjectView {

    private ProjectController projectController = new ProjectController();

    void showProjects() {
        try {
            for (Project object : projectController.showProjects()) {
                print(object);
            }
        } catch (ConnectionFailException e) {
            System.out.println("Connection failed.");
        } catch (SQLException e) {
            System.out.println("Incorrect query result.");
        }
    }

    void createProject(String name, Integer cost) {
        try {
            projectController.createProject(name, cost);
        } catch (ConnectionFailException e) {
            System.out.println("Connection failed.");
        } catch (SQLException e) {
            System.out.println("Incorrect query result.");
        }
    }

    void completeProject(Integer projectId) {
        try {
            projectController.completeProject(projectId);
        } catch (ConnectionFailException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Incorrect query result.");
        } catch (NotFoundObjectsException e) {
            System.out.println(e.getMessage());
        }
    }

    void showProjectsFilteredByCost(Integer cost) {
        try {
            for (Project object : projectController.findProjectsByCost(cost)) {
                print(object);
            }
        } catch (ConnectionFailException e) {
            System.out.println("Connection failed.");
        } catch (SQLException e) {
            System.out.println("Incorrect query result.");
        }
    }

    void showProjectsFilteredBySkill(Integer skillId) {
        try {
            for (Project object : projectController.findProjectsBySkill(skillId)) {
                print(object);
            }
        } catch (ConnectionFailException e) {
            System.out.println("Connection failed.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Incorrect query result.");
        }
    }

    void showProjectsFilteredByTeam(Integer teamId) {
        try {
            for (Project object : projectController.findProjectsByTeam(teamId)) {
                print(object);
            }
        } catch (ConnectionFailException e) {
            System.out.println("Connection failed.");
        } catch (SQLException e) {
            System.out.println("Incorrect query result.");
        }
    }

    private void print(Project project) {
        System.out.println("ID: " + project.getId()
                + "\tName: " + project.getName()
                + "\tCost: " + project.getCost()
                + "\tStatus: " + project.getStatus());
    }
}
