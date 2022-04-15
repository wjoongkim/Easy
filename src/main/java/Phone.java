import java.util.Objects;

public class Phone {
    private String phoneNumFull;
    private String phoneNumMiddle;
    private String phoneNumLast;

    public Phone(String phoneNum, String phoneNumMiddle, String phoneNumLast) {
        this.phoneNumFull = phoneNum;
        this.phoneNumMiddle = phoneNumMiddle;
        this.phoneNumLast = phoneNumLast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(phoneNumFull, phone.phoneNumFull) && Objects.equals(phoneNumMiddle, phone.phoneNumMiddle) && Objects.equals(phoneNumLast, phone.phoneNumLast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumFull, phoneNumMiddle, phoneNumLast);
    }

    public String getPhoneNumFull() {
        return phoneNumFull;
    }

    public void setPhoneNumFull(String phoneNumFull) {
        this.phoneNumFull = phoneNumFull;
    }

    public String getPhoneNumMiddle() {
        return phoneNumMiddle;
    }

    public void setPhoneNumMiddle(String phoneNumMiddle) {
        this.phoneNumMiddle = phoneNumMiddle;
    }

    public String getPhoneNumLast() {
        return phoneNumLast;
    }

    public void setPhoneNumLast(String phoneNumLast) {
        this.phoneNumLast = phoneNumLast;
    }
}
