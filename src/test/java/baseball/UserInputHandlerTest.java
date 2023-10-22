package baseball;

import baseball.handler.UserInputHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserInputHandlerTest {

    @Test
    @DisplayName("서로 다른 3자리의 수 입력 테스트")
    public void testGetNumbers() {
        UserInputHandler userInputHandler =mock(UserInputHandler.class);
        String userInput = "123";
        when(userInputHandler.readInput()).thenReturn(userInput); //getUserNumber()을 호출할 때마다 123을 반환 하도록 설정
        when(userInputHandler.convertInputToNumbers(userInput)).thenCallRealMethod(); //mock 객체에서 실제 구현된 processUserNumber() 호출
        List<Integer> result = userInputHandler.convertInputToNumbers(userInput); // 안에서 getUserNumber 호출 뒤 가공해서 반환
        assertEquals(List.of(1,2,3), result);
    }

    @Test
    @DisplayName("종료, 재시작 숫자 입력 테스트")
    public void testGetRestartChoice(){
        UserInputHandler userInputHandler = mock(UserInputHandler.class);
        String userInput ="1";
        when(userInputHandler.readInput()).thenReturn(userInput);
        when(userInputHandler.parseRestartChoice(userInput)).thenCallRealMethod();
        Integer choice = userInputHandler.parseRestartChoice(userInput);
        assertEquals(1,choice);
    }
}