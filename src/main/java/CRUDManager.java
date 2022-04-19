import java.util.*;
import java.util.stream.Collectors;

public abstract class CRUDManager implements ICRUDManager {
    Map<String, Employee> employeeMap;

    public CRUDManager(Map<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    public abstract String calc(String args);

    protected ArrayList<Employee> getPOption(ArrayList<String> empNoList) {

        Set<String> searchfilter = empNoList.stream().collect(Collectors.toCollection(HashSet::new));
        ArrayList<Employee> result;
        result = employeeMap.entrySet().stream().filter(c -> searchfilter.contains(c.getKey())).sorted(new Comparator<Map.Entry<String, Employee>>() {
            @Override
            public int compare(Map.Entry<String, Employee> o1, Map.Entry<String, Employee> o2) {
                return o1.getValue().getJoinYear() - o2.getValue().getJoinYear();
            }
        }).limit(5).map(map -> map.getValue()).collect(Collectors.toCollection(ArrayList::new));

        return result;
    }

    protected ArrayList<String> getEmpNoList(String args) {
        final int OPTION2 = 2;
        final int CONDITION = 4;
        final int KEYWORD = 5;

        String[] tokens = args.split(",");
        String option2 = tokens[OPTION2].trim();
        String condition = tokens[CONDITION];
        String keyword = tokens[KEYWORD];

        ArrayList<String> result = new ArrayList<>();

        //option 2 처리
        if (!option2.equals("")) {
            if (condition.equals("name")) {
                switch (option2) {
                    case "-f":
                        result = (ArrayList<String>) employeeMap.entrySet().stream()
                                .filter(employee -> employee.getValue().getName().getFirstName().compareTo(keyword)==0)
                                .map(Map.Entry::getKey).collect(Collectors.toList());
                        break;
                    case "-l":
                        result = (ArrayList<String>) employeeMap.entrySet().stream()
                                .filter(employee -> employee.getValue().getName().getLastName().compareTo(keyword)==0)
                                .map(Map.Entry::getKey).collect(Collectors.toList());
                        break;
                    default:
                        break;
                }
            }
            if (condition.equals("phoneNum")) {
                switch (option2) {
                    case "-m":
                        result = (ArrayList<String>) employeeMap.entrySet().stream()
                                .filter(employee -> employee.getValue().getPhoneNum().getMiddleNumber().compareTo(keyword)==0)
                                .map(Map.Entry::getKey).collect(Collectors.toList());
                        break;
                    case "-l":
                        result = (ArrayList<String>) employeeMap.entrySet().stream()
                                .filter(employee -> employee.getValue().getPhoneNum().getLastNumber().compareTo(keyword)==0)
                                .map(Map.Entry::getKey).collect(Collectors.toList());
                        break;
                    default:
                        break;
                }
            }
            if (condition.equals("birthday")) {
                switch (option2) {
                    case "-y":
                        result = (ArrayList<String>) employeeMap.entrySet().stream()
                                .filter(employee -> employee.getValue().getBirthday().getYear().compareTo(keyword)==0)
                                .map(Map.Entry::getKey).collect(Collectors.toList());
                        break;
                    case "-m":
                        result = (ArrayList<String>) employeeMap.entrySet().stream()
                                .filter(employee -> employee.getValue().getBirthday().getMonth().compareTo(keyword)==0)
                                .map(Map.Entry::getKey).collect(Collectors.toList());
                        break;
                    case "-d":
                        result = (ArrayList<String>) employeeMap.entrySet().stream()
                                .filter(employee -> employee.getValue().getBirthday().getDay().compareTo(keyword)==0)
                                .map(Map.Entry::getKey).collect(Collectors.toList());
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
                    result = (ArrayList<String>) employeeMap.entrySet().stream()
                            .filter(employee -> employee.getValue().getEmployeeNum().compareTo(keyword)==0)
                            .map(Map.Entry::getKey).collect(Collectors.toList());
                    break;
                case "name":
                    result = (ArrayList<String>) employeeMap.entrySet().stream()
                            .filter(employee -> employee.getValue().getName().getFullName().compareTo(keyword)==0)
                            .map(Map.Entry::getKey).collect(Collectors.toList());
                    break;
                case "cl":
                    result = (ArrayList<String>) employeeMap.entrySet().stream()
                            .filter(employee -> employee.getValue().getCl().compareTo(keyword)==0)
                            .map(Map.Entry::getKey).collect(Collectors.toList());
                    break;
                case "phoneNum":
                    result = (ArrayList<String>) employeeMap.entrySet().stream()
                            .filter(employee -> employee.getValue().getPhoneNum().getFullNumber().compareTo(keyword)==0)
                            .map(Map.Entry::getKey).collect(Collectors.toList());
                    break;
                case "birthday":
                    result = (ArrayList<String>) employeeMap.entrySet().stream()
                            .filter(employee -> employee.getValue().getBirthday().getBirthday().compareTo(keyword)==0)
                            .map(Map.Entry::getKey).collect(Collectors.toList());
                    break;
                case "certi":
                    result = (ArrayList<String>) employeeMap.entrySet().stream()
                            .filter(employee -> employee.getValue().getCerti().compareTo(keyword)==0)
                            .map(Map.Entry::getKey).collect(Collectors.toList());
                    break;
                default:
                    break;
            }
        }
        return result;
    }

}
