import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MOD {
    ArrayList<Employee> employees;

    MOD(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    String Run(String input) {
        String result = "";
        String[] token = input.split(",");

        if (token.length < 7) return null; //입력이 올바르지 않는 경우 예외처리합니다.

        String printOption = token[1];
        Stream<Employee> searchStream = Search(token[2], token[4], token[5]);

        if (searchStream == null) return null; //검색 결과가 없는 경우 예외처리합니다.

        if (printOption.compareTo("-p") == 0) {
            result = searchStream.limit(5).map(c -> c.getEmpInfo("MOD,")).collect(Collectors.joining("\n"));

        } else {
            result = token[0] + "," + String.valueOf(searchStream.filter(p -> p.getJoinYear() > 0).count());
        }

        searchStream = Search(token[2], token[4], token[5]);
        modify(searchStream, token[6], token[7]);
        return result;
    }

    Stream<Employee> Search(String option, String column, String param) {
        try {
            switch (column) {
                case "employeeNum":
                    return employees.stream().filter(c -> c.getEmployeeNum().compareTo(param) == 0);
                case "name":
                    return nameSearchStream(option, param);
                case "phoneNum":
                    return phoneNumSearchStream(option, param);
                case "cl":
                    return employees.stream().filter(c -> c.getCl().compareTo(param) == 0);
                case "birthday":
                    return birthdaySearchStream(option, param);
                case "certi":
                    return employees.stream().filter(c -> c.getCerti().compareTo(param) == 0);
                default:
                    return null;
            }
        } catch (Exception e) {
            System.out.println("MOD IN STREAM SEARCH ERROR");
        }
        return null;
    }


    void modify(Stream<Employee> data, String column, String param) {
        switch (column) {
            case "employeeNum":
                data.forEach(c -> c.setEmployeeNum(param));
                break;
            case "name":
                String[] split_name = param.split(" ");
                data.forEach(c -> c.setName(new Name(param, split_name[0], split_name[1])));
                break;
            case "phoneNum":
                String[] split_Num = param.split("-");
                data.forEach(c -> c.setPhoneNum(new Phone(param, split_Num[1], split_Num[2])));
                break;
            case "cl":
                data.forEach(c -> c.setCl(param));
                break;
            case "birthday":
                data.forEach(c -> c.setBirthday(new Birthday(param)));
                break;
            case "certi":
                data.forEach(c -> c.setCerti(param));
                break;
            default:
                //System.out.println("ERROR");
                break;
        }
    }

    Stream<Employee> nameSearchStream(String option, String param) {
        if (option.compareTo("-f") == 0) {
            return employees.stream().filter(c -> c.getName().getFirstName().compareTo(param) == 0);
        } else if (option.compareTo("-l") == 0) {
            return employees.stream().filter(c -> c.getName().getLastName().compareTo(param) == 0);
        } else if (option.compareTo(" ") == 0) {
            return employees.stream().filter(c -> c.getName().getFullName().compareTo(param) == 0);
        }
        return null;
    }

    Stream<Employee> phoneNumSearchStream(String option, String param) {
        if (option.compareTo("-m") == 0) {
            return employees.stream().filter(c -> c.getPhoneNum().getMiddleNumber().compareTo(param) == 0);
        } else if (option.compareTo("-l") == 0) {
            return employees.stream().filter(c -> c.getPhoneNum().getLastNumber().compareTo(param) == 0);
        } else if (option.compareTo(" ") == 0) {
            return employees.stream().filter(c -> c.getPhoneNum().getFullNumber().compareTo(param) == 0);
        }
        return null;
    }

    Stream<Employee> birthdaySearchStream(String option, String param) {
        if (option.compareTo("-y") == 0) {
            return employees.stream().filter(c -> c.getBirthday().getYear().compareTo(param) == 0);
        } else if (option.compareTo("-m") == 0) {
            return employees.stream().filter(c -> c.getBirthday().getMonth().compareTo(param) == 0);
        } else if (option.compareTo("-d") == 0) {
            return employees.stream().filter(c -> c.getBirthday().getDay().compareTo(param) == 0);
        } else if (option.compareTo(" ") == 0) {
            return employees.stream().filter(c -> c.getBirthday().getBirthday().compareTo(param) == 0);
        }
        return null;
    }
}
