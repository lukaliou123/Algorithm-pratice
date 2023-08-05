package exam.uu;
import java.util.*;

public class q1 {
    static class Line {
        double k;
        double b;

        public Line(int x1, int y1, int x2, int y2) {
            this.k = (double)(y2 - y1) / (x2 - x1);
            this.b = y1 - k * x1;
        }

        public double getY(double x) {
            return k * x + b;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Line> lines = new ArrayList<>();
        String[] startPoints = in.nextLine().split(",");
        String[] endPoints = in.nextLine().split(",");
        for(int i = 0; i < startPoints.length; i+=2) {
            int x1 = Integer.parseInt(startPoints[i]);
            int y1 = Integer.parseInt(startPoints[i+1]);
            int x2 = Integer.parseInt(endPoints[i]);
            int y2 = Integer.parseInt(endPoints[i+1]);
            lines.add(new Line(x1, y1, x2, y2));
        }
        double[] xPoints = new double[2001];  // 保持所有的x坐标点
        for (double i = 1.0; i <= 20.0; i += 0.01) {
            xPoints[(int)(i*100)] = i;
        }
        int count = 1;  // 区域计数
        for (double i = 1.01; i <= 20.0; i += 0.01) {
            double y = 0;
            for (Line line : lines) {
                if (i > 1.0 && i < 20.0 && line.getY(i) > y) {
                    y = line.getY(i);
                }
            }
            if (y != lines.get(0).getY(xPoints[(int)(i*100-1)])) {
                count++;
            }
        }
        System.out.println(count);
    }
}

