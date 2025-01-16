package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class AddConstantTest {

    @Test
    public void testAddConstantOne() {
        IntList lst = IntList.of(1, 2, 3, 4, 5);
        IntListExercises.addConstant(lst, 1);
        assertEquals("2 -> 3 -> 4 -> 5 -> 6", lst.toString());
    }

    @Test
    public void testAddConstantTwo() {
        IntList lst = IntList.of(2,23);
        IntListExercises.addConstant(lst, -3);
        assertEquals("-1 -> 20", lst.toString());
    }

    @Test
    public void testAddToLargeList() {
        IntList lst = IntList.of(1, 2);
        IntListExercises.addConstant(lst, 10);
        assertEquals("11 -> 12", lst.toString());
    }
}
