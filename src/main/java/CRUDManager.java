import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class CRUDManager {
    abstract String calc(Map<String, Employee> employeeMap, String args);

    ArrayList<String> getEmpnoList(Map<String, Employee> employeeMap, String args){

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
