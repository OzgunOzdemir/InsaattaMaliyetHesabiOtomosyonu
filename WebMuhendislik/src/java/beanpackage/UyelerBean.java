package beanpackage;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class UyelerBean implements Serializable {
     private Kullanici kullanici;

    public UyelerBean() {
         kullanici = new Kullanici();
    }
     public String giris() {
        String sonuc = "";
        try {
            Baglanti b = new Baglanti();
            Connection c = b.baglan();
            String sorgu = "select * from uye where EMAIL=" + "'" + kullanici.getEmail()+ "'" + " and SIFRE=" + "'" + kullanici.getSifre() + "'";
            PreparedStatement prs;
            prs = c.prepareStatement(sorgu);
            ResultSet rs = prs.executeQuery();
            Kullanici k = new Kullanici();
            while (rs.next()) {
                k.setAd(rs.getString("AD"));
                k.setSoyad(rs.getString("SOYAD"));
                k.setMeslek(rs.getString("MESLEK"));
                k.setEmail(rs.getString("EMAIL"));
                k.setSifre(rs.getString("SIFRE"));
            }
            if (k.getEmail().equals(kullanici.getEmail()) && k.getSifre().equals(kullanici.getSifre())) {
                sonuc = "hesaplama";
            } else {
                sonuc = "index";
            } 
        } catch (SQLException ex) {
            Logger.getLogger(UyelerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sonuc;
    }
 
    public String kullanicikaydet() {
        String sonuc = "";
        try {
            Baglanti b = new Baglanti();
            Connection c = b.baglan();
            Kullanici k = new Kullanici();
            String sorgu = ("INSERT INTO uye (\"ad\",\"soyad\",\"meslek\",\"email\",\"sifre\") VALUES (?,?,?,?,?)");
            PreparedStatement prs;
            prs = c.prepareStatement(sorgu);
            prs.setString(1, kullanici.getAd());
            prs.setString(2, kullanici.getSoyad());
            prs.setString(3, kullanici.getMeslek());
            prs.setString(4, kullanici.getEmail());
            prs.setString(5, kullanici.getSifre());                      
            prs.executeUpdate();
            sonuc = "index";
        } catch (SQLException ex) {
            Logger.getLogger(UyelerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sonuc;

    }
    public Kullanici getKullanici() {
        return kullanici;
    }  
    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }  
}
