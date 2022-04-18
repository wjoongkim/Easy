import java.util.ArrayList;

@Deprecated
public interface IEmployeeManager {
    Employee add(String args);
    void delete(String[] args);
    ArrayList<Employee> search(String args);
    void modify(String args);
}
