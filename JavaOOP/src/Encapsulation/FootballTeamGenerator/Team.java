package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;

    public List<Player> getPlayers() {
        return players;
    }

    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players=new ArrayList<>();
    }
    public void addPlayer(Player player){
        players.add(player);
    }
    public void removePlayer(Player player) throws NoSuchFieldException {
        if (!players.contains(player)){
            throw new IllegalArgumentException("Player "+ player + " is not in " + this.name + " team.");
        }
        players.remove(player);
    }
    public double getRating(){
        return players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name==null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }
}
