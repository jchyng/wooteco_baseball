package baseball.model;

import java.util.List;

public class Player extends Numbers {
    private int strikeCount = 0;
    private int ballCount = 0;

    public Player(List<Integer> numbers) {
        super(numbers);
    }

    public String play(List<Integer> numbers) {
        compareNumber(numbers);
        return createHintMessage();
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    private void compareNumber(List<Integer> numbers) {
        for (int i = 0; i < Rule.MAX_LENGTH.value(); i++) {
            if (super.getNumbers().get(i) == numbers.get(i)) {
                strikeCount++;
            } else if (numbers.contains(super.getNumbers().get(i))) {
                ballCount++;
            }
        }
    }

    private String createHintMessage() {
        if (ballCount + strikeCount == 0) {
            return BallState.낫싱.name();
        }
        if (strikeCount > 0 && ballCount == 0) {
            return strikeCount + BallState.스트라이크.name();
        }
        return getBallWithStrike();
    }

    private String getBallWithStrike() {
        StringBuilder gameResult = new StringBuilder();

        if (ballCount > 0) {
            gameResult.append(ballCount + BallState.볼.name());
        }
        if (strikeCount > 0 && ballCount > 0) {
            gameResult.append(" " + strikeCount + BallState.스트라이크.name());
        }
        return gameResult.toString();
    }

}

