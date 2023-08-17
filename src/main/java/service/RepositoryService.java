package service;

import repository.Data;

public class RepositoryService implements RepoDao {

    private static RepoDao INSTANCE;

    private RepositoryService() {
    }

    public static RepositoryService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RepositoryService();
        }
        return (RepositoryService) INSTANCE;
    }

    @Override
    public void setCurrentQuestion(String input) {
        Data.setCurrentQuestion(input);
    }

    @Override
    public String getStartedString() {
        return Data.getStartQuestion();
    }

    @Override
    public String getCurrentQuestion() {
        return Data.getCurrentQuestion();
    }

    @Override
    public String findQuestionName(String input) {
        if (input.endsWith("Победа")) return "win";
        if (input.endsWith("Поражение")) return "lose";
        return Data.questAnswers.get(input);
    }

    @Override
    public String getImage(String questionName) {
        return Data.questionList.stream().filter(q -> q.getName().equals(questionName)).toList().get(0).getUrlImg();
    }

    @Override
    public String findPositiveAnswer(String questionName) {
        return Data.questionList.stream().filter(q -> q.getName().equals(questionName)).toList().get(0).getPositiveAnswer();
    }

    @Override
    public String findNegativeAnswer(String questionName) {
        return Data.questionList.stream().filter(q -> q.getName().equals(questionName)).toList().get(0).getNegativeAnswer();
    }

}
