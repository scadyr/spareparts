<%-- 
    Document   : penjualan
    Created on : Oct 23, 2018, 10:02:06 AM
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
        <center><h1>Halaman Penjualan</h1></center>
        <center>
            <a href="index.jsp">Kembali</a>
            <a class="tambah" href="PenjualanController?proses=tambah-pnj">| Tambah</a>
        </center>
        <table style="margin:20px auto;" border="1">
            <tr>
                <th>No</th>
                <th>No Faktur</th>
                <th>Tanggal Faktur</th>
                <th>Nama Konsumen</th>
                <th>Kode Barang</th>
                <th>Jumlah</th>
                <th>Harga Satuan</th>
                <th>Harga Total</th>
                <th>Aksi</th>
            </tr>
            <%
                PenjualanModel km = new PenjualanModel();
                List<PenjualanModel> data = new ArrayList<PenjualanModel>();
                String ket = request.getParameter("ket");
                if (ket == null) {
                    data = km.tampil();
                } 
                
                for (int x = 0; x < data.size(); x++) {
                
                   
            %>
            <tr>
                <td><%=x + 1%></td>
                <td><%=data.get(x).getNo_faktur()%></td>
                <td><%=data.get(x).getTgl_faktur()%></td>
                <td><%=data.get(x).getNm_konsumen()%></td>
                <td><%=data.get(x).getKode_barang()%></td>
                <td><%=data.get(x).getJumlah()%></td>
                <td><%=data.get(x).getHarga_satuan()%></td>
                <td><%=data.get(x).getHarga_total()%></td>
                
                <td>
                    <a href="PenjualanController?proses=edit-pnj&no_faktur=<%=data.get(x).getNo_faktur()%>">Edit</a>
                    <a href="PenjualanController?proses=hapus-pnj&no_faktur=<%=data.get(x).getNo_faktur()%>">Hapus</a>
                </td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
