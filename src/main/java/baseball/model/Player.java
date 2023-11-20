package baseball.model;

import baseball.exception.ExceptionMessage;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private List<Integer> numbers;
    private int strikeCount = 0;
    private int ballCount = 0;

    public Player(String numbers) {
        validatePattern(numbers);
        validateDuplicate(numbers);

        this.numbers = stringToIntegerList(numbers);
    }

    public void compareNumber(List<Integer> numbers) {
        for (int i = 0; i < Rule.MAX_LENGTH.value(); i++) {
            if (this.numbers.get(i) == numbers.get(i)) {
                strikeCount++;
            } else if (numbers.contains(this.numbers.get(i))) {
                ballCount++;
            }
        }
    }

    public String createHintMessage() {
        StringBuilder gameResult = new StringBuilder();

        if (ballCount + strikeCount == 0) {
            return BallState.낫싱.name();
        }

        if (isCompleted() || strikeCount > 0 && ballCount == 0) {
            return strikeCount + BallState.스트라이크.name();
        }

        if (ballCount > 0) {
            gameResult.append(ballCount + BallState.볼.name());
        }
        if (strikeCount > 0 && ballCount > 0) {
            gameResult.append(" " + strikeCount + BallState.스트라이크.name());
        }

        return gameResult.toString();
    }

    public boolean isCompleted() {
        return strikeCount == Rule.MAX_LENGTH.value();
    }

    private void validatePattern(String number) {
        String pattern = "^[" + Rule.START_NUMBER.value() + "-" + Rule.END_NUMBER.value() + "]"
                + "{" + Rule.MAX_LENGTH.value() + "}$";

        if (!number.matches(pattern)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_FORMAT.message());
        }
    }

    private void validateDuplicate(String number) {
        int[] digitCounts = new int[10];

        for (char c : number.toCharArray()) {
            int digit = Character.getNumericValue(c);
            digitCounts[digit]++;
            if (digitCounts[digit] > 1) {
                throw new IllegalArgumentException(ExceptionMessage.NUMBER_DUPLICATE.message());
            }
        }
    }

    private List<Integer> stringToIntegerList(String number) {
        List<Integer> numbers = number.chars()
                .map(Character::getNumericValue).boxed()
                .collect(Collectors.toList());

        return numbers;
    }

}

