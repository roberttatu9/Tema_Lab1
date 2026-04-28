package lab7;

import lab7.forms.Circle;
import lab7.forms.Form;
import lab7.forms.Square;
import lab7.forms.Triangle;
import lab7.util.PasswordMaker;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // 7.6.1. Contor instante
        Triangle tri = new Triangle(1.1F, 2.0F, "red");
        Circle c = new Circle(1.5F, "yellow");
        Square sq = new Square(1.2F, "blue");
        System.out.println("Area = " + tri.getArea() + " details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);
        System.out.println("Total instance count is " + Form.getInstanceCount());

        // 7.6.2 Password maker singleton
        PasswordMaker pm2 = PasswordMaker.getInstance();
        System.out.println("\n7.6.2 a+b) Generated passwords: ");
        System.out.println("1:" + PasswordMaker.getInstance().getPassword());
        System.out.println("2:" + PasswordMaker.getInstance().getPassword());
        System.out.println("3:" + PasswordMaker.getInstance().getPassword());
        System.out.println("4:" + pm2.getPassword());
        System.out.println("5:" + pm2.getPassword());
        System.out.println("\n7.6.2 c) Number of time getInstance() has been called: " + PasswordMaker.getCallingCounts());

        // 7.6.3 Imutabilitate
        Set<Student> studenti = new LinkedHashSet<>();
        studenti.add(new Student(9322, "Dan", "Beat", "TI21/1"));
        studenti.add(new Student(120, "Alis", "Popa", "TI21/1"));
        studenti.add(new Student(112, "Maria", "Popa", "TI21/1"));
        studenti.add(new Student(150, "Ion", "Ionescu", "TI21/1"));
        studenti.add(new Student(200, "Ana", "Dumitrescu", "TI21/1"));

        studenti = imparteInDouaFormatii(studenti, "TI 211_1", "TI 211_2");
        System.out.println("\n7.6.3 Studenti impartiti in doua formatii:");
        for (Student s : studenti) {
            System.out.println(s);
        }
    }

    static Student schimbaFormatia(Student st, String nouaFormatieDeStudiu) {
        return new Student(st.getNumarMatricol(), st.getPrenume(), st.getNume(), nouaFormatieDeStudiu);
    }

    static Set<Student> imparteInDouaFormatii(Set<Student> studenti, String formatia1, String formatia2) {
        List<Student> lista = new ArrayList<>(studenti);
        int jumatate = (lista.size() + 1) / 2;
        Set<Student> rezultat = new LinkedHashSet<>();
        for (int i = 0; i < lista.size(); i++) {
            if (i < jumatate) {
                rezultat.add(schimbaFormatia(lista.get(i), formatia1));
            } else {
                rezultat.add(schimbaFormatia(lista.get(i), formatia2));
            }
        }
        return rezultat;
    }
}
