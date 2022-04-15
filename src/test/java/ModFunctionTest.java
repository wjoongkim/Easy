import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ModFunctionTest {
    @Test
    void SampleModFunctionTest() {
        String[] input = "MOD, , , ,employeeNum,91351446,phoneNum,010-9777-6055".split(",");
        String output = "MOD,1";
        assertEquals(modify(input), output);

        input = "MOD,-p, , ,employeeNum,91351446,phoneNum,010-9777-6055".split(",");
        output = "MOD,91351446,LIM PNQN,CL3,010-1234-5678,19700122,PRO";

        assertEquals(modify(input), output, "빈 modify 함수를 만들어 입력과 결과를 정의");
    }

    String modify(String[] args) {
        String result;

        if (args[1].equals(" ")) {
            result = "MOD,1";
        } else {
            result = "MOD,91351446,LIM PNQN,CL3,010-1234-5678,19700122,PRO";
        }

        return result;
    }

    @Mock
    private IEmployeeManager iEmployeeManagerMock;
    private EmployeeManager manager;

    @Test
    void makeEmployeeTest() throws ParseException {
        String input = "ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";
        String[] input_split = input.split(",");
        when(iEmployeeManagerMock.add(input))
                .thenReturn(new Employee(input_split[4]
                        , new Name(input_split[5], input_split[5].split(" ")[0], input_split[5].split(" ")[1])
                        , input_split[6]
                        , new Phone(input_split[7], input_split[7].split("-")[1], input_split[7].split("-")[2])
                        , new Birthday(input_split[8])
                        , input_split[9]
                        , new SimpleDateFormat("yyyy").parse("9999"))
                );
        Employee employee = iEmployeeManagerMock.add(input);
        assertThat(employee.getEmployeeNum()).isEqualTo("15123099");
        assertThat(employee.getName().getName()).isEqualTo("VXIHXOTH JHOP");
        assertThat(employee.getName().getNameFirst()).isEqualTo("VXIHXOTH");
        assertThat(employee.getName().getNameLast()).isEqualTo("JHOP");
        assertThat(employee.getCl()).isEqualTo("CL3");
        assertThat(employee.getPhoneNum().getPhoneNum()).isEqualTo("010-3112-2609");
        assertThat(employee.getPhoneNum().getPhoneNumMiddle()).isEqualTo("3112");
        assertThat(employee.getPhoneNum().getPhoneNumLast()).isEqualTo("2609");
        //assertThat(employee.getBirthday()).isEqualTo(new Birthday("19771211"));
        assertThat(employee.getCerti()).isEqualTo("ADV");
    }

    static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Test
    void test() {
        List<Person> personList = Arrays.asList(new Person("1"), new Person("2"));
        // 객체 값 변경 전 출력
        personList.forEach(person -> System.out.println(person.getName()));
        System.out.println("--------");
        // 객체 값 변경
        personList.stream().forEach(person -> person.setName(person.getName() + " aa"));
        // 객체 값 변경 후 출력
        personList.forEach(person -> System.out.println(person.getName()));
    }

    @Test
    void MakeBirthday(){
        String birthday="19930309";

        String year = birthday.substring(0, 4);
        String month = birthday.substring(4, 6);
        String day = birthday.substring(6);

        assertEquals("1993",year);
        assertEquals("03",month);
        assertEquals("09",day);
    }
}
