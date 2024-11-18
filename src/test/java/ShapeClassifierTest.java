import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ShapeClassifierTest {

    /**
     * This is an example test 
     */
    @DisplayName("Example Test")
    @Test
    public void example() {
        ShapeClassifier s = new ShapeClassifier();
        String answer = s.evaluateGuess("Equilateral,Large,Yes,100,100,100");
        assertNotEquals("Yes", answer);
    }

    @Test
    void testSingleParameterLine() {
        ShapeClassifier classifier = new ShapeClassifier();
        String result = classifier.evaluateGuess("Line,Small,Yes,5");
        assertEquals("Wrong Size,Wrong Even/Odd", result);
    }

    @Test
    void testSingleParameterIncorrectShape() {
        ShapeClassifier classifier = new ShapeClassifier();
        String result = classifier.evaluateGuess("Circle,Small,Yes,5");
        assertEquals("No: Suggestion=Line", result);
    }

    @Test
    void testTwoParametersCircle() {
        ShapeClassifier classifier = new ShapeClassifier();
        String result = classifier.evaluateGuess("Circle,Large,Yes,15,15");
        assertEquals("Yes: Wrong Even/Odd", result);
    }

    @Test
    void testTwoParametersEllipse() {
        ShapeClassifier classifier = new ShapeClassifier();
        String result = classifier.evaluateGuess("Ellipse,Small,No,15,10");
        assertEquals("No: Suggestion=Ellipse", result);
    }

    @Test
    void testThreeParametersEquilateral() {
        ShapeClassifier classifier = new ShapeClassifier();
        String result = classifier.evaluateGuess("Equilateral,Large,Yes,30,30,30");
        assertEquals("Yes: Wrong Even/Odd", result);
    }

    @Test
    void testThreeParametersIncorrectShape() {
        ShapeClassifier classifier = new ShapeClassifier();
        String result = classifier.evaluateGuess("Scalene,Large,No,30,30,30");
        assertEquals("No: Suggestion=Equilateral", result);
    }
}
