package servlet;

import java.io.IOException;
import java.time.LocalTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String timeString = LocalTime.now().toString();

        // pass the time string to the JSP page as an attribute
        req.setAttribute("timeNow", timeString);

        // forward the request to the index.jsp page
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}
