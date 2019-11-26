
public interface Sellable {
	int DEFAULT_PER=3;
	public abstract double sellWithDiscount(int per);
	public abstract String sellInternational(String country);
}
