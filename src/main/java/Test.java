import java.math.BigDecimal;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/3 10:51.
 */
public class Test {

    public static void main(String[] args) {
        float f = 0.1f;
        double d = 1.0/10;
        System.out.println(f==d);   //false

        float d1 = 423432434f;
        float d2 = d1+1;
        if(d1==d2){
            System.out.println("d1==d2");
        }else{
            System.out.println("d1!=d2");
        }


        String str1 = 'a' + 3 + "Hello";
        String str2 = "Hello" + 'a' + 3;

        System.out.println(str1);
        System.out.println(str2);

        BigDecimal b1 = new BigDecimal(String.valueOf(0.01));
        BigDecimal b2 = new BigDecimal(String.valueOf(0.05));
        BigDecimal b3 = new BigDecimal(String.valueOf(0.06));

        if(b1.add(b2).compareTo(b3) == 0) {
            System.out.println("两个数字相等!");
        }else {
            System.out.println("两个数字不相等!");
        }

        int a = 10;
        a= a++ +a+++a;
        System.out.println(a);

        int [][] aa = new int [3][3];
        aa[0][2] = 1;
        System.out.println(aa);
    }
}
