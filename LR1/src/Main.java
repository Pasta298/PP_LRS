import java.util.Scanner;

class Task {

    public static void CheckNumb (int numb, int x) {
        if (numb % 10 != x) {
            return;
        }
        System.out.printf(numb + " ");
    }

    public static void TaskFunc(int N, int x) {
            int first = 2;
            int second = 1;
            if (x == 1 || x == 2) {
                System.out.printf(x + " ");
            }
            for (int i = 2; i <= N; i++) {
                int temp = first + second;
                CheckNumb(temp, x);
                first = second;
                second = temp;
            }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter quantity of Luke's numbers:  ");
        int quantity = in.nextInt();
        System.out.printf("Enter last number:  ");
        int lastdigit = in.nextInt();
        TaskFunc(quantity, lastdigit);
    }
};