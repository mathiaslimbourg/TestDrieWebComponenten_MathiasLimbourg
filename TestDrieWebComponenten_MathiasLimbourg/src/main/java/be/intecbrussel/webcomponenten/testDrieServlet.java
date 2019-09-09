package be.intecbrussel.webcomponenten;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class testDrieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().isNew()){
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);

            HttpSession session = req.getSession(false);
            if (session!=null){
                String name = (String) session.getAttribute(String.valueOf(false));
                out.println("Welcome " + name);
            } else {
                req.getRequestDispatcher("/WEB-INF/login.jsp").include(req,resp);
            }
            out.close();
        } else {

            req.getRequestDispatcher("/WEB-INF/welcome.jsp").forward(req,resp);
            HttpSession session = req.getSession(false);
            String name = (String) session.getAttribute(String.valueOf(false));
            session.setAttribute("name",name);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        if (name.equals("")){
            HttpSession session = req.getSession();
            String message = " - Gelieve een geldige naam in te voeren -";
            session.setAttribute("message",message);
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);

        } else {
            out.println("Welcome " + name);
            req.getRequestDispatcher("/WEB-INF/welcome.jsp").include(req,resp);
            HttpSession session = req.getSession();
            session.setAttribute("name",name);

            out.close();
        }

    }
}
