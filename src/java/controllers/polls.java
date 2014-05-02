/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
public class polls extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
        } finally {
            out.close();
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(polls.class.getName()).log(Level.SEVERE, null, ex);
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
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //processRequest(request, response);
            int fn=Integer.parseInt(request.getParameter("fn"));
           model.model_polls conn= new model.model_polls();
           /*
           fn=1 create polls
           * fn=2 get poll list
           * fn=3 get poll results
           * fn=4 get poll Details
             */      
           switch (fn)
           {case 1:{
                        String detailJSON=request.getParameter("detailJSON");
                        String qtnJSON=request.getParameter("qtnJSON");
                        String ansJSON=request.getParameter("ansJSON");
                        System.out.println(detailJSON +"KK"+qtnJSON+"KK"+ansJSON);
                        boolean rslt=conn.createPoll(detailJSON, qtnJSON, ansJSON);
                        System.out.println(rslt);
                        out.println(rslt);
                        
                        
                    }break;
               case 2:{
                        
                        
                        String rslt=conn.viewPolls();
                        System.out.println(rslt);
                        out.println(rslt);
                        
                        
                    }break;
               case 3:{
                        int pid=Integer.parseInt(request.getParameter("pid"));
                        
                        
                        String rslt=conn.pollResult(pid);
                        System.out.println(rslt);
                        out.println(rslt);
                        
                        
                    }break;
               case 4:{
                        int pid=Integer.parseInt(request.getParameter("pid"));
                        
                        
                        String rslt=conn.pollDetails(pid);
                        System.out.println(rslt);
                        out.println(rslt);
                        
                        
                    }break;
           }
        } catch (SQLException ex) {
            Logger.getLogger(polls.class.getName()).log(Level.SEVERE, null, ex);
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
    }// </editor-fold>

}
