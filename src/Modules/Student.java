public class Student {
    private int id;
    private String name;
    private String surname;
    private double gpa;
    Student(int id, String name, String surname, double gpa){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gpa = gpa;
    }
    public double get_gpa(){

        return gpa;
    }
    public void set_gpa(double gpa){

        this.gpa = gpa;
    }
    public String get_name(){

        return name;
    }
    public String get_surname(){

        return surname;
    }
    public int get_id(){

        return id;
    }
}
