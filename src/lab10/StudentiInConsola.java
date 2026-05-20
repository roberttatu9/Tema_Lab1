package lab10;

import java.util.List;

public class StudentiInConsola implements IStudentiExport {
    @Override
    public void doExport(List<Student> studenti) {
        studenti.forEach(System.out::println);
    }
}
