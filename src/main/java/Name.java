import java.util.Objects;

public class Name {
    private String fullName;
    private String firstName;
    private String lastName;

    public Name(String fullName, String firstName, String lastName) {
        this.fullName = fullName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(fullName, name1.fullName) && Objects.equals(firstName, name1.firstName) && Objects.equals(lastName, name1.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, firstName, lastName);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
