import java.util.Scanner;

public class SSTF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of disk requests: ");
        int n = sc.nextInt();

        int[] requests = new int[n];

        System.out.println("Enter the disk requests:");
        for (int i = 0; i < n; i++) {
            requests[i] = sc.nextInt();
        }

        System.out.print("Enter the initial head position: ");
        int head = sc.nextInt();

        int totalDistance = 0;

        while (n > 0) {
            int minDistance = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < n; i++) {
                int distance = Math.abs(requests[i] - head);
                if (distance < minDistance) {
                    minDistance = distance;
                    minIndex = i;
                }
            }
            totalDistance += minDistance;
            head = requests[minIndex];
            for (int i = minIndex; i < n - 1; i++) {
                requests[i] = requests[i + 1];
            }
            n--;
        }

        System.out.println("Total head movement: " + totalDistance);

        sc.close();
    }
}
