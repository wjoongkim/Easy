import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static public void main(String[] args) throws IOException {

        String inputFileName = args[0];
        String outputFileName = args[1];
        String inputLine;

        EmployeeManager employeeManager = new EmployeeManager(new ArrayList<Employee>());

        BufferedReader br = new BufferedReader(new FileReader(inputFileName));
        while ((inputLine = br.readLine())!=null) {

            String[] tokens = inputLine.split(",");

            switch (tokens[0]) {
                case "ADD" :
                    employeeManager.add(inputLine);
                    break;
                case "SCH" :
                    employeeManager.search(inputLine);
                    break;
                case "MOD" :
                    employeeManager.modify(inputLine);
                    break;
                case "DEL" :
                    employeeManager.delete(args); //임시 에러 방지를 위해 인자를 args로 변경
                    break;
            }
        }

        br.close();

//        System.out.println("Hello Easy Member");
//        System.out.println("Go! Go! Team Project");
//        System.out.println("드디어 ㅠㅠㅠ");
//        System.out.println("Hello Code Review World!");
    }
}
