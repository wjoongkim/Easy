import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DelFunctionTest {
    @Mock
    private EmployeeManager employeeManager;

    //mock으로 data 넣어서 삭제 테스트
    @Test
    void del_Mock_First_Test() throws ParseException {
        Phone p1 = new Phone("010-3112-2609", "3112", "2609");
        Name n1 = new Name("VXIHXOTH JHOP", "VXIHXOTH", "JHOP");
        Birthday b1 = new Birthday("19771211");

        Phone p2 = new Phone("010-5645-6122", "5645", "6122");
        Name n2 = new Name("FB NTAWR", "FB", "NTAWR");
        Birthday b2 = new Birthday("19861203");

        String testString1 = "ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";
        String testString2 = "\"ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO\"";

        Map<String, Employee> employeeMap = new HashMap<>();
        Employee e1 = new Employee("15123099", n1, "CL3", p1, b1, "ADV", 2015123099);
        Employee e2 = new Employee("17112609", n2, "CL4", p2, b2, "PRO", 2017112609);
        employeeMap.put("15123099", new Employee("15123099", n1, "CL3", p1, b1, "ADV", 2015123099));
        employeeMap.put("17112609", new Employee("17112609", n2, "CL4", p2, b2, "PRO", 2017112609));

        when(employeeManager.add(testString1)).thenReturn(employeeMap.put(e1.getEmployeeNum(), e1));
        when(employeeManager.add(testString2)).thenReturn(employeeMap.put(e2.getEmployeeNum(), e2));

        employeeManager.add(testString1);
        employeeManager.add(testString2);
        //employeeMap.put(e1.getEmployeeNum(), e1);
        //employeeMap.put(e1.getEmployeeNum(), e2);

        /*
        List<Employee> liste = employees.stream().filter(employee -> employee.getName().getFullName().compareTo("VXIHXOTH JHOP")==0).collect(Collectors.toList());

        //juint
        assertThat(employees.size() == 2);
        for (Employee e : liste) {
            assertThat(e.getName().getFullName().compareTo("VXIHXOTH JHOP")==0);
            System.out.println("INDEX : " + employees.indexOf(e) + " NAME : " + e.getName().getFullName());
            employees.remove(e);
        }
        assertThat(employees.size() == 1);
        */
    }

    /*
    // add 함수 합쳐진 후 테스트
    @Test
    void del_Second_Test() throws ParseException {
        ArrayList<Employee> employees = new ArrayList<>();
        employeeManager = new EmployeeManager(employees);
        //Employee employee = employeeManager.add("15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        employeeManager.add("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        employeeManager.add("ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO");

        //juint
        assertThat(employeeManager.employees.size() == 2);

        //employeeManager.delete("DEL,,,,name,VXIHXOTH JHOP");

        for (Employee e : employeeManager.employees) {
            assertThat(e.getName().getFullName().compareTo("VXIHXOTH JHOP")==0);
            System.out.println("INDEX : " + employeeManager.employees.indexOf(e) + " NAME : " + e.getName().getFullName());
            employeeManager.employees.remove(e);
        }
        assertThat(employeeManager.employees.size() == 1);
    }
    */

    /*
    //mock으로 data 넣어서 삭제 테스트
    @Test
    void del_Mock_First_Test() throws ParseException {
        Phone p1 = new Phone("010-3112-2609", "3112", "2609");
        Name n1 = new Name("VXIHXOTH JHOP", "VXIHXOTH", "JHOP");
        Birthday b1 = new Birthday("19771211");

        Phone p2 = new Phone("010-5645-6122", "5645", "6122");
        Name n2 = new Name("FB NTAWR", "FB", "NTAWR");
        Birthday b2 = new Birthday("19861203");

        String testString1 = "VXIHXOTH JHOP";
        String testString2 = "FB NTAWR";

        ArrayList<Employee> employees = new ArrayList<>();

        when(employeeManager.add(testString1)).thenReturn(new Employee("15123099", n1, "CL3", p1, b1, "ADV", 2015));
        when(employeeManager.add(testString2)).thenReturn(new Employee("17112609", n2, "CL4", p2, b2, "PRO", 2017));

        Employee e1 = employeeManager.add(testString1);
        employees.add(e1);
        Employee e2 = employeeManager.add(testString2);
        employees.add(e2);

        List<Employee> liste = employees.stream().filter(employee -> employee.getName().getFullName().compareTo("VXIHXOTH JHOP")==0).collect(Collectors.toList());

        //juint
        assertThat(employees.size() == 2);
        for (Employee e : liste) {
            assertThat(e.getName().getFullName().compareTo("VXIHXOTH JHOP")==0);
            System.out.println("INDEX : " + employees.indexOf(e) + " NAME : " + e.getName().getFullName());
            employees.remove(e);
        }
        assertThat(employees.size() == 1);
    }

    // add 함수 합쳐진 후 테스트
    @Test
    void del_Second_Test() throws ParseException {
        ArrayList<Employee> employees = new ArrayList<>();
        employeeManager = new EmployeeManager(employees);
        //Employee employee = employeeManager.add("15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        employeeManager.add("15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        employeeManager.add("17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO");

        //juint
        assertThat(employeeManager.employees.size() == 2);

        //employeeManager.delete("DEL,,,,name,VXIHXOTH JHOP");

        for (Employee e : employeeManager.employees) {
            assertThat(e.getName().getFullName().compareTo("VXIHXOTH JHOP")==0);
            System.out.println("INDEX : " + employeeManager.employees.indexOf(e) + " NAME : " + e.getName().getFullName());
            employeeManager.employees.remove(e);
        }
        assertThat(employeeManager.employees.size() == 1);
    }
     */
}
