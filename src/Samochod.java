
public class Samochod{
	
	String marka;
	String model;
	float pojemnosc;
	int rocznik;
	float przebieg;
	String skrzynia;
	
	void wyswietl() {
		System.out.println(marka + " " + model + " " + pojemnosc + " " + rocznik + " " + przebieg + " " + skrzynia);
	}
	
	/*@Override
	public int compareTo(Samochod o) {
		int result = this.marka.compareTo(o.marka);
		if (result == 0) {
			return this.model.compareTo(o.model);
		}
		return result;
	}*/
	
	
	public Samochod(String marka, String model, int rocznik, float pojemnosc, float przebieg, String skrzynia){
        this.marka=marka;
        this.model=model;
        this.pojemnosc=pojemnosc;
        this.rocznik=rocznik;
        this.przebieg=przebieg;
        this.skrzynia=skrzynia;
    }
	
	public Samochod() {
	}

	public String getMarka() {
	    return marka;
	  }

	  public void setMarka(String marka) {
	    this.marka = marka;
	  }

	  public String getModel() {
	    return model;
	  }

	  public void setModel(String model) {
	    this.model = model;
	  }
	  
	  public void setPojemnosc(float pojemnosc) {
		  this.pojemnosc = pojemnosc;
	  }
	  
	  public float getPojemnosc() {
		  return pojemnosc;
	  }

	  public int getRocznik() {
	    return rocznik;
	  }

	  public void setRocznik(int rocznik) {
	    this.rocznik = rocznik;
	  }
	  
	  public float getPrzebieg() {
		  return przebieg;
	  }
	  
	  public void setPrzebieg(float przebieg) {
		  this.przebieg = przebieg;
	  }
	  
	  public String getSkrzynia() {
		  return skrzynia;
	  }
	  
	  public void setSkrzynia(String skrzynia) {
		  this.skrzynia = skrzynia;
	  }


	  

	  public String toString() {
	    StringBuffer buffer = new StringBuffer();
	    buffer.append(marka);
	    buffer.append("\n");
	    buffer.append(model);
	    buffer.append("\n");
	    buffer.append(pojemnosc);
	    buffer.append("\n");
	    buffer.append(rocznik);
	    buffer.append("\n");
	    buffer.append(przebieg);
	    buffer.append("\n");
	    buffer.append(skrzynia);
	    buffer.append("\n");

	    return buffer.toString();
	  }
	

}