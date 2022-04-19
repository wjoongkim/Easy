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
            if (condition.equals("name"))  return getOpt2Name(option2, keyword);
            if (condition.equals("phoneNum")) return getOpt2PhoneNum(option2, keyword);
            if (condition.equals("birthday")) return getOpt2Birthday(option2, keyword);
        }
        //option2가 없는 경우
        return getNoneOpt2(condition, keyword);
    }

    private ArrayList<String> getNoneOpt2(String condition, String keyword) {
        switch (condition) {
            case "employeeNum":
                return (ArrayList<String>) employeeMap.entrySet().stream()
                        .filter(employee -> employee.getValue().getEmployeeNum().compareTo(keyword)==0)
                        .map(Map.Entry::getKey).collect(Collectors.toList());
            case "name":
                return (ArrayList<String>) employeeMap.entrySet().stream()
                        .filter(employee -> employee.getValue().getName().getFullName().compareTo(keyword)==0)
                        .map(Map.Entry::getKey).collect(Collectors.toList());
            case "cl":
                return (ArrayList<String>) employeeMap.entrySet().stream()
                        .filter(employee -> employee.getValue().getCl().compareTo(keyword)==0)
                        .map(Map.Entry::getKey).collect(Collectors.toList());
            case "phoneNum":
                return (ArrayList<String>) employeeMap.entrySet().stream()
                        .filter(employee -> employee.getValue().getPhoneNum().getFullNumber().compareTo(keyword)==0)
                        .map(Map.Entry::getKey).collect(Collectors.toList());
            case "birthday":
                return (ArrayList<String>) employeeMap.entrySet().stream()
                        .filter(employee -> employee.getValue().getBirthday().getBirthday().compareTo(keyword)==0)
                        .map(Map.Entry::getKey).collect(Collectors.toList());
            case "certi":
                return (ArrayList<String>) employeeMap.entrySet().stream()
                        .filter(employee -> employee.getValue().getCerti().compareTo(keyword)==0)
                        .map(Map.Entry::getKey).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private ArrayList<String> getOpt2Birthday(String option2, String keyword) {
        switch (option2) {
            case "-y":
                return (ArrayList<String>) employeeMap.entrySet().stream()
                        .filter(employee -> employee.getValue().getBirthday().getYear().compareTo(keyword)==0)
                        .map(Map.Entry::getKey).collect(Collectors.toList());
            case "-m":
                return (ArrayList<String>) employeeMap.entrySet().stream()
                        .filter(employee -> employee.getValue().getBirthday().getMonth().compareTo(keyword)==0)
                        .map(Map.Entry::getKey).collect(Collectors.toList());
            case "-d":
                return (ArrayList<String>) employeeMap.entrySet().stream()
                        .filter(employee -> employee.getValue().getBirthday().getDay().compareTo(keyword)==0)
                        .map(Map.Entry::getKey).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private ArrayList<String> getOpt2PhoneNum(String option2, String keyword) {
        switch (option2) {
            case "-m":
                return (ArrayList<String>) employeeMap.entrySet().stream()
                        .filter(employee -> employee.getValue().getPhoneNum().getMiddleNumber().compareTo(keyword)==0)
                        .map(Map.Entry::getKey).collect(Collectors.toList());
            case "-l":
                return  (ArrayList<String>) employeeMap.entrySet().stream()
                        .filter(employee -> employee.getValue().getPhoneNum().getLastNumber().compareTo(keyword)==0)
                        .map(Map.Entry::getKey).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private ArrayList<String> getOpt2Name(String option2, String keyword) {
        switch (option2) {
            case "-f":
                return (ArrayList<String>) employeeMap.entrySet().stream()
                        .filter(employee -> employee.getValue().getName().getFirstName().compareTo(keyword)==0)
                        .map(Map.Entry::getKey).collect(Collectors.toList());
            case "-l":
                return (ArrayList<String>) employeeMap.entrySet().stream()
                        .filter(employee -> employee.getValue().getName().getLastName().compareTo(keyword)==0)
                        .map(Map.Entry::getKey).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

}
