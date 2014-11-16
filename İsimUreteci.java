import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class IsimUreteci {
	public static void main (String[] args)	{
		Scanner s = new Scanner(System.in);
		boolean durum = false;
		String dil;
		int sayi;
		
		do {
			System.out.println("Dil seçin Türkçe için tr İngilizce için en");
			dil = s.next();
			System.out.println("Lütfen üretilecek isim sayısını girin ");
			sayi = s.nextInt();
			if(dil.equals("tr") || dil.equals("en"))
				durum = true;
			else {
				System.out.println("Yanlış dil seçtin");
			}	
		} while(durum != true);
		
		IsimUret(dil, sayi);
	}

	static void IsimUret(String dil, int sayi) {
		String[]
				isimler = {
					"abajur",
					"baca",
					"canavar",
					"çaba",
					"demeç",
					"el",
					"fakülte",
					"gaflet",
					"hatıra",
					"ıhlamur",
					"iade",
					"jandarma",
					"kaş",
					"labirent",
					"medeniyet",
					"nabız",
					"ocak",
					"öncü",
					"puan",
					"rahat",
					"sene",
					"şablon",
					"tesis",
					"ucube",
					"ücret",
					"vaat",
					"yoğurt",
					"zehir",
				},
				sifatlar = {
					"ait",
					"basit",
					"cıvık",
					"çabuk",
					"dinamik",
					"erişilebilir",
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
				names = {
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
					"ulcer",
					"vacancy",
					"wad",
					"xenophobia",
					"yacht",
					"zinc",
				},
				adjectives = {
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
	
		if (dil.equals("tr")) {
			Adlar = isimler;
			Sifatlar = sifatlar;
		}
		else if (dil.equals("en")) {
			Adlar = names;
			Sifatlar = adjectives;
		}
		
		Random rnd = new Random();

		int olasilik = Sifatlar.length*Adlar.length;
		
		for (int i = 0; i < sayi;) {
			
			int AdIndex = rnd.nextInt(Adlar.length);
			int SifatIndex = rnd.nextInt(Sifatlar.length);
			
			File s = new File("/home/celikel/GitHub/progdil/");
			int dosya_sayisi = s.list().length;
			
			String ifade = Sifatlar[SifatIndex]+"-"+Adlar[AdIndex];
			File f = new File("/home/celikel/GitHub/progdil/" + ifade);
			
			if(f.isDirectory()) {
				if(dosya_sayisi == olasilik)
					break;
			}
			else {
				System.out.println((i+1)+". Üretilen ==>  "+ ifade);
				File klasor = new File("/home/celikel/GitHub/progdil/" + ifade);
				klasor.mkdir();	
				i++;
			}
		}
	}
}
