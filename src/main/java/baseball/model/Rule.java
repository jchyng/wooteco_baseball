package baseball.model;

public enum Rule {
    START_NUMBER(1),
    END_NUMBER(9),
    MAX_LENGTH(3),

    RESTART_NUMBER(1),
    EXIT_NUMBER(2),
    ;

    private final int value;

    Rule(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
