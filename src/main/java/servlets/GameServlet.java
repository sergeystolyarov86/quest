package servlets;


import service.RepositoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();
        String playerName = req.getParameter("playerName");

        if (playerName != null) {
            currentSession.setAttribute("playerName", playerName);
            if(playerName.isBlank()){
                currentSession.setAttribute("playerName", "default");
            }
        }
        getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession currentSession = req.getSession();
        req.setCharacterEncoding("UTF-8");
        String inputAnswer = req.getParameter("answer");

        if (inputAnswer == null) { getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp); }


        assert inputAnswer != null;
        String currentQuestion = RepositoryService.getInstance().findQuestionName(inputAnswer);
            if (currentQuestion.endsWith("Победа") || currentQuestion.endsWith("Поражение")) {
                currentSession.setAttribute("result", currentQuestion);
                String resultImage = currentQuestion.endsWith("Победа") ? "img/win.jpg" : "img/lose.jpg";
                currentSession.setAttribute("resultImg", resultImage);
                int count = (int) currentSession.getAttribute("countGames");
                count++;
                currentSession.setAttribute("countGames", count);
                getServletContext().getRequestDispatcher("/result").forward(req, resp);

            } else {

                String positiveAnswer = RepositoryService.getInstance().findPositiveAnswer(currentQuestion);
                String negativeAnswer = RepositoryService.getInstance().findNegativeAnswer(currentQuestion);

                currentSession.setAttribute("img", RepositoryService.getInstance().getImage(currentQuestion));
                currentSession.setAttribute("currentQuestion", currentQuestion);
                currentSession.setAttribute("positiveAnswer", positiveAnswer);
                currentSession.setAttribute("negativeAnswer", negativeAnswer);
                getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
            }
        }
}

