import java.util.Arrays;
import java.util.Scanner;

public class Looknew {
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

        System.out.print("Enter the direction (0 for left, 1 for right): ");
        int direction = sc.nextInt();

        Arrays.sort(requests);

        int totalDistance = 0;
        int current = head;

        if (direction == 0) { // moving left
            for (int i = requests.length - 1; i >= 0; i--) {
                if (requests[i] > current) {
                    continue;
                }
                totalDistance += current - requests[i];
                current = requests[i];
            }
            //totalDistance += current; // move to 0
            //current = 0;
            for (int i = 0; i < requests.length; i++) {
                if (requests[i] < current) {
                    continue;
                }
                totalDistance += requests[i] - current;
                current = requests[i];
            }
        } else { // moving right
            for (int i = 0; i < requests.length; i++) {
                if (requests[i] < current) {
                    continue;
                }
                totalDistance += requests[i] - current;
                current = requests[i];
            }
            //totalDistance += 99 - current; // move to 99
            //current = 99;
            for (int i = requests.length - 1; i >= 0; i--) {
                if (requests[i] > current) {
                    continue;
                }
                totalDistance += current - requests[i];
                current = requests[i];
            }
        }

        System.out.println("Total head movement: " + totalDistance);

        sc.close();
    }
}

