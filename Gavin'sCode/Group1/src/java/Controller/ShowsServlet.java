/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.shows;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gavok
 */
public class ShowsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NumberFormatException, ParseException {
        //hrows ServletException, IOException {
        //coding here 
        String action = request.getParameter("action");
        System.out.println("action = " + action);
        HttpSession session = request.getSession();

        String nextPage = "";
        switch (action) {
            case "RequestAddShows":
                nextPage = "/AddShows.html";
                break;

            case "home":
                nextPage = "/Home.jsp";
                break;
            case "saveShow":
                nextPage = processSaveShow(request, session);
                break;
            case "RequestAllShow":
                nextPage = processRequestAllShow(session);
                break;
            case "processAddShow":
                nextPage = processAddShow(request, session);
                break;
             case "UpdateShows":
                nextPage = processGetshowsDetailsByshowsID(request, session);
                break;
                     case "deleteshows":
                nextPage = processDeleteshows(request, session);
                break;
            default:

        }

        gotoPage(nextPage, request, response);
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
        try {
            processRequest(request, response);
        } catch (NumberFormatException ex) {
            Logger.getLogger(ShowsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ShowsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NumberFormatException ex) {
            Logger.getLogger(ShowsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ShowsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// 
    private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    private String processSaveShow(HttpServletRequest request, HttpSession session) throws ParseException {
        String nextPage;
        System.out.println("Save Shows");
        //get book details 
        //get new book details from request
        String category = request.getParameter("category");
        String department = request.getParameter("department");
      String startingDate = request.getParameter("startingDate");
        String closingDate = request.getParameter("closingDate");

        String description = request.getParameter("description");
        shows s = new shows(category, department, startingDate, closingDate, description);
        String message = null;

        request.setAttribute("message", message);
        //display the page again - need a new list to reflect deleted book
        return this.processRequestAllShow(session);
    }

    private String processRequestAllShow(HttpSession session) {
        String nextPage;
        System.out.println("in display all Shows");
        ArrayList<shows> allshowsList = new ArrayList<>();
        shows s1 = new shows();
        allshowsList = s1.findAllShows();
        session.setAttribute("Allshows", allshowsList);
        nextPage = "/DisplayAllShows.jsp";
        return nextPage;
    }

    private String processAddShow(HttpServletRequest request, HttpSession session) throws NumberFormatException, ParseException {
        //debud info
        System.out.println("In processAddBook");
        //get information from the user - isbn, author price title

        String category = request.getParameter("category");
        String department = request.getParameter("department");
        String dateString = request.getParameter("startingDate");
        String dateStrings = request.getParameter("closingDate");
        Date startingDate = new SimpleDateFormat("dd/mm/yyyy").parse(dateString);
        Date closingDate = new SimpleDateFormat("dd/mm/yyyy").parse(dateStrings);
        String description = request.getParameter("description");

        shows s = new shows(category, department, startingDate, closingDate, description);

        if (s.createshow()) {
            //send the user a message to say it was added-> view
            String message = "shows " + s.getCategory() + " was added to the system.";
            request.setAttribute("message", message);
            //display the page again - need a new list to reflect deleted book

            return this.processRequestAllShow(session);
        }
        return null;
    }

    private String processGetshowsDetailsByshowsID(HttpServletRequest request, HttpSession session) {
      String nextPage;
        System.out.println("Edit shows");
        
        shows showDetails = new shows();
        
        String showsIDString = (String) request.getParameter("showsID");
        System.out.println("Edit shows for showsID =" + showsIDString);
        int showsID = Integer.parseInt(showsIDString);
        showDetails = showDetails.findshowsByshowsID(showsID);
        showDetails.Print();
        session.setAttribute("shows", showDetails);
        nextPage = "/UpdateShows.jsp";
        return nextPage;
    }

    private String processDeleteshows(HttpServletRequest request, HttpSession session) {
           String nextPage;
        System.out.println("Delete shows");
        //get book details
           shows showDetails = new shows();
        //get bookid from request
        String showsIDString = (String) request.getParameter("showsID");
        System.out.println("delete shows for showsID " + showsIDString);
        showDetails.deleteshows(showsIDString);
        //display the page again - need a new list to reflect deleted book
        return this.processRequestAllShow(session);
    }

}
