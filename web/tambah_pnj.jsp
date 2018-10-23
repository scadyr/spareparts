<%-- 
    Document   : tambah_pnj
    Created on : Oct 23, 2018, 11:04:12 AM
    Author     : asus
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Halaman Input Penjualan</title>
    </head>
    <body>
    <center><h1>Input Data Penjualan</h1></center>
        <form action="PenjualanController?data=penjualan&proses=tambah-pnj" method="post">
            <table style="margin:20px auto;">
                <tr>
                    <td>No Faktur</td>
                    <td><input type="text" name="no_faktur"></td>
                </tr>
                <tr>
                    <td>Tanggal Faktur</td>
                    <td><input type="date" name="tgl_faktur"></td>
                </tr>
                <tr>
                    <td>Nama Konsumen</td>
                    <td><input type="text" name="nm_konsumen"></td>
                </tr>
                <tr>
                    <td>Jumlah</td>
                    <td><input type="text" name="jumlah"></td>
                </tr>
                <tr>
                    <td>Harga Satuan</td>
                    <td><input type="text" name="harga_satuan"></td>
                </tr>
                <tr>
                    <td>Harga TOtal</td>
                    <td><input type="text" name="harga_total"></td>
                </tr>
                <tr>
                    <td>Kode Barang</td>
                    <td><input type="text" name="kode_barang"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Tambah"></td>
                </tr>
            </table>
        </form> 
    </body>
</html>
