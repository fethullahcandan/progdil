import java.util.Scanner;

public class Underscore {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(" Kelime girin: ");
		String veri = s.next();
		ReplaceUnderscoreWithSpace(veri);
	}
	static void ReplaceUnderscoreWithSpace(String s) {
		int uzunluk = s.length();	
		char[] karakterDizisi = new char[uzunluk];
		// Girilen kelime uzunluğunda bir karakter dizisi oluşturduk.
		karakterDizisi = s.toCharArray();	
		//String nesnemizi karakter dizisine çevirdik ve char tipinde diziye attık.
		
		int ilk = 0;
		boolean durum = true;
		for (int i = 0; i < uzunluk; i++) {
			if (karakterDizisi[i] == '_' && durum == true) {
				ilk++;
			}
			else {
				durum = false;
			}
		}
	
		durum = true;
		int son = uzunluk - 1;
		for (int i = uzunluk - 1; i >= 0; i--) {
			if (karakterDizisi[i] == '_' && durum == true) {
				son--;
			}
			else {
				durum = false;
			}
		}
	
		String dizge = "";
		
		for (int i = ilk; i < son; i++) {
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
		System.out.println();
	}
}
