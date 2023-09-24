package mix;

/**
 *   x = x0 - f(x0)/f `(x0)
 *   ( f `(x) 为函数 f(x)  的一阶导数 f `(x) != 0)
 *   牛顿迭代法的思想是，假设你有一个函数 f(x)，你想找到使得 f(x) 为零的 x 的值，那么你可以通过以下步骤来不断逼近这个 x：
 *
 * 从某个猜测值 x 开始。
 * 在 x 处找到 f(x) 的切线，然后找到这条切线与 x 轴交点的 x 坐标。
 * 把这个新的 x 坐标当作新的猜测值，然后重复步骤2，
 * 直到新旧 x 值之差的绝对值小于某个很小的数（
 * 这个很小的数我们通常称为 eps，就是你之前看到的那个 eps），
 * 我们就认为我们已经找到了 f(x) 的零点。
 */
public class Cuberoot {

    public double cuberoot(double n) {
        double x = n;  // 初始值设为n，你可以选任何一个你认为合适的数
        double eps = 1e-6;  // 这是误差精度，也可以根据需要设定

        while(Math.abs(x * x * x - n) > eps) {  // 如果误差大于eps，继续迭代
            x = x - (x * x * x - n) / (3 * x * x);  // 更新x
        }

        return x;
    }

}
