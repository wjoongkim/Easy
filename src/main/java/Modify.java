import java.util.*;
import java.util.stream.Collectors;

public class Modify extends CRUDManager {

    public Modify(Map<String, Employee> employeeMap){
        super(employeeMap);
    }

    @Override
    String calc(String args) {
        String result = "";
        String[] token = args.split(",");

        if (token.length < 7) return null; //입력이 올바르지 않는 경우 예외처리합니다.

        String printOption = token[1];
        ArrayList<String> searchResult = Search(employeeMap, token[2], token[4], token[5]);

        if (searchResult == null) return token[0] + ",NONE"; //검색 결과가 없는 경우 예외처리합니다.

        if (printOption.compareTo("-p") == 0) {
            Set<String> searchfilter = searchResult.stream().collect(Collectors.toCollection(HashSet::new));
            result = employeeMap.entrySet().stream().filter(c -> searchfilter.contains(c.getKey())).sorted(new Comparator<Map.Entry<String, Employee>>() {
                @Override
                public int compare(Map.Entry<String, Employee> o1, Map.Entry<String, Employee> o2) {
                    return o1.getValue().getJoinYear() - o2.getValue().getJoinYear();
                }
            }).limit(5).map(c -> c.getValue().getEmpInfo("MOD")).collect(Collectors.joining("\n"));
        } else {
            result = token[0] + "," + searchResult.size();
        }

        modify(employeeMap, searchResult, token[6], token[7]);
        return result;
    }

    ArrayList<String> Search(Map<String, Employee> employeeMap, String option, String column, String param) {
        try {
            switch (column) {
                case "employeeNum":
                    return employeeMap.entrySet().stream().filter(e -> e.getValue().getEmployeeNum().compareTo(param) == 0).map(map -> map.getKey()).collect(Collectors.toCollection(ArrayList::new));
                case "name":
                    return nameSearchStream(employeeMap, option, param);
                case "phoneNum":
                    return phoneNumSearchStream(employeeMap, option, param);
                case "cl":
                    return employeeMap.entrySet().stream().filter(e -> e.getValue().getCl().compareTo(param) == 0).map(map -> map.getKey()).collect(Collectors.toCollection(ArrayList::new));
                case "birthday":
                    return birthdaySearchStream(employeeMap, option, param);
                case "certi":
                    return employeeMap.entrySet().stream().filter(e -> e.getValue().getCerti().compareTo(param) == 0).map(map -> map.getKey()).collect(Collectors.toCollection(ArrayList::new));
                default:
                    return null;
            }
        } catch (Exception e) {
            System.out.println("MOD IN STREAM SEARCH ERROR");
        }
        return null;
    }


    void modify(Map<String, Employee> employeeMap, ArrayList<String> data, String column, String param) {
        switch (column) {
            case "name":
                String[] split_name = param.split(" ");
                for (String Empno : data) {
                    employeeMap.get(Empno).setName(new Name(param, split_name[0], split_name[1]));
                }
                break;
            case "phoneNum":
                String[] split_Num = param.split("-");
                for (String Empno : data) {
                    employeeMap.get(Empno).setPhoneNum(new Phone(param, split_Num[1], split_Num[2]));
                }
                break;
            case "cl":
                for (String Empno : data) {
                    employeeMap.get(Empno).setCl(param);
                }
                break;
            case "birthday":
                for (String Empno : data) {
                    employeeMap.get(Empno).setBirthday(new Birthday(param));
                }
                break;
            case "certi":
                for (String Empno : data) {
                    employeeMap.get(Empno).setCerti(param);
                }
                break;
            default:
                //System.out.println("ERROR");
                break;
        }
    }

    ArrayList<String> nameSearchStream(Map<String, Employee> employeeMap, String option, String param) {
        if (option.compareTo("-f") == 0) {
            return employeeMap.entrySet().stream().filter(e -> e.getValue().getName().getFirstName().compareTo(param) == 0).map(map -> map.getKey()).collect(Collectors.toCollection(ArrayList::new));
        } else if (option.compareTo("-l") == 0) {
            return employeeMap.entrySet().stream().filter(e -> e.getValue().getName().getLastName().compareTo(param) == 0).map(map -> map.getKey()).collect(Collectors.toCollection(ArrayList::new));
        } else if (option.compareTo(" ") == 0) {
            return employeeMap.entrySet().stream().filter(e -> e.getValue().getName().getFullName().compareTo(param) == 0).map(map -> map.getKey()).collect(Collectors.toCollection(ArrayList::new));
        }
        return null;
    }

    ArrayList<String> phoneNumSearchStream(Map<String, Employee> employeeMap, String option, String param) {
        if (option.compareTo("-m") == 0) {
            return employeeMap.entrySet().stream().filter(e -> e.getValue().getPhoneNum().getMiddleNumber().compareTo(param) == 0).map(map -> map.getKey()).collect(Collectors.toCollection(ArrayList::new));
        } else if (option.compareTo("-l") == 0) {
            return employeeMap.entrySet().stream().filter(e -> e.getValue().getPhoneNum().getLastNumber().compareTo(param) == 0).map(map -> map.getKey()).collect(Collectors.toCollection(ArrayList::new));
        } else if (option.compareTo(" ") == 0) {
            return employeeMap.entrySet().stream().filter(e -> e.getValue().getPhoneNum().getFullNumber().compareTo(param) == 0).map(map -> map.getKey()).collect(Collectors.toCollection(ArrayList::new));
        }
        return null;
    }

    ArrayList<String> birthdaySearchStream(Map<String, Employee> employeeMap, String option, String param) {
        if (option.compareTo("-y") == 0) {
            return employeeMap.entrySet().stream().filter(e -> e.getValue().getBirthday().getYear().compareTo(param) == 0).map(map -> map.getKey()).collect(Collectors.toCollection(ArrayList::new));
        } else if (option.compareTo("-m") == 0) {
            return employeeMap.entrySet().stream().filter(e -> e.getValue().getBirthday().getMonth().compareTo(param) == 0).map(map -> map.getKey()).collect(Collectors.toCollection(ArrayList::new));
        } else if (option.compareTo("-d") == 0) {
            return employeeMap.entrySet().stream().filter(e -> e.getValue().getBirthday().getDay().compareTo(param) == 0).map(map -> map.getKey()).collect(Collectors.toCollection(ArrayList::new));
        } else if (option.compareTo(" ") == 0) {
            return employeeMap.entrySet().stream().filter(e -> e.getValue().getBirthday().getBirthday().compareTo(param) == 0).map(map -> map.getKey()).collect(Collectors.toCollection(ArrayList::new));
        }
        return null;
    }
}
