import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Search extends CRUDManager {

    public Search(Map<String, Employee> employeeMap){
        super(employeeMap);
    }

    @Override
    String calc(String args){
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

        ArrayList<String> empnoList = getEmpNoList(args);
        ArrayList<Employee> pOtionList;
        if(empnoList.size() == 0)
            return "SCH,NONE";

        if(option1.equals("-p")){
            return  getPOption(empnoList).stream().map(e -> e.getEmpInfo("SCH")).collect(Collectors.joining("\n"));
        }

        return "SCH," + empnoList.size();
    }
}
