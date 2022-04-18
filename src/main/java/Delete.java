import java.util.*;
import java.util.stream.Collectors;

public class Delete extends CRUDManager {

    public Delete(Map<String, Employee> employeeMap){
        super(employeeMap);
    }

    @Override
    String calc(String args) {
        String result = "";
        String[] token = args.split(",");

        if (token.length != 6) return null; //입력이 올바르지 않는 경우 예외처리합니다.

        ArrayList<String> empNoList = getEmpNoList(employeeMap, args);
        if (empNoList == null) return token[0] + ",NONE"; //검색 결과가 없는 경우 예외처리합니다.

        String printOption = token[1];
        if (printOption.compareTo("-p") == 0 && empNoList.size() > 0) {
            result = getPOption(employeeMap, empNoList).stream().map(e -> e.getEmpInfo("DEL")).collect(Collectors.joining("\n"));
        } else {
            result = token[0] + "," + (empNoList.size()==0?"NONE":empNoList.size());
        }

        delete(empNoList);

        return result;
    }

    void delete(ArrayList<String> empNoList) {
        for (String empNo : empNoList) {
            employeeMap.remove(empNo);
        }
    }
}