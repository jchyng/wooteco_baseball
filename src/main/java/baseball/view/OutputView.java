package baseball.view;

public class OutputView {

    public void printStartMessage() {
        System.out.println(OutMessage.START_MESSAGE);
    }

    public void printSuccessMessage() {
        System.out.println(OutMessage.SUCCESS_MESSAGE);
    }

    public void printHintMessage(String resultMessage) {
        System.out.println(resultMessage);
    }
}
