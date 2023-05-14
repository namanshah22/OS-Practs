import java.util.*;

public class Bankersnew {
    public static void main(String[] args) {
        int[][] allocation = {{0, 1, 0}, {2, 0, 0}, {3, 0, 2}, {2, 1, 1}, {0, 0, 2}}; // allocation matrix
        int[][] max = {{7, 5, 3}, {3, 2, 2}, {9, 0, 2}, {2, 2, 2}, {4, 3, 3}}; // maximum resource matrix
        int[] available = {3, 3, 2}; // available resources array
        //int[] request = {1, 0, 2}; // request array for process 1
        
        int n = allocation.length; // number of processes
        int m = available.length; // number of resource types
        
        int[][] need = new int[n][m]; // initialize need matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }
        
        boolean[] finished = new boolean[n]; // initialize finished array
        int[] safeSeq = new int[n]; // initialize safeSeq array
        int count = 0; // initialize count variable
        
        while (count < n) {
            boolean found = false;
            for (int i = 0; i < n; i++) {
                if (!finished[i]) {
                    boolean canFinish = true;
                    for (int j = 0; j < m; j++) {
                        if (need[i][j] > available[j]) {
                            canFinish = false;
                            break;
                        }
                    }
                    if (canFinish) {
                        for (int j = 0; j < m; j++) {
                            available[j] += allocation[i][j];
                        }
                        safeSeq[count++] = i;
                        finished[i] = true;
                        found = true;
                    }
                }
            }
            if (!found) {
                System.out.println("System is not in safe state");
                return;
            }
        }
        
        System.out.println("Safe Sequence: ");
        for (int i = 0; i < n; i++) {
            System.out.print(safeSeq[i] + " ");
        }
    }
}
