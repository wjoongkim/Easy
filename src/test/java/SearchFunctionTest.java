import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class SearchFunctionTest {
    @Mock
    private IEmployeeManager iEmployeeManagerMock;

    @BeforeEach
    void before_Mock_Setting(){

        ArrayList<Employee> firstCondi = new ArrayList<Employee>();
        firstCondi.add(new Employee("02117175"
                , new Name("SBILHUT LDEXRI", "SBILHUT", "LDEXRI")
                , "CL4"
                , new Phone("010-2814-1699","2814","1699")
                , new Date(1995, 7 ,4)
                , "ADV"
                , new Date(2002, 1 ,1)));


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
                , new Phone("010-4528-3059","4528","3059")
                , new Date(1991, 10 ,21)
                , "PRO"
                , new Date(1988, 1 ,1)));
//        SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO
        thirdCondi.add(new Employee("01122329"
                , new Name("DN WD", "DN", "WD")
                , "CL4"
                , new Phone("010-7174-5680","7174","5680")
                , new Date(2007, 11 ,17)
                , "PRO"
                , new Date(2001, 1 ,1)));
//        SCH,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO
        thirdCondi.add(new Employee("03113260"
                , new Name("HH LTUPF", "HH", "LTUPF")
                , "CL2"
                , new Phone("010-5798-5383","5798","5383")
                , new Date(1979, 10 ,18)
                , "PRO"
                , new Date(2003, 1 ,1)));
//        SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO
        thirdCondi.add(new Employee("05101762"
                , new Name("VCUHLE HMU", "VCUHLE", "HMU")
                , "CL4"
                , new Phone("010-3988-9289","3988","9289")
                , new Date(2003, 8 ,19)
                , "PRO"
                , new Date(2005, 1 ,1)));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        thirdCondi.add(new Employee("08123556"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047","7986","5047")
                , new Date(2010, 06 ,14)
                , "PRO"
                , new Date(1988, 1 ,1)));
        when(iEmployeeManagerMock.search("SCH,-p, , ,certi,PRO"))
                .thenReturn(thirdCondi);

        //임의의 6건 입력
        ArrayList<Employee> fourthCondi = new ArrayList<Employee>();
//        SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO
        fourthCondi.add(new Employee("88114052"
                , new Name("NQ LVARW", "NQ", "LVARW")
                , "CL4"
                , new Phone("010-4528-3059","4528","3059")
                , new Date(1991, 10 ,21)
                , "PRO"
                , new Date(1988, 1 ,1)));
//        SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO
        fourthCondi.add(new Employee("01122329"
                , new Name("DN WD", "DN", "WD")
                , "CL4"
                , new Phone("010-7174-5680","7174","5680")
                , new Date(2007, 11 ,17)
                , "PRO"
                , new Date(2001, 1 ,1)));
//        SCH,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO
        fourthCondi.add(new Employee("03113260"
                , new Name("HH LTUPF", "HH", "LTUPF")
                , "CL2"
                , new Phone("010-5798-5383","5798","5383")
                , new Date(1979, 10 ,18)
                , "PRO"
                , new Date(2003, 1 ,1)));
