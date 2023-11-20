package baseball.model;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void generateNumbers() {
        numbers = new ArrayList<>();

        while (numbers.size() < Rule.MAX_LENGTH.value()) {
            int randomNumber = Randoms.pickNumberInRange(Rule.START_NUMBER.value(), Rule.END_NUMBER.value());

            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}
