package beanpackage;
// uye tablosunun kolonları
public class Kullanici {
    private String ad="";
    private String soyad="";
    private String meslek="";
    private String email="";
    private String sifre="";
    // kolonların getter setter metodları
    /**
     * @return the ad
     */
    public String getAd() {
        return ad;
    }

    /**
     * @param ad the ad to set
     */
    public void setAd(String ad) {
        this.ad = ad;
    }

    /**
     * @return the soyad
     */
    public String getSoyad() {
        return soyad;
    }

    /**
     * @param soyad the soyad to set
     */
    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    /**
     * @return the meslek
     */
    public String getMeslek() {
        return meslek;
    }

    /**
     * @param meslek the meslek to set
     */
    public void setMeslek(String meslek) {
        this.meslek = meslek;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the sifre
     */
    public String getSifre() {
        return sifre;
    }

    /**
     * @param sifre the sifre to set
     */
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}

