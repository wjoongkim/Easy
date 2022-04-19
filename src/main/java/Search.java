import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Search extends CRUDManager {

    public Search(Map<String, Employee> employeeMap) {
        super(employeeMap);
    }

    @Override
    public String calc(String args) {
        final int OPTION1 = 1;

        String[] tokens = args.replace(" ", "").split(",");
        String option1 = tokens[OPTION1];

        ArrayList<String> empnoList = getEmpNoList(args);
        if (empnoList.size() == 0)
            return "SCH,NONE";

        if (option1.equals("-p")) {
            return getPOption(empnoList).stream().map(e -> e.getEmpInfo("SCH")).collect(Collectors.joining("\n"));
        }

        return "SCH," + empnoList.size();
    }
}
