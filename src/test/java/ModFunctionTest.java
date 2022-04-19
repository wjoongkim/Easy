import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ModFunctionTest {
    @Test
    void MockTest() {
        Modify mod = mock(Modify.class);
        when(mod.getEmpNoList("MOD,-p,  , ,certi,PRO,birthday,20050520")).thenReturn(new ArrayList<>());

        assertEquals(mod.calc("MOD,-p,  , ,certi,PRO,birthday,20050520"), "MOD,NONE");
    }

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
    void EmployeeTest() {
        EmployeeManager manager = new EmployeeManager();

        manager.getAdd().calc("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        manager.getAdd().calc("ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO");
        manager.getAdd().calc("ADD, , , ,18115040,TTETHU HBO,CL3,010-4581-2050,20080718,ADV");
        manager.getAdd().calc("ADD, , , ,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO");
        manager.getAdd().calc("ADD, , , ,19129568,SRERLALH HMEF,CL2,010-3091-9521,19640910,PRO");
        manager.getAdd().calc("ADD, , , ,17111236,VSID TVO,CL1,010-3669-1077,20120718,PRO");
        manager.getAdd().calc("ADD, , , ,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO");
        manager.getAdd().calc("ADD, , , ,01122329,DN WD,CL4,010-7174-5680,20071117,PRO");

        System.out.println(manager.getModify().calc("MOD,-p, , ,certi,PRO,cl,CL3"));
    }

    @Test
    void SearchNameTest() {
        EmployeeManager manager = new EmployeeManager();

        manager.getAdd().calc("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        manager.getAdd().calc("ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO");
        manager.getAdd().calc("ADD, , , ,18115040,TTETHU HBO,CL3,010-4581-2050,20080718,ADV");
        manager.getAdd().calc("ADD, , , ,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO");
        manager.getAdd().calc("ADD, , , ,19129568,SRERLALH HMEF,CL2,010-3091-9521,19640910,PRO");
        manager.getAdd().calc("ADD, , , ,17111236,VSID TVO,CL1,010-3669-1077,20120718,PRO");
        manager.getAdd().calc("ADD, , , ,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO");
        manager.getAdd().calc("ADD, , , ,01122329,DN WD,CL4,010-7174-5680,20071117,PRO");

        assertEquals(manager.getModify().calc("MOD,-p, , ,name,TWU QSOLT,certi,EX"),"MOD,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO");
        assertEquals(manager.getModify().calc("MOD, ,-f, ,name,TWU,certi,EX"),"MOD,1");
        assertEquals(manager.getModify().calc("MOD, ,-l, ,name,ABC,certi,EX"),"MOD,NONE");
    }

    @Test
    void SearchNumTest() {
        EmployeeManager manager = new EmployeeManager();

        manager.getAdd().calc("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        manager.getAdd().calc("ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO");
        manager.getAdd().calc("ADD, , , ,18115040,TTETHU HBO,CL3,010-4581-2050,20080718,ADV");
        manager.getAdd().calc("ADD, , , ,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO");
        manager.getAdd().calc("ADD, , , ,19129568,SRERLALH HMEF,CL2,010-3091-9521,19640910,PRO");
        manager.getAdd().calc("ADD, , , ,17111236,VSID TVO,CL1,010-3669-1077,20120718,PRO");
        manager.getAdd().calc("ADD, , , ,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO");
        manager.getAdd().calc("ADD, , , ,01122329,DN WD,CL4,010-7174-5680,20071117,PRO");

        assertEquals(manager.getModify().calc("MOD,-p, , ,phoneNum,010-6672-7186,certi,EX"),"MOD,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO");
        assertEquals(manager.getModify().calc("MOD, ,-m, ,phoneNum,7174,certi,EX"),"MOD,1");
        assertEquals(manager.getModify().calc("MOD, ,-l, ,phoneNum,6055,certi,EX"),"MOD,NONE");
    }

    @Test
    void SearchBirthdayTest() {
        EmployeeManager manager = new EmployeeManager();

        manager.getAdd().calc("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        manager.getAdd().calc("ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO");
        manager.getAdd().calc("ADD, , , ,18115040,TTETHU HBO,CL3,010-4581-2050,20080718,ADV");
        manager.getAdd().calc("ADD, , , ,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO");
        manager.getAdd().calc("ADD, , , ,19129568,SRERLALH HMEF,CL2,010-3091-9521,19640910,PRO");
        manager.getAdd().calc("ADD, , , ,17111236,VSID TVO,CL1,010-3669-1077,20120718,PRO");
        manager.getAdd().calc("ADD, , , ,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO");
        manager.getAdd().calc("ADD, , , ,01122329,DN WD,CL4,010-7174-5680,20071117,PRO");

        assertEquals(manager.getModify().calc("MOD,-p,-y, ,birthday,1990,name,KYUMOK LEE"),"MOD,NONE");
        assertEquals(manager.getModify().calc("MOD,-p,-m, ,birthday,09,cl,CL2"),"MOD,19129568,SRERLALH HMEF,CL2,010-3091-9521,19640910,PRO");
        assertEquals(manager.getModify().calc("MOD, ,-d, ,birthday,06,certi,EX"),"MOD,NONE");
    }

    @Test
    void SearchEmpNoTest() {
        EmployeeManager manager = new EmployeeManager();

        manager.getAdd().calc("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        manager.getAdd().calc("ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO");
        manager.getAdd().calc("ADD, , , ,18115040,TTETHU HBO,CL3,010-4581-2050,20080718,ADV");
        manager.getAdd().calc("ADD, , , ,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO");
        manager.getAdd().calc("ADD, , , ,19129568,SRERLALH HMEF,CL2,010-3091-9521,19640910,PRO");
        manager.getAdd().calc("ADD, , , ,17111236,VSID TVO,CL1,010-3669-1077,20120718,PRO");
        manager.getAdd().calc("ADD, , , ,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO");
        manager.getAdd().calc("ADD, , , ,01122329,DN WD,CL4,010-7174-5680,20071117,PRO");

        assertEquals(manager.getModify().calc("MOD,-p, , ,employeeNum,01122329,phoneNum,010-9777-6055"),"MOD,01122329,DN WD,CL4,010-7174-5680,20071117,PRO");
        assertEquals(manager.getModify().calc("MOD, , , ,employeeNum,01122329,phoneNum,010-9777-6055"),"MOD,1");
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
        assertEquals(mod.calc("MOD, , , ,certi,PRO,cl,CL3"), "MOD,6", "출력 결과가 올바른지 확인");
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

        assertEquals(mod.getEmpNoList("MOD,-p, , ,name,NQ LVARW,birthday,20050520").size(), 1, "사람 풀네임 찾기");
        assertEquals(mod.getEmpNoList("MOD,-p,-f, ,name,NQ,birthday,20050520").size(), 1, "사람 이름 찾기");
        assertEquals(mod.getEmpNoList("MOD,-p,-l, ,name,LVARW,birthday,20050520").size(), 1, "사람  찾기");
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

        assertEquals(mod.getEmpNoList("MOD,-p, , ,phoneNum,010-3091-9521,birthday,20050520").size(), 1, "전체 번호찾기");
        assertEquals(mod.getEmpNoList("MOD, ,-m, ,phoneNum,3091,birthday,20050520").size(), 1, "중간 번호 찾기");
        assertEquals(mod.getEmpNoList("MOD, ,-l, ,phoneNum,9521,birthday,20050520").size(), 1, "끝 번호 찾기");
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

        assertEquals(mod.getEmpNoList("MOD,-p, , ,birthday,20030413,birthday,20050520").size(), 1, "생년월일 전체 찾기");
        assertEquals(mod.getEmpNoList("MOD,-p,-y, ,birthday,1977,birthday,20050520").size(), 1, "년도 찾기");
        assertEquals(mod.getEmpNoList("MOD,-p,-m, ,birthday,04,birthday,20050520").size(), 1, "월 찾기");
        assertEquals(mod.getEmpNoList("MOD,,-d , ,birthday,03,birthday,20050520").size(), 1, "일 찾기");
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

        List<String> st = mod.getEmpNoList("MOD,-p,  , ,certi,PRO,birthday,20050520");
        for (String s : st
        ) {
            System.out.println(s);
        }
        assertEquals(6, st.size(), "Certi Pro등급이 6명인지 확인");
    }
}
