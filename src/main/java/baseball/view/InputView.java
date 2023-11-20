package baseball.view;

import baseball.constant.ExceptionMessage;
import baseball.constant.InputMessage;
import baseball.constant.Rule;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String enterPlayerNumber() {
        System.out.print(InputMessage.INPUT_NUMBER);
        return Console.readLine();
    }

    public String enterRestartGame() {
        System.out.print(InputMessage.ASK_RESTART_GAME);
        String inputValue = Console.readLine();

        validateRestartNumber(inputValue);

        return inputValue;
    }

    private void validateRestartNumber(String stringNumber) {
        if (!stringNumber.equals(Rule.RESTART_NUMBER) && !stringNumber.equals(Rule.EXIT_NUMBER)) {
            throw new IllegalArgumentException(ExceptionMessage.RESTART_NUMBER_NOT_FOUND.message());
        }
    }
}