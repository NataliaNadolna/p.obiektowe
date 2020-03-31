import java.util.Comparator;

public class MarkaComparator implements Comparator<Samochod>{
	
	@Override
	public int compare(Samochod s1, Samochod s2) {
		int result = s1.getMarka().compareTo(s2.getMarka());
		if (result == 0) {
			result = s1.getModel().compareTo(s2.getModel());
		}
		return result;
	}

}
