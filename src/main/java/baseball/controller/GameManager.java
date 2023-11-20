package baseball.controller;

import baseball.model.Rule;
import baseball.service.NumberBaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;


public class GameManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final NumberBaseballService numberBaseballService;

    public GameManager(NumberBaseballService numberBaseballService) {
        this.numberBaseballService = numberBaseballService;
    }

    public void startGame() {
        outputView.printStartMessage();

        numberBaseballService.generateComputerNumbers();

        boolean isCompleted = false;

        while (!isCompleted) {
            String playerNumber = inputView.enterPlayerNumber();

            numberBaseballService.setPlayerNumbers(playerNumber);

            numberBaseballService.comparePlayerWithComputer();

            outputView.printHintMessage(numberBaseballService.getHintMessage());

            isCompleted = numberBaseballService.isCompleted();
        }

        outputView.printSuccessMessage();

        endOrRestart();
    }

    private void endOrRestart() {
        String isRestart = inputView.enterRestartGame();

        if (isRestart.equals(Rule.RESTART_NUMBER)) {
            startGame();
        }
    }
}
