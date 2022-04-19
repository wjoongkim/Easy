import java.util.*;
import java.util.stream.Collectors;

public class Modify extends CRUDManager {

    public Modify(Map<String, Employee> employeeMap) {
        super(employeeMap);
    }

    @Override
    public String calc(String args) {
        String result = "";
        String[] token = args.split(",");

        if (token.length < 7) return null; //입력이 올바르지 않는 경우 예외처리합니다.

        ArrayList<String> searchResult = getEmpNoList(args);

        if (searchResult.size() == 0) return token[0] + ",NONE";//검색 결과가 없는 경우 예외처리합니다.

        if (isPrintCondition(token[1])) {
            result = getPOption(searchResult).stream().map(e -> e.getEmpInfo(token[0])).collect(Collectors.joining("\n"));
        } else {
            result = token[0] + "," + searchResult.size();
        }
        modify(employeeMap, searchResult, token[6], token[7]);

        return result;
    }

    private boolean isPrintCondition(String op) {
        return op.compareTo("-p") == 0;
    }

    private void modify(Map<String, Employee> employeeMap, ArrayList<String> data, String column, String param) {
        switch (column) {
            case "name":
                data.stream().forEach(e -> employeeMap.get(e).setName(new Name(param)));
                break;
            case "phoneNum":
                data.stream().forEach(e -> employeeMap.get(e).setPhoneNum(new Phone(param)));
                break;
            case "cl":
                data.stream().forEach(e -> employeeMap.get(e).setCl(param));
                break;
            case "birthday":
                data.stream().forEach(e -> employeeMap.get(e).setBirthday(new Birthday(param)));
                break;
            case "certi":
                data.stream().forEach(e -> employeeMap.get(e).setCerti(param));
                break;
            default:
                //System.out.println("ERROR");
                break;
        }
    }
}
