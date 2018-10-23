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
public class PenjualanModel {
    String no_faktur, tgl_faktur, nm_konsumen, jumlah, harga_satuan, harga_total, kode_barang;
    KoneksiDB db = null;

    public PenjualanModel() {
        db = new KoneksiDB();
    }
    
    public String getNo_faktur() {
        return no_faktur;
    }

    public void setNo_faktur(String no_faktur) {
        this.no_faktur = no_faktur;
    }

    public String getTgl_faktur() {
        return tgl_faktur;
    }

    public void setTgl_faktur(String tgl_faktur) {
        this.tgl_faktur = tgl_faktur;
    }

    public String getNm_konsumen() {
        return nm_konsumen;
    }

    public void setNm_konsumen(String nm_konsumen) {
        this.nm_konsumen = nm_konsumen;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getHarga_satuan() {
        return harga_satuan;
    }

    public void setHarga_satuan(String harga_satuan) {
        this.harga_satuan = harga_satuan;
    }

    public String getHarga_total() {
        return harga_total;
    }

    public void setHarga_total(String harga_total) {
        this.harga_total = harga_total;
    }

    public String getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }
    
    public void simpan(){
    String sql="INSERT INTO penjualan values('"+no_faktur+"','"+tgl_faktur+"','"+nm_konsumen+"','"+jumlah+"','"+harga_satuan+"','"+harga_total+"','"+kode_barang+"')";
    db.simpanData(sql);
  }
    
    public void update(){
        String sql="UPDATE penjualan SET tgl_faktur='"+tgl_faktur+"',nm_konsumen='"+nm_konsumen+"',jumlah='"+jumlah+"',harga_satuan='"+harga_satuan+"',harga_total='"+harga_total+"',kode_barang='"+kode_barang+"' WHERE no_faktur='"+no_faktur+"'";
        db.simpanData(sql);
    }
    
    
    
    public void hapus(){
        String sql="DELETE FROM penjualan WHERE no_faktur='"+no_faktur+"'";
        db.simpanData(sql);
        System.out.println("");
    }
    
    public List tampil() {
        List<PenjualanModel> data = new ArrayList<PenjualanModel>();
        ResultSet rs = null;
 
        try {
            String sql = "select * from penjualan order by no_faktur desc";
            rs = db.ambilData(sql);
            while (rs.next()) {
                PenjualanModel mp = new PenjualanModel();
                mp.setNo_faktur(rs.getString("no_faktur"));
                mp.setTgl_faktur(rs.getString("tgl_faktur"));
                mp.setNm_konsumen(rs.getString("nm_konsumen"));
                mp.setJumlah(rs.getString("jumlah"));
                mp.setHarga_satuan(rs.getString("harga_satuan"));
                mp.setHarga_total(rs.getString("harga_total"));
                mp.setKode_barang(rs.getString("kode_barang"));
                data.add(mp);
 
            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalahan Saat menampilkan data User" + ex);
        }
        return data;
    }
    
    public List cariPnj() {
        List<PenjualanModel> data = new ArrayList<PenjualanModel>();
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM penjualan WHERE no_faktur='"+no_faktur+"'";
            rs = db.ambilData(sql);
            while (rs.next()) {
                PenjualanModel m = new PenjualanModel();
                m.setNo_faktur(rs.getString("no_faktur"));
                m.setTgl_faktur(rs.getString("tgl_faktur"));
                m.setNm_konsumen(rs.getString("nm_konsumen"));
                m.setJumlah(rs.getString("jumlah"));
                m.setHarga_satuan(rs.getString("harga_satuan"));
                m.setHarga_total(rs.getString("harga_total"));
                m.setKode_barang(rs.getString("kode_barang"));
                data.add(m);

            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan Cari Kode Barang" + ex);
        }
        return data;
    }
}
