import java.util.Comparator;

public class SkrzyniaComparator implements Comparator<Samochod>{
	
	@Override
	public int compare(Samochod s1, Samochod s2) {
		int result = s1.getSkrzynia().compareTo(s2.getSkrzynia());
		if (result == 0) {
			result = s1.getMarka().compareTo(s2.getMarka());
			if (result == 0) {
				return s1.getModel().compareTo(s2.getModel());
			}
		}
		return result;
	}

}