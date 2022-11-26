package exercisesForExam.goldDigger.football.entities.field;

import exercisesForExam.goldDigger.football.entities.player.Player;
import exercisesForExam.goldDigger.football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static exercisesForExam.goldDigger.football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static exercisesForExam.goldDigger.football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field {

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;


    public BaseField(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    @Override
    public int sumEnergy() {
        return supplements.stream().mapToInt(Supplement::getEnergy).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (player.getKg() >= capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public void drag() {
        players.forEach(Player::stimulation);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):", name, this.getClass().getSimpleName()))
                .append(System.lineSeparator());
        sb.append("Player: ");
        if (players.isEmpty()) {
            sb.append("none");
        }else {
            sb.append(this.players.stream().map(Player::getName).collect(Collectors.joining(" ")));
        }
        sb.append(System.lineSeparator());
        sb.append("Supplement: ").append(this.supplements.size()).append(System.lineSeparator());
        sb.append("Energy: ").append(this.sumEnergy());

        return sb.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
