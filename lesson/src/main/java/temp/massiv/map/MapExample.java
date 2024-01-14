package temp.massiv.map;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer,String> region = new HashMap<>();
        region.put(63,"Samara");
        region.put(77,"Moscow");
        region.put(78,"Sankt.Peterburg");
        region.put(100,null);
        System.out.println(region);

        System.out.println(region.get(62));

        String key = region.get(100); // не верное сравнение ключей если в мапе присутствуют null зачения
        if(key== null){
            System.out.println("no such value exists!");
        }

        if(!region.containsKey(100)){    //правильно так производить поиск ключей если в мапе присутствуют null зачения
        System.out.println("no such value exists!");
       }
        System.out.println("------------");

        for(Map.Entry<Integer,String> entry:region.entrySet()){
            System.out.println(entry.getKey()+ " "+ entry.getValue());
        }

        Map<Integer,String> namesDictionery = Map.of(1,"maxim",2,"Vitaly");
        String name = namesDictionery.getOrDefault(1,"");
        if("maxim".equals(name)){
            System.out.println("авторизация прошла успешна");
        }
    }
}
