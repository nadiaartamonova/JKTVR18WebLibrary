/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Book;
import entity.Reader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Melnikov
 */
@WebServlet(name = "MyServlet", urlPatterns = {"/newBook","/addBook","/page2", "/page3", "/newReader", "/addReader"})
public class MyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
  
        if(null != path)switch (path) {
            case "/newBook":
                request.getRequestDispatcher("/WEB-INF/newBook.jsp")
                        .forward(request, response);
                break;
            case "/addBook":
                String title=request.getParameter("title");
                String author=request.getParameter("author");
                String year=request.getParameter("year");
                String quantity=request.getParameter("quantity");
                try 
                {
                    Book book = new Book(title, author, Integer.parseInt(year),Integer.parseInt(quantity));
                    request.setAttribute("info", book);
                    
                    
                }catch(NumberFormatException e){
                    
                    request.setAttribute("info", "не корректные данные");
                }
                request.getRequestDispatcher("/WEB-INF/newBook.jsp")
                        .forward(request, response);
                break;
            case "/newReader":
                request.getRequestDispatcher("/WEB-INF/newReader.jsp")
                        .forward(request, response);
                break;
            case "/addReader":
                String name=request.getParameter("name");
                String lastname=request.getParameter("lastname");
                String day=request.getParameter("day");
                String month=request.getParameter("month");
                year=request.getParameter("year");
                try
                {
                    Reader reader = new Reader(name, lastname, Integer.parseInt(day),Integer.parseInt(month),Integer.parseInt(year));
                    request.setAttribute("info", reader);
                  
                }  
                catch(NumberFormatException e){
                    request.setAttribute("info", "не корректные данные");
                }
                request.getRequestDispatcher("/WEB-INF/newReader.jsp")
                        .forward(request, response);
                break;
            case "/page2":
                request.getRequestDispatcher("/WEB-INF/page2.jsp")
                        .forward(request, response);
                break;
            case "/page3":
                String param = request.getParameter("param");
                String param2 = request.getParameter("param2");
               // String str = "This data send from servlet";
                request.setAttribute("info",param);
                request.setAttribute("param2",param2);
                
                request.getRequestDispatcher("/page3.jsp")
                        .forward(request, response);
                break;
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
