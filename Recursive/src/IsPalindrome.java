
public class IsPalindrome {
	public static boolean isPalindrome(String s) {
		if(s.length()<=1) {
			return true;
		}
		if(s.charAt(0)!=s.charAt(s.length()-1)) {
			return false;
		}
		else {
			return isPalindrome(s.substring(1, s.length()-1));
		}
	}
}
