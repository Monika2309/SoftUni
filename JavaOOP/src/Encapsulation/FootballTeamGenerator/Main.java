package FootballTeamGenerator;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        List<Team> teams = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        String command = scanner.nextLine();
            while (!command.equals("END")) {
                String[] information = command.split(";");
                String action = information[0];
                String teamName = information[1];

                switch (action) {
                    case "Team":
                        try {
                            Team team = new Team(teamName);
                            teams.add(team);
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "Add":
                        try {
                            String playerName = information[2];
                            int endurance = Integer.parseInt(information[3]);
                            int sprint = Integer.parseInt(information[4]);
                            int dribble = Integer.parseInt(information[5]);
                            int passing = Integer.parseInt(information[6]);
                            int shooting = Integer.parseInt(information[7]);
                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            if (teams.stream().noneMatch(team1 -> team1.getName().equals(teamName))) {
                                System.out.println("Team " + teamName + " does not exist.");
                            } else {
                                Team teamAdd = teams.stream().filter(team2 -> team2.getName().equals(teamName)).findFirst().get();
                                teamAdd.addPlayer(player);
                                players.add(player);
                            }
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "Remove":
                        try {
                            String playerNameToRemove = information[2];
                            Team teamRemove = teams.stream().filter(team -> team.getName().equals(teamName)).findFirst().get();
                            if (teamRemove.getPlayers().stream().noneMatch(player1 -> player1.getName().equals(playerNameToRemove))) {
                                System.out.println("Player " + playerNameToRemove + " is not in " + teamName + " team.");
                            } else {
                                Player playerToRemove = players.stream()
                                        .filter(player -> player.getName().equals(playerNameToRemove))
                                        .findFirst()
                                        .get();
                                teamRemove.removePlayer(playerToRemove);
                                players.remove(playerToRemove);
                            }
                        } catch (Exception e){
                                System.out.println(e.getMessage());
                            }

                        break;
                    case "Rating":
                        try {
                            Team teamForRating = teams.stream().filter(team3 -> team3.getName().equals(teamName)).findFirst().get();
                            System.out.printf("%s - %d%n", teamName, Math.round(teamForRating.getRating()));
                        }catch (Exception e){
                            System.out.println("Team "+teamName+" does not exist.");
                        }
                        break;
                }

                command = scanner.nextLine();
            }
    }
}
