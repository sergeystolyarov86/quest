package service;



public interface RepoDao {

    void setCurrentQuestion(String input);

    String getStartedString();

    String getCurrentQuestion();

    String findQuestionName(String question);

    String getImage(String question);

    String findPositiveAnswer(String questionName);

    String findNegativeAnswer(String questionName);
}

