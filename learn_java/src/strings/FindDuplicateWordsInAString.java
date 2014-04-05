package strings;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * http://howtodoinjava.com/2012/11/09/how-to-find-duplicate-words-in-a-string-in-java/
 * @author sudheerl
 *
 */
public class FindDuplicateWordsInAString {
   
   @SuppressWarnings("unchecked")
   public static void main(String[] args) {
      // Using Collections
       String text = "a r b k c d se f g a d f s s f d s ft gh f ws w f v x s g h d h j j k f sd j e wed a d f";

       List<String> list = Arrays.asList(text.split(" "));

       Set<String> uniqueWords = new HashSet<String>(list);
       for (String word : uniqueWords) {
           System.out.println(word + ": " + Collections.frequency(list, word));
       }
   /** without collections
    * String[] words = sentence.split( sentense );
int length = words.length();
for(int i = 0; i < length; i++)
{
for(int j = 0; j < length; j++)
{
if(words[i].equalsIgnoreCase(words[j]))
{
System.out.printf(Ò%s %sÓ, word[i], word[j]);
}
}
}
    */
   
   String words[] = {"the", "cat", "in", "the", "hat" };
   HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();
   for (String w : words) {
   Integer i = (Integer) wordCounts.get(w);
   if (i == null)
   wordCounts.put(w, 1);
   else
   wordCounts.put(w, i + 1);
   }
}
}


