import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorTest {

    static int testsPassed = 0;
    static int testsFailed = 0;

    public static void main(String[] args) {

        testCalculate("Adunare simpla",
                Arrays.asList(4f, 5f), Arrays.asList("+"), 9f);

        testCalculate("Scadere simpla",
                Arrays.asList(10f, 3f), Arrays.asList("-"), 7f);

        testCalculate("Inmultire simpla",
                Arrays.asList(6f, 7f), Arrays.asList("*"), 42f);

        testCalculate("Impartire simpla",
                Arrays.asList(20f, 4f), Arrays.asList("/"), 5f);

        testCalculate("Prioritatea operatiilor: 10+5*4+3",
                Arrays.asList(10f, 5f, 4f, 3f), Arrays.asList("+", "*", "+"), 33f);

        testCalculate("Ordine stanga-dreapta: 10-5+2",
                Arrays.asList(10f, 5f, 2f), Arrays.asList("-", "+"), 7f);

        testCalculate("Un singur numar",
                Arrays.asList(8f), new ArrayList<>(), 8f);

        testCalculate("Numere zecimale: 2.5+1",
                Arrays.asList(2.5f, 1f), Arrays.asList("+"), 3.5f);

        testCalculate("Impartire la zero (test care ESUEAZA - bug identificat)",
                Arrays.asList(5f, 0f), Arrays.asList("/"), 0f);

        System.out.println("\n----------------------------");
        System.out.println("Teste trecute: " + testsPassed);
        System.out.println("Teste esuate: " + testsFailed);
    }

    static void testCalculate(String numeTest, List<Float> numere,
                              List<String> operatii, float rezultatAsteptat) {

        List<Float> numbers = new ArrayList<>(numere);
        List<String> operations = new ArrayList<>(operatii);

        Calculator.Calculate(numbers, operations);
        float rezultatObtinut = Calculator.finalResult;

        if (rezultatObtinut == rezultatAsteptat) {
            System.out.println("PASSED: " + numeTest);
            testsPassed++;
        } else {
            System.out.println("FAILED: " + numeTest
                    + " | asteptat: " + rezultatAsteptat
                    + " | obtinut: " + rezultatObtinut);
            testsFailed++;
        }
    }
}
