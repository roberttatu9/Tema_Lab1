package lab3;

import java.util.Objects;

public class Student {
    private int numarMatricol;
    private String prenume;
    private String nume;
    private String formatieDeStudiu;
    private float nota;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public int getNumarMatricol() {
        return numarMatricol;
    }

    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Student : numarMatricol=" + this.numarMatricol + ", prenume=" + this.prenume + ", nume=" + this.nume + ", formatie de studiu=" + this.formatieDeStudiu + ", nota=" + this.nota + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(prenume, student.prenume) &&
                Objects.equals(nume, student.nume) &&
                Objects.equals(formatieDeStudiu, student.formatieDeStudiu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenume, nume, formatieDeStudiu);
    }
}
