import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        List<Student> studenti = new ArrayList<>();

        studenti.add(new Student(9322, "Dan", "Beat_Man", "4-3-3"));
        studenti.add(new Student(120, "Alis", "Popa", "TI21/2"));
        studenti.add(new Student(112, "Maria", "Popa", "TI21/1"));
        studenti.add(new Student(150, "Ion", "Ionescu", "TI21/2"));

        System.out.println(" Lista de Studenti ");
        for (Student student : studenti) {
            System.out.println(student);
        }

        //b) verificare Alis Popa TI 21/2
        System.out.println("VERIFICARE Alis Popa");
        Student studentCautat1= new Student(120, "Alis", "Popa", "TI21/2");
        boolean existaAlis = existaStudentInLista(studenti, studentCautat1);
        System.out.println("Studentul Alis Popa exista in lista: " + existaAlis);

        //c) verificare Maria Popa TI 21/1
        System.out.println("VERIFICARE Maria Popa");
        Student studentCautat2= new Student(112, "Maria", "Popa", "TI21/1");
        boolean existaMaria = existaStudentInLista(studenti, studentCautat2);
        System.out.println("Studenta Maria Popa exista in lista: " + existaMaria);
    }

    public static boolean existaStudentInLista(List<Student> studenti, Student student) {
        return studenti.contains(student);
    }
}