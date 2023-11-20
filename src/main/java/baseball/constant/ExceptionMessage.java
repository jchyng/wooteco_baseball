package baseball.constant;

public enum ExceptionMessage {
    RESTART_NUMBER_NOT_FOUND("재시작을 원하신다면 1, 종료를 원하신다면 2를 입력하세요.");
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
