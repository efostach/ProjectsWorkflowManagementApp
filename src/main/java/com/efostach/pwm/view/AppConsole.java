package com.efostach.pwm.view;

import com.efostach.pwm.repository.exceptions.ConnectionFailException;
import com.efostach.pwm.repository.io.JDBCConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppConsole {

    private Scanner scanner = new Scanner(System.in);
    private ProjectView pv = new ProjectView();
    private TeamView tv = new TeamView();
    private SkillView sv = new SkillView();

    public void run() {

        pv.completeProject(1);


        printGeneralMenu();

        switch (scanner.nextLine()) {
            default: {
                printWrongSelection();
                run();
                break;
            }
            case "1": {
                List<String> parameters = new ArrayList<>();
                parameters.add("name, cost");

                printInputParameters(parameters);

                pv.createProject(getFieldInputValue(), transferToIntegerValue());

                run();
                break;
            }
            case "2": {
                List<String> parameters = new ArrayList<>();
                parameters.add("id");

                printInputParameters(parameters);

                pv.completeProject(transferToIntegerValue());

                run();
                break;
            }
            case "3": {
                List<String> parameters = new ArrayList<>();
                parameters.add("cost");

                printInputParameters(parameters);

                pv.showProjectsFilteredByCost(transferToIntegerValue());

                run();
                break;
            }
            case "4": {
                List<String> parameters = new ArrayList<>();

                parameters.add("teamID");

                printInputParameters(parameters);

                pv.showProjectsFilteredByTeam(transferToIntegerValue());

                run();
                break;
            }
            case "5": {
                List<String> parameters = new ArrayList<>();

                parameters.add("skillID");

                printInputParameters(parameters);

                pv.showProjectsFilteredBySkill(transferToIntegerValue());

                run();
                break;
            }
            case "6": {
                List<String> parameters = new ArrayList<>();

                parameters.add("skillID");

                printInputParameters(parameters);

                tv.showFilteredTeamsBySkill(transferToIntegerValue());

                run();
                break;
            }
            case "7": {
                sv.showSkills();
                run();
                break;
            }
            case "8": {
                pv.showProjects();
                run();
                break;
            }
            case "9": {
                tv.showTeams();
                run();
                break;
            }
            case "0": {
                break;
            }
        }

        try {
            if (JDBCConnection.getConnection() != null)
                JDBCConnection.getConnection().close();
        } catch (ConnectionFailException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void printGeneralMenu() {
        System.out.println("\n1. Create project");
        System.out.println("2. Complete project");
        System.out.println("3. Find project by cost");
        System.out.println("4. Find project by team");
        System.out.println("5. Find project by skill");
        System.out.println("6. Find team by skill");
        System.out.println("7. Show skills");
        System.out.println("8. Show projects");
        System.out.println("9. Show teams");
        System.out.println("0. Exit \n");
    }

    private void printWrongSelection() {
        System.out.println("Oops, it's wrong value.\n");
    }

    private void printInputParameters(List<String> parameters) {

        if (!parameters.isEmpty()) {
            StringBuilder string = new StringBuilder().append("\nEnter ");

            for (String parameter : parameters) {
                string.append(parameter + "    ");
            }

            System.out.println(string);
        }
    }

    private String getFieldInputValue() {
        String input;
        do {
            input = scanner.nextLine();
        } while (input.equals(""));
        return input;
    }

    private Integer transferToIntegerValue() {
        Integer input = null;

        try {
            input = getIntegerValue(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Invalid id value.");
        }
        return input;
    }

    private static Integer getIntegerValue(String value) {

        Integer result = null;

        try {
            result = Integer.valueOf(value);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid id value.");
        }
        return result;
    }

}
