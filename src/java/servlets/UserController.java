/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Book;
import entity.History;
import entity.Reader;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.BookFacade;
import session.HistoryFacade;
import session.ReaderFacade;
import session.UserFacade;
import util.EncryptPass;

/**
 *
 * @author pupil
 */
@WebServlet(name = "UserController", urlPatterns = {
        "/takeOn"
        , "/createHistory"
        , "/buyBook"
        
})


public class UserController extends HttpServlet {
    @EJB private UserFacade userFacade;
    @EJB private ReaderFacade readerFacade;
    @EJB private BookFacade bookFacade;
    @EJB private HistoryFacade historyFacade;
    
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        
        if(null == session) { //если сеесия не создана, то ошибка
            request.setAttribute("info", "you have not permission");
            request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
            return;
        }
        User user = (User)session.getAttribute("user");
        
        if(null == user) { // если узера нет, то выведет ошибку
            request.setAttribute("info", "you have not permission");
            request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
            return;
        }
        
    String path = request.getServletPath();
            
    if(null != path)switch (path) {
        case "/takeOn":
                List<Book> listBooks = bookFacade.findEnableBooks();
                List<Reader> listReaders = readerFacade.findAll();
                request.setAttribute("listBooks", listBooks);
                request.setAttribute("listReaders", listReaders);
                request.getRequestDispatcher("/WEB-INF/takeOn.jsp")
                        .forward(request, response);
                break;
            
            case "/createHistory":
                String bookId=request.getParameter("bookId");
                String readerId=request.getParameter("readerId");
               
                try
                {
                    Book book = bookFacade.find(Long.parseLong(bookId));
                    
                    if(book.getQuantity()>0){
                        Reader reader = readerFacade.find(Long.parseLong(readerId));
                        book.setQuantity(book.getQuantity()-1);
                        bookFacade.edit(book);
                        
                        History history=new History();
                        history.setBook(book);
                        
                        history.setReader(reader);
                        history.setTakeOnDate(new Date());
                        historyFacade.create(history);
                        request.setAttribute("info", "Book is took");
                    }else{
                        request.setAttribute("info", "No any book of this title");
                    }
                    
                }  
                catch(NumberFormatException e){
                    request.setAttribute("info", "не корректные данные");
                }
                request.getRequestDispatcher("/takeOn")
                        .forward(request, response);
                break;
                
            case "/buyBook":
                
                
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
