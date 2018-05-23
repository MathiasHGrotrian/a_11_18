package Chapter11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Exercise18
{
    /*
    Write a method called reverse that accepts a map from strings to strings as a parameter
     and returns a new map that is the reverse of the original. The reverse of a map is a new
      map that uses the values from the original as its keys and the keys from the original as
       its values. Since a map’s values need not be unique but its keys must be, you should have
        each value map to a set of keys. In other words, if the original map maps keys of type K
         to values of type V, the new map should map keys of type V to values that are Sets
          containing elements of type K. For example, the map
           {42=Marty, 81=Sue, 17=Ed, 31=Dave, 56=Ed, 3=Marty, 29=Ed} has a reverse of {Marty=[42, 3], Sue=[81], Ed=[17, 56, 29], Dave=[31]}.
            (The order of the keys and values does not matter.)
     */

    public static void main(String[] args)
    {
        Map<String, String> value = new HashMap<>();
        value.put("42", "Marty");
        value.put("81","Sue");
        value.put("17","Ed");
        value.put("31" ,"Dave");
        value.put("56", "Ed");
        value.put("3","Marty");
        value.put("29","Ed");
        System.out.println(reverse(value));
    }

    public static Map<String, Set<String>> reverse(Map<String, String> map)
    {
        Map<String, Set<String>> value = new HashMap<>();

        for (Map.Entry<String, String> m1: map.entrySet())
        {
            if(value.containsKey(m1.getValue()))
            {
                Set<String> set = value.get(m1.getValue());
                set.add(m1.getKey());
                value.put(m1.getValue(), set);
            }else
            {
                Set<String> set = new HashSet<>();
                set.add(m1.getKey());
                value.put(m1.getValue(), set);
            }

        }

        return value;
    }

}
