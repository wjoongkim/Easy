import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DEL {
    ArrayList<Employee> employees;

    DEL(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    String Run(String input) {
        String result = "";
        String[] token = input.split(",");

        if (token.length < 6) return null; //입력이 올바르지 않는 경우 예외처리합니다.

        String printOption = token[1];

        //ArrayList<Employee> deleteStreamArrayList = SearchFilter(token[2], token[4], token[5]);

        Stream<Employee> deleteStream = Search(token[2], token[4], token[5]);

        if (deleteStream == null) return null; //검색 결과가 없는 경우 예외처리합니다.

        if (printOption.compareTo("-p") == 0) {
            deleteStream.sorted(Comparator.comparing(Employee::getJoinYear)).collect(Collectors.toCollection(ArrayList::new));
            result = deleteStream.limit(5).map(c -> c.getEmpInfo("MOD,")).collect(Collectors.joining("\n"));
        } else {
            result = token[0] + "," + String.valueOf(deleteStream.filter(p -> p.getJoinYear() > 0).count());
        }

        delete(Search(token[2], token[4], token[5]));

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

    void delete(Stream<Employee> data) {
        List<Employee> tempEmp = data.collect(Collectors.toList());
        for (Employee e : tempEmp) {
            System.out.println("DELETE2 : " + e.getName().getFullName());
            employees.remove(e);
        }
        //data.forEach(c -> employees.indexOf(c)));
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


/*
    ArrayList<Employee> SearchFilter(String option, String column, String param) {
        try {
            BetterFitler<Employee> betterFilter = new BetterFitler<Employee>();
            switch (column) {
                case "employeeNum":
                    EmployeeNumComparable employeeNumComparable = new EmployeeNumComparable(param);

                    ArrayList<Employee> employeeNumItems = betterFilter.filter(employees, employeeNumComparable);
                    for (Employee item : employeeNumItems) {
                        System.out.println("EMPNO : " + item.getEmployeeNum());
                    }
                    return employeeNumItems;
                case "name":
                    FullNameComparable fullNameComparable = new FullNameComparable(param);

                    ArrayList<Employee> fullNameItems = betterFilter.filter(employees, fullNameComparable);
                    for (Employee item : fullNameItems) {
                        System.out.println("FULLNAME : " + item.getName().getFullName());
                    }
                    return fullNameItems;
                case "phoneNum":
                    return null;
                case "cl":
                    return null;
                case "birthday":
                    return null;
                case "certi":
                    return null;
                default:
                    return null;
            }
        } catch (Exception e) {
            System.out.println("MOD IN STREAM SEARCH ERROR");
        }
        return null;
    }
*/
}