import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        LoggerSingleton logger = LoggerSingleton.getInstance();
        List<Integer> result = new ArrayList<>();
        for (Integer integer : source) {
            if (integer > treshold) {
                logger.log("Элемент \"" + integer + "\" проходит");
                result.add(integer);
            } else {
                logger.log("Элемент \"" + integer + "\" не проходит");
            }
        }
        return result;
    }
}
