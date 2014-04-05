package strings;

/** http://www.careercup.com/question?id=4883670854795264
 * Given a list with duplicate values find the first unique elements in it. 

for eg: BH BH F AL HJ AL HJ PK 
so answer is F

 * @author sudheerl
 * protected string GetFirstUnique(List<string> baseList)
    {
        Dictionary<string,int> single = new Dictionary<string,int>();
        Hashtable multiple = new Hashtable();
        string retVal = null;
        int minIndex = int.MaxValue;

        for (int index = 0; index < baseList.Count; index++)
        {
            string str = baseList[index];
            if (!multiple.ContainsKey(str))
            {
                if (single.ContainsKey(str))
                {
                    single.Remove(str);
                    multiple.Add(str, 0);
                }
                else
                {
                    single.Add(str, index);
                }
            }
        }
        
        foreach (var e in single)
        {
            if (e.Value < minIndex)
                retVal = e.Key;
        }
        return retVal;
    }
 *
 */

public class FindFirstUniqueElementsFromDuplicateLIst {

}
