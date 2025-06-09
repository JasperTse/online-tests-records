import java.util.Scanner;

public class Main {

    private static int area(int x1, int y1, int x2, int y2) {
        if (x2 <= x1 || y2 <= y1) return 0;
        return (x2 - x1) * (y2 - y1);
    }

    private static int overlapArea(int ax1, int ay1, int ax2, int ay2,
                                   int bx1, int by1, int bx2, int by2) {
        int ox1 = Math.max(ax1, bx1);
        int oy1 = Math.max(ay1, by1);
        int ox2 = Math.min(ax2, bx2);
        int oy2 = Math.min(ay2, by2);

        return area(ox1, oy1, ox2, oy2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ax1 = sc.nextInt();
        int ay1 = sc.nextInt();
        int ax2 = sc.nextInt();
        int ay2 = sc.nextInt();

        int bx1 = sc.nextInt();
        int by1 = sc.nextInt();
        int bx2 = sc.nextInt();
        int by2 = sc.nextInt();

        int cx1 = sc.nextInt();
        int cy1 = sc.nextInt();
        int cx2 = sc.nextInt();
        int cy2 = sc.nextInt();

        int areaA = area(ax1, ay1, ax2, ay2);
        int areaB = area(bx1, by1, bx2, by2);

        int overlapA = overlapArea(ax1, ay1, ax2, ay2, cx1, cy1, cx2, cy2);
        int overlapB = overlapArea(bx1, by1, bx2, by2, cx1, cy1, cx2, cy2);

        int visibleArea = (areaA - overlapA) + (areaB - overlapB);

        System.out.println(visibleArea);
    }
}
