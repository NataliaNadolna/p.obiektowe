import java.util.Comparator;

public class ModelComparator implements Comparator<Samochod>{
	
	@Override
	public int compare(Samochod s1, Samochod s2) {
		int result = s1.getModel().compareTo(s2.getModel());
		return result;
	}

}