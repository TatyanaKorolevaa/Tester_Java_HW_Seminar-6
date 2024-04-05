import java.util.*;


public class PhoneBook {
    private int _ai = 0;
    private static HashMap<Integer, PhoneInfo> phoneBook = new HashMap<>();
    public ArrayList<Integer> sortedKeys = new ArrayList<>();

    public void add(String unitName, Integer phoneNum) {
        Boolean[] isExists = { false };
        phoneBook.forEach((k,v) -> {
            String name = v.getName();
            ArrayList<Integer> phones = v.getPhones();
            if (name.equals(unitName)) {
                phones.add(phoneNum);
                isExists[0] = true;
            }
        });
        if (!isExists[0]) {
            phoneBook.put(++this._ai, new PhoneInfo(unitName, phoneNum));
        }
        this.wasAdded(this._ai);
    }

    public static HashMap<Integer, PhoneInfo> getPhoneBook() {
        return phoneBook;
    }

    public void wasAdded(int idx) {
        String str = new String(
            String.format("У контакта %s с id(%d) номер телефона %d", 
                phoneBook.get(idx).getName(), 
                idx, 
                phoneBook.get(idx).getPhoneNumberCounter()
            )
        );
        System.out.println(str);
    }
}
