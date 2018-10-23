/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author asus
 */
public class MasterbarangModel {
    String kode_barang, nama_barang, harga_jual, harga_beli, satuan, kategori, stok, jumlah;
    KoneksiDB db = null;
    
    public MasterbarangModel() {
        db = new KoneksiDB();
    }

    public String getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(String harga_jual) {
        this.harga_jual = harga_jual;
    }

    public String getHarga_beli() {
        return harga_beli;
    }

    public void setHarga_beli(String harga_beli) {
        this.harga_beli = harga_beli;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
    
    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }
    
    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }
    
    public void simpan(){
        String sql="INSERT INTO mstr_barang values('"+kode_barang+"','"+nama_barang+"','"+harga_jual+"','"+harga_beli+"','"+satuan+"','"+kategori+"','"+stok+"')";
        db.simpanData(sql);
    }
    
    public void kurangiStok(){
        String sql="UPDATE mstr_barang SET stok=stok-'"+jumlah+"' WHERE kode_barang='"+kode_barang+"'";
        db.simpanData(sql);
    }
    
    public void update(){
        String sql="UPDATE mstr_barang SET nama_barang='"+nama_barang+"',harga_jual='"+harga_jual+"',harga_beli='"+harga_beli+"',satuan='"+satuan+"',kategori='"+kategori+"',stok='"+stok+"' WHERE kode_barang='"+kode_barang+"'";
        db.simpanData(sql);
    }
    
    public void hapus(){
        String sql="DELETE FROM mstr_barang WHERE kode_barang='"+kode_barang+"'";
        db.simpanData(sql);
        System.out.println("");
    }
    
    public List tampil() {
        List<MasterbarangModel> data = new ArrayList<MasterbarangModel>();
        ResultSet rs = null;
 
        try {
            String sql = "select * from mstr_barang order by kode_barang asc";
            rs = db.ambilData(sql);
            while (rs.next()) {
                MasterbarangModel mb = new MasterbarangModel();
                mb.setKode_barang(rs.getString("kode_barang"));
                mb.setNama_barang(rs.getString("nama_barang"));
                mb.setHarga_jual(rs.getString("harga_jual"));
                mb.setHarga_beli(rs.getString("harga_beli"));
                mb.setSatuan(rs.getString("satuan"));
                mb.setKategori(rs.getString("kategori"));
                mb.setStok(rs.getString("stok"));
                data.add(mb);
 
            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalahan Saat menampilkan data User" + ex);
        }
        return data;
    }
    
    public List cariBrg() {
        List<MasterbarangModel> data = new ArrayList<MasterbarangModel>();
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM mstr_barang WHERE kode_barang='"+kode_barang+"'";
            rs = db.ambilData(sql);
            while (rs.next()) {
                MasterbarangModel m = new MasterbarangModel();
                m.setKode_barang(rs.getString("kode_barang"));
                m.setNama_barang(rs.getString("nama_barang"));
                m.setHarga_jual(rs.getString("harga_jual"));
                m.setHarga_beli(rs.getString("harga_beli"));
                m.setSatuan(rs.getString("satuan"));
                m.setKategori(rs.getString("kategori"));
                m.setStok(rs.getString("stok"));
                data.add(m);

            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan Cari Kode Barang" + ex);
        }
        return data;
    }
    
}
