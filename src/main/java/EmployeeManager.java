import java.util.*;

public class EmployeeManager {
    private final Map<String, Employee> employeeMap;
    private final CRUDManager search;
    private final CRUDManager add;
    private final CRUDManager modify;
    private final CRUDManager delete;

    public EmployeeManager(){
        employeeMap = new HashMap<>();
        search = new Search(employeeMap);
        add = new Add(employeeMap);
        modify = new Modify(employeeMap);
        delete = new Delete(employeeMap);
    }

    public Map<String, Employee> getEmployeeMap() {
        return employeeMap;
    }

    public CRUDManager getSearch() {
        return search;
    }

    public CRUDManager getAdd() {
        return add;
    }

    public CRUDManager getModify() {
        return modify;
    }

    public CRUDManager getDelete() {
        return delete;
    }
}
