package learningSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, "foo", "bar", "baz");

        System.out.println("----- print set -----");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        List<String> list = new ArrayList<>();
        list.add("foo");
        list.add("bar");
        list.add("baz");

        System.out.println("----- print list -----");
        list.forEach(l -> {
            System.out.println(l);
        });

    }

}
