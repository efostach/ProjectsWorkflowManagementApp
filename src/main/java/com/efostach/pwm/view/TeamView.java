package com.efostach.pwm.view;

import com.efostach.pwm.controller.TeamController;
import com.efostach.pwm.model.Team;
import com.efostach.pwm.repository.exceptions.ConnectionFailException;

import java.sql.SQLException;

class TeamView {

    private TeamController teamController = new TeamController();

    void showTeams() {
        try {
            for(Team object : teamController.showTeams()){
                print(object);
            }
        } catch (ConnectionFailException e) {
            System.out.println("Connection failed.");
        } catch (SQLException e) {
            System.out.println("Incorrect query result.");
        }
    }

    void showFilteredTeamsBySkill(Integer skillId) {
        try {
            for(Team object : teamController.getTeamsBySkill(skillId)){
                print(object);
            }
        } catch (ConnectionFailException e) {
            System.out.println("Connection failed.");
        } catch (SQLException e) {
            System.out.println("Incorrect query result.");
        }
    }

    private void print(Team team){
        System.out.println("ID: " + team.getId()
                + "\tName: " + team.getName());
    }

}
