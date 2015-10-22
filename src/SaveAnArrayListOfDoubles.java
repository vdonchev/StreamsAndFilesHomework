import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveAnArrayListOfDoubles {
    public static void main(String[] args) {
        List<Double> doubles = new ArrayList<Double>() {{
            addAll(Arrays.asList(2.5, 6.2, 1.3, 0.1, 3.14, 66.6, 6.9));
        }};

        saveDoubles(doubles);
        loadDoubles(doubles.size());
    }

    private static void loadDoubles(int numOfItems) {
        try(ObjectInputStream source = new ObjectInputStream(new FileInputStream("lib/doubles.list"))) {
            for (int i = 0; i < numOfItems; i++) {
                System.out.println(source.readDouble());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveDoubles(List<Double> doubles) {
        try(ObjectOutputStream destination = new ObjectOutputStream(new FileOutputStream("lib/doubles.list"))) {
            for (Double aDouble : doubles) {
                destination.writeDouble(aDouble);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}