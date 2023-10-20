package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    public String getUserInput(){
        return readLine();
    }

    public List<Integer> getNumbers() {
        String userInput = getUserInput();
        List<Integer> numbers = new ArrayList<>();
        for(char c : userInput.toCharArray())
            numbers.add(Character.getNumericValue(c));
        return numbers;
    }

    public Integer getRestartChoice(){
        return Integer.parseInt(getUserInput());
    }
}