import java.util.Random;

/**
 * @author xiaozhihe
 * @Description: ${todo}
 * @date 2020/10/230:42
 */
public class MultiMatrixTest implements Runnable{
    private int[][] A;
    private int[][] B;
    private int length;
    static int[][] multiplyMatrix;//定义一个全局矩阵，存放矩阵乘积的结果
    static Random ran=new Random();
    public static void main(String args[]){
        int length1;
        //随机产生方阵A的行列数
        length1=ran.nextInt(10)+1;
        int [][]a = createSquareMatrix(length1);
//        createSquareMatrix(a);

        multipartMatrix(a);
        show();
    }
    public static void createSquareMatrix(int[][]a){//使用随机数生成矩阵a和b
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                a[i][j]=ran.nextInt(100);
            }
        }
        System.out.println("输出矩阵A");//输出矩阵A
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }

    }

    public static int[][] createSquareMatrix(int length){
        if(length>0){
            int [][]a = new int[length][length];
            for(int i=0;i<length;i++){
                for(int j=0;j<a[0].length;j++){
                    a[i][j]=ran.nextInt(100);
                }
            }

            System.out.println("输出矩阵A");//输出矩阵A
            for(int i=0;i<a.length;i++){
                for(int j=0;j<a[0].length;j++){
                    System.out.print(a[i][j]+" ");
                }
                System.out.println("");
            }
            return a;
        }else{
            return  new int[][]{};
        }


    }
    public static void multipartMatrix(int[][] a){
        System.out.println("输出矩阵A*A结果");
        int[][] b = a;
        multiplyMatrix=new int[a.length][a.length];
        //A的行数
        for (int i = 0; i<a.length; i++) {
            //B的列数
            for (int j = 0; j<b[0].length; j++) {
                //A的列数
                for (int k = 0; k<a[0].length; k++) {
                    MultiMatrixTest multiMatrixTest = new MultiMatrixTest();
                    Thread t1 = new Thread(multiMatrixTest,"线程"+k);
                    t1.start();
                    //将矩阵A的第I行和矩阵B的第J列对应的数相乘得到multiplyMatrix[i][j]
                    multiplyMatrix[i][j]=multiplyMatrix[i][j]+a[i][k]*b[k][j];
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

    @Override
    public void run() {
        for (int i = 0; i< length; i++) {
            //B的列数
            for (int j = 0; j< length; j++) {
                //A的列数
                for (int k = 0; k< length; k++) {
                    //将矩阵A的第I行和矩阵B的第J列对应的数相乘得到multiplyMatrix[i][j]
                    multiplyMatrix[i][j]=multiplyMatrix[i][j]+A[i][k]*B[k][j];
                }
            }
        }
    }
}


