package learnjava;

//http://javabuzzpgms.blogspot.in/2012/05/remove-any-given-character-from-string.html

public class RemoveCharFromString {

	public static void main(String[] args) {

		System.out.println(removeChar("HI 12a Buddy", 'a'));
		// String str =;

	}

	public static String removeChar(String str, char c) {

		if (str == null) {
			return "";
		}

		StringBuilder strBuilder = new StringBuilder();
//http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=321859
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == c) {
				continue;
			}
			strBuilder.append(ch);
		}

		return strBuilder.toString();
	}

}
