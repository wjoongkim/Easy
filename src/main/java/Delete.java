import java.util.*;
import java.util.stream.Collectors;

public class Delete extends CRUDManager {

    public Delete(Map<String, Employee> employeeMap) {
        super(employeeMap);
    }

    @Override
    String calc(String args) {
        String result;
        String[] token = args.split(",");

        if (token.length != 6) return null;

        ArrayList<String> empNoList = getEmpNoList(args);
        if (empNoList.size() == 0) return token[0] + ",NONE";

        String printOption = token[1];
        if (printOption.compareTo("-p") == 0) {
            result = getPOption(empNoList).stream().map(e -> e.getEmpInfo("DEL")).collect(Collectors.joining("\n"));
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