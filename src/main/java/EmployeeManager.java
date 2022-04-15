import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.util.stream.Collectors;


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
//SCH,-p,-d, ,birthday,04
        //SCH, , , ,employeeNum,79110836\
        //SCH,-p, , ,certi,PRO
        //SCH, , , ,certi,ADV
//        SCH,-p, , ,cl,CL4
//        SCH, ,-m, ,birthday,09
//        SCH,-p,-y, ,birthday,2003
//        SCH,-p, , ,employeeNum,05101762
//        SCH,-p,-m, ,phoneNum,3112
//        SCH,-p,-l, ,phoneNum,4605
//        SCH,-p, , ,employeeNum,10127115
//        SCH, ,-f, ,name,LDEXRI
//        SCH, , , ,name,FB NTAWR

        final int OPERATION = 0;
        final int OPTION1 = 1;
        final int OPTION2 = 2;
        final int OPTION3 = 3;
        final int CONDITION = 4;
        final int KEYWORD = 5;

        String[] tokens = args.replace(" ","").split(",");
        String option1 = tokens[OPTION1];
        String option2 = tokens[OPTION2];
        String option3 = tokens[OPTION3];
        String condition = tokens[CONDITION];
        String keyword = tokens[KEYWORD];

        ArrayList<Employee> result = new ArrayList<Employee>();;

        //option 2 처리
        if(!option2.equals("") ){
            if(condition.equals("name")){
                switch (option2){
                    case "f":
                        result = employees.stream().filter(employee -> employee.getName().getNameFirst().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                        break;
                    case "l":
                        result =  employees.stream().filter(employee -> employee.getName().getNameLast().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                        break;
                    default:
                        break;
                }
            }
            if(condition.equals("phone")){
                switch (option2){
                    case "m":
                        result =  employees.stream().filter(employee -> employee.getPhoneNum().getPhoneNumMiddle().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                        break;
                    case "l":
                        result =  employees.stream().filter(employee -> employee.getPhoneNum().getPhoneNumLast().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                        break;
                    default:
                        break;
                }
            }
            if(condition.equals("birthday")){
                switch (option2){
                    case "y":
                        result =  employees.stream().filter(employee -> employee.getBirthday().getYear().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                        break;
                    case "m":
                        result =  employees.stream().filter(employee -> employee.getBirthday().getMonth().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                        break;
                    case "d":
                        result =  employees.stream().filter(employee -> employee.getBirthday().getDay().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                        break;
                    default:
                        break;
                }
            }
        }
        //option2가 없는 경우
        else {
            switch (condition){
                case "employeeNum":
                    result =  employees.stream().filter(employee -> employee.getEmployeeNum().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                    break;
                case "name":
                    result =  employees.stream().filter(employee -> employee.getName().getNameFull().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                    break;
                case "cl":
                    result =  employees.stream().filter(employee -> employee.getCl().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                    break;
                case "phoneNum":
                    result =  employees.stream().filter(employee -> employee.getPhoneNum().getPhoneNumFull().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                    break;
                case "birthday":
                    result =  employees.stream().filter(employee -> employee.getBirthday().getBirthday().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                    break;
                case "certi":
                    result =  employees.stream().filter(employee -> employee.getCerti().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    @Override
    public void modify(String[] args) {

    }
}
