package progDil;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class IsimUreteci {

	public static void main (String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Dil seçiniz: ");
		String dil = s.next();
		System.out.println("Lutfen üretilecek isim sayısını giriniz: ");
		int sayi =s.nextInt();

		isimUret(dil, sayi);
	}

	static void isimUret(String Language, int Adet) {
		String[]
				TrAdlar = {
				/*"Deniz",
				"Akşam",
				"Kitap",
				"Ev",
				"Öğrenci",
				"Gün",
				"Yumruk",			
				"Kurt",
				"Bilezik",
				"Yılan",
				"Aslan",
				"Masa",
				"Top",
				"Vazo",
				"Çorap",
				"Duvar",
				"Çanta",
				"Tasma",
				"Yagmur",
				"Şimşek",
				"Çilek",
				"Koku",
				"Korsan",
				"Bıçak",*/
				"Çivi",
				"Fethullah",
				"Fatih",
		},

		EngAdlar = {

				"Sea",
				"Night",
				"Book",
				"House",
				"Student",
				"Day",
				"Punch",
				"Wolf",
				"Bracelet",
				"Snake",
				"Lion",
				"Table",
				"Ball",
				"Vase",
				"Socks",
				"Wall",
				"Bag",
				"Collar",
				"Rain",
				"Lightning",
				"Strawberry",
				"Smell",
				"Pirate",
				"Knife",
				"Gib",
				"Fethullah",
				"Fatih"
		},

		TrSifatlar = {
				/*"İyi",
				"Kötü",
				"Çirkin",
				"Mutlu",
				"Sağlıklı",
				"Yardımsever",
				"Sevimli",
				"Mükemmel",
				"Gururlu",
				"Güzel",
				"Sadık",
				"Muhteşem",
				"Demir",
				"Başarılı",
				"Harika",
				"Neşeli",*/
				"Şanslı",
				"Esprili",
				"Kızgın",
		},

		EngSifatlar = {
				"Good",
				"Bad",
				"Ugly",
				"Happy",
				"Healthy",
				"Helpful",
				"Lovely",
				"Perfect",
				"Proud",
				"Nice",
				"Obedient",	
				"Splendid",
				"Iron",
				"Successful",
				"Wonderful",
				"Vivacious",
				"Lucky",
				"Witty",
				"Angry",
		};

		String[] Adlar = null, Sifatlar = null;
		//ArrayList<String> Uretilenler = null;

		if (Language.equals("Tr")) {
			Adlar = TrAdlar;
			Sifatlar = TrSifatlar;
		}
		else if (Language.equals("Eng")) {
			Adlar = EngAdlar;
			Sifatlar = EngSifatlar;
		}
		else
		{
			System.out.println("Seçiminiz yanlış");
		}

		Random rnd = new Random();
		int j=0;
		int olasilik = Sifatlar.length*Adlar.length;
		System.out.println(olasilik);
		
		for (int i = 0; i < Adet;) {
			
			int AdIndex = rnd.nextInt(Adlar.length);
			int SifatIndex = rnd.nextInt(Sifatlar.length);
			
			String ifade = Sifatlar[SifatIndex]+" "+Adlar[AdIndex];
			File f = new File("d:\\ProgDil\\" + ifade);
			
			File s =new File("d:\\ProgDil");
			int sayi = s.list().length;
			//System.out.println("Dosya sayisi = "+ sayi);
			
			if(f.isDirectory())
			{
				System.out.println(ifade+ " adlı klasör bulunmaktadır.");
				j += 1;
				if(sayi == olasilik)
				{
					System.out.println("Boş= "+ j);
					break;
				}
			}
			else
			{
				System.out.println((i+1)+". Üretilen ==> "+ ifade);
				File klasor = new File("d:\\ProgDil\\" + ifade);
				klasor.mkdir();	
				i++;
			}
		}
	}
}

