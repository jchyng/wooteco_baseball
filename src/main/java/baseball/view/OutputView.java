package baseball.view;

import baseball.model.Rule;

public class OutputView {

    private static String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static String SUCCESS_MESSAGE = Rule.MAX_LENGTH.value() + "개의 숫자를 모두 맞히셨습니다! 게임 종료";


    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printSuccessMessage() {
        System.out.println(SUCCESS_MESSAGE);
    }

    public void printHintMessage(String hint) {
        System.out.println(hint);
    }
}
