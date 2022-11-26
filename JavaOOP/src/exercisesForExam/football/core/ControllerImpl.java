package exercisesForExam.goldDigger.football.core;


import exercisesForExam.goldDigger.football.entities.field.ArtificialTurf;
import exercisesForExam.goldDigger.football.entities.field.Field;
import exercisesForExam.goldDigger.football.entities.field.NaturalGrass;
import exercisesForExam.goldDigger.football.entities.player.Men;
import exercisesForExam.goldDigger.football.entities.player.Player;
import exercisesForExam.goldDigger.football.entities.player.Women;
import exercisesForExam.goldDigger.football.entities.supplement.Liquid;
import exercisesForExam.goldDigger.football.entities.supplement.Powdered;
import exercisesForExam.goldDigger.football.entities.supplement.Supplement;
import exercisesForExam.goldDigger.football.repositories.SupplementRepository;
import exercisesForExam.goldDigger.football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static exercisesForExam.goldDigger.football.common.ConstantMessages.*;
import static exercisesForExam.goldDigger.football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplementRepository;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplementRepository = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }


    @Override
    public String addField(String fieldType, String fieldName) {
        Field field = null;
        if (fieldType.equals("ArtificialTurf")) {
            field = new ArtificialTurf(fieldName);
        }else if (fieldType.equals("NaturalGrass")) {
            field = new NaturalGrass(fieldName);
        }else {
            throw new NullPointerException(INVALID_FIELD_TYPE);
        }
        fields.add(field);
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement currentSupplement = null;
        if (type.equals("Liquid")) {
            currentSupplement = new Liquid();
        }else if (type.equals("Powdered")) {
            currentSupplement = new Powdered();
        }else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        supplementRepository.add(currentSupplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Field field = getFieldByName(fieldName);
          Supplement  supplement = supplementRepository.findByType(supplementType);
        if (supplement == null) {
            String message = String.format(NO_SUPPLEMENT_FOUND, supplementType);
            throw new IllegalArgumentException(message);
        }
        field.addSupplement(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player = null;
        if (playerType.equals("Women")) {
            player = new Women(playerName, nationality, strength);
        } else if (playerType.equals("Men")) {
            player = new Men(playerName, nationality, strength);
        }else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        Field field = getFieldByName(fieldName);

        if (field.getClass().getSimpleName().equals("ArtificialTurf") && playerType.equals("Women")) {
            field.addPlayer(player);
        } else if ((field.getClass().getSimpleName().equals("NaturalGrass") && playerType.equals("Men"))) {
            field.addPlayer(player);
        } else {
            return FIELD_NOT_SUITABLE;
        }
        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = getFieldByName(fieldName);
        field.drag();
        return String.format(PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = getFieldByName(fieldName);
        int value = field.getPlayers().stream().mapToInt(Player::getStrength).sum();
        return String.format(STRENGTH_FIELD, fieldName, value);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        fields.forEach(field -> sb.append(field.getInfo()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
    private Field getFieldByName(String fieldName) {
        return fields.stream()
                .filter(f -> f.getName().equals(fieldName))
                .findFirst()
                .orElse(null);
    }
}
