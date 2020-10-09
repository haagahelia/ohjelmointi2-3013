package servlet;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("")
public class IndexServletti extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String aikaString = LocalTime.now().toString();

        // lähetetään aika merkkijono JSP-sivulle attribuuttina
        req.setAttribute("aikaNyt", aikaString);

        // lähetä request edelleen index.jsp sivulle
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}
