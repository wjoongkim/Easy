import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;


public class EmployeeManager implements IEmployeeManager{
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

        SimpleDateFormat dtBirthFormat = new SimpleDateFormat("yyyyMMdd");
        Date dtBirth = null;
        try {
            dtBirth = dtBirthFormat.parse(tokens[4]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String joinYear = tokens[0].substring(0,2);

        if(Integer.parseInt(joinYear) > 25) {
            joinYear = "19" + joinYear;
        }
        else {
            joinYear = "20" + joinYear;
        }

        SimpleDateFormat dtJoinYearFormat = new SimpleDateFormat("yyyy");
        Date dtJoinYear = null;
        try {
            dtJoinYear = dtJoinYearFormat.parse(joinYear);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Employee employee = new Employee(
                  tokens[0],new Name(fullName,firstName,lastName),tokens[2]
                , new Phone(fullPhoneNumber,middlePhoneNumber,lastPhoneNumber)
                , dtBirth, tokens[5],dtJoinYear);

        employees.add(employee);
        return employee;
    }

    @Override
    public void delete(String[] args) {

    }

    @Override
    public void search(String[] args) {

    }

    @Override
    public void modify(String[] args) {

    }
}
