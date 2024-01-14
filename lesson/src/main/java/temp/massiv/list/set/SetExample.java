package temp.massiv.list.set;

import temp.massiv.list.set.dto.User;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set<String> sphetofor = Set.of("green","yellow","red");
        System.out.println(sphetofor);

        Set<String>sphetafor2 = new HashSet<>(Set.of("green","yellow","red"));
        sphetafor2.add("green");
        System.out.println(sphetafor2);


        Set<User> users= new HashSet<>(3);
        users.add(new User(1L,"Max"));
        users.add(new User(2L,"Olga"));
        users.add(new User(3L,"Petr"));
        System.out.println(users);

      //  Set<User> users2 = new TreeSet<>();

        Set<User> users1 = new TreeSet<>(new Comparator<User>() {    //сортируем с помощью компаратора
            @Override
            public int compare(User o1, User o2) {
                return o2.getId().compareTo(o1.getId());    //сортировка по id
               // return o2.getName().compareTo(o1.getName());    // сортировка по name
            }
        });
        users1.add(new User(1L,"Max"));
        users1.add(new User(2L,"Olga"));
        users1.add(new User(3L,"Petr"));
        System.out.println(users1);


        Set<User> users3= new LinkedHashSet<>(3);  // линкин хашсет будет выводить список в той же последовательности как мы его записали
        users3.add(new User(1L,"Max"));
        users3.add(new User(2L,"Olga"));
        users3.add(new User(3L,"Petr"));
        System.out.println(users3);
    }
}
