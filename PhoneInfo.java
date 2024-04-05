import java.util.*;


public class PhoneInfo {
    private String _unit_name;
    private ArrayList<Integer> _phone_number = new ArrayList<>();

    PhoneInfo(String name, int num) {
        _unit_name = name;
        _phone_number.add(num);
    }

    public int getPhoneNumberCounter() {
        return this.getPhones().size();
    }

    public String toString() {
        return String.format("{%s:%s}", this._unit_name, this._phone_number.toString());
    }

    public String getName() {
        return this._unit_name;
    }

    public ArrayList<Integer> getPhones() {
        return this._phone_number;
    }
}
