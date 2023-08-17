package servlets;

import service.RepositoryService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/result")
public class ResultServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();
        currentSession.setAttribute("currentQuestion", RepositoryService.getInstance().getStartedString());
        String positiveAnswer = RepositoryService.getInstance().findPositiveAnswer(RepositoryService.getInstance().getStartedString());
        String negativeAnswer = RepositoryService.getInstance().findNegativeAnswer(RepositoryService.getInstance().getStartedString());
        currentSession.setAttribute("positiveAnswer", positiveAnswer);
        currentSession.setAttribute("negativeAnswer", negativeAnswer);
        currentSession.setAttribute("img",RepositoryService.getInstance().getImage(RepositoryService.getInstance().getCurrentQuestion()));
        getServletContext().getRequestDispatcher("/result.jsp").forward(req,resp);
    }
}
