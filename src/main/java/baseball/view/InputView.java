package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static String ASK_RESTART_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ";

    public String enterPlayerNumber() {
        System.out.print(INPUT_NUMBER);
        return Console.readLine();
    }

    public String enterRestartGame() {
        System.out.print(ASK_RESTART_GAME);
        return Console.readLine();
    }
}