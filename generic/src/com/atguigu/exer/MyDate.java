package com.atguigu.exer;/**
 * @Author Curry
 * @Create 2020-11-2:47
 */

/**
 * @Description todo
 * @ClassName MyDate
 * @Author admin
 * @Date 2020/11/26 2:47
 * @Version 1.0
 */
public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyDate myDate = (MyDate) o;

        if (year != myDate.year) return false;
        if (month != myDate.month) return false;
        return day == myDate.day;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + month;
        result = 31 * result + day;
        return result;
    }

    public int getYear() {

        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(int year, int month, int day) {

        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate() {

    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof MyDate) {
//            MyDate b = (MyDate) o;
//            int minusYear = this.getYear() - b.getYear();
//            int minusMonth = this.getMonth() - b.getMonth();
//            int minusDay = this.getDay() - b.getDay();
//            if (minusYear != 0) {
//                return minusYear;
//            }
//            if (minusMonth != 0) {
//                return minusMonth;
//            }
//            return minusDay;
//        } else {
//            throw new RuntimeException("类型不匹配！");
//        }
//    }

    @Override
    public int compareTo(MyDate o) {
        int minusYear = this.getYear() - o.getYear();
        int minusMonth = this.getMonth() - o.getMonth();
        int minusDay = this.getDay() - o.getDay();
        if (minusYear != 0) {
            return minusYear;
        }
        if (minusMonth != 0) {
            return minusMonth;
        }
        return minusDay;
    }

}
