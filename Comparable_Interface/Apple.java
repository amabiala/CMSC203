
public class Apple implements Comparable<Apple> {
	private String variety;
	
	private int weight;
	@Override
	public int compareTo(Apple o) {
//		if (this.weight<o.weight) {
//			return -1;
//		}
//		if(this.weight==o.weight) {
//			return 0;
//		}
//		else {
//			return 1;
//		}
//		return Integer.compare(this.weight, o.weight);
		int result=this.variety.compareTo(o.variety);
		
		if(result==0) {
			result=Integer.compare(this.weight, o.weight);
		}
//		if(result==0) {
//			result=this.color.compareTo(o.color);
//		}
		return result;
	}
	
}
