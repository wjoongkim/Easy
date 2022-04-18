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

        String inputFileName = args[0];
        String outputFileName = args[1];
        BufferedWriter output = new BufferedWriter(new FileWriter(outputFileName));
        BufferedReader input = new BufferedReader(new FileReader(inputFileName));
        EmployeeManager employeeManager = new EmployeeManager();
        String inputLine;

        while ((inputLine = input.readLine()) != null) {

            String[] tokens = inputLine.split(",");

            switch (tokens[0]) {
                case "ADD":
                    employeeManager.add.calc(inputLine);
                    break;
                case "SCH":
                    output.write(employeeManager.search.calc(inputLine));
                    output.newLine();
                    output.flush();
                    break;
                case "MOD":
                    output.write(employeeManager.modify.calc(inputLine));
                    output.newLine();
                    output.flush();
                    break;
                case "DEL":
                    output.write(employeeManager.delete.calc(inputLine));
                    output.newLine();
                    output.flush();
                    break;
            }
        }
        input.close();
        output.close();
    }
}
