import java.util.*;
import java.util.stream.Collectors;

public class Programm {
    public static void main(String[] args) {
        String name1;
        String name2;
        int phone1;
        int phone2;
        

        if (args.length == 0) {
            name1 = "Митрофанова Ирина";
            name2 = "Васильев Олег";
            phone1 = 6532244;
            phone2 = 6342288;
            
        } else {
            name1 = args[0];
            name2 = args[1];
            phone1 = Integer.parseInt(args[2]);
            phone2 = Integer.parseInt(args[3]);
        }
        
        PhoneBook myPhoneBook = new PhoneBook();
        
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone2);
        myPhoneBook.add(name2, phone1);
        myPhoneBook.add(name2, phone2);
        
        System.out.println();

        Map<Integer, PhoneInfo> pb = PhoneBook.getPhoneBook();
        LinkedHashMap<Integer, PhoneInfo> lhm = pb.entrySet().stream().sorted(
            (e1, e2) -> Integer.compare(
                e2.getValue().getPhoneNumberCounter(), 
                e1.getValue().getPhoneNumberCounter()
            )
        ).collect(
            Collectors.toMap(
                Map.Entry::getKey, 
                Map.Entry::getValue, 
                (e1, e2) -> e1, 
                LinkedHashMap::new
            )
        );
        
        for (var item : lhm.entrySet()) {
            System.out.println(item.toString());
        }
    }
}
