package temp.massiv.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {

        List<String> colors =new ArrayList<>( List.of("red","green","blue","yellow"));
        colors.add(3,"white");
        System.out.println(colors);

        System.out.println(colors.get(colors.size()-1));
        System.out.println(colors.indexOf("green"));

        List<Boolean> flags = new LinkedList<>();
        flags.add(false);
        flags.add(true);
        flags.add(false);
        flags.add(true);
        flags.add(null);

        System.out.println(flags);
        flags.set(4,false);
        System.out.println(flags);


    }



}
