package techkids.mad3.trungnt.student;

import java.io.Serializable;

/**
 * Created by TrungNT on 4/6/2016.
 */
public class Student implements Serializable {
    private String nameStudent;
    private String className;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getBirthdayPlace() {
        return birthdayPlace;
    }

    public void setBirthdayPlace(String birthdayPlace) {
        this.birthdayPlace = birthdayPlace;
    }

    public int getHobby() {
        return hobby;
    }

    public void setHobby(int hobby) {
        this.hobby = hobby;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    private String birthday;
    private String birthdayPlace;
    private int hobby;
    private int gender;

    public Student(String nameStudent, String className, String birthday, String birthdayPlace, int hobby, int gender)
    {
        this.nameStudent = nameStudent;
        this.className = className;
        this.birthday = birthday;
        this.birthdayPlace = birthdayPlace;
        this.hobby = hobby;
        this.gender = gender;
    }
}
