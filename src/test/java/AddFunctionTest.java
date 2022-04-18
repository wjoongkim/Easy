import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddFunctionTest {
    @Mock
    private EmployeeManager employeeManagerMock;

    @Test
    void add_함수_Mock_Test() {

        when(employeeManagerMock.add("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV"))
                .thenReturn(new Employee("15123099"
                        , new Name("VXIHXOTH JHOP")
                        , "CL3"
                        , new Phone("010-3112-2609")
                        , new Birthday("19771211")
                        , "ADV"
                        , 2015123099)
                );

        Employee employee = employeeManagerMock.add("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");

        assertThat(employee.getEmployeeNum()).isEqualTo("15123099");
        assertThat(employee.getName().getFullName()).isEqualTo("VXIHXOTH JHOP");
        assertThat(employee.getName().getFirstName()).isEqualTo("VXIHXOTH");
        assertThat(employee.getName().getLastName()).isEqualTo("JHOP");
        assertThat(employee.getCl()).isEqualTo("CL3");
        assertThat(employee.getPhoneNum().getFullNumber()).isEqualTo("010-3112-2609");
        assertThat(employee.getPhoneNum().getMiddleNumber()).isEqualTo("3112");
        assertThat(employee.getPhoneNum().getLastNumber()).isEqualTo("2609");
        assertThat(employee.getBirthday().getBirthday()).isEqualTo("19771211");
        assertThat(employee.getCerti()).isEqualTo("ADV");
        assertThat(employee.getJoinYear()).isEqualTo(2015123099);

        System.out.println("성공!!! 완성!!!");
    }


    @Test
    void add_함수_Test() {

        ArrayList<Employee> employees = new ArrayList<>();
        EmployeeManager employeeManager = new EmployeeManager();

        Employee employee = employeeManager.add("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        assertEquals(employee.getEmployeeNum(), "15123099");
        assertEquals(employee.getName().getFullName(), "VXIHXOTH JHOP");
        assertEquals(employee.getName().getFirstName(), "VXIHXOTH");
        assertEquals(employee.getName().getLastName(), "JHOP");
        assertEquals(employee.getCl(), "CL3");
        assertEquals(employee.getPhoneNum().getFullNumber(), "010-3112-2609");
        assertEquals(employee.getPhoneNum().getMiddleNumber(), "3112");
        assertEquals(employee.getPhoneNum().getLastNumber(), "2609");
        assertEquals(employee.getBirthday().getBirthday(), "19771211");
        assertEquals(employee.getBirthday().getYear(), "1977");
        assertEquals(employee.getBirthday().getMonth(), "12");
        assertEquals(employee.getBirthday().getDay(), "11");
        assertEquals(employee.getCerti(), "ADV");
        assertEquals(employee.getJoinYear(), 2015123099);
        System.out.println("성공!!! 완성!!!");

        employee = employeeManager.add("ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO");
        assertEquals(employee.getEmployeeNum(), "17112609");
        assertEquals(employee.getName().getFullName(), "FB NTAWR");
        assertEquals(employee.getName().getFirstName(), "FB");
        assertEquals(employee.getName().getLastName(), "NTAWR");
        assertEquals(employee.getCl(), "CL4");
        assertEquals(employee.getPhoneNum().getFullNumber(), "010-5645-6122");
        assertEquals(employee.getPhoneNum().getMiddleNumber(), "5645");
        assertEquals(employee.getPhoneNum().getLastNumber(), "6122");
        assertEquals(employee.getBirthday().getBirthday(), "19861203");
        assertEquals(employee.getBirthday().getYear(), "1986");
        assertEquals(employee.getBirthday().getMonth(), "12");
        assertEquals(employee.getBirthday().getDay(), "03");
        assertEquals(employee.getCerti(), "PRO");
        assertEquals(employee.getJoinYear(), 2017112609);
        System.out.println("성공!!! 완성!!!");

        employee = employeeManager.add("ADD, , , ,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO");
        assertEquals(employee.getEmployeeNum(), "88114052");
        assertEquals(employee.getName().getFullName(), "NQ LVARW");
        assertEquals(employee.getName().getFirstName(), "NQ");
        assertEquals(employee.getName().getLastName(), "LVARW");
        assertEquals(employee.getCl(), "CL4");
        assertEquals(employee.getPhoneNum().getFullNumber(), "010-4528-3059");
        assertEquals(employee.getPhoneNum().getMiddleNumber(), "4528");
        assertEquals(employee.getPhoneNum().getLastNumber(), "3059");
        assertEquals(employee.getBirthday().getBirthday(), "19911021");
        assertEquals(employee.getBirthday().getYear(), "1991");
        assertEquals(employee.getBirthday().getMonth(), "10");
        assertEquals(employee.getBirthday().getDay(), "21");
        assertEquals(employee.getCerti(), "PRO");
        assertEquals(employee.getJoinYear(), 1988114052);
        System.out.println("성공!!! 완성!!!");
    }

//    @ParameterizedTest
//    @CsvFileSource(resources = "/person-data.csv", numLinesToSkip = 1)


}
