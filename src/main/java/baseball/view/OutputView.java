package baseball.view;

public class OutputView {

    public void printStartMessage() {
        System.out.println(OutMessage.START_MESSAGE.message());
    }

    public void printSuccessMessage() {
        System.out.println(OutMessage.SUCCESS_MESSAGE.message());
    }

    public void printHintMessage(String hint) {
        System.out.println(hint);
    }
}
