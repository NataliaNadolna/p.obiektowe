import java.util.Comparator;

public class PrzebiegComparator implements Comparator<Samochod>{
	
	@Override
	public int compare(Samochod s1, Samochod s2) {
		return Float.compare(s1.getPrzebieg(), s2.getPrzebieg());
		
	}
}