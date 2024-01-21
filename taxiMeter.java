package soru;

import java.util.*; //Tüm kütüphaneyi içeri aktarıyoruz

public class Soru {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Scanner kütüphanesini tanımlıyoruz
        double perKiloMeter = 17.61; //Her kilometre başına verilecek olan ücret
        double kiloMeter; //Kişinin gireceği kilometre miktarının değişkeni
        double taxiMeter; //Taksimetre sonucu
        
        System.out.println("Taksiye bindin!\nKaç kilometrelik yol gideceksin?");
        kiloMeter = input.nextDouble(); //Veriyi okuyoruz
        taxiMeter = 24.55 + (kiloMeter * perKiloMeter); //Kilometre ile kilometre başı fiyatını çarpıyoruz sonrasında biniş ücretiyle topluyoruz
        if (taxiMeter <= 90) { //Eğer taksimetre 90 tlden az veya aşağı ise taksimetre ücretini 90tl yapıyoruz (indi bindi tarifesi)
            taxiMeter = 90;
            System.out.println("İndi bindi tarifesi uygulandı, alınan para: " + taxiMeter); //indi bindi tarifesi
        } else {
            System.out.println("Yol: " + taxiMeter + " TL"); //Normal sonuç
        }
        
    }    
}
