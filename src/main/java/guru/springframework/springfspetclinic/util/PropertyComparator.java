package guru.springframework.springfspetclinic.util;

import java.util.Comparator;
import java.util.List;

/**
 * Utility class for sorting collections by property values.
 */
public class PropertyComparator {

    /**
     * Sorts a list of objects that have a getName() method by their name property.
     * 
     * @param <T> the type of objects in the list that have a getName() method
     * @param list the list to sort
     */
    public static <T> void sort(List<T> list) {
        list.sort(Comparator.comparing(obj -> {
            try {
                return (String) obj.getClass().getMethod("getName").invoke(obj);
            } catch (Exception e) {
                return "";
            }
        }));
    }
}