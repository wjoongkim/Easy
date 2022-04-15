import java.util.Objects;

public class Birthday {
    String birthday;
    String year;
    String month;
    String day;

    Birthday(String birthday) {
        this.birthday = birthday;
        this.year = birthday.substring(0, 4);
        this.month = birthday.substring(4, 6);
        this.day = birthday.substring(6);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Birthday birthday1 = (Birthday) o;
        return Objects.equals(birthday, birthday1.birthday) && Objects.equals(year, birthday1.year) && Objects.equals(month, birthday1.month) && Objects.equals(day, birthday1.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthday, year, month, day);
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

}
