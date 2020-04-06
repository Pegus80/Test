package lv.mysoftwares;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/startpage")

public class TestServlet extends HttpServlet {


//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String nameFromHTML = req.getParameter("nameHTML");
//
//        PrintWriter out=resp.getWriter();
//
//        resp.setContentType("text/html");
//
//        out.println("<h3> "+nameFromHTML+" </h3>");
//        out.close();
//
//
//    }


    @Override
    public void init() throws ServletException {
        System.out.println("Initializiruju ");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String firstNameFromHTTP = req.getParameter("firstName");
        HttpSession httpSession=req.getSession();
        ServletContext servletContext =req.getServletContext();


        if (httpSession.getAttribute("firstNameFromSession") == null) {
            httpSession.setAttribute("firstNameFromSession", firstNameFromHTTP);
        } else {

        }

        if (servletContext.getAttribute("firstNameFromContextServlet") == null) {
            servletContext.setAttribute("firstNameFromContextServlet", firstNameFromHTTP);
        } else {

        }


        PrintWriter out = resp.getWriter();
        out.println("FromSession:" + httpSession.getAttribute("firstNameFromSession"));
        out.println("FromServletContext:" + servletContext.getAttribute("firstNameFromContextServlet"));
        out.println("FromRequest:" + firstNameFromHTTP);

        out.close();

    }
}
