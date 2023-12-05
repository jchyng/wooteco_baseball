package baseball.model;

import baseball.exception.ExceptionMessage;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_DUPLICATE.message());
        }
        if (isNumberOutOfRange(numbers)){
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE.message());
        }
        if (isOutOfLength(numbers)){
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_LENGTH.message());
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.size() != numbers.stream()
                .distinct()
                .collect(Collectors.toList())
                .size();
    }

    private boolean isNumberOutOfRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number < Rule.START_NUMBER.value() || number > Rule.END_NUMBER.value()){
                return true;
            }
        }
        return false;
    }

    private boolean isOutOfLength(List<Integer> numbers){
        return numbers.size() != Rule.MAX_LENGTH.value();
    }
}
