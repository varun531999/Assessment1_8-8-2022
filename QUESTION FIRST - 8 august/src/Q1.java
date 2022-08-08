import java.util.HashMap;

public class Q1 {

	public static void main(String[] args) {
		CountryCapital countryMap = new CountryCapital();

		countryMap.saveCountryCapital("India", "Delhi");
		countryMap.saveCountryCapital("Srilanka", "Colombo");
		countryMap.saveCountryCapital("Pakistan", "Lahore");
		countryMap.saveCountryCapital("Newzealand", "Wellington");
		countryMap.saveCountryCapital("Bangladesh", "Dhaka");
		
		
		
		System.out.println(countryMap.getCapital("India"));
		System.out.println(countryMap.getCountry("Lahore"));
		System.out.println(countryMap.toArrayList());
		
		HashMap<String, String> M2 = countryMap.swapKeyValue();
		System.out.println(M2);
	}

}