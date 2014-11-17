package progDilIsimUreteci;

import java.io.File;
import java.util.Random;

public class IsimUreteciClass {

	String Language = "";
	int sayi = 0;
	
	public IsimUreteciClass(String secilenDil, int adet) {
		
		Language = secilenDil;
		sayi = adet; 
	}

	public void IsimUreteci() {

		String[]
				TrAdlar = {
				
				
				"Akşam",
				"Aslan",
				"Bıçak",
				"Bilezik",
				"Çanta",
				"Çilek",
				"Çivi",
				"Çorap",
				"Deniz",
				"Duvar",
				"Ev",
				"Fatih",
				"Fethullah",
				"Gün",
				"Kitap",
				"Kurt",
				"Koku",
				"Korsan",
				"Top",
				"Tasma",
				"Masa",
				"Öğrenci",
				"Yumruk",	
				"Vazo",
				"Yagmur",
				"Yılan",

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

				"İyi",
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
				"Neşeli",
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
		String yol = "";

		if (this.Language.equals("tr")) {

			Adlar = TrAdlar;
			Sifatlar = TrSifatlar;
			yol = "Turkce Dosyalar\\";
		}

		else if (Language.equals("eng")) {

			Adlar = EngAdlar;
			Sifatlar = EngSifatlar;
			yol = "İngilizce Dosyalar\\"; 
		}

		Random rnd = new Random();
		
		int olasilik = Sifatlar.length * Adlar.length; // Bir kök dizinde bulunabilecek maksimum dosya sayısı heplanmıştır.

		System.out.println("\n>>> SONUÇLAR <<<\n");

		for (int i = 0; i < sayi;) {

			int AdIndex = rnd.nextInt(Adlar.length);
			int SifatIndex = rnd.nextInt(Sifatlar.length);
			String ifade = Sifatlar[SifatIndex] + " " + Adlar[AdIndex];

			File uretilecekDosya = new File("d:\\ProgDil\\" + yol + ifade);
			File dosyaSayisi = new File("d:\\ProgDil\\" + yol);

			int dSayisi = dosyaSayisi.list().length;

			if(uretilecekDosya.isDirectory()) { // Kök dizinde, üretilecek olan dosya var mı?

				if(dSayisi  == olasilik) { // Kök dizindeki dosya sayısı, maksimum oluşacak dosya ismi sayısına eşit mi?

					System.out.println("\n!!!ÜRETİLEBİLECEK MAKSİMUM DOSYA SAYISINA ULAŞILMIŞTIR!!!");
					break;
				}

				System.out.println("\n\tÜretilecek olan '" + ifade + "'" + " adlı klasör belirtilen kök dizinde zaten bulunmaktadır. Bu yüzden tekrar üretilmemiştir.\n");
			}

			else {

				System.out.println((i + 1) + ". Üretilen ==> " + ifade);

				uretilecekDosya.mkdir(); // Belirtilen yoldaki dosya oluşturuldu.
				i ++ ;
			}		
		}
	}	
}
