
package servlets;

import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.UserFacade;
import util.EncryptPass;


@WebServlet(name = "LoginController", urlPatterns = {
        "/showLogin" 
        , "/login"
        ,"/logout"
        
    })
public class LoginController extends HttpServlet {
@EJB private UserFacade userFacade;
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        HttpSession session = null;
        switch (path){
            case "/showLogin":
                request.getRequestDispatcher("/showLogin.jsp").forward(request, response);
                break;
            case "/login":
                String login = request.getParameter("login");
                login=login.trim(); // убираем пробелы
                
                String password = request.getParameter("password");
                password=password.trim(); // убираем пробелы
                
                
                if(null == login || "".equals(login) || null == password || "".equals(password)){
                    request.setAttribute("info", "Input fields");
                    request.getRequestDispatcher("/showLogin.jsp").forward(request, response);
                    break;
                }
                User user = userFacade.findByLogin(login);
                
                if(user == null){
                    request.setAttribute("info", "Uncorrect data");
                    request.getRequestDispatcher("/showLogin.jsp").forward(request, response);
                    break;
                }
                EncryptPass ep= new EncryptPass();
                password = ep.setEncryptPass(password, user.getSalts());
                
                if(!password.equals(user.getPassword())){
                    request.setAttribute("info", "Uncorrect data");
                    request.getRequestDispatcher("/showLogin.jsp").forward(request, response);
                    break;
                }
                session = request.getSession(true);
                session.setAttribute("user", user);
                request.setAttribute("info", "Hello, " + user.getLogin());
                request.setAttribute("user", user);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                
                break;  
            case "/logout":
                session = request.getSession(false);
                if (session!=null){
                    session.invalidate();
                    request.setAttribute("info", "You are logged out");
                }
                request.getRequestDispatcher("/index.jsp").forward(request, response);
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
