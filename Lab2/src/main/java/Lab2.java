import java.util.Arrays;

public class Lab2 {
    public static void main(String[] args) {
        Matrix mt1, mt2, mt3, mt4, mtr;
        MatrixImmutable mti1, mti2, mti3, mti4, mtir;
        double [][] t1= new double[][] {{1.1, 1.2, 1.3}, {2.1, 2.2, 2.3}, {3.1, 3.2, 3.3}, {4.1, 4.2, 4.3}};
        double [][] t2= new double[][] {{110, 120, 130}, {210, 220, 230}, {310, 320, 330}, {410, 420, 430}};
        double [][] t3=new double[][] {{2, 5, 7}, {6, 3, 4}, {5, -2, -3}};
        double [][] t4=new double[][] {{11, 12, 13, 14}, {21, 22, 23, 24}, {31, 32, 33, 34}};
        mt1= new Matrix(t1);
        mt2=new Matrix(t2);
        mt3=new Matrix(t3);
        mt4=new Matrix(t4);
        mti1= new MatrixImmutable(t1);
        mti2=new MatrixImmutable(t2);
        mti3=new MatrixImmutable(t3);
        mti4=new MatrixImmutable(t4);
        System.out.println();

        //Розмірність матриці
        System.out.println("Розмірність матриці mt1=: "+Arrays.toString(mt1.size_matrix()));

        //Перевірка суми
        mtr= mt1.sum(mt2);
        print_array(mtr.get_table());
        mtir= mti1.sum(mti2);
        print_array(mtir.get_table());

        //Перевірка множення на скаляр
        mtr=mt1.multiplication(2);
        print_array(mtr.get_table());
        mtir= mti1.multiplication(2);
        print_array(mtir.get_table());

        //Перевірка множення на матрицю
        mtr=mt1.multiplication(mt4);
        print_array(mtr.get_table());
        mtir= mti1.multiplication(mti4);
        print_array(mtir.get_table());

        //Перевірка транспонування матриці
        mtr=mt1.transpose();
        print_array(mtr.get_table());
        mtir= mti1.transpose();
        print_array(mtir.get_table());

        //Перевірка діагональної матриці(вектор - масив)
        mtr=mt1.diagonal(new double [] {11, 22, 33, 44});
        print_array(mtr.get_table());
        mtir= mti1.diagonal(new double [] {11, 22, 33, 44});
        print_array(mtir.get_table());

        //Перевірка діагональної матриці(вектор - матриця)
        mtr=mt1.diagonal(new Matrix (new double[][] {{11}, {22}, {33}, {44}}));
        print_array(mtr.get_table());
        mtir= mti1.diagonal(new MatrixImmutable (new double[][] {{11}, {22}, {33}, {44}}));
        print_array(mtir.get_table());

        //Перевірка одиничної матриці
        mtr=mt1.identity(4);
        print_array(mtr.get_table());
        mtir= mti1.identity(4);
        print_array(mtir.get_table());

        //Перевірка оберненої матриці
        mtr=mt3.inverse(mt3);
        print_array(mtr.get_table());
        mtir= mti3.inverse(mti3);
        print_array(mtir.get_table());
    }
    private static void print_array(double[][] v){
        System.out.println("--------------------------");
        if (v.length>0){
            for (int i=0; i<v.length; i++){
                for (int  j=0; j<v[0].length; j++){
                    if (v[i][j]==0){
                        System.out.printf("%12.2f", 0.00);
                    }
                    else{
                        System.out.printf("%12.2f", v[i][j]);
                    }
                }
                System.out.println("");
            }
        }
    }
}
