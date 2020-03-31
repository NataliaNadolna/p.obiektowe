import java.util.Comparator;

public class PojemnoscComparator implements Comparator<Samochod>{
	
	@Override
	public int compare(Samochod s1, Samochod s2) {
		return Float.compare(s1.getPojemnosc(), s2.getPojemnosc());
		
	}
}