import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import repository.Data;
import repository.Question;
import service.RepositoryService;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RepositoryServiceTest {


    @ParameterizedTest
    @ValueSource(strings = {"Ты поднялся на мостик. Ты кто?"})
    void setCurrentQuestion(String input) {
        RepositoryService.getInstance().setCurrentQuestion(input);
        assertEquals(input,Data.getCurrentQuestion());
    }

    @Test
    void getStartedString() {
        String actual = RepositoryService.getInstance().getStartedString();
        String expected = "Ты потерял память. Принять вызов НЛО?";
        assertEquals(expected, actual);
    }

    @Test
    void getCurrentQuestion() {
        String question = "question";
        Data.setCurrentQuestion(question);
        String actual = RepositoryService.getInstance().getCurrentQuestion();
        assertEquals(question, actual);
    }

    @ParameterizedTest
    @MethodSource("dataFactory")
    void findQuestionName(String input) {
        Data.questAnswers.put("Принять вызов", "Ты принял вызов. Поднимешься на мостик к капитану?");
        String actual = RepositoryService.getInstance().findQuestionName(input);
        if (input.endsWith("Победа")) {
            String expected = "win";
            assertEquals(expected, "win");
        }
        else if (input.endsWith("Поражение")) {
            String expected = "lose";
            assertEquals(expected, actual);
        } else {
            String expected = "Ты принял вызов. Поднимешься на мостик к капитану?";
            assertEquals(expected, actual);
        }
    }
    static Stream<String> dataFactory() {
        return Stream.of("уаошум Победа", "усусцц Поражение", "Принять вызов");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ты потерял память  Принять вызов НЛО?"})
    void getImage(String strings) {
        Data.questionList.add(new Question("Ты потерял память  Принять вызов НЛО?","Принять вызов",
                "Отклонить вызов","img/call.jpg"));
        String expected = "img/call.jpg";
        String actual = RepositoryService.getInstance().getImage(strings);
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ты принял вызов. Поднимешься на мостик к капитану?"})
    void findPositiveAnswer(String input) {
        Data.questionList.add(new Question("Ты принял вызов. Поднимешься на мостик к капитану?","Подняться на мостик",
                "Отказаться подниматься на мостик","img/call_accept.jpg"));
        String expected = "Подняться на мостик";
        String actual = RepositoryService.getInstance().findPositiveAnswer(input);
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ты принял вызов. Поднимешься на мостик к капитану?"})
    void findNegativeAnswer(String input) {
        Data.questionList.add(new Question("Ты принял вызов. Поднимешься на мостик к капитану?","Подняться на мостик",
                "Отказаться подниматься на мостик","img/call_accept.jpg"));
        String expected = "Отказаться подниматься на мостик";
        String actual = RepositoryService.getInstance().findNegativeAnswer(input);
        assertEquals(expected,actual);
    }
}