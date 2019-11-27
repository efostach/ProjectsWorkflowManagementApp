package com.efostach.pwm.view;

import com.efostach.pwm.controller.SkillController;
import com.efostach.pwm.model.Skill;
import com.efostach.pwm.repository.exceptions.ConnectionFailException;

import java.sql.SQLException;

class SkillView {

    private SkillController skillController = new SkillController();

    void showSkills() {
        try {
            for(Skill object : skillController.showSkills()){
                print(object);
            }
        } catch (ConnectionFailException e) {
            System.out.println("Connection failed.");
        } catch (SQLException e) {
            System.out.println("Incorrect query result.");
        }
    }

    private void print(Skill skill){
        System.out.println("ID: " + skill.getId()
                + "\tName: " + skill.getName());
    }

}
