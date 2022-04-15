import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;


public class EmployeeManager implements IEmployeeManager{
    ArrayList<Employee> employees;

    public EmployeeManager(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee add(String args) {

        return null;
    }

    @Override
    public void delete(String[] args) {

    }

    @Override
    public ArrayList<Employee> search(String args) {

        return null;
    }

    @Override
    public void modify(String[] args) {

    }
}
