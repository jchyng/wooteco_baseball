package baseball.model;

import baseball.constant.BallState;
import baseball.constant.ExceptionMessage;
import baseball.constant.Rule;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private List<Integer> numbers;
    private int strikeCount = 0;
    private int ballCount = 0;


    public void init() {
        this.numbers = null;
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(String number) {
        validateNumberWithPattern(number);
        validateUniqueNumber(number);

        this.numbers = stringToIntegerList(number);
    }

    public void addStrikeCount() {
        this.strikeCount++;
    }

    public void addBallCount() {
        this.ballCount++;
    }


    public String createHintMessage() {
        StringBuilder gameResult = new StringBuilder();

        if (isNothing()) {
            return BallState.낫싱.name();
        }

        if (isStrike()) {
            return strikeCount + BallState.스트라이크.name();
        }

        if (isBall()) {
            gameResult.append(ballCount + BallState.볼.name());
        }
        if (isStrikeWithBall()) {
            gameResult.append(" " + strikeCount + BallState.스트라이크.name());
        }

        return gameResult.toString();
    }

    public boolean isCompleted() {
        return strikeCount == Rule.MAX_LENGTH.value();
    }

    public boolean isNothing() {
        return ballCount + strikeCount == 0;
    }

    public boolean isStrike() {
        return isCompleted() || strikeCount > 0 && ballCount == 0;
    }

    public boolean isStrikeWithBall() {
        return strikeCount > 0 && ballCount > 0;
    }

    public boolean isBall() {
        return ballCount > 0;
    }

    private void validateNumberWithPattern(String stringNumber) {
        String pattern = "^["
                + Rule.START_NUMBER
                + "-"
                + Rule.END_NUMBER
                + "]{" + Rule.MAX_LENGTH.value() + "}$";

        if (!stringNumber.matches(pattern)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_FORMAT.message());
        }
    }

    private void validateUniqueNumber(String stringNumber) {
        int[] digitCounts = new int[10];

        for (char c : stringNumber.toCharArray()) {
            int digit = Character.getNumericValue(c);
            digitCounts[digit]++;
            if (digitCounts[digit] > 1) {
                throw new IllegalArgumentException(ExceptionMessage.NUMBER_DUPLICATE.message());
            }
        }
    }

    private List<Integer> stringToIntegerList(String stringNumber) {
        List<Integer> numberList = stringNumber.chars()
                .map(Character::getNumericValue).boxed()
                .collect(Collectors.toList());

        return numberList;
    }
}

