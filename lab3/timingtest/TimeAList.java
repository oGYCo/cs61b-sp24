package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        int currentN=1000;
        while(currentN<=128000) {
            Stopwatch sw = new Stopwatch();
            AList<Integer> testList = new AList<>();
            for (int i = 0; i < currentN; i++) {
                testList.addLast(i);
            }
            double time = sw.elapsedTime();

            Ns.addLast(currentN);
            times.addLast(time);
            opCounts.addLast(currentN);

            currentN *= 2;
        }

        printTimingTable(Ns,times,opCounts);
    }
}
