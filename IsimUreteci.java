import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class IsimUreteci {

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
		
		isimUret(secilenDil, adet);
	}

	static void isimUret(String Language, int Adet) {
		
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

		if (Language.equals("tr")) {

			Adlar = TrAdlar;
			Sifatlar = TrSifatlar;
			yol = "Turkce Dosyalar/";
		}

		else if (Language.equals("eng")) {

			Adlar = EngAdlar;
			Sifatlar = EngSifatlar;
			yol = "Ingilizce Dosyalar/"; 
		}

		Random rnd = new Random();
		
		int olasilik = Sifatlar.length * Adlar.length; // Bir kök dizinde bulunabilecek maksimum dosya sayısı hesaplanmıştır.

		System.out.println("\n>>> SONUÇLAR <<<\n");
		
		for (int i = 0; i < Adet;) {

			int AdIndex = rnd.nextInt(Adlar.length);
			int SifatIndex = rnd.nextInt(Sifatlar.length);
			String ifade = Sifatlar[SifatIndex] + " " + Adlar[AdIndex];
			
			File uretilecekDosya = new File("/home/celikel/ProgDil/" + yol + ifade);
			File dosyaSayisi = new File("/home/celikel/ProgDil/" + yol);

			int dSayisi = dosyaSayisi.list().length;

			if(uretilecekDosya.isDirectory()) { // Kök dizinde, üretilecek olan dosya var mı?

				if(dSayisi  == olasilik) { // Kök dizindeki dosya sayısı, maksimum oluşacak dosya ismi sayısına eşit mi?

					System.out.println("\n!!!ÜRETİLEBİLECEK MAKSIMUM DOSYA SAYISINA ULAŞILMIŞTIR!!!");
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
