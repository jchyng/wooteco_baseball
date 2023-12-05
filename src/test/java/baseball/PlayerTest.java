package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.exception.ExceptionMessage;
import baseball.model.Numbers;
import baseball.model.Player;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PlayerTest {
    private static Stream<Arguments> outOfRangeNumbers(){
        List<Arguments> listOfArguments = new LinkedList<>();
        listOfArguments.add(Arguments.of(List.of(0,1,2)));
        listOfArguments.add(Arguments.of(List.of(1,2,10)));
        return listOfArguments.stream();
    }

    private static Stream<Object[]> ballStatesAndHintMessages(){
        return Stream.of(
                new Object[] {List.of(1,2,3), List.of(4,1,2), "2볼"},
                new Object[] {List.of(1,2,3), List.of(1,2,4), "2스트라이크"},
                new Object[] {List.of(1,2,3), List.of(1,3,4), "1볼 1스트라이크"},
                new Object[] {List.of(1,2,3), List.of(4,5,6), "낫싱"}
        );
    }

    @DisplayName("숫자 리스트의 값이 중복이라면 예외가 발생한다.")
    @Test
    void createRandomNumbersByDuplicate() {
        assertThatThrownBy(() -> new Numbers(List.of(1,2,2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NUMBER_DUPLICATE.message());
    }

    @DisplayName("숫자 리스트의 값이 1~9 범위를 벗어나면 예외가 발생한다.")
    @MethodSource("outOfRangeNumbers")
    @ParameterizedTest
    void createRandomNumbersByOutOfRange(List<Integer> numbers) {
        assertThatThrownBy(() -> new Numbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.OUT_OF_RANGE.message());
    }

    @DisplayName("숫자 리스트의 값의 길이가 3이 아니라면 예외가 발생한다")
    @Test
    void createRandomNumberByOutOfLength() {
        assertThatThrownBy(() -> new Numbers(List.of(1,2,3,4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.OUT_OF_LENGTH.message());
    }

    @DisplayName("플레이어와 컴퓨터의 숫자 비교 후 볼 상태에 맞는 힌트 메세지를 반환한다.")
    @MethodSource("ballStatesAndHintMessages")
    @ParameterizedTest
    void getHintMessageBy(List<Integer> computerNumbers, List<Integer> playerNumbers, String hintMessage) {
        //Given
        Numbers numbers = new Numbers(computerNumbers);
        Player player = new Player(playerNumbers);
        //When & Then
        assertThat(player.play(numbers.getNumbers()))
                .isEqualTo(hintMessage);
    }

}
