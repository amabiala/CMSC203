
public class HolidayBonus {
	/**
	 * calculate the bonus of each store
	 * @param data two dimensional array of store sales
	 * @param highBonus bonus for the highest store in a category
	 * @param lowBonus bonus for the lowest store in a category
	 * @param other bonus for all other stores in a category
	 * @return an array of the bonus for each store
	 */
	public double[] CalculateHolidayBonus(double[][]data, double highBonus, double lowBonus, double other){
		double[]bonus=new double [data.length];
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data[i].length;j++){
				double lowest =TwoDimRaggedArrayUtility.getLowestInColumn(data, i);
				double highest=TwoDimRaggedArrayUtility.getHighestInColumn(data, i);
				if(data[j][i]!=lowest && data[j][i]!=highest) {
					data[j][i]=other;
				}
				else if(data[j][i]==lowest) {
					data[j][i]=lowBonus;
				}
				else {
					data[j][i]=highBonus;
				}
				bonus[i]=data[i][j];
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
	public double calculateTotalHolidayBonus(double[][]data, double highBonus, double lowBonus, double other) {
		double[]bonus=new double [data.length];
		double totalBonus=0;
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data[i].length;j++){
				double lowest =TwoDimRaggedArrayUtility.getLowestInColumn(data, i);
				double highest=TwoDimRaggedArrayUtility.getHighestInColumn(data, i);
				if(data[j][i]!=lowest && data[j][i]!=highest) {
					data[j][i]=other;
				}
				else if(data[j][i]==lowest) {
					data[j][i]=lowBonus;
				}
				else {
					data[j][i]=highBonus;
				}
				bonus[i]=data[i][j];
				totalBonus+=bonus[i];
			}
			
		}
		return totalBonus;
	}
}