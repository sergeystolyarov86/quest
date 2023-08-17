package servlets;

import repository.Data;
import repository.Question;
import service.RepositoryService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/start")
public class StartServlet extends HttpServlet {


    @Override
    public void init() {
        /**
         вместо этой портянки внизу здесь должен был быть метод, который тянет данный через сервис из файла, возникла
         проблема в кодировке при чтении из файла.
         */
        Data.questAnswers.put("Принять вызов","Ты принял вызов. Поднимешься на мостик к капитану?");
        Data.questAnswers.put("Подняться на мостик","Ты поднялся на мостик. Ты кто?");
        Data.questAnswers.put("Рассказать правду о себе","Тебя вернули домой. Победа");
        Data.questAnswers.put("Отклонить вызов","Ты отклонил вызов. Поражение");
        Data.questAnswers.put("Отказаться подниматься на мостик","Ты не пошел на переговоры. Поражение");
        Data.questAnswers.put("Солгать о себе","Твою ложь разоблачили. Поражение");

        Data.questionList.add(new Question("Ты потерял память. Принять вызов НЛО?","Принять вызов",
                "Отклонить вызов","img/call.jpg"));
        Data.questionList.add(new Question("Ты принял вызов. Поднимешься на мостик к капитану?","Подняться на мостик",
                "Отказаться подниматься на мостик","img/call_accept.jpg"));
        Data.questionList.add(new Question("Ты поднялся на мостик. Ты кто?","Рассказать правду о себе",
                "Солгать о себе","img/bridge.jpg"));


        RepositoryService.getInstance().setCurrentQuestion(RepositoryService.getInstance().getStartedString());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("ip",req.getRemoteAddr());
        session.setAttribute("countGames",0);
        session.setAttribute("img",RepositoryService.getInstance().getImage(RepositoryService.getInstance().getCurrentQuestion()));
        session.setAttribute("currentQuestion",RepositoryService.getInstance().getCurrentQuestion());
        String positiveAnswer = RepositoryService.getInstance().findPositiveAnswer(RepositoryService.getInstance().getCurrentQuestion());
        session.setAttribute("positiveAnswer",positiveAnswer);
        String negativeAnswer = RepositoryService.getInstance().findNegativeAnswer(RepositoryService.getInstance().getCurrentQuestion());
        session.setAttribute("negativeAnswer",negativeAnswer);
        getServletContext().getRequestDispatcher("/start.jsp").forward(req,resp);
    }
}
