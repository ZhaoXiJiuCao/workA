import java.util.Random;

/**
 * @author xiaozhihe
 * @Description: ${todo}
 * @date 2020/10/230:42
 */
public class MultiMatrixTest {
    static int[][] multiplyMatrix;//定义一个全局矩阵，存放矩阵乘积的结果
    static Random ran=new Random();
    public static void main(String args[]){
        int length1;
        int length2;
        int length3;
        length1=ran.nextInt(10)+1;//随机产生矩阵A的行数以及矩阵B列数，两个矩阵相乘行数和列数必须相同
        length2=ran.nextInt(10)+1;//随机产生矩阵A的列数
        length3=ran.nextInt(10)+1;//随机产生矩阵B的行数
        int [][]a = new int[length2][length1];
        int [][]b = new int[length1][length3];
        getAB(a,b);
        mMatrix(a,b);
        show();
    }
    public static void getAB(int[][]a,int[][]b){//使用随机数生成矩阵a和b
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                a[i][j]=ran.nextInt(100);
            }
        }
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[0].length;j++){
                b[i][j]=ran.nextInt(100);
            }
        }
        System.out.println("输出矩阵A");//输出矩阵A
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("输出矩阵B");//输出矩阵B
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[0].length;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public static void mMatrix(int[][] a,int[][] b){//矩阵A*B
        System.out.println("输出矩阵A*B");
        multiplyMatrix=new int[a.length][b[0].length];
        for (int i = 0; i<a.length; i++) {//A的行数
            for (int j = 0; j<b[0].length; j++) {//B的列数
                for (int k = 0; k<a[0].length; k++) {//A的列数
                    multiplyMatrix[i][j]=multiplyMatrix[i][j]+a[i][k]*b[k][j];//将矩阵A的第I行和矩阵B的第J列对应的数相乘得到multiplyMatrix[i][j]
                }
            }
        }
    }
    public static void show(){//输出矩阵乘积multiplyMatrix
        for (int i = 0; i<multiplyMatrix.length; i++) {
            for (int j = 0; j<multiplyMatrix[0].length; j++) {
                System.out.print (multiplyMatrix[i][j]+" ");
            }
            System.out.println ("");
        }
    }

}


