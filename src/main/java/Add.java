import java.util.Map;

public class Add extends CRUDManager {

    public Add(Map<String, Employee> employeeMap) {
        super(employeeMap);
    }

    @Override
    String calc(String args) {
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

}
