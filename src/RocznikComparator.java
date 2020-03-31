import java.util.Comparator;

public class RocznikComparator implements Comparator<Samochod>{
	
	@Override
	public int compare(Samochod s1, Samochod s2) {
		return Integer.compare(s1.getRocznik(), s2.getRocznik());
		
	}
}
