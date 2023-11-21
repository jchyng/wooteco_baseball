package baseball.controller;

import baseball.exception.ExceptionMessage;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Rule;
import baseball.view.InputView;
import baseball.view.OutputView;


public class GameManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    public void startGame() {
        outputView.printStartMessage();
        Computer computer = new Computer();

        play(computer);

        outputView.printSuccessMessage();
        endOrRestart();
    }

    private void play(Computer computer) {
        String numbers = inputView.enterPlayerNumber();
        Player player = new Player(numbers);

        player.compareNumber(computer.getNumbers());
        outputView.printHintMessage(player.createHintMessage());

        if (!player.isCompleted()) {
            play(computer);
        }
    }

    private void endOrRestart() {
        String isRestart = inputView.enterRestartGame();
        validate(isRestart);
        if (isRestart.equals(Rule.RESTART_NUMBER.value())) {
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
}
