import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Positive> positives = new ArrayList<>();

    public List<Positive> getPositives() {
        return positives;
    }

    public Calculator(List<String> strings) {
        createPositives(strings);
    }

    public void createPositives(List<String> strings) {
        strings.forEach(s -> positives.add(new Positive(s)));
    }

    public int getResult() {
        return positives.stream()
                .map(Positive::getNumber)
                .reduce((x,y)->x+y)
                .orElseThrow(RuntimeException::new);
    }

}
