
public class HolidayBonus {
	/**
	 * calculate the bonus of each store
	 * @param data two dimensional array of store sales
	 * @param highBonus bonus for the highest store in a category
	 * @param lowBonus bonus for the lowest store in a category
	 * @param other bonus for all other stores in a category
	 * @return an array of the bonus for each store
	 */
	public static double[] calculateHolidayBonus(double[][]data, double highBonus, double lowBonus, double other){
		double[]bonus=new double [data.length];
		for(int j=0;j<data.length;j++) {
			for(int i=0;i<data[j].length;i++){
				double lowest =TwoDimRaggedArrayUtility.getLowestInColumn(data, i);
				double highest=TwoDimRaggedArrayUtility.getHighestInColumn(data, i);
				if(data[j][i]!=lowest && data[j][i]!=highest) {
					bonus[j]+=other;
				}
				else if(data[j][i]==lowest) {
					bonus[j]+=lowBonus;
				}
				else {
					bonus[j]+=highBonus;
				}
				//bonus[i]=data[j][i];
			}
			
		}
		return bonus;
	}
	/**
	 * Calculates the total holiday bonuses
	 *  @param data two dimensional array of store sales
	 * @param highBonus bonus for the highest store in a category
	 * @param lowBonus bonus for the lowest store in a category
	 * @param other bonus for all other stores in a category
	 * @return an array of the bonus for each store
	 */
	public static double calculateTotalHolidayBonus(double[][]data, double highBonus, double lowBonus, double other) {
		double totalBonus=0;
		double[]ar=HolidayBonus.calculateHolidayBonus(data, highBonus, lowBonus, other);
		for(int j=0;j<ar.length;j++) {
			totalBonus+=ar[j];
		}
		return totalBonus;
	}
}
