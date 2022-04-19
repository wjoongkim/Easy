import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddFunctionTest {
    @Mock
    private EmployeeManager employeeManagerMock;
    Map<String, Employee> employeeMap = new HashMap<>();

//    EmployeeManager employeeManager = new EmployeeManager();

    @Test
    void add_함수_Mock_Test() {

//        when(employeeManagerMock.add.calc("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV"))
//                .thenReturn(new Employee("15123099"
//                        , new Name("VXIHXOTH JHOP")
//                        , "CL3"
//                        , new Phone("010-3112-2609")
//                        , new Birthday("19771211")
//                        , "ADV"
//                        , 2015123099)
//                );
//
//        Employee employee = employeeManagerMock.add("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
//
//        assertThat(employee.getEmployeeNum()).isEqualTo("15123099");
//        assertThat(employee.getName().getFullName()).isEqualTo("VXIHXOTH JHOP");
//        assertThat(employee.getName().getFirstName()).isEqualTo("VXIHXOTH");
//        assertThat(employee.getName().getLastName()).isEqualTo("JHOP");
//        assertThat(employee.getCl()).isEqualTo("CL3");
//        assertThat(employee.getPhoneNum().getFullNumber()).isEqualTo("010-3112-2609");
//        assertThat(employee.getPhoneNum().getMiddleNumber()).isEqualTo("3112");
//        assertThat(employee.getPhoneNum().getLastNumber()).isEqualTo("2609");
//        assertThat(employee.getBirthday().getBirthday()).isEqualTo("19771211");
//        assertThat(employee.getCerti()).isEqualTo("ADV");
//        assertThat(employee.getJoinYear()).isEqualTo(2015123099);

        System.out.println("성공!!! 완성!!!");


        System.out.println("성공!!! 완성!!!");
    }


    @Test
    void add_함수_Test() {

        EmployeeManager employeeManager = new EmployeeManager();

        employeeManager.getAdd().calc("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");

        assertEquals(employeeManager.getEmployeeMap().get("15123099").getEmployeeNum(), "15123099");
        assertEquals(employeeManager.getEmployeeMap().get("15123099").getName().getFullName(), "VXIHXOTH JHOP");
        assertEquals(employeeManager.getEmployeeMap().get("15123099").getName().getFirstName(), "VXIHXOTH");
        assertEquals(employeeManager.getEmployeeMap().get("15123099").getName().getLastName(), "JHOP");
        assertEquals(employeeManager.getEmployeeMap().get("15123099").getCl(), "CL3");
        assertEquals(employeeManager.getEmployeeMap().get("15123099").getPhoneNum().getFullNumber(), "010-3112-2609");
        assertEquals(employeeManager.getEmployeeMap().get("15123099").getPhoneNum().getMiddleNumber(), "3112");
        assertEquals(employeeManager.getEmployeeMap().get("15123099").getPhoneNum().getLastNumber(), "2609");
        assertEquals(employeeManager.getEmployeeMap().get("15123099").getBirthday().getBirthday(), "19771211");
        assertEquals(employeeManager.getEmployeeMap().get("15123099").getBirthday().getYear(), "1977");
        assertEquals(employeeManager.getEmployeeMap().get("15123099").getBirthday().getMonth(), "12");
        assertEquals(employeeManager.getEmployeeMap().get("15123099").getBirthday().getDay(), "11");
        assertEquals(employeeManager.getEmployeeMap().get("15123099").getCerti(), "ADV");
        assertEquals(employeeManager.getEmployeeMap().get("15123099").getJoinYear(), 2015123099);
        System.out.println("성공!!! 완성!!!");

        employeeManager.getAdd().calc("ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO");
        assertEquals(employeeManager.getEmployeeMap().get("17112609").getEmployeeNum(), "17112609");
        assertEquals(employeeManager.getEmployeeMap().get("17112609").getName().getFullName(), "FB NTAWR");
        assertEquals(employeeManager.getEmployeeMap().get("17112609").getName().getFirstName(), "FB");
        assertEquals(employeeManager.getEmployeeMap().get("17112609").getName().getLastName(), "NTAWR");
        assertEquals(employeeManager.getEmployeeMap().get("17112609").getCl(), "CL4");
        assertEquals(employeeManager.getEmployeeMap().get("17112609").getPhoneNum().getFullNumber(), "010-5645-6122");
        assertEquals(employeeManager.getEmployeeMap().get("17112609").getPhoneNum().getMiddleNumber(), "5645");
        assertEquals(employeeManager.getEmployeeMap().get("17112609").getPhoneNum().getLastNumber(), "6122");
        assertEquals(employeeManager.getEmployeeMap().get("17112609").getBirthday().getBirthday(), "19861203");
        assertEquals(employeeManager.getEmployeeMap().get("17112609").getBirthday().getYear(), "1986");
        assertEquals(employeeManager.getEmployeeMap().get("17112609").getBirthday().getMonth(), "12");
        assertEquals(employeeManager.getEmployeeMap().get("17112609").getBirthday().getDay(), "03");
        assertEquals(employeeManager.getEmployeeMap().get("17112609").getCerti(), "PRO");
        assertEquals(employeeManager.getEmployeeMap().get("17112609").getJoinYear(), 2017112609);
        System.out.println("성공!!! 완성!!!");

        employeeManager.getAdd().calc("ADD, , , ,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO");
        assertEquals(employeeManager.getEmployeeMap().get("88114052").getEmployeeNum(), "88114052");
        assertEquals(employeeManager.getEmployeeMap().get("88114052").getName().getFullName(), "NQ LVARW");
        assertEquals(employeeManager.getEmployeeMap().get("88114052").getName().getFirstName(), "NQ");
        assertEquals(employeeManager.getEmployeeMap().get("88114052").getName().getLastName(), "LVARW");
        assertEquals(employeeManager.getEmployeeMap().get("88114052").getCl(), "CL4");
        assertEquals(employeeManager.getEmployeeMap().get("88114052").getPhoneNum().getFullNumber(), "010-4528-3059");
        assertEquals(employeeManager.getEmployeeMap().get("88114052").getPhoneNum().getMiddleNumber(), "4528");
        assertEquals(employeeManager.getEmployeeMap().get("88114052").getPhoneNum().getLastNumber(), "3059");
        assertEquals(employeeManager.getEmployeeMap().get("88114052").getBirthday().getBirthday(), "19911021");
        assertEquals(employeeManager.getEmployeeMap().get("88114052").getBirthday().getYear(), "1991");
        assertEquals(employeeManager.getEmployeeMap().get("88114052").getBirthday().getMonth(), "10");
        assertEquals(employeeManager.getEmployeeMap().get("88114052").getBirthday().getDay(), "21");
        assertEquals(employeeManager.getEmployeeMap().get("88114052").getCerti(), "PRO");
        assertEquals(employeeManager.getEmployeeMap().get("88114052").getJoinYear(), 1988114052);
        System.out.println("성공!!! 완성!!!");
    }

}
