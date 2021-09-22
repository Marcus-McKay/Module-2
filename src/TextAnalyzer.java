import java.io.File; 
import java.io.FileNotFoundException;
import java.util.*;

public class TextAnalyzer
{
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/textFile.txt");
        @SuppressWarnings("resource")
		Scanner scan = new Scanner(file);
        /**
         * map to store key value pair
         * key : word
         * val: frequency of the word
         */
        Map<String,Integer> map = new HashMap<String, Integer>(); 
        while (scan.hasNext())
        {
            String val = scan.next(); // read every word in the document
            if(map.containsKey(val) == false) // insert by setting the frequency as 1 if the string is not inserted in the map
                map.put(val,1);
            else // otherwise remove the entry from map and again insert by adding 1 in the frequency
            {
                int count = (int)(map.get(val)); // find the current frequency of the word
                map.remove(val);  // remove the entry from the map
                map.put(val,count+1); // reinsert the word and increase frequency by 1
            }
        }
        Set<Map.Entry<String, Integer>> set = map.entrySet(); // retrieve the map contents
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String, Integer>>(set); // make an array list of entries 
        Collections.sort( sortedList, new Comparator<Map.Entry<String, Integer>>() // sort the array list
        {
            public int compare( Map.Entry<String, Integer> a, Map.Entry<String, Integer> b ) // compare entries and sort them
            {
                return (b.getValue()).compareTo( a.getValue() ); // descending order 
             //	return (a.getValue()).compareTo( b.getValue() ); // ascending order 
            }
        } );
        // print the list
        for(Map.Entry<String, Integer> i:sortedList){
            System.out.println(i.getKey()+" -> "+i.getValue());
        }
    }
}