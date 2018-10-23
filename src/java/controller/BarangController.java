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

/**
 *
 * @author asus
 */
@WebServlet(name = "BarangController", urlPatterns = {"/BarangController"})
public class BarangController extends HttpServlet {

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
        //processRequest(request, response);
        
        String proses=request.getParameter("proses");
        String action=request.getParameter("action");
        
        if (proses.equals("tambah-brg")){
            response.sendRedirect("tambah_brg.jsp");
            return;
        }else if(proses.equals("edit-brg")){
            response.sendRedirect("edit_brg.jsp?kode_barang="+request.getParameter("kode_barang"));
            return;
        }else if(proses.equals("hapus-brg")){
            MasterbarangModel hps = new MasterbarangModel();
            hps.setKode_barang(request.getParameter("kode_barang"));
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
           if(data.equals("barang")){
                MasterbarangModel mb=new MasterbarangModel();
                mb.setKode_barang(request.getParameter("kode_barang"));
                mb.setNama_barang(request.getParameter("nama_barang"));
                mb.setHarga_jual(request.getParameter("harga_jual"));
                mb.setHarga_beli(request.getParameter("harga_beli"));
                mb.setSatuan(request.getParameter("satuan"));
                mb.setKategori(request.getParameter("kategori"));
                mb.setStok(request.getParameter("stok"));
                if (proses.equals("tambah-brg")){
                    mb.simpan();
                }else if(proses.equals("update-brg")){
                    mb.update();
                }else if(proses.equals("hapus-brg")){
                    mb.hapus();
                }
                response.sendRedirect("tampil_brg.jsp");
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