//        SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO
        fourthCondi.add(new Employee("05101762"
                , new Name("VCUHLE HMU", "VCUHLE", "HMU")
                , "CL4"
                , new Phone("010-3988-9289","3988","9289")
                , new Date(2003, 8 ,19)
                , "PRO"
                , new Date(2005, 1 ,1)));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        fourthCondi.add(new Employee("08123556"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047","7986","5047")
                , new Date(2010, 6 ,14)
                , "PRO"
                , new Date(1988, 1 ,1)));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        fourthCondi.add(new Employee("08123557"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047","7986","5047")
                , new Date(2010, 06 ,14)
                , "PRO"
                , new Date(1988, 1 ,1)));
        when(iEmployeeManagerMock.search("SCH, , , ,certi,ADV"))
                .thenReturn(fourthCondi);

    }

    @Test
    void search_함수_Mock_Test() throws ParseException {



        ArrayList<Employee> firstCondi = new ArrayList<Employee>();
        firstCondi.add(new Employee("02117175"
                , new Name("SBILHUT LDEXRI", "SBILHUT", "LDEXRI")
                , "CL4"
                , new Phone("010-2814-1699","2814","1699")
                , new Date(1995, 7 ,4)
                , "ADV"
                , new Date(2002, 1 ,1)));

        ArrayList<Employee> secondCondi = new ArrayList<Employee>();

        ArrayList<Employee> thirdCondi = new ArrayList<Employee>();
//        SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO
        thirdCondi.add(new Employee("88114052"
                , new Name("NQ LVARW", "NQ", "LVARW")
                , "CL4"
                , new Phone("010-4528-3059","4528","3059")
                , new Date(1991, 10 ,21)
                , "PRO"
                , new Date(1988, 1 ,1)));
//        SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO
        thirdCondi.add(new Employee("01122329"
                , new Name("DN WD", "DN", "WD")
                , "CL4"
                , new Phone("010-7174-5680","7174","5680")
                , new Date(2007, 11 ,17)
                , "PRO"
                , new Date(2001, 1 ,1)));
//        SCH,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO
        thirdCondi.add(new Employee("03113260"
                , new Name("HH LTUPF", "HH", "LTUPF")
                , "CL2"
                , new Phone("010-5798-5383","5798","5383")
                , new Date(1979, 10 ,18)
                , "PRO"
                , new Date(2003, 1 ,1)));
//        SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO
        thirdCondi.add(new Employee("05101762"
                , new Name("VCUHLE HMU", "VCUHLE", "HMU")
                , "CL4"
                , new Phone("010-3988-9289","3988","9289")
                , new Date(2003, 8 ,19)
                , "PRO"
                , new Date(2005, 1 ,1)));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        thirdCondi.add(new Employee("08123556"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047","7986","5047")
                , new Date(2010, 6 ,14)
                , "PRO"
                , new Date(1988, 1 ,1)));

        //임의의 6건 입력
        ArrayList<Employee> fourthCondi = new ArrayList<Employee>();
//        SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO
        fourthCondi.add(new Employee("88114052"
                , new Name("NQ LVARW", "NQ", "LVARW")
                , "CL4"
                , new Phone("010-4528-3059","4528","3059")
                , new Date(1991, 10 ,21)
                , "PRO"
                , new Date(1988, 1 ,1)));
//        SCH,01122329,DN WD,CL4,010-7174-5680,20071117,PRO
        fourthCondi.add(new Employee("01122329"
                , new Name("DN WD", "DN", "WD")
                , "CL4"
                , new Phone("010-7174-5680","7174","5680")
                , new Date(2007, 11 ,17)
                , "PRO"
                , new Date(2001, 1 ,1)));
//        SCH,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO
        fourthCondi.add(new Employee("03113260"
                , new Name("HH LTUPF", "HH", "LTUPF")
                , "CL2"
                , new Phone("010-5798-5383","5798","5383")
                , new Date(1979, 10 ,18)
                , "PRO"
                , new Date(2003, 1 ,1)));
//        SCH,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO
        fourthCondi.add(new Employee("05101762"
                , new Name("VCUHLE HMU", "VCUHLE", "HMU")
                , "CL4"
                , new Phone("010-3988-9289","3988","9289")
                , new Date(2003, 8 ,19)
                , "PRO"
                , new Date(2005, 1 ,1)));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        fourthCondi.add(new Employee("08123556"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047","7986","5047")
                , new Date(2010, 6 ,14)
                , "PRO"
                , new Date(1988, 1 ,1)));
//        SCH,08123556,WN XV,CL1,010-7986-5047,20100614,PRO
        fourthCondi.add(new Employee("08123557"
                , new Name("WN XV", "WN", "XV")
                , "CL1"
                , new Phone("010-7986-5047","7986","5047")
                , new Date(2010, 6 ,14)
                , "PRO"
                , new Date(1988, 1 ,1)));

        //SCH,-p,-d, ,birthday,04
        //SCH, , , ,employeeNum,79110836\
        //SCH,-p, , ,certi,PRO
        //SCH, , , ,certi,ADV

        assertEquals(firstCondi, iEmployeeManagerMock.search("SCH,-p,-d, ,birthday,04"));
        assertEquals(secondCondi, iEmployeeManagerMock.search("SCH, , , ,employeeNum,79110836"));
        assertEquals(thirdCondi, iEmployeeManagerMock.search("SCH,-p, , ,certi,PRO"));
        assertEquals(fourthCondi, iEmployeeManagerMock.search("SCH, , , ,certi,ADV"));
    }
}
