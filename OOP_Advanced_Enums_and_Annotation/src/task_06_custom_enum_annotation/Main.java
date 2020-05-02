package task_06_custom_enum_annotation;

/*
Create a custom annotation that can be applied to classes and can be accessed at runtime. The annotation type elements
it should contain are category and description. Apply the annotation to both enumeration types you have created for
 the previous problems (Rank and Suit). Provide them these exact values:
 Rank:
•	type = "Enumeration"
•	category = "Rank"
•	description = "Provides rank constants for a Card class."
Suit:
•	type = "Enumeration"
•	category = "Suit"
•	description = "Provides suit constants for a Card class."
Create a program which gets the description and type by a given category: “Rank” or “Suit”.
Note
Try using the getAnnotation() method.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rankOrSuit = reader.readLine();

        Class<Rank> rankType = Rank.class;
        Class<Suite> suiteType = Suite.class;

        CustomEnumAnnotation annRank = rankType.getAnnotation(CustomEnumAnnotation.class);
        CustomEnumAnnotation annSuite = suiteType.getAnnotation(CustomEnumAnnotation.class);

        String ann = rankOrSuit.equals("Rank") ? "Type = " + annRank.type() + ", Description = " + annRank.description()
                : "Type = " + annSuite.type() + ", Description = " + annSuite.description();
        System.out.println(ann);
    }
}
