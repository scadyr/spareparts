<%-- 
    Document   : tampil_brg
    Created on : Oct 22, 2018, 10:05:19 PM
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
        <title>Data Barang</title>
    </head>
    <body>
        <center><h1>Master Data Barang</h1></center>
        <center>
            <a href="index.jsp">Kembali</a>
            <a class="tambah" href="BarangController?proses=tambah-brg">| Tambah</a>
        </center>
        <table style="margin:20px auto;" border="1">
            <tr>
                <th>No</th>
                <th>Kode Barang</th>
                <th>Nama Barang</th>
                <th>Harga Jual</th>
                <th>Harga Beli</th>
                <th>Satuan</th>
                <th>Kategori</th>
                <th>Stok</th>
                <th>Aksi</th>
            </tr>
            <%
                MasterbarangModel km = new MasterbarangModel();
                List<MasterbarangModel> data = new ArrayList<MasterbarangModel>();
                String ket = request.getParameter("ket");
                if (ket == null) {
                    data = km.tampil();
                } 
                for (int x = 0; x < data.size(); x++) {
            %>
            <tr>
                <td><%=x + 1%></td>
                <td><%=data.get(x).getKode_barang()%></td>
                <td><%=data.get(x).getNama_barang()%></td>
                <td><%=data.get(x).getHarga_jual()%></td>
                <td><%=data.get(x).getHarga_beli()%></td>
                <td><%=data.get(x).getSatuan()%></td>
                <td><%=data.get(x).getKategori()%></td>
                <td><%=data.get(x).getStok()%></td>
                <td>
                    <a href="BarangController?proses=edit-brg&kode_barang=<%=data.get(x).getKode_barang()%>">Edit</a>
                    <a href="BarangController?proses=hapus-brg&kode_barang=<%=data.get(x).getKode_barang()%>">Hapus</a>
                </td>
            </tr>
            <%}%>
        </table>
        
    </body>
</html>
