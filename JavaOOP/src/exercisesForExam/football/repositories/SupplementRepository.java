package exercisesForExam.goldDigger.football.repositories;

import exercisesForExam.goldDigger.football.entities.supplement.Supplement;

public interface SupplementRepository {
    void add(Supplement supplement);

    boolean remove(Supplement supplement);

    Supplement findByType(String type);
}
