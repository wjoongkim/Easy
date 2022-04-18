import java.util.ArrayList;
import java.util.Map;

public class Add extends CRUDManager {

    @Override
    String calc(Map<String, Employee> employeeMap, String args) {
        String[] tokens = args.split(",");

        final int EMPNO = 4;
        final int NAME = 5;
        final int CL = 6;
        final int PHONE = 7;
        final int BIRTHDAY = 8;
        final int CERTI = 9;

        String joinYear = "19" + tokens[EMPNO].substring(0, 2);
        int intJoinYear = Integer.parseInt(joinYear);
        final int FIRST_YEAR_OF_EMPLOYMENT = 1969;

        if (intJoinYear < FIRST_YEAR_OF_EMPLOYMENT) {
            intJoinYear += 100;
        }

        final int JOINYEAR = intJoinYear * 1000000 + Integer.parseInt(tokens[EMPNO].substring(2));

        employeeMap.put(tokens[EMPNO], new Employee(tokens[EMPNO], new Name(tokens[NAME]), tokens[CL], new Phone(tokens[PHONE]), new Birthday(tokens[BIRTHDAY]), tokens[CERTI], JOINYEAR));

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
                tokens[4], new Name(fullName), tokens[6]
                , new Phone(fullPhoneNumber)
                , new Birthday(tokens[8]), tokens[9], intJoinYear * 1000000 + Integer.parseInt(tokens[4].substring(2)));

        employees.add(employee);

        return employee;
    }
}
