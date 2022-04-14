import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddFunctionTest {
    @Mock
    private IEmployeeManager iEmployeeManagerMock;

    @Test
    void add_함수_Mock_Test() throws ParseException {

//        Date date1 = new SimpleDateFormat("yyyyMMdd").parse("19771211");
//        Date date2 = new SimpleDateFormat("yyyy").parse("2015");
//        System.out.println(date1);
//        System.out.println(date2);

        when(iEmployeeManagerMock.add("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV"))
                .thenReturn(new Employee("15123099"
                        , new Name("VXIHXOTH JHOP", "VXIHXOTH", "JHOP")
                        , "CL3"
                        ,new Phone("010-3112-2609","3112","2609")
                        , new SimpleDateFormat("yyyyMMdd").parse("19771211")
                        , "ADV"
                        , new SimpleDateFormat("yyyy").parse("2015"))
                );

        Employee employee = iEmployeeManagerMock.add("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");

        assertThat(employee.getEmployeeNum()).isEqualTo("15123099");
        assertThat(employee.getName().getName()).isEqualTo("VXIHXOTH JHOP");
        assertThat(employee.getName().getNameFirst()).isEqualTo("VXIHXOTH");
        assertThat(employee.getName().getNameLast()).isEqualTo("JHOP");
        assertThat(employee.getCl()).isEqualTo("CL3");
        assertThat(employee.getPhoneNum().getPhoneNum()).isEqualTo("010-3112-2609");
        assertThat(employee.getPhoneNum().getPhoneNumMiddle()).isEqualTo("3112");
        assertThat(employee.getPhoneNum().getPhoneNumLast()).isEqualTo("2609");
//        assertThat(employee.getBirthday()).isEqualTo(new SimpleDateFormat("yyyyMMdd").parse("19771211"));
        assertThat(employee.getCerti()).isEqualTo("ADV");
//        assertThat(employee.getJoinYear()).isEqualTo("2015");

        System.out.println("성공!!! 완성!!!");
    }



//    IEmployeeManager iEmployeeManager;
//    EmployeeManager employeeManager;

    @Test
    void add_함수_Test() {

        ArrayList<Employee> employees = new ArrayList<>();
        EmployeeManager employeeManager = new EmployeeManager(employees);

        Employee employee = employeeManager.add("15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        assertEquals(employee.getEmployeeNum(),"15123099");
    }
}
