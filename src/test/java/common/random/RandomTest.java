package common.random;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class RandomTest {

    /**
     * 注意 这里生成的随机数是假的
     */
    @Test
    public void testRandom(){
        Random random = new Random(1000);
        int randInt = random.nextInt(100);
        System.out.println(randInt);
    }

    @Test
    public void testRandom2(){
        Random random = new Random();
        int randInt = random.nextInt(100);
        System.out.println(randInt);
    }

    @Test
    public void testRandomWithMath(){
        // 案例1
        System.out.println("Math.random()=" + Math.random());// 结果是个double类型的值，区间为[0.0,1.0）
        int num = (int) (Math.random() * 3); // 注意不要写成(int)Math.random()*3，这个结果为0，因为先执行了强制转换
        System.out.println("num=" + num);
        /**
         * 输出结果为：
         *
         * Math.random()=0.02909671613289655
         * num=0
         *
         */
    }

    /**
     * 相同种子的随机数
     */
    @Test
    public void testRandom3(){
        // 案例2
        // 对于种子相同的Random对象，生成的随机数序列是一样的。
        Random ran1 = new Random(10);
        System.out.println("使用种子为10的Random对象生成[0,10)内随机整数序列: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(ran1.nextInt(10) + " ");
        }
        System.out.println();
        Random ran2 = new Random(10);
        System.out.println("使用另一个种子为10的Random对象生成[0,10)内随机整数序列: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(ran2.nextInt(10) + " ");
        }
    }

    /**
     * 生成不同的随机数
     */
    @Test
    public void testRandom4(){
        // 案例3
        // 在没带参数构造函数生成的Random对象的种子缺省是当前系统时间的毫秒数。
        Random r3 = new Random();
        System.out.println();
        System.out.println("使用种子缺省是当前系统时间的毫秒数的Random对象生成[0,10)内随机整数序列");
        for (int i = 0; i < 10; i++) {
            System.out.print(r3.nextInt(10)+" ");
        }
        /**
         * 输出结果为：
         *
         * 使用种子缺省是当前系统时间的毫秒数的Random对象生成[0,10)内随机整数序列
         * 1 1 0 4 4 2 3 8 8 4
         *
         */

        // 另外，直接使用Random无法避免生成重复的数字，如果需要生成不重复的随机数序列，需要借助数组和集合类
        ArrayList list=new RandomTest().getDiffNO(10);
        System.out.println();
        System.out.println("产生的n个不同的随机数："+list);
    }

    /**
     * 生成n个不同的随机数，且随机数区间为[0,10)
     * @param n
     * @return
     */
    public ArrayList getDiffNO(int n){
        // 生成 [0-n) 个不重复的随机数
        // list 用来保存这些随机数
        ArrayList list = new ArrayList();
        Random rand = new Random();
        boolean[] bool = new boolean[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            do {
                // 如果产生的数相同继续循环
                num = rand.nextInt(n);
            } while (bool[num]);
            bool[num] = true;
            list.add(num);
        }
        return list;
    }

    /**
     备注：下面是Java.util.Random()方法摘要：

     protected int next(int bits)：生成下一个伪随机数。
     boolean nextBoolean()：返回下一个伪随机数，它是取自此随机数生成器序列的均匀分布的boolean值。
     void nextBytes(byte[] bytes)：生成随机字节并将其置于用户提供的 byte 数组中。
     double nextDouble()：返回下一个伪随机数，它是取自此随机数生成器序列的、在0.0和1.0之间均匀分布的 double值。
     float nextFloat()：返回下一个伪随机数，它是取自此随机数生成器序列的、在0.0和1.0之间均匀分布float值。
     double nextGaussian()：返回下一个伪随机数，它是取自此随机数生成器序列的、呈高斯（“正态”）分布的double值，其平均值是0.0标准差是1.0。
     int nextInt()：返回下一个伪随机数，它是此随机数生成器的序列中均匀分布的 int 值。
     int nextInt(int n)：返回一个伪随机数，它是取自此随机数生成器序列的、在（包括和指定值（不包括）之间均匀分布的int值。
     long nextLong()：返回下一个伪随机数，它是取自此随机数生成器序列的均匀分布的 long 值。
     void setSeed(long seed)：使用单个 long 种子设置此随机数生成器的种子。

     下面给几个例子：

     1 生成[0,1.0)区间的小数：double d1 = r.nextDouble();
     2 生成[0,5.0)区间的小数：double d2 = r.nextDouble() * 5;
     3 生成[1,2.5)区间的小数：double d3 = r.nextDouble() * 1.5 + 1;
     4 生成-231到231-1之间的整数：int n = r.nextInt();
     5 生成[0,10)区间的整数：
       int n2 = r.nextInt(10);//方法一
       n2 = Math.abs(r.nextInt() % 10);//方法二
     */
}
