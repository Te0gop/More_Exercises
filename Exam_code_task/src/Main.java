import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Colors> colors = new ArrayList<>(Arrays.asList(Colors.red, Colors.blue, Colors.green, Colors.black));
        List<String> brands = Arrays.asList("Copic", "Feela", "Ohuhu", "Prismacolor", "Tanmit");

        Random r = new Random();
        WritingMaterial[] arrayOfMarkers = new WritingMaterial[50];

        for (int i = 0; i < arrayOfMarkers.length; i++) {

           arrayOfMarkers[i] = new Marker(colors.get(r.nextInt(3)), r.nextInt(5), r.nextInt(500),
                   brands.get(r.nextInt(4)), r.nextBoolean(), r.nextBoolean());

            // if we want new objects in the array:
            //arrayOfMarkers[i+1] = new Pen(colors.get(r.nextInt(3)), r.nextInt(5), r.nextInt(500),
            //                    brands.get(r.nextInt(4)), r.nextBoolean(), r.nextBoolean());
            // length of arrayOfMarkers must be arrayOfMarkers.length-1;
        }
        List<WritingMaterial> list = Arrays
                .stream(arrayOfMarkers)
                .collect(Collectors.toList());

        for (int i = 0; i < list.size() ; i++) {
            if(i % 2 == 0 && list.get(i).getColor().equals(Colors.blue) && list.get(i).isWritable()) {
                System.out.println("color: " + list.get(i).getColor() + ", brand: " + list.get(i).getBrand());
            }
        }
    }
}
