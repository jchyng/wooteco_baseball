package baseball.controller;

import baseball.exception.ExceptionMessage;
import baseball.model.Numbers;
import baseball.model.Player;
import baseball.model.Rule;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GameManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    public void startGame() {
        outputView.printStartMessage();
        Numbers numbers = new Numbers(generateNumbers());

        play(numbers);

        outputView.printSuccessMessage();
        endOrRestart();
    }

    private void play(Numbers numbers) {
        while (true) {
            String inputNumbers = inputView.enterPlayerNumber();
            Player player = new Player(stringToIntegerList(inputNumbers));

            outputView.printHintMessage(player.play(numbers.getNumbers()));

            if (player.getStrikeCount() == Rule.MAX_LENGTH.value()) {
                break;
            }
        }
    }

    private void endOrRestart() {
        String isRestart = inputView.enterRestartGame();
        validate(isRestart);

        if (Integer.parseInt(isRestart) == Rule.RESTART_NUMBER.value()) {
            startGame();
        }
    }

    private void validate(String number) {
        try {
            int num = Integer.parseInt(number);

            if (num != Rule.RESTART_NUMBER.value() && num != Rule.EXIT_NUMBER.value()) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.RESTART_NUMBER_NOT_FOUND.message());
        }
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < Rule.MAX_LENGTH.value()) {
            int randomNumber = Randoms.pickNumberInRange(Rule.START_NUMBER.value(), Rule.END_NUMBER.value());

            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private List<Integer> stringToIntegerList(String number) {
        List<Integer> numbers = number.chars()
                .map(Character::getNumericValue).boxed()
                .collect(Collectors.toList());
        return numbers;
    }
}
