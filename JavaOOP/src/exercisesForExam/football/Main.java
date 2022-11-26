package exercisesForExam.goldDigger.football;

import exercisesForExam.goldDigger.football.core.Engine;
import exercisesForExam.goldDigger.football.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
