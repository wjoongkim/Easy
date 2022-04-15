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
        ADD add = new ADD(employees);
        return add.Run(args);
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

        String[] tokens = args.replace(" ", "").split(",");
        String option1 = tokens[OPTION1];
        String option2 = tokens[OPTION2];
        String option3 = tokens[OPTION3];
        String condition = tokens[CONDITION];
        String keyword = tokens[KEYWORD];

        ArrayList<Employee> result = new ArrayList<>();

        //option 2 처리
        if (!option2.equals("")) {
            if (condition.equals("name")) {
                switch (option2) {
                    case "-f":
                        result = employees.stream().filter(employee -> employee.getName().getFirstName().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                        break;
                    case "-l":
                        result = employees.stream().filter(employee -> employee.getName().getLastName().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                        break;
                    default:
                        break;
                }
            }
            if (condition.equals("phone")) {
                switch (option2) {
                    case "-m":
                        result = employees.stream().filter(employee -> employee.getPhoneNum().getMiddleNumber().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                        break;
                    case "-l":
                        result = employees.stream().filter(employee -> employee.getPhoneNum().getLastNumber().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                        break;
                    default:
                        break;
                }
            }
            if (condition.equals("birthday")) {
                switch (option2) {
                    case "-y":
                        result = employees.stream().filter(employee -> employee.getBirthday().getYear().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                        break;
                    case "-m":
                        result = employees.stream().filter(employee -> employee.getBirthday().getMonth().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                        break;
                    case "-d":
                        result = employees.stream().filter(employee -> employee.getBirthday().getDay().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                        break;
                    default:
                        break;
                }
            }
        }
        //option2가 없는 경우
        else {
            switch (condition) {
                case "employeeNum":
                    result = employees.stream().filter(employee -> employee.getEmployeeNum().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                    break;
                case "name":
                    result = employees.stream().filter(employee -> employee.getName().getFullName().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                    break;
                case "cl":
                    result = employees.stream().filter(employee -> employee.getCl().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                    break;
                case "phoneNum":
                    result = employees.stream().filter(employee -> employee.getPhoneNum().getFullNumber().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                    break;
                case "birthday":
                    result = employees.stream().filter(employee -> employee.getBirthday().getBirthday().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                    break;
                case "certi":
                    result = employees.stream().filter(employee -> employee.getCerti().contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    @Override
    public void modify(String args) {
        MOD mod = new MOD(employees);
        System.out.println(mod.Run(args));
    }
}
