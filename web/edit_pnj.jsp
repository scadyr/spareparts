<%-- 
    Document   : edit_pnj
    Created on : Oct 23, 2018, 12:36:16 PM
    Author     : asus
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.PenjualanModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center><h1>Ubah Data Barang</h1></center>
        <form action="PenjualanController?data=penjualan&proses=update-pnj" method="post">
            <table style="margin:20px auto;">
            <%
                String no_faktur = request.getParameter("no_faktur");
                PenjualanModel km = new PenjualanModel();
                km.setNo_faktur(no_faktur);
                List<PenjualanModel> data = new ArrayList<PenjualanModel>();
                data = km.cariPnj(); 
                if (data.size() > 0) {
 
            %>
                <tr>
                    <td>Kode Barang</td>
                    <td><input type="text" name="kode_barang" value="<%=data.get(0).getKode_barang()%>"></td>
                </tr>
                <tr>
                    <td>Tanggal Faktur</td>
                    <td><input type="text" name="tgl_faktur" value="<%=data.get(0).getTgl_faktur()%>"></td>
                </tr>
                <tr>
                    <td>Nama Konsumen</td>
                    <td><input type="text" name="nm_konsumen" value="<%=data.get(0).getNm_konsumen()%>"></td>
                </tr>
                <tr>
                    <td>Jumlah</td>
                    <td><input type="text" name="jumlah" value="<%=data.get(0).getJumlah()%>"></td>
                </tr>
                <tr>
                    <td>Harga Satuan</td>
                    <td><input type="text" name="harga_satuan" value="<%=data.get(0).getHarga_satuan()%>"></td>
                </tr>
                <tr>
                    <td>Harga Total</td>
                    <td><input type="text" name="harga_total" value="<%=data.get(0).getHarga_total()%>"></td>
                    <td><input type="hidden" name="no_faktur" value="<%=data.get(0).getNo_faktur()%>"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update"></td>
                </tr>
                  <%}%>
            </table>
          
        </form>
    </body>
</html>
