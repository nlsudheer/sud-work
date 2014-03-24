package advanced;


/* http://www.careercup.com/question?id=4773069298073600
 * Using a Java data structure, eliminate all unnecessary/stop words from a string. Assume you are given the string 
"To be or not to be - that is the question: Whether it is nobler in the mind to suffer, the slings and arrows of outrageous fortune. Or to take up arms against a sea of troubles, and by opposing end them" 
The unnecessary words to remove are "a", "be", "to", "the", "that", "this", "or" 
So the resulting string should be like this 
"not - is question: Whether it is nobler in mind suffer…

public static string EliminateStopWords(string val)
        {
            var stopWords = new HashSet<string>() { "a", "be", "to", "the", "that", "this", "or" };
            var arrVal = val.Split(' ');
            var j = 0;
            for (var i = 0; i < arrVal.Length; i++)
            {
                if (!stopWords.Contains(arrVal[i].ToLower()))
                {
                    arrVal[j] = arrVal[i];
                    j++;
                }
            }
            return string.Join(" ", arrVal, 0, j);
        }
        
        import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;


public class UnusedWords {
   public static void main(String[] args) {
      String s= "To be or not to be - that is the question: Whether it is nobler in the mind to suffer, the slings and arrows of outrageous fortune. Or to take up arms against a sea of troubles, and by opposing end them";
           StringTokenizer st = new StringTokenizer(s," ");
            List<String> ls = new ArrayList<>();
       
         HashSet<String >  hst =  new HashSet<String >(); 
         hst.add("a" );
         hst.add("be");
         hst.add("that" );
         hst.add("the" );
         hst.add("this" );
         hst.add( "or" );
         hst.add( "to" );
  
         
  while (st.hasMoreTokens()){
     String Currentword = st.nextToken();
     if(!hst.contains(Currentword.toLowerCase())){
        
        ls.add(Currentword.toLowerCase());
        
     }  
  }
      for(String srt:ls){
         System.out.println(srt.toString());
   
         
      }
   }

}
 * 
 */

public class EliminateWordsInAString {

}
