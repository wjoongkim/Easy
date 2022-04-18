import java.util.ArrayList;
import java.util.Map;

public class Add extends CRUDManager {

    @Override
    String calc(Map<String, Employee> employeeMap, String args) {
        String[] tokens = args.split(",");

        String fullName = tokens[5];
        String[] nameTokens = fullName.split(" ");
        String firstName = nameTokens[0];
        String lastName = nameTokens[1];

        String fullPhoneNumber = tokens[7];
        String[] phoneNumberTokens = fullPhoneNumber.split("-");
        String middlePhoneNumber = phoneNumberTokens[1];
        String lastPhoneNumber = phoneNumberTokens[2];

        String joinYear = "19" + tokens[4].substring(0, 2);
        int intJoinYear = Integer.parseInt(joinYear);
        final int FIRST_YEAR_OF_EMPLOYMENT = 1969;

        if (intJoinYear < FIRST_YEAR_OF_EMPLOYMENT) {
            intJoinYear += 100;
        }

        employeeMap.put(tokens[4], new Employee(
                tokens[4], new Name(fullName, firstName, lastName), tokens[6]
                , new Phone(fullPhoneNumber, middlePhoneNumber, lastPhoneNumber)
                , new Birthday(tokens[8]), tokens[9], intJoinYear * 1000000 + Integer.parseInt(tokens[4].substring(2))));

        return null;
    }

    ArrayList<Employee> employees;

    public Add() {

    }

    public Add(ArrayList<Employee> employees) {
        this.employees = employees;
    }


    public Employee Run(String input) {

        String[] tokens = input.split(",");

        String fullName = tokens[5];
        String[] nameTokens = fullName.split(" ");
        String firstName = nameTokens[0];
        String lastName = nameTokens[1];

        String fullPhoneNumber = tokens[7];
        String[] phoneNumberTokens = fullPhoneNumber.split("-");
        String middlePhoneNumber = phoneNumberTokens[1];
        String lastPhoneNumber = phoneNumberTokens[2];

        String joinYear = "19" + tokens[4].substring(0, 2);
        int intJoinYear = Integer.parseInt(joinYear);
        final int FIRST_YEAR_OF_EMPLOYMENT = 1969;

        if (intJoinYear < FIRST_YEAR_OF_EMPLOYMENT) {
            intJoinYear += 100;
        }

        Employee employee = new Employee(
                tokens[4], new Name(fullName, firstName, lastName), tokens[6]
                , new Phone(fullPhoneNumber, middlePhoneNumber, lastPhoneNumber)
                , new Birthday(tokens[8]), tokens[9], intJoinYear * 1000000 + Integer.parseInt(tokens[4].substring(2)));

        employees.add(employee);

        return employee;
    }
}
