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

        if (token.length < 6) return null; //입력이 올바르지 않는 경우 예외처리합니다.

        String printOption = token[1];
        ArrayList<String> empNoList = getEmpnoList(employeeMap, args);

        if (empNoList == null) return token[0] + ",NONE"; //검색 결과가 없는 경우 예외처리합니다.

        if (printOption.compareTo("-p") == 0) {
            Set<String> searchfilter = empNoList.stream().collect(Collectors.toCollection(HashSet::new));
            result = employeeMap.entrySet().stream().filter(c -> searchfilter.contains(c.getKey())).sorted(new Comparator<Map.Entry<String, Employee>>() {
                @Override
                public int compare(Map.Entry<String, Employee> o1, Map.Entry<String, Employee> o2) {
                    return o1.getValue().getJoinYear() - o2.getValue().getJoinYear();
                }
            }).limit(5).map(c -> c.getValue().getEmpInfo("DEL")).collect(Collectors.joining("\n"));
        } else {
            result = token[0] + "," + empNoList.size();
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