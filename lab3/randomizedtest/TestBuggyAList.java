package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        BuggyAList<Integer> BuggyAList = new BuggyAList<>();
        AListNoResizing<Integer> AListNoResizing = new AListNoResizing<>();
        BuggyAList.addLast(4);
        BuggyAList.addLast(5);
        BuggyAList.addLast(6);
        AListNoResizing.addLast(4);
        AListNoResizing.addLast(5);
        AListNoResizing.addLast(6);
        assertEquals(BuggyAList.size(), BuggyAList.size());
        assertEquals(BuggyAList.removeLast(),AListNoResizing.removeLast());
        assertEquals(BuggyAList.removeLast(),AListNoResizing.removeLast());
        assertEquals(BuggyAList.removeLast(),AListNoResizing.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 998;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                broken.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size1 = L.size();
                int size2 = broken.size();
                assertEquals(size1, size2);
            } else if (operationNumber == 2&&L.size()!=0&&broken.size()!=0) {
                int m=L.getLast();
                int n=broken.getLast();
                assertEquals(m,n);
            }
            else if (operationNumber == 3&&L.size()!=0&&broken.size()!=0) {
                assertEquals(L.removeLast(),broken.removeLast());
            }
        }
    }
}
