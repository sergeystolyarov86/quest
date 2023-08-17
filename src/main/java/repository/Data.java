package repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {

    private final static String startQuestion = "Ты потерял память. Принять вызов НЛО?";
    private static String currentQuestion;

     public static String getCurrentQuestion() {
        return currentQuestion;
    }

    public static void setCurrentQuestion(String currentQuestion) {
        Data.currentQuestion = currentQuestion;
    }

    public static String getStartQuestion() {
        return startQuestion;
    }

    public static Map<String, String> questAnswers = new HashMap<>();

    public static List<Question> questionList = new ArrayList<>();


}
