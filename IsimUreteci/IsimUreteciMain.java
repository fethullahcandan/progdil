package progDilIsimUreteci;

import java.util.Scanner;
import progDilIsimUreteci.IsimUreteciClass;

public class IsimUreteciMain {

	public static void main(String[] args) {

		System.out.println("\n***************İsim Üreteci Programına Hoşgeldiniz.***************\n");
		
		Scanner girilen = new Scanner(System.in);

		boolean durum = true;
		String secilenDil = "";
		int adet = 0;
		String tercih = "";

		while(durum) {

			System.out.println("\tLütfen hangi dilde dosya adı üretmek istediğinizi seçiniz.(Tr/Eng): ");

			secilenDil = girilen.next().toLowerCase();

			if(secilenDil.equals("tr") || secilenDil.equals("eng")) {

				System.out.println("\tLütfen üretmek istediğiniz dosya ismi sayısını giriniz: ");

				adet = girilen.nextInt();
				durum = false;
			}
			
			else {

				System.out.println("\nYanlış dil tercihinde bulundunuz lütfen tekrar giriş yapınız!\n");
				System.out.println("--Programdan çıkmak için 'E'e devam etmek için herhangi bir tuşa basınız: ");
		
				tercih = girilen.next().toLowerCase();
				
				if(tercih.equals("e")) {
					return;
				}
			}

		}

		IsimUreteciClass iclass = new IsimUreteciClass(secilenDil, adet);
		iclass.IsimUreteci();
	}
}

