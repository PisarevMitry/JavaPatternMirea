import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

/*Сортировка по возрасту в обратном порядке, фильтрация по имени
«начинается с А», сортировка по дате рождения, расчет среднего веса.*/

public class Main {

    public static void main(String[] args) {
        List<Human> humanList = new LinkedList<>();
        humanList.add(new Human(19, "Pisarev", "Dmitrii", LocalDate.of(2003, 9, 1), 67));
        humanList.add(new Human(21, "Gnjfkvd", "Sadhbh", LocalDate.of(2001, 1, 1), 86));
        humanList.add(new Human(1, "PDFView", "Aew fw", LocalDate.of(2019, 12, 1), 8));
        humanList.add(new Human(29, "Pfvdfvddf", "Aet", LocalDate.of(1993, 9, 1), 86));
        humanList.add(new Human(18, "Ldvdfd", "Auy", LocalDate.of(2003, 9, 1), 45));

        Stream<Human> humanStream = humanList.stream()
                .sorted(Comparator.comparingInt(Human::getAge))
                .filter(human -> human.getLastName().charAt(0) == 'A')
                .sorted(Comparator.comparing(Human::getBirthDate));

        humanStream.forEach(System.out::println);

        OptionalDouble averageWeight = humanList.stream().
                sorted(Comparator.comparingInt(Human::getAge)).
                filter(human -> human.getLastName().charAt(0) == 'A').
                sorted(Comparator.comparing(Human::getBirthDate)).
                mapToDouble(Human::getWeight).
                average();

        System.out.println(averageWeight.getAsDouble());
    }
}
