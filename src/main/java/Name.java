import java.util.Objects;

public class Name {
    private String name;
    private String nameFirst;
    private String nameLast;

    public Name(String name, String nameFirst, String nameLast) {
        this.name = name;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name) && Objects.equals(nameFirst, name1.nameFirst) && Objects.equals(nameLast, name1.nameLast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nameFirst, nameLast);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }
}
