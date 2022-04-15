import java.util.ArrayList;

public interface IEmployeeManager {
    Employee add(String args);
    void delete(String[] args);
    ArrayList<Employee> search(String args);
    void modify(String[] args);
}
