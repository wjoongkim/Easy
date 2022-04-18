import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    private EmployeeManager employeeManagerMock;
    private EmployeeManager manager;

    @Test
    void makeEmployeeTest() throws ParseException {
        String input = "ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";
        String[] input_split = input.split(",");
//        when(employeeManagerMock.add.calc(input))
//                .thenReturn(new Employee(input_split[4]
//                        , new Name(input_split[5])
//                        , input_split[6]
//                        , new Phone(input_split[7])
//                        , new Birthday(input_split[8])
//                        , input_split[9]
//                        , 2015)
//                );
//        Employee employee = employeeManagerMock.add.calc(input);
//        assertThat(employee.getEmployeeNum()).isEqualTo("15123099");
//        assertThat(employee.getName().getFullName()).isEqualTo("VXIHXOTH JHOP");
//        assertThat(employee.getName().getFirstName()).isEqualTo("VXIHXOTH");
//        assertThat(employee.getName().getLastName()).isEqualTo("JHOP");
//        assertThat(employee.getCl()).isEqualTo("CL3");
//        assertThat(employee.getPhoneNum().getFullNumber()).isEqualTo("010-3112-2609");
//        assertThat(employee.getPhoneNum().getMiddleNumber()).isEqualTo("3112");
//        assertThat(employee.getPhoneNum().getLastNumber()).isEqualTo("2609");
//        assertThat(employee.getBirthday().getYear()).isEqualTo("1977");
//        assertThat(employee.getBirthday().getMonth()).isEqualTo("12");
//        assertThat(employee.getBirthday().getDay()).isEqualTo("11");
//        assertThat(employee.getBirthday().getBirthday()).isEqualTo("19771211");
//        assertThat(employee.getCerti()).isEqualTo("ADV");
//
//        System.out.println(employee.getEmpInfo("TEST"));
    }

    //전체를 입력하기 힘들어 작은 class 구현하여 테스트 수행하였음.
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
        List<Person> personList = Arrays.asList(new Person("1"), new Person("2"), new Person("3"), new Person("4"));
        // 객체 값 변경 전 출력
        personList.forEach(person -> System.out.println(person.getName()));
        System.out.println("--------");
        // 객체 값 변경
        personList.stream().forEach(person -> person.setName(person.getName() + " aa"));
        // 객체 값 변경 후 출력
        personList.forEach(person -> System.out.println(person.getName()));

        //Stream 테스트 먼저!

        Stream<Person> st = personList.stream().filter(c -> c.getName().compareTo("2 aa") == 0);

        assertEquals(1, st.count(), "Stream 카운트 확인");

        ArrayList<Person> tmp = personList.stream().filter(c -> c.getName().compareTo("2 aa") == 0).collect(Collectors.toCollection(ArrayList::new));
        tmp.forEach(c -> c.setName("????"));

        personList.stream().forEach(c -> System.out.println(c.getName()));

        assertEquals(personList.get(1).getName(), "????", "Stream 값이 바뀌는지 확인");
        assertEquals(1, tmp.size(), "Stream 카운트 확인");

        //Steam객체 map 적용 확인
        personList.stream().map(c -> "AAA," + c.getName()).forEach(t -> System.out.println(t));
    }

    @Test
    void MakeBirthday() {
        String birthday = "19930309";

        String year = birthday.substring(0, 4);
        String month = birthday.substring(4, 6);
        String day = birthday.substring(6);

        assertEquals("1993", year);
        assertEquals("03", month);
        assertEquals("09", day);
    }
    @Deprecated
    @Test
    void EmployeeListTest() {
        ArrayList<Employee> list = new ArrayList<Employee>();
        EmployeeManager manager = new EmployeeManager();

        manager.add.calc("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        manager.add.calc("ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO");
        manager.add.calc("ADD, , , ,18115040,TTETHU HBO,CL3,010-4581-2050,20080718,ADV");
        manager.add.calc("ADD, , , ,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO");
        manager.add.calc("ADD, , , ,19129568,SRERLALH HMEF,CL2,010-3091-9521,19640910,PRO");
        manager.add.calc("ADD, , , ,17111236,VSID TVO,CL1,010-3669-1077,20120718,PRO");
        manager.add.calc("ADD, , , ,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO");
        manager.add.calc("ADD, , , ,01122329,DN WD,CL4,010-7174-5680,20071117,PRO");

//        MOD mod = new MOD(list);
//        System.out.println(mod.Run("MOD,-p, , ,certi,PRO,cl,CL3"));
//        System.out.println("??");
//        manager.employees.stream().forEach(c -> System.out.println(c.getEmpInfo("MOD")));
//
//        System.out.println();
//        Stream<Employee> st = mod.Search("-p", "certi", "PRO");
//        st.forEach(c -> System.out.println(c.getEmpInfo("MOD")));
//
//        System.out.println();
//
//        assertEquals("MOD,6", mod.Run("MOD, , , ,certi,PRO,certi,ADV"));
//        System.out.println();
//        manager.employees.stream().forEach(c -> System.out.println(c.getEmpInfo("MOD")));
    }
    @Deprecated
    @Test
    void SearchNameTest() {
        ArrayList<Employee> list = new ArrayList<Employee>();
        EmployeeManager manager = new EmployeeManager();

        manager.add.calc("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        manager.add.calc("ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO");
        manager.add.calc("ADD, , , ,18115040,TTETHU HBO,CL3,010-4581-2050,20080718,ADV");
        manager.add.calc("ADD, , , ,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO");
        manager.add.calc("ADD, , , ,19129568,SRERLALH HMEF,CL2,010-3091-9521,19640910,PRO");
        manager.add.calc("ADD, , , ,17111236,VSID TVO,CL1,010-3669-1077,20120718,PRO");
        manager.add.calc("ADD, , , ,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO");
        manager.add.calc("ADD, , , ,01122329,DN WD,CL4,010-7174-5680,20071117,PRO");

//        MOD mod = new MOD(list);
//        assertEquals(mod.Search("", "name", "NQ LVARW"), null, "옵션없음 테스트");
//        assertEquals(mod.Search(" ", "name", "NQ LVARW").count(), 1, "사람 풀네임 찾기");
//        assertEquals(mod.Search("-f", "name", "VSID").count(), 1, "사람 이름 찾기");
//        assertEquals(mod.Search("-l", "name", "TVO").count(), 1, "사람 성 찾기");
    }
    @Deprecated
    @Test
    void SearchNumTest() {
        ArrayList<Employee> list = new ArrayList<Employee>();
        EmployeeManager manager = new EmployeeManager();

        manager.add.calc("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        manager.add.calc("ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO");
        manager.add.calc("ADD, , , ,18115040,TTETHU HBO,CL3,010-4581-2050,20080718,ADV");
        manager.add.calc("ADD, , , ,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO");
        manager.add.calc("ADD, , , ,19129568,SRERLALH HMEF,CL2,010-3091-9521,19640910,PRO");
        manager.add.calc("ADD, , , ,17111236,VSID TVO,CL1,010-3669-1077,20120718,PRO");
        manager.add.calc("ADD, , , ,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO");
        manager.add.calc("ADD, , , ,01122329,DN WD,CL4,010-7174-5680,20071117,PRO");

//        MOD mod = new MOD(list);
//        assertEquals(mod.Search("", "phoneNum", "010-3091-9521"), null, "옵션없음 테스트");
//        assertEquals(mod.Search(" ", "phoneNum", "010-3091-9521").count(), 1, "전체 번호찾기");
//        assertEquals(mod.Search("-m", "phoneNum", "3091").count(), 1, "중간 번호 찾기");
//        assertEquals(mod.Search("-l", "phoneNum", "9521").count(), 1, "끝 번호 찾기");
    }
    @Deprecated
    @Test
    void SearchBirthdayTest() {
        ArrayList<Employee> list = new ArrayList<Employee>();
        EmployeeManager manager = new EmployeeManager();

        manager.add.calc("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        manager.add.calc("ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO");
        manager.add.calc("ADD, , , ,18115040,TTETHU HBO,CL3,010-4581-2050,20080718,ADV");
        manager.add.calc("ADD, , , ,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO");
        manager.add.calc("ADD, , , ,19129568,SRERLALH HMEF,CL2,010-3091-9521,19640910,PRO");
        manager.add.calc("ADD, , , ,17111236,VSID TVO,CL1,010-3669-1077,20120718,PRO");
        manager.add.calc("ADD, , , ,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO");
        manager.add.calc("ADD, , , ,01122329,DN WD,CL4,010-7174-5680,20071117,PRO");

//        MOD mod = new MOD(list);
//        assertEquals(mod.Search("", "birthday", "20030413"), null, "옵션없음 테스트");
//        assertEquals(mod.Search(" ", "birthday", "20030413").count(), 1, "생년월일 전체 찾기");
//        assertEquals(mod.Search("-y", "birthday", "2003").count(), 1, "년도 찾기");
//        assertEquals(mod.Search("-m", "birthday", "12").count(), 2, "월 찾기");
//        assertEquals(mod.Search("-d", "birthday", "13").count(), 1, "일 찾기");
    }


    //NEW Modify Class

    @Test
    void EmployeeListTest2() {
        Map<String, Employee> m = new HashMap<String, Employee>();
        Modify mod = new Modify(m);

        m.put("15123099", new Employee(
                "15123099", new Name("VXIHXOTH JHOP"), "CL3", new Phone("010-3112-2609"), new Birthday("19771211"), "ADV", 2015123099
        ));
        m.put("17112609", new Employee(
                "17112609", new Name("FB NTAWR"), "CL4", new Phone("010-5645-6122"), new Birthday("19861203"), "PRO", 2017112609
        ));
        m.put("18115040", new Employee(
                "18115040", new Name("TTETHU HBO"), "CL3", new Phone("010-4581-2050"), new Birthday("20080718"), "ADV", 2018115040
        ));
        m.put("88114052", new Employee(
                "88114052", new Name("NQ LVARW"), "CL4", new Phone("010-4528-3059"), new Birthday("19911021"), "PRO", 1988114052
        ));
        m.put("19129568", new Employee(
                "19129568", new Name("SRERLALH HMEF"), "CL2", new Phone("010-3091-9521"), new Birthday("19640910"), "PRO", 2019129568
        ));
        m.put("17111236", new Employee(
                "17111236", new Name("VSID TVO"), "CL1", new Phone("010-3669-1077"), new Birthday("20120718"), "PRO", 2017111236
        ));
        m.put("18117906", new Employee(
                "18117906", new Name("TWU QSOLT"), "CL4", new Phone("010-6672-7186"), new Birthday("20030413"), "PRO", 2018117906
        ));
        m.put("01122329", new Employee(
                "01122329", new Name("DN WD"), "CL4", new Phone("010-7174-5680"), new Birthday("20071117"), "PRO", 2001122329
        ));
        System.out.println("Before");
        System.out.println(mod.calc("MOD,-p, , ,certi,PRO,cl,CL3"));
        assertEquals(mod.calc("MOD, , , ,certi,PRO,cl,CL3"), "MOD,6");
        System.out.println("After");
        m.entrySet().stream().filter(c -> c.getValue().getCerti().contains("PRO")).forEach(s -> System.out.println(s.getValue().getEmpInfo("MOD")));
    }

    @Test
    void SearchNameTest2() {
        Map<String, Employee> m = new HashMap<String, Employee>();
        Modify mod = new Modify(m);

        m.put("15123099", new Employee(
                "15123099", new Name("VXIHXOTH JHOP"), "CL3", new Phone("010-3112-2609"), new Birthday("19771211"), "ADV", 2015123099
        ));
        m.put("17112609", new Employee(
                "17112609", new Name("FB NTAWR"), "CL4", new Phone("010-5645-6122"), new Birthday("19861203"), "PRO", 2017112609
        ));
        m.put("18115040", new Employee(
                "18115040", new Name("TTETHU HBO"), "CL3", new Phone("010-4581-2050"), new Birthday("20080718"), "ADV", 2018115040
        ));
        m.put("88114052", new Employee(
                "88114052", new Name("NQ LVARW"), "CL4", new Phone("010-4528-3059"), new Birthday("19911021"), "PRO", 1988114052
        ));
        m.put("19129568", new Employee(
                "19129568", new Name("SRERLALH HMEF"), "CL2", new Phone("010-3091-9521"), new Birthday("19640910"), "PRO", 2019129568
        ));
        m.put("17111236", new Employee(
                "17111236", new Name("VSID TVO"), "CL1", new Phone("010-3669-1077"), new Birthday("20120718"), "PRO", 2017111236
        ));
        m.put("18117906", new Employee(
                "18117906", new Name("TWU QSOLT"), "CL4", new Phone("010-6672-7186"), new Birthday("20030413"), "PRO", 2018117906
        ));
        m.put("01122329", new Employee(
                "01122329", new Name("DN WD"), "CL4", new Phone("010-7174-5680"), new Birthday("20071117"), "PRO", 2001122329
        ));

        assertEquals(mod.Search(m, "", "name", "NQ LVARW"), null, "옵션없음 테스트");
        assertEquals(mod.Search(m, " ", "name", "NQ LVARW").size(), 1, "사람 풀네임 찾기");
        assertEquals(mod.Search(m, "-f", "name", "VSID").size(), 1, "사람 이름 찾기");
        assertEquals(mod.Search(m, "-l", "name", "TVO").size(), 1, "사람  찾기");
    }

    @Test
    void SearchNumTest2() {
        Map<String, Employee> m = new HashMap<String, Employee>();
        Modify mod = new Modify(m);

        m.put("15123099", new Employee(
                "15123099", new Name("VXIHXOTH JHOP"), "CL3", new Phone("010-3112-2609"), new Birthday("19771211"), "ADV", 2015123099
        ));
        m.put("17112609", new Employee(
                "17112609", new Name("FB NTAWR"), "CL4", new Phone("010-5645-6122"), new Birthday("19861203"), "PRO", 2017112609
        ));
        m.put("18115040", new Employee(
                "18115040", new Name("TTETHU HBO"), "CL3", new Phone("010-4581-2050"), new Birthday("20080718"), "ADV", 2018115040
        ));
        m.put("88114052", new Employee(
                "88114052", new Name("NQ LVARW"), "CL4", new Phone("010-4528-3059"), new Birthday("19911021"), "PRO", 1988114052
        ));
        m.put("19129568", new Employee(
                "19129568", new Name("SRERLALH HMEF"), "CL2", new Phone("010-3091-9521"), new Birthday("19640910"), "PRO", 2019129568
        ));
        m.put("17111236", new Employee(
                "17111236", new Name("VSID TVO"), "CL1", new Phone("010-3669-1077"), new Birthday("20120718"), "PRO", 2017111236
        ));
        m.put("18117906", new Employee(
                "18117906", new Name("TWU QSOLT"), "CL4", new Phone("010-6672-7186"), new Birthday("20030413"), "PRO", 2018117906
        ));
        m.put("01122329", new Employee(
                "01122329", new Name("DN WD"), "CL4", new Phone("010-7174-5680"), new Birthday("20071117"), "PRO", 2001122329
        ));

        assertEquals(mod.getEmpNoList("MOD,-p, , ,phoneNum,010-3091-9521R,birthday,20050520").size(), 1, "전체 번호찾기");
        assertEquals(mod.getEmpNoList("MOD, ,-m, ,phoneNum,010-3091-9521R,birthday,20050520").size(), 1, "중간 번호 찾기");
        assertEquals(mod.getEmpNoList("MOD, ,-l, ,phoneNum,010-3091-9521R,birthday,20050520").size(), 1, "끝 번호 찾기");
    }

    @Test
    void SearchBirthdayTest2() {
        Map<String, Employee> m = new HashMap<String, Employee>();
        Modify mod = new Modify(m);

        m.put("15123099", new Employee(
                "15123099", new Name("VXIHXOTH JHOP"), "CL3", new Phone("010-3112-2609"), new Birthday("19771211"), "ADV", 2015123099
        ));
        m.put("17112609", new Employee(
                "17112609", new Name("FB NTAWR"), "CL4", new Phone("010-5645-6122"), new Birthday("19861203"), "PRO", 2017112609
        ));
        m.put("18115040", new Employee(
                "18115040", new Name("TTETHU HBO"), "CL3", new Phone("010-4581-2050"), new Birthday("20080718"), "ADV", 2018115040
        ));
        m.put("88114052", new Employee(
                "88114052", new Name("NQ LVARW"), "CL4", new Phone("010-4528-3059"), new Birthday("19911021"), "PRO", 1988114052
        ));
        m.put("19129568", new Employee(
                "19129568", new Name("SRERLALH HMEF"), "CL2", new Phone("010-3091-9521"), new Birthday("19640910"), "PRO", 2019129568
        ));
        m.put("17111236", new Employee(
                "17111236", new Name("VSID TVO"), "CL1", new Phone("010-3669-1077"), new Birthday("20120718"), "PRO", 2017111236
        ));
        m.put("18117906", new Employee(
                "18117906", new Name("TWU QSOLT"), "CL4", new Phone("010-6672-7186"), new Birthday("20030413"), "PRO", 2018117906
        ));
        m.put("01122329", new Employee(
                "01122329", new Name("DN WD"), "CL4", new Phone("010-7174-5680"), new Birthday("20071117"), "PRO", 2001122329
        ));
        assertEquals(mod.Search(m, "", "birthday", "20030413"), null, "옵션없음 테스트");
        assertEquals(mod.Search(m, " ", "birthday", "20030413").size(), 1, "생년월일 전체 찾기");
        assertEquals(mod.Search(m, "-y", "birthday", "2003").size(), 1, "년도 찾기");
        assertEquals(mod.Search(m, "-m", "birthday", "12").size(), 2, "월 찾기");
        assertEquals(mod.Search(m, "-d", "birthday", "13").size(), 1, "일 찾기");
    }

    @Test
    void SearchCertiTest() {
        Map<String, Employee> m = new HashMap<String, Employee>();
        Modify mod = new Modify(m);

        m.put("15123099", new Employee(
                "15123099", new Name("VXIHXOTH JHOP"), "CL3", new Phone("010-3112-2609"), new Birthday("19771211"), "ADV", 2015123099
        ));
        m.put("17112609", new Employee(
                "17112609", new Name("FB NTAWR"), "CL4", new Phone("010-5645-6122"), new Birthday("19861203"), "PRO", 2017112609
        ));
        m.put("18115040", new Employee(
                "18115040", new Name("TTETHU HBO"), "CL3", new Phone("010-4581-2050"), new Birthday("20080718"), "ADV", 2018115040
        ));
        m.put("88114052", new Employee(
                "88114052", new Name("NQ LVARW"), "CL4", new Phone("010-4528-3059"), new Birthday("19911021"), "PRO", 1988114052
        ));
        m.put("19129568", new Employee(
                "19129568", new Name("SRERLALH HMEF"), "CL2", new Phone("010-3091-9521"), new Birthday("19640910"), "PRO", 2019129568
        ));
        m.put("17111236", new Employee(
                "17111236", new Name("VSID TVO"), "CL1", new Phone("010-3669-1077"), new Birthday("20120718"), "PRO", 2017111236
        ));
        m.put("18117906", new Employee(
                "18117906", new Name("TWU QSOLT"), "CL4", new Phone("010-6672-7186"), new Birthday("20030413"), "PRO", 2018117906
        ));
        m.put("01122329", new Employee(
                "01122329", new Name("DN WD"), "CL4", new Phone("010-7174-5680"), new Birthday("20071117"), "PRO", 2001122329
        ));

        List<String> st = mod.Search(m, " ", "certi", "PRO");
        for (String s : st
        ) {
            System.out.println(s);
        }
    }
}
