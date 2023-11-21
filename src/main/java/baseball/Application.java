package baseball;


import baseball.controller.GameManager;

public class Application {
    public static void main(String[] args) {
        GameManager gm = new GameManager();

        gm.startGame();
    }
}
