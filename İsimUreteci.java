package progDil;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class isimUretimi {
	
	public static void main (String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Lutfen üretilecek isim sayısını giriniz: ");
		int adet =s.nextInt();
		System.out.println(adet + " adet sıfat tamlaması üretilecektir.");
		
		sifatTamlamasi(adet);
	}
	static void sifatTamlamasi(int a)
	{
		String sifatlar [] = {"İyi","Kötü","Çirkin"}; // Sıfatlar listesi tanımlandı. Liste Uzatılacak
		String isimler [] = {"Fethullah", "Fatih","İzzet"}; // isimler listesi tanımlandı. Liste Uzatılacak
		
		int sUzun = sifatlar.length;
		int iUzun = isimler.length;
		boolean feto = true;
		int i = 0 ;
		
		ArrayList <String> ciftler = new ArrayList<> ();
		while(feto)
		{
			if(i < a)
			{			
				Random rndSifat = new Random();    //İki adet random sayı üretilmiştir. 
				int sSayi = rndSifat.nextInt(sUzun);
				Random rndIsim = new Random();
				int iSayi = rndIsim.nextInt(iUzun);
				
				String cift = sifatlar[sSayi] + " " + isimler[iSayi]; //Bir adet cift üretildi. 
				int cUzun = ciftler.size();
				
				System.out.println(ciftler.indexOf(cift)== -1);//ciftler icerisinde yeni üretilen cift varsa False yoksa True çıktısı verir.
				if (ciftler.indexOf(cift) == -1) {
					ciftler.add(cift);
					String uretilen =  sifatlar[sSayi] +" "+ isimler[iSayi];
					System.out.println((i+1) + " ==> Uretilen = " + uretilen);
					i++;
				}
			}
			else
				feto = false;
		}
	}
}
