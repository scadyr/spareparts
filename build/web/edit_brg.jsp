<%-- 
    Document   : edit_brg
    Created on : Oct 23, 2018, 7:44:46 AM
    Author     : asus
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.MasterbarangModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ubah Data Barang</title>
    </head>
    <body>
        <center><h1>Ubah Data Barang</h1></center>
        <form action="BarangController?data=barang&proses=update-brg" method="post">
            <table style="margin:20px auto;">
            <%
                String kode_barang = request.getParameter("kode_barang");
                MasterbarangModel km = new MasterbarangModel();
                km.setKode_barang(kode_barang);
                List<MasterbarangModel> data = new ArrayList<MasterbarangModel>();
                data = km.cariBrg(); 
                if (data.size() > 0) {
 
            %>
                <tr>
                    <td>Nama Barang</td>
                    <td><input type="text" name="nama_barang" value="<%=data.get(0).getNama_barang()%>"></td>
                </tr>
                <tr>
                    <td>Harga Jual</td>
                    <td><input type="text" name="harga_jual" value="<%=data.get(0).getHarga_jual()%>"></td>
                </tr>
                <tr>
                    <td>Harga Beli</td>
                    <td><input type="text" name="harga_beli" value="<%=data.get(0).getHarga_beli()%>"></td>
                </tr>
                <tr>
                    <td>Satuan</td>
                    <td><input type="text" name="satuan" value="<%=data.get(0).getSatuan()%>"></td>
                </tr>
                <tr>
                    <td>Kategori</td>
                    <td><input type="text" name="kategori" value="<%=data.get(0).getKategori()%>"></td>
                </tr>
                <tr>
                    <td>Stok</td>
                    <td><input type="text" name="stok" value="<%=data.get(0).getStok()%>"></td>
                    <td><input type="hidden" name="kode_barang" value="<%=data.get(0).getKode_barang()%>"></td>
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
