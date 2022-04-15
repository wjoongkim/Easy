import java.util.Objects;

public class Phone {
    private String fullNumber;
    private String middleNumber;
    private String lastNumber;

    public Phone(String phoneNum, String phoneNumMiddle, String phoneNumLast) {
        this.fullNumber = fullNumber;
        this.middleNumber = middleNumber;
        this.lastNumber = lastNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(fullNumber, phone.fullNumber) && Objects.equals(middleNumber, phone.middleNumber) && Objects.equals(lastNumber, phone.lastNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullNumber, middleNumber, lastNumber);
    }

    public String getFullNumber() {
        return fullNumber;
    }

    public void setFullNumber(String fullNumber) {
        this.fullNumber = fullNumber;
    }

    public String getMiddleNumber() {
        return middleNumber;
    }

    public void setMiddleNumber(String middleNumber) {
        this.middleNumber = middleNumber;
    }

    public String getLastNumber() {
        return lastNumber;
    }

    public void setLastNumber(String lastNumber) {
        this.lastNumber = lastNumber;
    }
}
