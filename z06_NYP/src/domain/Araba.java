package domain;

public class Araba  extends Arac implements LastikKontrol,SurusKontrol{

    private int hiz;

    public Araba(String marka, String model, String renk, int hiz) {
        super(marka, model, renk);
        this.hiz = hiz;
    }

    public Araba() {

    }

    public int getHiz() {
        return hiz;
    }

    public void setHiz(int hiz) {
        this.hiz = hiz;
    }

    public void  hizlan(int hizArtisi)
    {
        this.hiz+=hizArtisi;
    }

    public void yavasla(int hizAzaltma)
    {
        this.hiz-=hizAzaltma;
    }

    public void dur()
    {
        this.hiz=0;
    }

    public void  bilgileriGoster()
    {
        System.out.println("Marka : " +this.getMarka());
        System.out.println("Model : " +this.getModel() );
        System.out.println("Renk : " +this.getRenk() );

        System.out.println("Hız : " +hiz );
    }


    @Override
    public void YorgunlukAlgi() {
        System.out.println("Yorgunluk Aldı Kontrol Ediliyor...");
    }


    @Override
    public void LastikHavaBasinci() {
        System.out.println("Lastik Hava Basıncı Kontrol Ediliyor...");
    }
}


/*
public class Araba {

    private String marka;
    private String model;
    private String renk;
    private int hiz;

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public int getHiz() {
        return hiz;
    }

    public void setHiz(int hiz) {
        this.hiz = hiz;
    }

    public Araba() {
    }

    public Araba(String marka, String model, String renk, int hiz) {
        this.marka = marka;
        this.model = model;
        this.renk = renk;
        this.hiz = hiz;
    }

    @Override
    public String toString() {
        return "Araba{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", renk='" + renk + '\'' +
                ", hiz=" + hiz +
                '}';
    }
}
*/