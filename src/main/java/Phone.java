import java.util.Objects;

public class Phone {
    private String phoneNum;
    private String phoneNumMiddle;
    private String phoneNumLast;

    public Phone(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(phoneNum, phone.phoneNum) && Objects.equals(phoneNumMiddle, phone.phoneNumMiddle) && Objects.equals(phoneNumLast, phone.phoneNumLast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNum, phoneNumMiddle, phoneNumLast);
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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