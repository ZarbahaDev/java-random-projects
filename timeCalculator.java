package soru;

import java.util.*; //Tüm kütüphaneyi içeri aktarıyoruz
import java.lang.Math; //Math kütüphanesini içeri aktarıyoruz (üslü işlemler için)
import java.util.concurrent.TimeUnit; //Saniyeyi dakika saat güne çevirmek için kullanacağımız kütüphaneyi içeri aktarıyoruz

public class Soru {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Scanner kütüphanesini tanımlıyoruz
        double fileSize; //Dosyamızın GB boyutunu belirten değişken
        double internetSpeed; //İnternetimizin hızını belirten değişken
        double hesaplama; //Hesaplamanın yapılacağı değişken
        String fileType = null; //Kullanıcıdan alacağımız dosya türünün değişkeni
        
        
        
        System.out.println("Dosya boyutunun büyüklük türü ne olsun;\nKB\nMB\nGB\nTB"); //Kullanıcıya 4 seçenek sunuyoruz
        fileType = input.nextLine().toUpperCase(); //Kişinin 4 veriden birini girmesi halinde harfleri büyütmesini istiyoruz bu şekilde kontrol edeceğiz
        while (true) { //Bir döngü başlatıyoruz kişi yanlış bir bilgi girerse program bitmesin döngünün başına gelsin diye
            if (fileType.equals("KB") || fileType.equals("MB") || fileType.equals("GB") || fileType.equals("TB")) { //fileType değişkenini kontrol ediyoruz
                System.out.println("İndireceğiniz dosyanın " + fileType + " cinsinden boyutunu yaz!");
                fileSize = input.nextDouble(); //Gelen veriyi okuyoruz
                System.out.println(fileSize + " " + fileType + " boyutunda dosyayı seçtin!");
                System.out.println("İnternet hızını yaz!"); 
                internetSpeed = input.nextDouble(); //Gelen veriyi okuyoruz
                System.out.println("İnternet hızın: " + internetSpeed + " Mbps");
                switch (fileType) { //Switch case yapısını burada kullanmak kolayıma geldi
                    case "KB": //Eğer KB ise
                        hesaplama =  (fileSize * (Math.pow(1024,1)) ) / (internetSpeed * (Math.pow(1024,2) / 8) ) ;
                        //KB değerini Mbps değerinde ölçmek için kullanılan matematiksel işlem
                        //Dosya boyutu * 1024 üssü 1 / internet hızı * 1024 üssü 2 / 8
                        //KB değerini 1024 üssü 1 ile belirtmemiz gerekmekte bknz. https://tr.wikipedia.org/wiki/Bayt
                        //İnternet hızımı 1024 üssü 2 ile çarpıyoruz bunun sebebi mbps türünden zamanı hesaplamamız
                        //8 e bölmemizin sebebi ise 1 byte değerinin 8 bite eşdeğer olmasıdır
                        timeFinder((int) hesaplama); //aşağıda yazdığım timeFinder metodu
                        break;
                    case "MB": //Eğer MB ise
                        hesaplama =  (fileSize * (Math.pow(1024,2)) ) / (internetSpeed * (Math.pow(1024,2) / 8) ) ;
                        //MB değerini Mbps değerinde ölçmek için kullanılan matematiksel işlem
                        //Dosya boyutu * 1024 üssü 2 / internet hızı * 1024 üssü 2 / 8
                        //MB değerini 1024 üssü 2 ile belirtmemiz gerekmekte bknz. https://tr.wikipedia.org/wiki/Bayt
                        timeFinder((int) hesaplama); //aşağıda yazdığım timeFinder metodu
                        break;
                    case "GB": //Eğer GB ise
                        hesaplama =  (fileSize * (Math.pow(1024,3)) ) / (internetSpeed * (Math.pow(1024,2) / 8) ) ;
                        //GB değerini Mbps değerinde ölçmek için kullanılan matematiksel işlem
                        // Dosya boyutu * 1024 üssü 3 / internet hızı * 1024 üssü 2 / 8
                        //GB değerini 1024 üssü 3 ile belirtmemiz gerekmekte bknz. https://tr.wikipedia.org/wiki/Bayt
                        timeFinder((int) hesaplama); //aşağıda yazdığım timeFinder metodu    
                        break;
                    case "TB": //Eğer TB ise
                        hesaplama =  (fileSize * (Math.pow(1024,4)) ) / (internetSpeed * (Math.pow(1024,2) / 8) ) ;
                        //TB değerini Mbps değerinde ölçmek için kullanılan matematiksel işlem
                        // Dosya boyutu * 1024 üssü 4 / internet hızı * 1024 üssü 2 / 8
                        //TB değerini 1024 üssü 4 ile belirtmemiz gerekmekte bknz. https://tr.wikipedia.org/wiki/Bayt
                        timeFinder((int) hesaplama); //aşağıda yazdığım timeFinder metodu    
                        break;
                    default: //Eğer gözden kaçırmadığım bir nokta yoksa program asla bu konuma gelmemeli
                        System.out.println("Bir şeyler ters gitti!"); //Bunlar sadece bir soruna karşı geri uyarı
                }
                break; //Sonucu printledikten sonra While döngüyü burada kırıyoruz
            } else {
                System.out.print("Lütfen listede olan bir veri türü seç: "); //Eğer KB MB GB TB seçeneklerinden biri yazılmamışsa bizi buraya yönlendirecek ve yeniden bir dosya türü girmemiz isteyecek
                fileType = input.nextLine().toUpperCase(); //Dosya türünü yeniden alıyoruz ve döngünün başına gönderiyoruz
            }
            
        }
        
        
    }
    
    
    public static void timeFinder(int seconds) { //Verilen integer saniye birimine göre gün saat dakika saniye hesaplayıcı
        int day = (int)TimeUnit.SECONDS.toDays(seconds); //Günü hesaplamak için saniyeyi güne çeviren metodu çağırıyoruz
        long hours = TimeUnit.SECONDS.toHours(seconds) - (day *24); //Saati hesaplamak için saniyeyi saate çeviren metodu çağırıyoruz ardından gün sayısına göre 24 ile çarpıp çıkartıyoruz bu sayede 24 saatlik süre dilimini direkt olarak güne aktarıyoruz
        long minute = TimeUnit.SECONDS.toMinutes(seconds) - (TimeUnit.SECONDS.toHours(seconds)* 60); //Dakikayı hesaplamak için saniyeyi dakikaya çeviririz, saatte yaptığımız işlerin benzerini uygularız
        long second = TimeUnit.SECONDS.toSeconds(seconds) - (TimeUnit.SECONDS.toMinutes(seconds) *60); //Saniyeyi hesaplamak için saniyeyi saniyeye çeviririz, dakikaya yaptığımız işlerin benzerini uygularız
        System.out.println("İndirme süresi: " + day + " Gün | " + hours + " Saat | " + minute + " Dakika | " + second + " Saniye"); //Sonucları printliyoruz
    }
}
