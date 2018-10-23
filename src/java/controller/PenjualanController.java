/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MasterbarangModel;
import model.PenjualanModel;

/**
 *
 * @author asus
 */
@WebServlet(name = "PenjualanController", urlPatterns = {"/PenjualanController"})
public class PenjualanController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
       // processRequest(request, response);
        String proses=request.getParameter("proses");
        String action=request.getParameter("action");
        
        if (proses.equals("tambah-pnj")){
            response.sendRedirect("tambah_pnj.jsp");
            return;
        }else if(proses.equals("edit-pnj")){
            response.sendRedirect("edit_pnj.jsp?no_faktur="+request.getParameter("no_faktur"));
            return;
        }else if(proses.equals("hapus-pnj")){
            PenjualanModel hps = new PenjualanModel();
            hps.setNo_faktur(request.getParameter("no_faktur"));
            hps.hapus();
            response.sendRedirect("");
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
        //processRequest(request, response);
        String data = request.getParameter("data");
        String proses = request.getParameter("proses");

        if (data != null){
           if(data.equals("penjualan")){
                PenjualanModel mp=new PenjualanModel();
                MasterbarangModel mb=new MasterbarangModel();
                mp.setNo_faktur(request.getParameter("no_faktur"));
                mp.setTgl_faktur(request.getParameter("tgl_faktur"));
                mp.setNm_konsumen(request.getParameter("nm_konsumen"));
                mp.setJumlah(request.getParameter("jumlah"));
                mp.setHarga_satuan(request.getParameter("harga_satuan"));
                mp.setHarga_total(request.getParameter("harga_total"));
                mp.setKode_barang(request.getParameter("kode_barang"));
                if (proses.equals("tambah-pnj")){
                    mp.simpan();
                    mb.kurangiStok();
                }else if(proses.equals("update-pnj")){
                    mp.update();
                }else if(proses.equals("hapus-pnj")){
                    mp.hapus();
                }
                response.sendRedirect("penjualan.jsp");
            }
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
