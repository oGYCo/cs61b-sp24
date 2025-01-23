package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        int currentN=1000;
        int M=10000;
        while(currentN<=128000){
            SLList<Integer> list = new SLList<>();
            for(int i=0; i<currentN; i++){
                list.addLast(i);
            }

            Stopwatch stopwatch = new Stopwatch();
            for(int i=0; i<M; i++){
                list.getLast();
            }
            double time=stopwatch.elapsedTime();

            Ns.addLast(currentN);
            times.addLast(time);
            opCounts.addLast(M);
            currentN*=2;
        }

        printTimingTable(Ns, times, opCounts);
    }

}
