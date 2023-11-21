package baseball.view;

import baseball.model.Rule;

public enum OutMessage {
    START_MESSAGE("숫자 야구 게임을 시작합니다."),
    SUCCESS_MESSAGE(Rule.MAX_LENGTH.value() + "개의 숫자를 모두 맞히셨습니다! 게임 종료");

    private final String message;

    OutMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
