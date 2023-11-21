package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String enterPlayerNumber() {
        System.out.print(InputMessage.INPUT_NUMBER.message());
        return Console.readLine();
    }

    public String enterRestartGame() {
        System.out.print(InputMessage.ASK_RESTART_GAME.message());
        return Console.readLine();
    }
}