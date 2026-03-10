public class Student {

    private int numarMatricol;
    private String prenume;
    private String nume;
    private String formatieDeStudiu;



    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }




    @Override
    public String toString() {
        return "Student : numarMatricol=" + numarMatricol  + ", prenume=" + prenume + ", nume=" + nume + ", formatie de studiu=" + formatieDeStudiu + "." ;
    }
}

