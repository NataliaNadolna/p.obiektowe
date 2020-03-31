import java.util.Scanner;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {
	
	
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Samochod s = new Samochod();
		Samochod n = new Samochod();
		int i=1;
		List<Samochod> lista = new LinkedList<>();
		BufferedReader reader;
		
		//wczytanie do listy
		try {
		
			reader = new BufferedReader(new FileReader("java-samochody.txt"));
			String line = reader.readLine();
			while (line != null) {
				
				if(i==1) {
					s.marka=line;
				}
				else if(i==2) {
					s.model=line;
				}
				else if(i==3) {
					float f = Float.parseFloat(line);
					s.pojemnosc=f;
				}
				else if(i==4) {
					int r = Integer.parseInt(line);
					s.rocznik=r;
				}
				else if(i==5) {
					float p = Float.parseFloat(line);
					s.przebieg=p;
				}
				else if(i==6) {
					s.skrzynia=line;
					i=0;
					lista.add(s);
					s = new Samochod(); 	
				}

				line = reader.readLine();
				i++;
			}
			reader.close();
			System.out.println("Wczytano " + lista.size() + " samochodow. (Aby przejœæ do menu naciœnij Enter)");
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("Instrukcja co do menu:");
			System.out.println("Naciœnij 1, aby wyswietliæ listê wszystkich samochodów");
			System.out.println("Naciœnij 2, aby wyœwielkiæ jeden wybrany samochód");
			System.out.println("Naciœnij 3, aby dodaæ samochód do listy");
			System.out.println("Naciœnij 4, aby usun¹æ wybrany samochód");
			System.out.println("Naciœnij 5, aby posortowaæ listê samochodów po marce");
			System.out.println("Naciœnij 6, aby posortowaæ listê samochodów po modelu");
			System.out.println("Naciœnij 7, aby posortowaæ listê samochodów po roczniku");
			System.out.println("Naciœnij 8, aby posortowaæ listê samochodów po pojemnoœci silnika");
			System.out.println("Naciœnij 9, aby posortowaæ listê samochodów po przebiegu");
			System.out.println("Naciœnij 10, aby posortowaæ listê samochodów po skrzyni");
			System.out.println("Naciœnij 11, aby wyœwietliæ listê samochodów nowszych od podanego roku");
			System.out.println("Naciœnij 12, aby zapisaæ listê samochodów do pliku");
			int menu;
			Scanner m = new Scanner(System.in);
			menu = m.nextInt();

			switch(menu) {
			case 1: 
				//wyswietlanie wszystkich
				for(int j=0;j<lista.size();j++) {
					n = lista.get(j);
					n.wyswietl();
				}
				System.out.println("\n Aby kontynuowaæ naciœnij Enter.");
				System.in.read();
				break;
			case 2: 
				//wyswietlanie jednego
		        System.out.println("Podaj numer samochodu, ktory chcesz wyswietlic");
		        int w = scan.nextInt();
				n = lista.get(w-1);
				n.wyswietl();
				System.out.println("\n Aby kontynuowaæ naciœnij Enter.");
				System.in.read();
				break;
			case 3:
				//dodanie nowego samochodu
				Samochod d = new Samochod();
				
				System.out.println("Podaj marke nowego samochodu. (Pamiêtaj o zapisaniu marki z wielkiej litery)");
				d.marka = scan.nextLine();
				scan.nextLine();
				System.out.println("Podaj model. (Model równie¿ zapisz z wielkiej litery)");
				d.model = scan.nextLine();
				System.out.println("Podaj pojemnosc. (U¿yj przecinka nie kropki)");
				d.pojemnosc = scan.nextFloat();
				scan.nextLine();
				System.out.println("Podaj rocznik.");
				d.rocznik = scan.nextInt();
				scan.nextLine();
				System.out.println("Podaj przebieg.");
				d.przebieg = scan.nextFloat();
				scan.nextLine();
				System.out.println("Podaj skrzynie (manualna/automatyczna)");
				d.skrzynia = scan.nextLine();
				
				lista.add(d);
				System.out.println("Dodano samochod "  + d.marka + " " + d.model + " " + d.pojemnosc + " " + d.rocznik + " " + d.przebieg + " " + d.skrzynia);
				System.out.println("\n Aby kontynuowaæ naciœnij Enter.");
				System.in.read();
				break;
			case 4:
				//usuniecie wybranego auta
				System.out.println("Podaj numer samochodu, który chcesz usun¹æ");
				w = scan.nextInt();
				lista.remove(w-1);
				break;
			case 5:
				Collections.sort(lista, new MarkaComparator());
				n = new Samochod();
				for(int j=0;j<lista.size();j++) {
					n = lista.get(j);
					n.wyswietl();
				}
				System.out.println("\n Aby kontynuowaæ naciœnij Enter.");
				System.in.read();
				break;
			case 6:
				Collections.sort(lista, new ModelComparator());
				n = new Samochod();
				for(int j=0;j<lista.size();j++) {
					n = lista.get(j);
					n.wyswietl();
				}
				System.out.println("\n Aby kontynuowaæ naciœnij Enter.");
				System.in.read();
				break;
			case 7:
				Collections.sort(lista, new RocznikComparator());
				n = new Samochod();
				for(int j=0;j<lista.size();j++) {
					n = lista.get(j);
					n.wyswietl();
				}
				System.out.println("\n Aby kontynuowaæ naciœnij Enter.");
				System.in.read();
				break;
			case 8:
				Collections.sort(lista, new PojemnoscComparator());
				n = new Samochod();
				for(int j=0;j<lista.size();j++) {
					n = lista.get(j);
					n.wyswietl();
				}
				System.out.println("\n Aby kontynuowaæ naciœnij Enter.");
				System.in.read();
				break;
			case 9:
				Collections.sort(lista, new PrzebiegComparator());
				n = new Samochod();
				for(int j=0;j<lista.size();j++) {
					n = lista.get(j);
					n.wyswietl();
				}
				System.out.println("\n Aby kontynuowaæ naciœnij Enter.");
				System.in.read();
				break;
			case 10:
				Collections.sort(lista, new SkrzyniaComparator());
				n = new Samochod();
				for(int j=0;j<lista.size();j++) {
					n = lista.get(j);
					n.wyswietl();
				}
				System.out.println("\n Aby kontynuowaæ naciœnij Enter.");
				System.in.read();
				break;
			case 11:
				//wyswietlanie warunkowe
				System.out.println("Program wyswietli wszytkie samochody wyprodukowane po podanym roku. Podaj rok ");
				w = scan.nextInt();
				for(int j=0;j<lista.size();j++) {
					n = lista.get(j);
					if(n.rocznik > w) {
						n.wyswietl();
					}
				}
				System.out.println("\n Aby kontynuowaæ naciœnij Enter.");
				System.in.read();
				break;
			case 12:
				PrintWriter zapis = new PrintWriter("posortowane.txt");
				for(int j=0;j<lista.size();j++) {
					n = lista.get(j);
					zapis.println(n.marka + " " + n.model + " " + n.pojemnosc + " " + n.rocznik + " " + n.przebieg + " " + n.skrzynia);
				}
				zapis.close();
				System.out.println("Zapisano.");
				System.out.println("\n Aby kontynuowaæ naciœnij Enter.");
				System.in.read();
				break;
				
			}
		}
	}

}


		
		
		


		
	
	
	
	
	
	
	
	
		
	





   