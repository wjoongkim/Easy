import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class SearchFunctionTest {
    @Mock
    private IEmployeeManager iEmployeeManagerMock;

    @BeforeEach
    void before_Mock_Setting() {

        ArrayList<Employee> firstCondi = new ArrayList<Employee>();
        firstCondi.add(new Employee("02117175"
                , new Name("SBILHUT LDEXRI", "SBILHUT", "LDEXRI")
                , "CL4"
                , new Phone("010-2814-1699", "2814", "1699")
                , new Birthday("19950704")
                , "ADV"
                , 2002));


        when(iEmployeeManagerMock.search("SCH,-p,-d, ,birthday,04"))
                .thenReturn(firstCondi);

        ArrayList<Employee> secondCondi = new ArrayList<Employee>();
        when(iEmployeeManagerMock.search("SCH, , , ,employeeNum,79110836"))
                .thenReturn(secondCondi);

        ArrayList<Employee> thirdCondi = new ArrayList<Employee>();
//        SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO
        thirdCondi.add(new Employee("88114052"
                , new Name("NQ LVARW", "NQ", "LVARW")
                , "CL4"
                , new Phone("010-4528-3059", "4528", "3059")
                , new Birthday("19911021")
                , "PRO"
                , 1988));
//        SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO
        thirdCondi.add(new Employee("01122329"
                , new Name("DN WD", "DN", "WD")
                , "CL4"
                , new Phone("010-7174-5680", "7174", "5680")
                , new Birthday("20071117")
                , "PRO"
                , 2001));
//        SCH,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO
        thirdCondi.add(new Employee("03113260"
                , new Name("HH LTUPF", "HH", "LTUPF")
                , "CL2"
                , new Phone("010-5798-5383", "5798", "5383")
                , new Birthday("19791018")
                , "PRO"
                , 2003));
//        SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO
        thirdCondi.add(new Employee("05101762"
                , new Name("VCUHLE HMU", "VCUHLE", "HMU")
                , "CL4"
                , new Phone("010-3988-9289", "3988", "9289")
                , new Birthday("20030819")
                , "PRO"
                , 2005));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        thirdCondi.add(new Employee("08123556"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047", "7986", "5047")
                , new Birthday("20100614")
                , "PRO"
                , 1988));
        when(iEmployeeManagerMock.search("SCH,-p, , ,certi,PRO"))
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
                , 1988));
//        SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO
        fourthCondi.add(new Employee("01122329"
                , new Name("DN WD", "DN", "WD")
                , "CL4"
                , new Phone("010-7174-5680", "7174", "5680")
                , new Birthday("20071117")
                , "PRO"
                , 2001));
//        SCH,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO
        fourthCondi.add(new Employee("03113260"
                , new Name("HH LTUPF", "HH", "LTUPF")
                , "CL2"
                , new Phone("010-5798-5383", "5798", "5383")
                , new Birthday("19791018")
                , "PRO"
                , 2003));
//        SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO
        fourthCondi.add(new Employee("05101762"
                , new Name("VCUHLE HMU", "VCUHLE", "HMU")
                , "CL4"
                , new Phone("010-3988-9289", "3988", "9289")
                , new Birthday("20030819")
                , "PRO"
                , 2005));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        fourthCondi.add(new Employee("08123556"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047", "7986", "5047")
                , new Birthday("20100614")
                , "PRO"
                , 1988));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        fourthCondi.add(new Employee("08123557"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047", "7986", "5047")
                , new Birthday("20100614")
                , "PRO"
                , 2008));
        when(iEmployeeManagerMock.search("SCH, , , ,certi,ADV"))
                .thenReturn(fourthCondi);

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
                , 2002));

        ArrayList<Employee> secondCondi = new ArrayList<Employee>();

        ArrayList<Employee> thirdCondi = new ArrayList<Employee>();
//        SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO
        thirdCondi.add(new Employee("88114052"
                , new Name("NQ LVARW", "NQ", "LVARW")
                , "CL4"
                , new Phone("010-4528-3059", "4528", "3059")
                , new Birthday("19911021")
                , "PRO"
                , 1988));
//        SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO
        thirdCondi.add(new Employee("01122329"
                , new Name("DN WD", "DN", "WD")
                , "CL4"
                , new Phone("010-7174-5680", "7174", "5680")
                , new Birthday("20071117")
                , "PRO"
                , 2001));
//        SCH,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO
        thirdCondi.add(new Employee("03113260"
                , new Name("HH LTUPF", "HH", "LTUPF")
                , "CL2"
                , new Phone("010-5798-5383", "5798", "5383")
                , new Birthday("19791018")
                , "PRO"
                , 2003));
//        SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO
        thirdCondi.add(new Employee("05101762"
                , new Name("VCUHLE HMU", "VCUHLE", "HMU")
                , "CL4"
                , new Phone("010-3988-9289", "3988", "9289")
                , new Birthday("20030819")
                , "PRO"
                , 2005));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        thirdCondi.add(new Employee("08123556"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047", "7986", "5047")
                , new Birthday("20100614")
                , "PRO"
                , 1988));

        //임의의 6건 입력
        ArrayList<Employee> fourthCondi = new ArrayList<Employee>();
