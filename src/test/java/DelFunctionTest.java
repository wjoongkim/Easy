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
        Phone p1 = new Phone("010-3112-2609");
        Name n1 = new Name("VXIHXOTH JHOP");
        Birthday b1 = new Birthday("19771211");

        Phone p2 = new Phone("010-5645-6122");
        Name n2 = new Name("FB NTAWR");
        Birthday b2 = new Birthday("19861203");

        //String testString1 = "ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";
        //String testString2 = "ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO";

        Map<String, Employee> employeeMap = new HashMap<>();
        Employee e1 = new Employee("15123099", n1, "CL3", p1, b1, "ADV", 2015123099);
        Employee e2 = new Employee("17112609", n2, "CL4", p2, b2, "PRO", 2017112609);

        String testString1 = "ADD1";
        String testString2 = "ADD2";

        //when(employeeManager.getAdd()(testString1)).thenReturn(employeeMap.put(e1.getEmployeeNum(), e1));
        //when(employeeManager.getAdd()(testString2)).thenReturn(employeeMap.put(e2.getEmployeeNum(), e2));

        employeeManager.getAdd().calc(testString1);
        employeeManager.getAdd().calc(testString2);
        //employeeMap.put(e1.getEmployeeNum(), e1);
        //employeeMap.put(e1.getEmployeeNum(), e2);

        CRUDManager crudManager = new Delete(employeeMap);
        //juint
        assertThat(employeeMap.size()).isEqualTo(2);
        for (Employee e : employeeMap.values()) {
            System.out.println(e.getName().getFullName());
        }
        //employeeManager.delete("DEL,-p, , ,name,VXIHXOTH JHOP");
        //System.out.println(crudManager.calc("DEL,-p, , ,name,VXIHXOTH JHOP"));
        System.out.println(crudManager.calc("DEL,-p,-f, ,name,VXIHXOTH"));
        assertThat(employeeMap.size()).isEqualTo(1);
    }

    // add 함수 합쳐진 후 테스트
    @Test
    void del_Second_Test() throws ParseException {
        String testString1 = "ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";
        String testString2 = "ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO";
        String testString3 = "ADD, , , ,15123100,VXIHXOTH JHIP,CL3,010-3112-2609,19771211,ADV";
        String testString4 = "ADD, , , ,15123101,VXIHXOTH JHXP,CL3,010-3112-2609,19771211,ADV";
        Map<String, Employee> employeeMap = new HashMap<>();
        CRUDManager addManager = new Add(employeeMap);
        addManager.calc(testString1);
        addManager.calc(testString2);
        addManager.calc(testString3);
        addManager.calc(testString4);

        CRUDManager crudManager = new Delete(employeeMap);
        //juint
        assertThat(employeeMap.size()).isEqualTo(4);
        for (Employee e : employeeMap.values()) {
            System.out.println(e.getName().getFullName());
        }
        System.out.println(crudManager.calc("DEL,-p,-f, ,name,VXIHXOTH"));
        assertThat(employeeMap.size()).isEqualTo(1);
    }

    // full name 삭제 테스트
    @Test
    void del_Thrid_Test() throws ParseException {
        String testString1 = "ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";
        String testString2 = "ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO";
        String testString3 = "ADD, , , ,15123100,VXIHXOTH JHIP,CL3,010-3112-2609,19771211,ADV";
        String testString4 = "ADD, , , ,15123101,VXIHXOTH JHXP,CL3,010-3112-2609,19771211,ADV";
        Map<String, Employee> employeeMap = new HashMap<>();
        CRUDManager addManager = new Add(employeeMap);
        addManager.calc(testString1);
        addManager.calc(testString2);
        addManager.calc(testString3);
        addManager.calc(testString4);

        CRUDManager crudManager = new Delete(employeeMap);
        //juint
        assertThat(employeeMap.size()).isEqualTo(4);
        for (Employee e : employeeMap.values()) {
            System.out.println(e.getName().getFullName());
        }
        System.out.println(crudManager.calc("DEL,-p, , ,name,VXIHXOTH JHOP"));
        assertThat(employeeMap.size()).isEqualTo(3);
        System.out.println(crudManager.calc("DEL,-p,-l, ,name,JHIP"));
        assertThat(employeeMap.size()).isEqualTo(2);
    }

    // empno, phone 삭제 테스트
    @Test
    void del_Forth_Test() throws ParseException {
        String testString1 = "ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";
        String testString2 = "ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO";
        String testString3 = "ADD, , , ,15123100,VXIHXOTH JHIP,CL3,010-3112-2611,19771211,ADV";
        String testString4 = "ADD, , , ,15123101,VXIHXOTH JHXP,CL3,010-3112-2611,19771211,ADV";
        Map<String, Employee> employeeMap = new HashMap<>();
        CRUDManager addManager = new Add(employeeMap);
        addManager.calc(testString1);
        addManager.calc(testString2);
        addManager.calc(testString3);
        addManager.calc(testString4);

        CRUDManager crudManager = new Delete(employeeMap);
        //juint
        assertThat(employeeMap.size()).isEqualTo(4);
        System.out.println(crudManager.calc("DEL, , , ,employeeNum,17112609"));
        assertThat(employeeMap.size()).isEqualTo(3);
        System.out.println(crudManager.calc("DEL, , , ,employeeNum,17112609"));
        assertThat(employeeMap.size()).isEqualTo(3);
        System.out.println(crudManager.calc("DEL,-p,-m, ,phoneNum,2611"));
        assertThat(employeeMap.size()).isEqualTo(3);
        System.out.println(crudManager.calc("DEL,-p,-l, ,phoneNum,2611"));
        assertThat(employeeMap.size()).isEqualTo(1);
        System.out.println(crudManager.calc("DEL, , , ,phoneNum,010-3112-2609"));
        assertThat(employeeMap.size()).isEqualTo(0);
    }

    /*
    //ArrayList Version test
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
        assertThat(employeeMap.size()).isEqualTo(2);
        for (Employee e : liste) {
            assertThat(e.getName().getFullName().compareTo("VXIHXOTH JHOP")==0);
            System.out.println("INDEX : " + employees.indexOf(e) + " NAME : " + e.getName().getFullName());
            employees.remove(e);
        }
        assertThat(employeeMap.size()).isEqualTo(1);
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
        assertThat(employeeMap.size()).isEqualTo(2);

        //employeeManager.delete("DEL,,,,name,VXIHXOTH JHOP");

        for (Employee e : employeeManager.employees) {
            assertThat(e.getName().getFullName().compareTo("VXIHXOTH JHOP")==0);
            System.out.println("INDEX : " + employeeManager.employees.indexOf(e) + " NAME : " + e.getName().getFullName());
            employeeManager.employees.remove(e);
        }
        assertThat(employeeMap.size()).isEqualTo(1);
    }
     */
}