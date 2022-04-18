import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class SearchFunctionTest {
    @Mock
    private EmployeeManager employeeManager;

    @Test
    void getEmployeeMeberString_Test(){
        CRUDManager crudManager = new Search();

        String expectedVal = (new Employee("02117175"
                , new Name("SBILHUT LDEXRI", "SBILHUT", "LDEXRI")
                , "CL4"
                , new Phone("010-2814-1699", "2814", "1699")
                , new Birthday("19950704")
                , "ADV"
                , 2002117175)).getEmpInfo("SCH");
        assertEquals("SCH,02117175,SBILHUT LDEXRI,CL4,010-2814-1699,19950704,ADV", expectedVal);
        String expectedVal2 = (new Employee("88114052"
                , new Name("NQ LVARW", "NQ", "LVARW")
                , "CL4"
                , new Phone("010-4528-3059", "4528", "3059")
                , new Birthday("19911021")
                , "PRO"
                , 1988114052)).getEmpInfo("SCH");
        assertEquals("SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO", expectedVal2);


    }

    @Test
    void Search_Class_Test(){
        CRUDManager crudManager = new Search();
        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put("02117175", new Employee("02117175"
                , new Name("SBILHUT LDEXRI", "SBILHUT", "LDEXRI")
                , "CL4"
                , new Phone("010-2814-1699", "2814", "1699")
                , new Birthday("19950704")
                , "ADV"
                , 2002117175));

        employeeMap.put("88114052", new Employee("88114052"
                , new Name("NQ LVARW", "NQ", "LVARW")
                , "CL4"
                , new Phone("010-4528-3059", "4528", "3059")
                , new Birthday("19911021")
                , "PRO"
                , 1988114052));
//        SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO
        employeeMap.put( "01122329", new Employee("01122329"
                , new Name("DN WD", "DN", "WD")
                , "CL4"
                , new Phone("010-7174-5680", "7174", "5680")
                , new Birthday("20071117")
                , "PRO"
                , 2001122329));
//        SCH,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO
        employeeMap.put("03113260", new Employee("03113260"
                , new Name("HH LTUPF", "HH", "LTUPF")
                , "CL2"
                , new Phone("010-5798-5383", "5798", "5383")
                , new Birthday("19791018")
                , "PRO"
                , 2003113260));
//        SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO
        employeeMap.put("05101762", new Employee("05101762"
                , new Name("VCUHLE HMU", "VCUHLE", "HMU")
                , "CL4"
                , new Phone("010-3988-9289", "3988", "9289")
                , new Birthday("20030819")
                , "PRO"
                , 2005101762));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        employeeMap.put("08123556", new Employee("08123556"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047", "7986", "5047")
                , new Birthday("20100614")
                , "PRO"
                , 2008123556));

        assertEquals("SCH,02117175,SBILHUT LDEXRI,CL4,010-2814-1699,19950704,ADV", crudManager.calc(employeeMap, "SCH,-p,-d, ,birthday,04"));
        assertEquals("SCH,NONE", crudManager.calc(employeeMap, "SCH, , , ,employeeNum,79110836"));
        assertEquals("SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO\n" +
                "SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO\n" +
                "SCH,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO\n" +
                "SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO\n" +
                "SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO", crudManager.calc(employeeMap, "SCH,-p, , ,certi,PRO"));
    }

    @Test
    void search_함수_Mock_Test() throws ParseException {

        ArrayList<Employee> firstCondi = new ArrayList<Employee>();
        firstCondi.add(new Employee("02117175"
                , new Name("SBILHUT LDEXRI", "SBILHUT", "LDEXRI")
                , "CL4"
                , new Phone("010-2814-1699", "2814", "1699")
                , new Birthday("19950704")
                , "ADV"
                , 2002117175));

        ArrayList<Employee> secondCondi = new ArrayList<Employee>();
        when(employeeManager.search("SCH,-p,-d, ,birthday,04"))
                .thenReturn(firstCondi);

        ArrayList<Employee> thirdCondi = new ArrayList<Employee>();
//        SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO
        thirdCondi.add(new Employee("88114052"
                , new Name("NQ LVARW", "NQ", "LVARW")
                , "CL4"
                , new Phone("010-4528-3059", "4528", "3059")
                , new Birthday("19911021")
                , "PRO"
                , 1988114052));
//        SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO
        thirdCondi.add(new Employee("01122329"
                , new Name("DN WD", "DN", "WD")
                , "CL4"
                , new Phone("010-7174-5680", "7174", "5680")
                , new Birthday("20071117")
                , "PRO"
                , 2001122329));
//        SCH,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO
        thirdCondi.add(new Employee("03113260"
                , new Name("HH LTUPF", "HH", "LTUPF")
                , "CL2"
                , new Phone("010-5798-5383", "5798", "5383")
                , new Birthday("19791018")
                , "PRO"
                , 2003113260));
//        SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO
        thirdCondi.add(new Employee("05101762"
                , new Name("VCUHLE HMU", "VCUHLE", "HMU")
                , "CL4"
                , new Phone("010-3988-9289", "3988", "9289")
                , new Birthday("20030819")
                , "PRO"
                , 2005101762));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        thirdCondi.add(new Employee("08123556"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047", "7986", "5047")
                , new Birthday("20100614")
                , "PRO"
                , 1908123556));
        when(employeeManager.search("SCH,-p, , ,certi,PRO"))
                .thenReturn(thirdCondi);

        //임의의 6건 입력
        ArrayList<Employee> fourthCondi = new ArrayList<Employee>();
//        SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO
        fourthCondi.add(new Employee("88114052"
                , new Name("NQ LVARW", "NQ", "LVARW")
                , "CL4"
                , new Phone("010-4528-3059", "4528", "3059")
                , new Birthday("19911021")
                , "PRO"
                , 1988114052));
//        SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO
        fourthCondi.add(new Employee("01122329"
                , new Name("DN WD", "DN", "WD")
                , "CL4"
                , new Phone("010-7174-5680", "7174", "5680")
                , new Birthday("20071117")
                , "PRO"
                , 2001122329));
//        SCH,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO
        fourthCondi.add(new Employee("03113260"
                , new Name("HH LTUPF", "HH", "LTUPF")
                , "CL2"
                , new Phone("010-5798-5383", "5798", "5383")
                , new Birthday("19791018")
                , "PRO"
                , 2003113260));
//        SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO
        fourthCondi.add(new Employee("05101762"
                , new Name("VCUHLE HMU", "VCUHLE", "HMU")
                , "CL4"
                , new Phone("010-3988-9289", "3988", "9289")
                , new Birthday("20030819")
                , "PRO"
                , 2005101762));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        fourthCondi.add(new Employee("08123556"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047", "7986", "5047")
                , new Birthday("20100614")
                , "PRO"
                , 1908123556));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        fourthCondi.add(new Employee("08123557"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047", "7986", "5047")
                , new Birthday("20100614")
                , "PRO"
                , 2008123557));
        when(employeeManager.search("SCH, , , ,certi,ADV"))
                .thenReturn(fourthCondi);

        //SCH,-p,-d, ,birthday,04
        //SCH, , , ,employeeNum,79110836\
        //SCH,-p, , ,certi,PRO
        //SCH, , , ,certi,ADV

        assertEquals(firstCondi, employeeManager.search("SCH,-p,-d, ,birthday,04"));
        assertEquals(secondCondi, employeeManager.search("SCH, , , ,employeeNum,79110836"));
        assertEquals(thirdCondi, employeeManager.search("SCH,-p, , ,certi,PRO"));
        assertEquals(fourthCondi, employeeManager.search("SCH, , , ,certi,ADV"));
    }

    @Test
    void getPOption_함수_Test() {

        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put("02117175", new Employee("02117175"
                , new Name("SBILHUT LDEXRI", "SBILHUT", "LDEXRI")
                , "CL4"
                , new Phone("010-2814-1699", "2814", "1699")
                , new Birthday("19950704")
                , "ADV"
                , 2002117175));

        employeeMap.put("88114052", new Employee("88114052"
                , new Name("NQ LVARW", "NQ", "LVARW")
                , "CL4"
                , new Phone("010-4528-3059", "4528", "3059")
                , new Birthday("19911021")
                , "PRO"
                , 1988114052));
//        SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO
        employeeMap.put( "01122329", new Employee("01122329"
                , new Name("DN WD", "DN", "WD")
                , "CL4"
                , new Phone("010-7174-5680", "7174", "5680")
                , new Birthday("20071117")
                , "PRO"
                , 2001122329));
//        SCH,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO
        employeeMap.put("03113260", new Employee("03113260"
                , new Name("HH LTUPF", "HH", "LTUPF")
                , "CL2"
                , new Phone("010-5798-5383", "5798", "5383")
                , new Birthday("19791018")
                , "PRO"
                , 2003113260));
//        SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO
        employeeMap.put("05101762", new Employee("05101762"
                , new Name("VCUHLE HMU", "VCUHLE", "HMU")
                , "CL4"
                , new Phone("010-3988-9289", "3988", "9289")
                , new Birthday("20030819")
                , "PRO"
                , 2005101762));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        employeeMap.put("08123556", new Employee("08123556"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047", "7986", "5047")
                , new Birthday("20100614")
                , "PRO"
                , 2008123556));

        ArrayList<String> empnoList = new ArrayList<>();
        empnoList.add("08123556");
        empnoList.add("05101762");
        empnoList.add("03113260");

        ArrayList<Employee> EmployeeList = new ArrayList<>();
        EmployeeList.add(new Employee("03113260"
                , new Name("HH LTUPF", "HH", "LTUPF")
                , "CL2"
                , new Phone("010-5798-5383", "5798", "5383")
                , new Birthday("19791018")
                , "PRO"
                , 2003113260));
        EmployeeList.add(new Employee("05101762"
                , new Name("VCUHLE HMU", "VCUHLE", "HMU")
                , "CL4"
                , new Phone("010-3988-9289", "3988", "9289")
                , new Birthday("20030819")
                , "PRO"
                , 2005101762));
        EmployeeList.add(new Employee("08123556"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047", "7986", "5047")
                , new Birthday("20100614")
                , "PRO"
                , 2008123556));

        CRUDManager search = new Search();
        assertEquals(EmployeeList, search.getPOption(employeeMap, empnoList));

        empnoList = new ArrayList<>();
        empnoList.add("08123556");
        empnoList.add("05101762");
        empnoList.add("03113260");
        empnoList.add("02117175");
        empnoList.add("88114052");
        empnoList.add("01122329");
        EmployeeList = new ArrayList<>();
        EmployeeList.add(new Employee("88114052"
                , new Name("NQ LVARW", "NQ", "LVARW")
                , "CL4"
                , new Phone("010-4528-3059", "4528", "3059")
                , new Birthday("19911021")
                , "PRO"
                , 1988114052));
        EmployeeList.add(new Employee("01122329"
                , new Name("DN WD", "DN", "WD")
                , "CL4"
                , new Phone("010-7174-5680", "7174", "5680")
                , new Birthday("20071117")
                , "PRO"
                , 2001122329));
        EmployeeList.add(new Employee("02117175"
                , new Name("SBILHUT LDEXRI", "SBILHUT", "LDEXRI")
                , "CL4"
                , new Phone("010-2814-1699", "2814", "1699")
                , new Birthday("19950704")
                , "ADV"
                , 2002117175));
        EmployeeList.add(new Employee("03113260"
                , new Name("HH LTUPF", "HH", "LTUPF")
                , "CL2"
                , new Phone("010-5798-5383", "5798", "5383")
                , new Birthday("19791018")
                , "PRO"
                , 2003113260));
        EmployeeList.add(new Employee("05101762"
                , new Name("VCUHLE HMU", "VCUHLE", "HMU")
                , "CL4"
                , new Phone("010-3988-9289", "3988", "9289")
                , new Birthday("20030819")
                , "PRO"
                , 2005101762));

        assertEquals(EmployeeList, search.getPOption(employeeMap, empnoList));

    }

    @Test
    void getEmpnoList_함수_Test() {

        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put("02117175", new Employee("02117175"
                , new Name("SBILHUT LDEXRI", "SBILHUT", "LDEXRI")
                , "CL4"
                , new Phone("010-2814-1699", "2814", "1699")
                , new Birthday("19950704")
                , "ADV"
                , 2002117175));

        employeeMap.put("88114052", new Employee("88114052"
                , new Name("NQ LVARW", "NQ", "LVARW")
                , "CL4"
                , new Phone("010-4528-3059", "4528", "3059")
                , new Birthday("19911021")
                , "PRO"
                , 1988114052));
//        SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO
        employeeMap.put( "01122329", new Employee("01122329"
                , new Name("DN WD", "DN", "WD")
                , "CL4"
                , new Phone("010-7174-5680", "7174", "5680")
                , new Birthday("20071117")
                , "PRO"
                , 2001122329));
//        SCH,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO
        employeeMap.put("03113260", new Employee("03113260"
                , new Name("HH LTUPF", "HH", "LTUPF")
                , "CL2"
                , new Phone("010-5798-5383", "5798", "5383")
                , new Birthday("19791018")
                , "PRO"
                , 2003113260));
//        SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO
        employeeMap.put("05101762", new Employee("05101762"
                , new Name("VCUHLE HMU", "VCUHLE", "HMU")
                , "CL4"
                , new Phone("010-3988-9289", "3988", "9289")
                , new Birthday("20030819")
                , "PRO"
                , 2005101762));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        employeeMap.put("08123556", new Employee("08123556"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047", "7986", "5047")
                , new Birthday("20100614")
                , "PRO"
                , 2008123556));

        CRUDManager search = new Search();
        ArrayList<String> expectedVal1 = new ArrayList<>();
        expectedVal1.add("08123556");
        assertEquals( expectedVal1, search.getEmpNoList(employeeMap, "SCH,-p,-f, ,name,WN"));
        assertEquals( expectedVal1, search.getEmpNoList(employeeMap, "SCH,-p,-l, ,name,XV"));


        ArrayList<String> expectedVal2 = new ArrayList<>();
        expectedVal2.add("03113260");
        expectedVal2.add("08123556");
        assertEquals( expectedVal2, search.getEmpNoList(employeeMap, "SCH,-p,-m, ,phone,79"));
        ArrayList<String> expectedVal3 = new ArrayList<>();
        expectedVal3.add("05101762");
        assertEquals( expectedVal3, search.getEmpNoList(employeeMap, "SCH,-p,-l, ,phone,92"));
        ArrayList<String> expectedVal4 = new ArrayList<>();
        expectedVal4.add("05101762");
        assertEquals( expectedVal4, search.getEmpNoList(employeeMap, "SCH,-p,-l, ,phone,92"));
        ArrayList<String> expectedVal5 = new ArrayList<>();
        expectedVal5.add("08123556");
        assertEquals( expectedVal5, search.getEmpNoList(employeeMap, "SCH,-p,-y, ,birthday,2010"));
        ArrayList<String> expectedVal6 = new ArrayList<>();
        expectedVal6.add("05101762");
        assertEquals( expectedVal6, search.getEmpNoList(employeeMap, "SCH,-p,-m, ,birthday,08"));
        ArrayList<String> expectedVal7 = new ArrayList<>();
        expectedVal7.add("03113260");
        assertEquals( expectedVal7, search.getEmpNoList(employeeMap, "SCH,-p,-d, ,birthday,18"));
        ArrayList<String> expectedVal8 = new ArrayList<>();
        expectedVal8.add("01122329");
        expectedVal8.add("08123556");
        assertEquals( expectedVal8, search.getEmpNoList(employeeMap, "SCH,-p, , ,employeeNum,12"));
        ArrayList<String> expectedVal9 = new ArrayList<>();
        expectedVal9.add("03113260");
        assertEquals( expectedVal9, search.getEmpNoList(employeeMap, "SCH,-p, , ,name,HH"));
        ArrayList<String> expectedVal10 = new ArrayList<>();
        expectedVal10.add("03113260");
        assertEquals( expectedVal10, search.getEmpNoList(employeeMap, "SCH,-p, , ,cl,CL2"));
        ArrayList<String> expectedVal11 = new ArrayList<>();
        expectedVal11.add("03113260");
        expectedVal11.add("08123556");
        assertEquals( expectedVal11, search.getEmpNoList(employeeMap, "SCH,-p, , ,phoneNum,79"));
        ArrayList<String> expectedVal12 = new ArrayList<>();
        expectedVal12.add("08123556");
        assertEquals( expectedVal12, search.getEmpNoList(employeeMap, "SCH,-p, , ,birthday,1006"));
        ArrayList<String> expectedVal13 = new ArrayList<>();
        expectedVal13.add("02117175");
        assertEquals( expectedVal13, search.getEmpNoList(employeeMap, "SCH,-p, , ,certi,ADV"));

    }

    @Test
    void search_함수_Test() {
        ArrayList<Employee> employees = new ArrayList<>();
        EmployeeManager employeeManager = new EmployeeManager(employees);

        employeeManager.add("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        employeeManager.add("ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO");
        employeeManager.add("ADD, , , ,18115040,TTETHU HBO,CL3,010-4581-2050,20080718,ADV");
        employeeManager.add("ADD, , , ,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO");
        employeeManager.add("ADD, , , ,19129568,SRERLALH HMEF,CL2,010-3091-9521,19640910,PRO");
        employeeManager.add("ADD, , , ,17111236,VSID TVO,CL1,010-3669-1077,20120718,PRO");
        employeeManager.add("ADD, , , ,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO");
        employeeManager.add("ADD, , , ,08123556,WN XV,CL1,010-7986-5047,20100614,PRO");
        employeeManager.add("ADD, , , ,02117175,SBILHUT LDEXRI,CL4,010-2814-1699,19950704,ADV");
        employeeManager.add("ADD, , , ,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO");
        employeeManager.add("ADD, , , ,14130827,RPO JK,CL4,010-3231-1698,20090201,ADV");
        employeeManager.add("ADD, , , ,01122329,DN WD,CL4,010-7174-5680,20071117,PRO");
        employeeManager.add("ADD, , , ,08108827,RTAH VNUP,CL4,010-9031-2726,19780417,ADV");
        employeeManager.add("ADD, , , ,85125741,FBAH RTIJ,CL1,010-8900-1478,19780228,ADV");
        employeeManager.add("ADD, , , ,08117441,BMU MPOSXU,CL3,010-2703-3153,20010215,ADV");
        employeeManager.add("ADD, , , ,10127115, KBU MHU, CL3, 010 - 3284 - 4054, 19660814, ADV");
        employeeManager.add("ADD, , , ,12117017,LFIS JJIVL,CL1,010-7914-4067,20120812,PRO");
        employeeManager.add("ADD, , , ,11125777, TKOQKIS HC, CL1, 010 - 6734 - 2289, 19991001, PRO");
        employeeManager.add("ADD, , , ,11109136,QKAHCEX LTODDO,CL4,010-2627-8566,19640130,PRO");
        employeeManager.add("ADD, , , ,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO");


        ArrayList<Employee> firstCondi = new ArrayList<Employee>();
        firstCondi.add(new Employee("02117175"
                , new Name("SBILHUT LDEXRI", "SBILHUT", "LDEXRI")
                , "CL4"
                , new Phone("010-2814-1699", "2814", "1699")
                , new Birthday("19950704")
                , "ADV"
                , 2002117175));

        ArrayList<Employee> secondCondi = new ArrayList<Employee>();

        ArrayList<Employee> thirdCondi = new ArrayList<Employee>();
//        SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO
        thirdCondi.add(new Employee("88114052"
                , new Name("NQ LVARW", "NQ", "LVARW")
                , "CL4"
                , new Phone("010-4528-3059", "4528", "3059")
                , new Birthday("19911021")
                , "PRO"
                , 1988114052));
//        SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO
        thirdCondi.add(new Employee("01122329"
                , new Name("DN WD", "DN", "WD")
                , "CL4"
                , new Phone("010-7174-5680", "7174", "5680")
                , new Birthday("20071117")
                , "PRO"
                , 2001122329));
//        SCH,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO
        thirdCondi.add(new Employee("03113260"
                , new Name("HH LTUPF", "HH", "LTUPF")
                , "CL2"
                , new Phone("010-5798-5383", "5798", "5383")
                , new Birthday("19791018")
                , "PRO"
                , 2003113260));
//        SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO
        thirdCondi.add(new Employee("05101762"
                , new Name("VCUHLE HMU", "VCUHLE", "HMU")
                , "CL4"
                , new Phone("010-3988-9289", "3988", "9289")
                , new Birthday("20030819")
                , "PRO"
                , 2005101762));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        thirdCondi.add(new Employee("08123556"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047", "7986", "5047")
                , new Birthday("20100614")
                , "PRO"
                , 2008123556));


        assertEquals(firstCondi, employeeManager.search("SCH,-p,-d, ,birthday,04"));
        assertEquals(secondCondi, employeeManager.search("SCH, , , ,employeeNum,79110836"));
        assertEquals(thirdCondi, employeeManager.search("SCH,-p, , ,certi,PRO"));
    }
}
