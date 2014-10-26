import java.util.Scanner;

public class Underscore {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Kelime girin: ");
		String veri = s.next();
		
		ReplaceUnderscoreWithSpace(veri);
	}
	static void ReplaceUnderscoreWithSpace(String s) {
		int uzunluk = s.length();	
		
		char[] karakterDizisi = new char[uzunluk];
		// Girilen kelime uzunluğunda bir karakter dizisi oluşturduk.
		karakterDizisi = s.toCharArray();	
		//String nesnemizi karakter dizisine çevirdik ve char tipinde diziye attık.
		
		int ilk = IlkIndisBulma(karakterDizisi);
		int son = SonIndisBulma(karakterDizisi);
		
		String dizge = "";
		for (int i = ilk; i <= son; i++) { 
			dizge = dizge + karakterDizisi[i];
		}	
		
		dizge = dizge.replace( '_', ' ');	
		
		char[] altDizi = new char[dizge.length()];
		altDizi = dizge.toCharArray();
		
		for (int i = 0; i < altDizi.length; i++) {
			karakterDizisi[i+ilk] = altDizi[i];
		}
		for ( int i = 0; i <uzunluk; i++ ) {
			System.out.print(karakterDizisi[i]);
		}
		//27 ile 37. satırlar arasındaki bölüm farklı olarak bu şekilde de yapılabilir
		/*
		for (int i =0; i<uzunluk; i++)
		{
			if(i<ilk)
			{
				dizge ="_" + dizge;
			}
			if(i>son)
			{
				dizge=dizge + "_";
			}
		}
		*/
		System.out.println();
	}
	static int IlkIndisBulma(char[] dizi) {
		int indis = 0;
		boolean durum = true;
		for (int i = 0; i < dizi.length; i++) {
			if (dizi[i] == '_' && durum == true) 
				indis++;
			else
				durum = false;
		}
		return indis;
	}
	static int SonIndisBulma(char[] dizi) {
		int indis = dizi.length-1 ;
		boolean durum = true;
		for (int i = dizi.length-1; i >= 0; i--) {
			if (dizi[i] == '_' && durum == true)
				indis--;
			else
				durum = false;
		}
		return indis;
	}
}
//String sınıfı metotları, immutable metotlardır.
//Yani bu sınıfın metotları değiştirilemez.
