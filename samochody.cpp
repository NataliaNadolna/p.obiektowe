#include<iostream>
#include<fstream>
#include<conio.h>
#include<cstdlib>
#include<vector>
#include<string>

using namespace std;

class Samochod {
public:
	string marka;
	string model;
	float pojemnosc;
	int rocznik;
	float przebieg;
	string skrzynia;

	void wyswietl() {
		cout << marka << " ";
		cout << model << " ";
		cout << pojemnosc << " ";
		cout << rocznik << " ";
		cout << przebieg << " ";
		cout << skrzynia << endl;
	}
	void dodaj() {
		cout << "Podaj marke nowego samochodu" << endl;
		cin >> marka;
		cout << "Podaj model" << endl;
		cin >> model;
		cout << "Podaj pojemnosc" << endl;
		cin >> pojemnosc;
		cout << "Podaj rocznik" << endl;
		cin >> rocznik;
		cout << "Podaj przebieg" << endl;
		cin >> przebieg;
		cout << "Podaj skrzynia" << endl;
		cin >> skrzynia;
	}
	void zapisz(ofstream& plik) {
		plik << marka << " " << model << " " << pojemnosc << " " <<
			rocznik << " " << przebieg << " " << skrzynia << endl;
	}

private:
	friend ostream& operator<< (ostream& wyjscie, Samochod& s);
	friend istream& operator>> (istream& wejscie, Samochod& s);
};
ostream& operator<< (ostream& plik, Samochod& s) {
	return plik << s.marka << " " << s.model << " " << s.pojemnosc << " " <<
		s.rocznik << " " << s.przebieg << " " << s.skrzynia << endl;
}
istream& operator>> (istream& plik, Samochod& s) {
	return plik >> s.marka >> s.model >> s.pojemnosc >>
		s.rocznik >> s.przebieg >> s.skrzynia;
}
int main() {

	ofstream wyjscie;
	ifstream wejscie;
	vector <Samochod> spis;
	Samochod nowy, usunauto;
	wejscie.open("samochody.txt");
	wyjscie.open("po_zapisie.txt");
	int r;

	int menu_c = 0;
	int menu_min = 0;
	int menu_max = 12;
	int input;
	while (true) {
		system("cls");
		cout << (menu_c == 0 ? "> " : "  ") << "Wczytaj dane z pliku" << endl;
		cout << (menu_c == 1 ? "> " : "  ") << "Dodaj nowy samochod" << endl;
		cout << (menu_c == 2 ? "> " : "  ") << "Usun wybrany samochod" << endl;
		cout << (menu_c == 3 ? "> " : "  ") << "Wyswietl liste samochodow" << endl;
		cout << (menu_c == 4 ? "> " : "  ") << "Wyswietlanie danych wybranego samochodu" << endl;
		cout << (menu_c == 5 ? "> " : "  ") << "Sortowanie rosnace po marce" << endl;
		cout << (menu_c == 6 ? "> " : "  ") << "Sortowanie rosnace po modelu" << endl;
		cout << (menu_c == 7 ? "> " : "  ") << "Sortowanie rosnace po roczniku" << endl;
		cout << (menu_c == 8 ? "> " : "  ") << "Sortowanie rosnace po przebiegu" << endl;
		cout << (menu_c == 9 ? "> " : "  ") << "Sortowanie rosnace po skrzyni biegow" << endl;
		cout << (menu_c == 10 ? "> " : "  ") << "Wyswietlanie samochodow nowszych od podanego roku" << endl;
		cout << (menu_c == 11 ? "> " : "  ") << "Zapisz do pliku" << endl;
		cout << (menu_c == 12 ? "> " : "  ") << "Zamknij program" << endl;
		input = _getch();
		if (input == 224)
			switch (_getch()) {
			case 80: if (menu_c < menu_max) menu_c++; break;
			case 72: if (menu_c > menu_min) menu_c--; break;
			}
		if (input == 13)
			switch (menu_c) {

			case 0: //wczytanie danych z pliku i zamiana na wektor
				while (wejscie >> nowy) {
					spis.push_back(nowy);
				}
				break;

			case 1: //dodawanie nowego samochodu
				nowy.dodaj();
				spis.push_back(nowy);
				break;

			case 2: //ususiecie wybranego samochodu
				int u;
				cout << "Podaj numer samochodu, ktory chcesz usunac";
				cin >> u;
				spis.erase(spis.begin() + u);
				break;

			case 3: //wyswietlanie listy samochodow
				for (int i = 0; i < spis.size(); i++) {
					spis[i].wyswietl();
				}
				system("pause");
				break;

			case 4: //wyswietlanie danych wybranego samochodu
				cout << "Podaj numer samochodu, ktory chcesz wyswietlic ";
				cin >> r;
				spis[r].wyswietl();
				system("pause");
				break;

			case 5: //sortowanie po wybranym parametrze - marka
				int czy_byla_zmiana;

				do {
					czy_byla_zmiana = 0;
					for (int i = 0; i < (spis.size() - 1); i++) {
						if (spis[i].marka > spis[i + 1].marka) {
							Samochod j = spis[i];
							spis[i] = spis[i + 1];
							spis[i + 1] = j;
							czy_byla_zmiana = 1;
						}
					}
				} while (czy_byla_zmiana);
				break;

			case 6: //model
				do {
					czy_byla_zmiana = 0;
					for (int i = 0; i < (spis.size() - 1); i++) {
						if (spis[i].model > spis[i + 1].model) {
							Samochod j = spis[i];
							spis[i] = spis[i + 1];
							spis[i + 1] = j;
							czy_byla_zmiana = 1;
						}
					}
				} while (czy_byla_zmiana);
				break;

			case 7: //rocznik
				do {
					czy_byla_zmiana = 0;
					for (int i = 0; i < (spis.size() - 1); i++) {
						if (spis[i].rocznik > spis[i + 1].rocznik) {
							Samochod j = spis[i];
							spis[i] = spis[i + 1];
							spis[i + 1] = j;
							czy_byla_zmiana = 1;
						}
					}
				} while (czy_byla_zmiana);
				break;

			case 8: //przebieg
				do {
					czy_byla_zmiana = 0;
					for (int i = 0; i < (spis.size() - 1); i++) {
						if (spis[i].przebieg > spis[i + 1].przebieg) {
							Samochod j = spis[i];
							spis[i] = spis[i + 1];
							spis[i + 1] = j;
							czy_byla_zmiana = 1;
						}
					}
				} while (czy_byla_zmiana);
				break;

			case 9: //skrzynia
				do {
					czy_byla_zmiana = 0;
					for (int i = 0; i < (spis.size() - 1); i++) {
						if (spis[i].skrzynia > spis[i + 1].skrzynia) {
							Samochod j = spis[i];
							spis[i] = spis[i + 1];
							spis[i + 1] = j;
							czy_byla_zmiana = 1;
						}
					}
				} while (czy_byla_zmiana);
				break;

			case 10: //rok mniejszy od
				cout << "Program wyswietli wszytkie samochody wyprodukowane po podanym roku. Podaj rok ";
				cin >> r;
				for (int j = 0; j < spis.size(); j++) {
					if (spis[j].rocznik > r) {
						spis[j].wyswietl();
					}
				} system("pause");
				break;
			case 11: //zapis do pliku
				for (int i = 0; i < spis.size(); i++) {
					spis[i].zapisz(wyjscie);
				}
				break;
			case 12: //zamknij program
				exit(0);
			}
	}
	wejscie.close();
	wyjscie.close();
	return 0;
}