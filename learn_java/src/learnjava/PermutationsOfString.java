package learnjava;

import java.util.*;

public class PermutationsOfString {



	    public static void main(String[] args) {
	        String a = "abcd";
	        for(String s: all_perm(a)) {
	            System.out.println(s);
	        }
	    }

	    public static Set<String> concat(String c, Set<String> lst) {
	        HashSet<String> ret_set = new HashSet<String>();
	        for(String s: lst) {
	            ret_set.add(c+s);
	        }
	        return ret_set;
	    }

	    public static HashSet<String> all_perm(String a) {
	        HashSet<String> set = new HashSet<String>();
	        if(a.length() == 1) {
	            set.add(a);
	        } else {
	            for(int i=0; i<a.length(); i++) {
	                set.addAll(concat(a.charAt(i)+"", all_perm(a.substring(0, i)+a.substring(i+1, a.length()))));
	            }
	        }
	        return set;
	    }
	}