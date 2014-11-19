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
				
				
				"abajur",
				"baca",
				"canavar",
				"çaba",
				"demeç",
				"el",
				"fakülte",
				"gaflet",
				"ıhlamur",
				"iade",
				"jandarma",
				"kaş",
				"labirent",
				"medeniyet",
				"nabız",
				"ocak",
				"puan",					
				"rahat",
				"sene",
				"şablon",
				"tesis",
				"ücret",
				"vaat",
				"yoğurt",
				"zehir",

		},

		EngAdlar = {

				"ability",
				"bigot",
				"cab",
				"dab",
				"eagle",
				"fable",
				"gable",
				"haberdasher",
				"ice",
				"jackal",
				"karat",
				"lab",
				"machine",
				"nail",
				"oak",
				"pace",
				"quack",
				"rabbit",
				"saber",
				"tabby",
				"vacancy",
				"wad",
				"xenophobia",
				"yacht",
				"zinc",
		},

		TrSifatlar = {

				"basit",
				"cıvık",
				"çabuk",
				"dinamik",
				"feci",
				"gri",
				"hoyrat",
				"ılık",
				"iki",
				"kaplı",
				"lacivert",
				"müstakil",
				"nitel",
				"olağan",
				"öncül",
				"patlayıcı",
				"rafadan",
				"sade",
				"şık",
				"tatlı",
				"uçan",
				"ücra",
				"vasat",
				"yıkık",
				"zayıf",
		},

		EngSifatlar = {

			"akin",
				"beatiful",
				"conscious",
				"damned",
				"each",
				"fair",
				"gangling",
				"habitual",
				"idle",
				"jocular",
				"known",
				"laconic",
				"macabre",
				"nasty",
				"oblique",
				"pugnacious",
				"quadruple",
				"radical",
				"sad",
				"tactful",
				"ubiqutous",
				"vague",
				"warlike",
				"yellow",
				"zigzag",
		};

		String[] Adlar = null, Sifatlar = null;
		String yol = "";

		if (this.Language.equals("tr")) {

			Adlar = TrAdlar;
			Sifatlar = TrSifatlar;
			yol = "Turkce Dosyalar\\";
		}

		else {

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
