package baseball.exception;

public enum ExceptionMessage {
    RESTART_NUMBER_NOT_FOUND("재시작을 원하신다면 1, 종료를 원하신다면 2를 입력하세요."),
    OUT_OF_RANGE("1~9 사이의 숫자만 입력해주세요."),
    NUMBER_DUPLICATE("각 숫자는 한 번만 나와야 합니다."),
    OUT_OF_LENGTH("3개의 숫자를 입력해주세요.");


    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

}
