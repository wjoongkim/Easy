import java.util.*;
import java.util.stream.Collectors;

public abstract class CRUDManager {
    abstract String calc(Map<String, Employee> employeeMap, String args);


    ArrayList<Employee> getPOption(Map<String, Employee> employeeMap, ArrayList<String> empnoList){

        Set<String> searchfilter = empnoList.stream().collect(Collectors.toCollection(HashSet::new));
        ArrayList<Employee> result = new ArrayList<>();
        result = employeeMap.entrySet().stream().filter(c -> searchfilter.contains(c.getKey())).sorted(new Comparator<Map.Entry<String, Employee>>() {
            @Override
            public int compare(Map.Entry<String, Employee> o1, Map.Entry<String, Employee> o2) {
                return o1.getValue().getJoinYear() - o2.getValue().getJoinYear();
            }
        }).limit(5).map(map -> map.getValue()).collect(Collectors.toCollection(ArrayList::new));

        return result;
    }

    ArrayList<String> getEmpnoList(Map<String, Employee> employeeMap, String args){
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

        ArrayList<String> result = new ArrayList<>();

        //option 2 처리
        if (!option2.equals("")) {
            if (condition.equals("name")) {
                switch (option2) {
                    case "-f":
                        result = (ArrayList<String>) employeeMap.entrySet().stream()
                                .filter(employee -> employee.getValue().getName().getFirstName().contains(keyword))
                                .map(Map.Entry::getKey).collect(Collectors.toList());
                        break;
                    case "-l":
                        result = (ArrayList<String>) employeeMap.entrySet().stream()
                                .filter(employee -> employee.getValue().getName().getLastName().contains(keyword))
                                .map(Map.Entry::getKey).collect(Collectors.toList());
                        break;
                    default:
                        break;
                }
            }
            if (condition.equals("phone")) {
                switch (option2) {
                    case "-m":
                        result = (ArrayList<String>) employeeMap.entrySet().stream()
                                .filter(employee -> employee.getValue().getPhoneNum().getMiddleNumber().contains(keyword))
                                .map(Map.Entry::getKey).collect(Collectors.toList());
                        break;
                    case "-l":
                        result = (ArrayList<String>) employeeMap.entrySet().stream()
                                .filter(employee -> employee.getValue().getPhoneNum().getLastNumber().contains(keyword))
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
                                .filter(employee -> employee.getValue().getBirthday().getYear().contains(keyword))
                                .map(Map.Entry::getKey).collect(Collectors.toList());
                        break;
                    case "-m":
                        result = (ArrayList<String>) employeeMap.entrySet().stream()
                                .filter(employee -> employee.getValue().getBirthday().getMonth().contains(keyword))
                                .map(Map.Entry::getKey).collect(Collectors.toList());
                        break;
                    case "-d":
                        result = (ArrayList<String>) employeeMap.entrySet().stream()
                                .filter(employee -> employee.getValue().getBirthday().getDay().contains(keyword))
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
                    result = (ArrayList<String>)employeeMap.entrySet().stream()
                            .filter(employee -> employee.getValue().getEmployeeNum().contains(keyword))
                            .map(Map.Entry::getKey).collect(Collectors.toList());
                    break;
                case "name":
                    result = (ArrayList<String>)employeeMap.entrySet().stream()
                            .filter(employee -> employee.getValue().getName().getFullName().contains(keyword))
                            .map(Map.Entry::getKey).collect(Collectors.toList());
                    break;
                case "cl":
                    result = (ArrayList<String>)employeeMap.entrySet().stream()
                            .filter(employee -> employee.getValue().getCl().contains(keyword))
                            .map(Map.Entry::getKey).collect(Collectors.toList());
                    break;
                case "phoneNum":
                    result = (ArrayList<String>)employeeMap.entrySet().stream()
                            .filter(employee -> employee.getValue().getPhoneNum().getFullNumber().contains(keyword))
                            .map(Map.Entry::getKey).collect(Collectors.toList());
                    break;
                case "birthday":
                    result = (ArrayList<String>)employeeMap.entrySet().stream()
                            .filter(employee -> employee.getValue().getBirthday().getBirthday().contains(keyword))
                            .map(Map.Entry::getKey).collect(Collectors.toList());
                    break;
                case "certi":
                    result = (ArrayList<String>)employeeMap.entrySet().stream()
                            .filter(employee -> employee.getValue().getCerti().contains(keyword))
                            .map(Map.Entry::getKey).collect(Collectors.toList());
                    break;
                default:
                    break;
            }
        }
        return result;
    }

}
