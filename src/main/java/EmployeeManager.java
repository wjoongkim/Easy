import java.util.ArrayList;

public class EmployeeManager implements IEmployeeManager {
    ArrayList<Employee> employees;

    public EmployeeManager(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee add(String args) {
        String[] tokens = args.split(",");

        String fullName = tokens[1];
        String[] nameTokens = fullName.split(" ");
        String firstName = nameTokens[0];
        String lastName = nameTokens[1];

        String fullPhoneNumber = tokens[3];
        String[] phoneNumberTokens = fullPhoneNumber.split("-");
        String middlePhoneNumber = phoneNumberTokens[1];
        String lastPhoneNumber = phoneNumberTokens[2];

        String joinYear = tokens[0].substring(0, 2);

        final int BASE_YEAR = 25;
        if (Integer.parseInt(joinYear) > BASE_YEAR) {
            joinYear = "19" + joinYear;
        } else {
            joinYear = "20" + joinYear;
        }

        Employee employee = new Employee(
                tokens[0], new Name(fullName, firstName, lastName), tokens[2]
                , new Phone(fullPhoneNumber, middlePhoneNumber, lastPhoneNumber)
                , new Birthday(tokens[4]), tokens[5], Integer.parseInt(joinYear));

        employees.add(employee);

        return employee;
    }

    @Override
    public void delete(String[] args) {

    }

    @Override
    public ArrayList<Employee> search(String args) {

        return null;
        //SCH,-p,-d, ,birthday,04
        //SCH, , , ,employeeNum,79110836\
        //SCH,-p, , ,certi,PRO
        //SCH, , , ,certi,ADV


    }

    @Override
    public void modify(String[] args) {

    }
}
