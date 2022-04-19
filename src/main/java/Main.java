import java.io.*;

public class Main {
    static public void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Argument 수가 맞지 않습니다.");
            return;
        }

        if (args[0].contains("/") || args[0].contains("\\") || args[1].contains("/") || args[1].contains("\\")) {
            System.out.println("argument에 허용되지 않는 문자가 있습니다.");
            return;
        }

        String path = System.getProperty("user.dir");

        String inputFileName = path + "\\" + args[0];
        String outputFileName = path + "\\" + args[1];
        BufferedWriter output = new BufferedWriter(new FileWriter(outputFileName));
        BufferedReader input = new BufferedReader(new FileReader(inputFileName));
        EmployeeManager employeeManager = new EmployeeManager();
        String inputLine;

        while ((inputLine = input.readLine()) != null) {

            String[] tokens = inputLine.split(",");

            switch (tokens[0]) {
                case "ADD":
                    employeeManager.getAdd().calc(inputLine);
                    break;
                case "SCH":
                    output.write(employeeManager.getSearch().calc(inputLine));
                    output.newLine();
                    output.flush();
                    break;
                case "MOD":
                    output.write(employeeManager.getModify().calc(inputLine));
                    output.newLine();
                    output.flush();
                    break;
                case "DEL":
                    output.write(employeeManager.getDelete().calc(inputLine));
                    output.newLine();
                    output.flush();
                    break;
            }
        }
        System.out.println("작업을 정상적으로 완료 했습니다!!");
        input.close();
        output.close();
    }
}
