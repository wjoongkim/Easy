import java.util.Date;
import java.util.Objects;

public class Employee {
    private String employeeNum;
    private Name name;
    private String cl;
    private Phone phoneNum;
    private Birthday birthday;
    private String certi;
    private int joinYear;

    public Employee(String employeeNum, Name name, String cl, Phone phoneNum, Birthday birthday, String certi, int joinYear) {
        this.employeeNum = employeeNum;
        this.name = name;
        this.cl = cl;
        this.phoneNum = phoneNum;
        this.birthday = birthday;
        this.certi = certi;
        this.joinYear = joinYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeNum, employee.employeeNum) && Objects.equals(name, employee.name) && Objects.equals(cl, employee.cl) && Objects.equals(phoneNum, employee.phoneNum) && Objects.equals(birthday, employee.birthday) && Objects.equals(certi, employee.certi) && Objects.equals(joinYear, employee.joinYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNum, name, cl, phoneNum, birthday, certi, joinYear);
    }

    public String getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(String employeeNum) {
        this.employeeNum = employeeNum;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public Phone getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Phone phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Birthday getBirthday() {
        return birthday;
    }

    public void setBirthday(Birthday birthday) {
        this.birthday = birthday;
    }

    public String getCerti() {
        return certi;
    }

    public void setCerti(String certi) {
        this.certi = certi;
    }

    public int getJoinYear() {
        return joinYear;
    }

    public void setJoinYear(int joinYear) {
        this.joinYear = joinYear;
    }

    public String getEmpInfo(String op) {
        return op + "," + employeeNum + "," + name.getFullName() + "," + cl + "," + phoneNum.getFullNumber() + ',' + getBirthday().getBirthday() + ',' + getCerti();
    }
}
