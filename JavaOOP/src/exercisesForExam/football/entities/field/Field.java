package exercisesForExam.goldDigger.football.entities.field;

import exercisesForExam.goldDigger.football.entities.player.Player;
import exercisesForExam.goldDigger.football.entities.supplement.Supplement;

import java.util.Collection;

public interface Field {
    int sumEnergy();

    void addPlayer(Player player);

    void removePlayer(Player player);

    void addSupplement(Supplement supplement);

    void drag();

    String getInfo();

    Collection<Player> getPlayers();

    Collection<Supplement> getSupplements();

    String getName();
}
