import java.util.*;

public class EmployeeManager {
    Map<String, Employee> employeeMap = new HashMap<>();
    CRUDManager search = new Search(employeeMap);
    CRUDManager add = new Add(employeeMap);
    CRUDManager modify = new Modify(employeeMap);
    CRUDManager delete = new Delete(employeeMap);
}
