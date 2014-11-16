import java.util.Scanner;

public class Underscore {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Kelime girin: ");
		String str = s.next();
		
		ReplaceUnderscoreWithSpace(str);
	}
	
	static void ReplaceUnderscoreWithSpace(String s) {
		int uzunluk = s.length();	
		
		char[] karakterDizisi = new char[uzunluk];
		karakterDizisi = s.toCharArray();	
		
		int ilk = IlkIndisBulma(karakterDizisi);
		int son = SonIndisBulma(karakterDizisi);
		
		s = s.replace('_', ' ');
		s = s.trim();                         //Baştaki ve sondaki boşlukları siler.
		
		for (int i = 0; i < ilk; i++) {
			s = "_" + s;
		}
		
		for (int i = 0; i < uzunluk - son - 1; i++) {
			s = s + "_";
		}
		
		System.out.println(s);
	}
	
	static int IlkIndisBulma(char[] dizi) {
		int i;
		for (i = 0; i < dizi.length; i++) {
			if (dizi[i] != '_' ) 
				break;
			
		}
		return i;
	}
	
	static int SonIndisBulma(char[] dizi) {
		int j;
		for (j = dizi.length-1; j >= 0; j--) {
			if (dizi[j] != '_' )
				break;
		}
		return j;
	}
}
//String sınıfı metotları, immutable metotlardır.
//Yani bu sınıfın metotları değiştirilemez.
