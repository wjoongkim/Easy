import java.util.ArrayList;
import java.util.Map;

public class Search extends CRUDManager {

    @Override
    String calc(Map<String, Employee> employeeMap, String args){
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

        ArrayList<String> empnoList = getEmpNoList(employeeMap, args);
        ArrayList<Employee> pOtionList;
        if(empnoList.size() == 0)
            return "SCH,NONE";

        if(option1.equals("-p")){
            pOtionList = getPOption(employeeMap, empnoList);
            String resultStr = "";
            for(Employee employee : pOtionList){
                resultStr += employee.getEmpInfo("SCH");
                resultStr += "\n";
            }
            return resultStr.trim();
        }

        return "SCH," + empnoList.size();
    }
}