//        SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO
        fourthCondi.add(new Employee("88114052"
                , new Name("NQ LVARW", "NQ", "LVARW")
                , "CL4"
                , new Phone("010-4528-3059", "4528", "3059")
                , new Birthday("19911021")
                , "PRO"
                , 1988));
//        SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO
        fourthCondi.add(new Employee("01122329"
                , new Name("DN WD", "DN", "WD")
                , "CL4"
                , new Phone("010-7174-5680", "7174", "5680")
                , new Birthday("20071117")
                , "PRO"
                , 2001));
//        SCH,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO
        fourthCondi.add(new Employee("03113260"
                , new Name("HH LTUPF", "HH", "LTUPF")
                , "CL2"
                , new Phone("010-5798-5383", "5798", "5383")
                , new Birthday("19791018")
                , "PRO"
                , 2003));
//        SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO
        fourthCondi.add(new Employee("05101762"
                , new Name("VCUHLE HMU", "VCUHLE", "HMU")
                , "CL4"
                , new Phone("010-3988-9289", "3988", "9289")
                , new Birthday("20030819")
                , "PRO"
                , 2005));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        fourthCondi.add(new Employee("08123556"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047", "7986", "5047")
                , new Birthday("20100614")
                , "PRO"
                , 1988));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        fourthCondi.add(new Employee("08123557"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047", "7986", "5047")
                , new Birthday("20100614")
                , "PRO"
                , 2008));

        //SCH,-p,-d, ,birthday,04
        //SCH, , , ,employeeNum,79110836\
        //SCH,-p, , ,certi,PRO
        //SCH, , , ,certi,ADV

        assertEquals(firstCondi, iEmployeeManagerMock.search("SCH,-p,-d, ,birthday,04"));
        assertEquals(secondCondi, iEmployeeManagerMock.search("SCH, , , ,employeeNum,79110836"));
        assertEquals(thirdCondi, iEmployeeManagerMock.search("SCH,-p, , ,certi,PRO"));
        assertEquals(fourthCondi, iEmployeeManagerMock.search("SCH, , , ,certi,ADV"));
    }

    @Test
    void search_함수_Test() {
        ArrayList<Employee> employees = new ArrayList<>();
        IEmployeeManager employeeManager = new EmployeeManager(employees);

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
        employeeManager.add("ADD, , , , 10127115, KBU MHU, CL3, 010 - 3284 - 4054, 19660814, ADV");
        employeeManager.add("ADD, , , ,12117017,LFIS JJIVL,CL1,010-7914-4067,20120812,PRO");
        employeeManager.add("ADD, , , , 11125777, TKOQKIS HC, CL1, 010 - 6734 - 2289, 19991001, PRO");
        employeeManager.add("ADD, , , ,11109136,QKAHCEX LTODDO,CL4,010-2627-8566,19640130,PRO");
        employeeManager.add("ADD, , , ,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO");


        ArrayList<Employee> firstCondi = new ArrayList<Employee>();
        firstCondi.add(new Employee("02117175"
                , new Name("SBILHUT LDEXRI", "SBILHUT", "LDEXRI")
                , "CL4"
                , new Phone("010-2814-1699", "2814", "1699")
                , new Birthday("19950704")
                , "ADV"
                , 2002));

        ArrayList<Employee> secondCondi = new ArrayList<Employee>();

        ArrayList<Employee> thirdCondi = new ArrayList<Employee>();
//        SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO
        thirdCondi.add(new Employee("88114052"
                , new Name("NQ LVARW", "NQ", "LVARW")
                , "CL4"
                , new Phone("010-4528-3059", "4528", "3059")
                , new Birthday("19911021")
                , "PRO"
                , 1988));
//        SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO
        thirdCondi.add(new Employee("01122329"
                , new Name("DN WD", "DN", "WD")
                , "CL4"
                , new Phone("010-7174-5680", "7174", "5680")
                , new Birthday("20071117")
                , "PRO"
                , 2001));
//        SCH,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO
        thirdCondi.add(new Employee("03113260"
                , new Name("HH LTUPF", "HH", "LTUPF")
                , "CL2"
                , new Phone("010-5798-5383", "5798", "5383")
                , new Birthday("19791018")
                , "PRO"
                , 2003));
//        SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO
        thirdCondi.add(new Employee("05101762"
                , new Name("VCUHLE HMU", "VCUHLE", "HMU")
                , "CL4"
                , new Phone("010-3988-9289", "3988", "9289")
                , new Birthday("20030819")
                , "PRO"
                , 2005));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        thirdCondi.add(new Employee("08123556"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047", "7986", "5047")
                , new Birthday("20100614")
                , "PRO"
                , 1988));

        assertEquals(firstCondi, iEmployeeManagerMock.search("SCH,-p,-d, ,birthday,04"));
        assertEquals(secondCondi, iEmployeeManagerMock.search("SCH, , , ,employeeNum,79110836"));
        assertEquals(thirdCondi, iEmployeeManagerMock.search("SCH,-p, , ,certi,PRO"));
    }
}
