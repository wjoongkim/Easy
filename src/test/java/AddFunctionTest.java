import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddFunctionTest {
    @Mock
    private IEmployeeManager iEmployeeManagerMock;

    @Test
    void add_함수_Mock_Test() {

        when(iEmployeeManagerMock.add("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV"))
                .thenReturn(new Employee("15123099"
                        , new Name("VXIHXOTH JHOP", "VXIHXOTH", "JHOP")
                        , "CL3"
                        , new Phone("010-3112-2609", "3112", "2609")
                        , new Birthday("19771211")
                        , "ADV"
                        , 2015)
                );

        Employee employee = iEmployeeManagerMock.add("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");

        assertThat(employee.getEmployeeNum()).isEqualTo("15123099");
        assertThat(employee.getName().getNameFull()).isEqualTo("VXIHXOTH JHOP");
        assertThat(employee.getName().getNameFirst()).isEqualTo("VXIHXOTH");
        assertThat(employee.getName().getNameLast()).isEqualTo("JHOP");
        assertThat(employee.getCl()).isEqualTo("CL3");
        assertThat(employee.getPhoneNum().getPhoneNumFull()).isEqualTo("010-3112-2609");
        assertThat(employee.getPhoneNum().getPhoneNumMiddle()).isEqualTo("3112");
        assertThat(employee.getPhoneNum().getPhoneNumLast()).isEqualTo("2609");
        assertThat(employee.getBirthday().getBirthday()).isEqualTo("19771211");
        assertThat(employee.getCerti()).isEqualTo("ADV");
        assertThat(employee.getJoinYear()).isEqualTo(2015);

        System.out.println("성공!!! 완성!!!");
    }


    @Test
    void add_함수_Test() {

        ArrayList<Employee> employees = new ArrayList<>();
        EmployeeManager employeeManager = new EmployeeManager(employees);

        Employee employee = employeeManager.add("15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        assertEquals(employee.getEmployeeNum(), "15123099");
    }

//    @ParameterizedTest
//    @CsvFileSource(resources = "/person-data.csv", numLinesToSkip = 1)


}
