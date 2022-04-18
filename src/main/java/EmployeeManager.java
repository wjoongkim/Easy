import java.util.*;
import java.util.stream.Collectors;


public class EmployeeManager {
    @Deprecated
    ArrayList<Employee> employees = new ArrayList<>();

    Map<String, Employee> employeeMap = new HashMap<>();
    CRUDManager search = new Search(employeeMap);
    CRUDManager add = new Add(employeeMap);
    CRUDManager modify = new Modify(employeeMap);
    CRUDManager delete = new Delete(employeeMap);

    @Deprecated
    public Employee add(String args) {
        Add add = new Add(employees);
        return add.Run(args);
    }

    @Deprecated
    //이 함수는 delete.calc 함수로 대체 예정입니다.
    public String delete(String args) {
        return "";
    }

    @Deprecated
    public String search(String args) {
        return "";
    }

    @Deprecated
    public String modify(String args) {
        return modify.calc(args);
    }
}
