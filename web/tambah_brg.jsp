<%-- 
    Document   : tambah_brg
    Created on : Oct 22, 2018, 9:35:37 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Data Barang</title>
    </head>
    <body>
        <center><h1>Form Tambah Data Barang</h1></center>
        <form action="BarangController?data=barang&proses=tambah-brg" method="post">
            <table style="margin:20px auto;">
                <tr>
                    <td>Kode Barang</td>
                    <td><input type="text" name="kode_barang"></td>
                </tr>
                <tr>
                    <td>Nama Barang</td>
                    <td><input type="text" name="nama_barang"></td>
                </tr>
                <tr>
                    <td>Harga Beli</td>
                    <td><input type="text" name="harga_beli"></td>
                </tr>
                <tr>
                    <td>Harga Jual</td>
                    <td><input type="text" name="harga_jual"></td>
                </tr>
                <tr>
                    <td>Satuan</td>
                    <td><input type="text" name="satuan"></td>
                </tr>
                <tr>
                    <td>Kategori</td>
                    <td><input type="text" name="kategori"></td>
                </tr>
                <tr>
                    <td>Stok</td>
                    <td><input type="text" name="stok"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Tambah"></td>
                </tr>
            </table>
        </form> 
    
    </body>
</html>
