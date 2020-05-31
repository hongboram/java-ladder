package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.PlayerNameEmptyException;
import nextstep.ladder.domain.exceptions.PlayerNameLengthException;

import java.util.Objects;

public class PlayerName {
    private static final int MAX_NAME_VALUE_LENGTH = 5;
    private String name;

    public PlayerName(String name) {
        validate(name);
        this.name = name;
    }

    public int length() {
        return this.name.length();
    }

    public String getName() {
        return this.name;
    }

    private void validate(String nameValue) {
        validateNull(nameValue);
        validateNameLength(nameValue);
        validateEmptyName(nameValue);
    }

    private void validateNull(String nameValue) {
        if (nameValue == null) {
            throw new PlayerNameEmptyException("Player's name must not be null");
        }
    }

    private void validateNameLength(String nameValue) {
        if (nameValue.length() > MAX_NAME_VALUE_LENGTH) {
            throw new PlayerNameLengthException("Player's name length muse be smaller than 5");
        }
    }

    private void validateEmptyName(String nameValue) {
        if (nameValue.trim().isEmpty()) {
            throw new PlayerNameEmptyException("Player's name must not be empty");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName that = (PlayerName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "PlayerName{" +
                "nameValue='" + name + '\'' +
                '}';
    }
}