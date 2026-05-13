package lab9;

public class Student {
    private final int numarMatricol;
    private final String prenume;
    private final String nume;
    private final String formatieDeStudiu;
    private final double nota;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu, double nota) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota = nota;
    }

    public int getNumarMatricol() { return numarMatricol; }
    public String getPrenume() { return prenume; }
    public String getNume() { return nume; }
    public String getFormatieDeStudiu() { return formatieDeStudiu; }
    public double getNota() { return nota; }

    @Override
    public String toString() {
        return prenume + " " + nume + " [" + formatieDeStudiu + "] nota=" + nota;
    }
}
