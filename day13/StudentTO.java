package com.htc.ioss;

import java.io.Serializable;
@SuppressWarnings("serial")
public class StudentTO implements Serializable {
    private  int     stuId;
    private  String  stuName;
    private  String  course;
   
    public StudentTO(int stuId, 
                     String stuName,
                     String course) {
        super();
        this.stuId = stuId;
        this.stuName = stuName;
        this.course = course;
    }

    public StudentTO() {
    }

    public int getStuId() {
        return this.stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return this.stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.stuId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StudentTO other = (StudentTO) obj;
        if (this.stuId != other.stuId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "StudentTO [stuId=" + this.stuId + ", stuName=" + this.stuName
                + ", course=" + this.course + "]";
    }
    
    

}
