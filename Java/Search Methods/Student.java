public class Student implements Comparable<Student>{
    String name;
    Integer age; 
    double gradeAvg;

    public Student(String name, Integer age, double grade) {
        this.name = name;
        this.age = age; 
        this.gradeAvg = grade;
    }

    @Override
    public int compareTo(Student s){
        if (this.age < s.age) {
            return -1;
        }
        if (this.age > s.age) {
            return 1;
        }
        return 0;
    }

    public String getName() {
        return this.name;
    }
}
