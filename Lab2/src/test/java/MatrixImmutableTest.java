import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixImmutableTest {
    double[][] t;
    MatrixImmutable mt, mtr;

    @BeforeEach
    void setUp() {
        t=new double[][] {{11, 12, 13}, {21, 22, 23}, {31, 32, 33}, {41, 42, 43}};
        mt=new MatrixImmutable(t);

    }

    @Test
    void rows_count() {
        Assertions.assertEquals(4, mt.rows_count());
        Assertions.assertNotEquals(3, mt.rows_count());
    }

    @Test
    void cols_count() {
        Assertions.assertEquals(3, mt.cols_count());
        Assertions.assertNotEquals(4, mt.cols_count());
    }

    @Test
    void size_matrix() {
        Assertions.assertArrayEquals(new int[] {4,3}, mt.size_matrix());
    }

    @Test
    void check_rc() {
        Assertions.assertTrue(mt.check_rc(0, 0, false));
        Assertions.assertTrue(mt.check_rc(3, 2, false));
        Assertions.assertFalse(mt.check_rc(4, 2, false));
        Assertions.assertFalse(mt.check_rc(1, 3, false));
        IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mt.check_rc(4, 2, true);
        });
        Assertions.assertEquals("Номер рядка перевищує розмір матриці.",thrown1.getMessage());
        IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mt.check_rc(1, 3, true);
        });
        Assertions.assertEquals("Номер стовпчика перевищує розмір матриці.",thrown2.getMessage());
    }

    @Test
    void set_element_im() {
        mtr = mt.set_element_im(1, 1, 11.1);
        Assertions.assertArrayEquals(new double[][] {{11, 12, 13}, {21, 11.1, 23}, {31, 32, 33}, {41, 42, 43}}, mtr.get_table());
        IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mtr=mt.set_element_im(4, 1, 41);
        });
        Assertions.assertEquals("Номер рядка перевищує розмір матриці.",thrown1.getMessage());
        IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mtr=mt.set_element_im(1, 3, 41);
        });
        Assertions.assertEquals("Номер стовпчика перевищує розмір матриці.",thrown2.getMessage());
        IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mtr=mt.set_element_im(1, -1, 41);
        });
        Assertions.assertEquals("Номер стовпчика меньше нуля.",thrown3.getMessage());
        IllegalArgumentException thrown4 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mtr=mt.set_element_im(-1, 1, 41);
        });
        Assertions.assertEquals("Номер рядка меньше нуля.",thrown4.getMessage());
    }

    @Test
    void set_row_im() {
        mtr=mt.set_row_im(1, new double[]{21.1, 22.1, 23.1});
        Assertions.assertArrayEquals(new double[][] {{11, 12, 13}, {21.1, 22.1, 23.1}, {31, 32, 33}, {41, 42, 43}}, mtr.get_table());
        IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mtr=mt.set_row_im(4, new double[]{21.1, 22.1, 23.1});
        });
        Assertions.assertEquals("Номер рядка перевищує розмір матриці.",thrown1.getMessage());
        IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mtr=mt.set_row_im(3, new double[]{21.1, 22.1, 23.1, 24.1});
        });
        Assertions.assertEquals("Кількість стовпчиків повина дорівнювати кількості значень.",thrown2.getMessage());
        IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mtr=mt.set_row_im(3, new double[]{21.1, 22.1});
        });
        Assertions.assertEquals("Кількість стовпчиків повина дорівнювати кількості значень.",thrown3.getMessage());
        IllegalArgumentException thrown4 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mtr=mt.set_row_im(-1, new double[]{21.1, 22.1, 23.1});
        });
        Assertions.assertEquals("Номер рядка меньше нуля.",thrown4.getMessage());
    }

    @Test
    void set_col_im() {
        mtr=mt.set_col_im(1, new double[]{12.1, 22.1, 32.1, 42.1});
        Assertions.assertArrayEquals(new double[][] {{11, 12.1, 13}, {21, 22.1, 23}, {31, 32.1, 33}, {41, 42.1, 43}}, mtr.get_table());
        IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mtr=mt.set_col_im(3, new double[]{12.1, 22.1, 32.1, 42.1});
        });
        Assertions.assertEquals("Номер стовпчика перевищує розмір матриці.",thrown1.getMessage());
        IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mtr=mt.set_col_im(2, new double[]{12.1, 22.1, 32.1, 42.1, 52.1});
        });
        Assertions.assertEquals("Кількість рядків повина дорівнювати кількості значень.",thrown2.getMessage());
        IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mtr=mt.set_col_im(2, new double[]{21.1, 22.1});
        });
        Assertions.assertEquals("Кількість рядків повина дорівнювати кількості значень.",thrown3.getMessage());
        IllegalArgumentException thrown4 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mtr=mt.set_col_im(-1, new double[]{12.1, 22.1, 32.1, 42.1});
        });
        Assertions.assertEquals("Номер стовпчика меньше нуля.",thrown4.getMessage());
    }

    @Test
    void set_table_im() {
        mtr=mt.set_table_im(new double[][] {{111, 112, 113}, {121, 122, 123}, {131, 132, 133}, {141, 142, 143}});
        Assertions.assertArrayEquals(new double[][] {{111, 112, 113}, {121, 122, 123}, {131, 132, 133}, {141, 142, 143}}, mtr.get_table());
        IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mtr=mt.set_table_im(new double[][] {{111, 112, 113, 114}, {121, 122, 123, 124}, {131, 132, 133, 134}, {141, 142, 143, 144}});
        });
        Assertions.assertEquals("Кількість стовпчиків повина дорівнювати кількості стовпчиків значень.",thrown1.getMessage());
        IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mtr=mt.set_table_im(new double[][] {{111, 112, 113}, {121, 122, 123}, {131, 132, 133}, {141, 142, 143}, {151, 152, 153}});
        });
        Assertions.assertEquals("Кількість рядків повина дорівнювати кількості рядків значень.",thrown2.getMessage());
        IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mtr=mt.set_table_im(new double[][] {{111, 112, 113}, {121, 122, 123}, {131, 132, 133}});
        });
        Assertions.assertEquals("Кількість рядків повина дорівнювати кількості рядків значень.",thrown3.getMessage());
        IllegalArgumentException thrown4 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mtr=mt.set_table_im(new double[][] {{111, 112}, {121, 122}, {131, 132}, {141, 142}});
        });
        Assertions.assertEquals("Кількість стовпчиків повина дорівнювати кількості стовпчиків значень.",thrown4.getMessage());
    }

    @Test
    void get_element() {
        Assertions.assertEquals(22, mt.get_element(1, 1));
        Assertions.assertNotEquals(22, mt.get_element(0, 0));
        IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mt.get_element(4, 1);
        });
        Assertions.assertEquals("Номер рядка перевищує розмір матриці.",thrown1.getMessage());
        IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mt.get_element(1, 3);
        });
        Assertions.assertEquals("Номер стовпчика перевищує розмір матриці.",thrown2.getMessage());
        IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mt.get_element(1, -1);
        });
        Assertions.assertEquals("Номер стовпчика меньше нуля.",thrown3.getMessage());
        IllegalArgumentException thrown4 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mt.get_element(-1, 1);
        });
        Assertions.assertEquals("Номер рядка меньше нуля.",thrown4.getMessage());
    }

    @Test
    void get_row() {
        Assertions.assertArrayEquals(new double []{21, 22, 23}, mt.get_row(1));
        IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mt.get_row(4);
        });
        Assertions.assertEquals("Номер рядка перевищує розмір матриці.",thrown1.getMessage());
        IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mt.get_row(-1);
        });
        Assertions.assertEquals("Номер рядка меньше нуля.",thrown2.getMessage());
    }

    @Test
    void get_col() {
        Assertions.assertArrayEquals(new double []{12, 22, 32, 42}, mt.get_col(1));
        IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mt.get_col(3);
        });
        Assertions.assertEquals("Номер стовпчика перевищує розмір матриці.",thrown1.getMessage());
        IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mt.get_col(-1);
        });
        Assertions.assertEquals("Номер стовпчика меньше нуля.",thrown2.getMessage());
    }

    @Test
    void get_table() {
        Assertions.assertArrayEquals(new double[][] {{11, 12, 13}, {21, 22, 23}, {31, 32, 33}, {41, 42, 43}}, mt.get_table());
    }

    @Test
    void testEquals() {
        double[][] t1, t2;
        MatrixImmutable mt1, mt2;
        t1=new double[][] {{11, 12, 13}, {21, 22, 23}, {31, 32, 33}, {41, 42, 43}};
        mt1=new MatrixImmutable(t1);
        t2=new double[][] {{11, 12, 13}, {21, 52, 23}, {31, 32, 33}, {41, 42, 43}};
        mt2=new MatrixImmutable(t2);
        Assertions.assertTrue(mt.equals(mt1));
        Assertions.assertFalse(mt.equals(mt2));
    }

    @Test
    void testHashCode() {
        Assertions.assertEquals(-982233452, mt.hashCode());
        Assertions.assertNotEquals(982233452, mt.hashCode());
    }

    @Test
    void sum() {
        double[][] t1, ts;
        Matrix mt1, mt2, mts;
        t1=new double[][] {{111, 112, 113}, {121, 122, 123}, {131, 132, 133}, {141, 142, 143}};
        mt1=new Matrix(t1);
        mt2=mt.sum(mt1);
        ts=new double[][] {{122, 124, 126}, {142, 144, 146}, {162, 164, 166}, {182, 184, 186}};
        mts=new MatrixImmutable(ts);
        Assertions.assertTrue(mt2.equals(mts));
        Assertions.assertFalse(mt.equals(mts));
    }

    @Test
    void multiplication() {
        double[][] ts;
        Matrix mt2, mts;
        mt2=mt.multiplication(2);
        ts=new double[][] {{22, 24, 26}, {42, 44, 46}, {62, 64, 66}, {82, 84, 86}};
        mts=new MatrixImmutable(ts);
        Assertions.assertTrue(mt2.equals(mts));
        Assertions.assertFalse(mt.equals(mts));
    }

    @Test
    void testMultiplication() {
        double[][] t1,t11, ts;
        Matrix mt1, mt11, mt2, mts;
        t1=new double[][] {{111, 112, 113, 114}, {121, 122, 123, 124}, {131, 132, 133, 134}};
        mt1=new Matrix(t1);
        mt2=mt.multiplication(mt1);
        ts=new double[][] {{4376.00,4412.00,4448.00,4484.00},
                {8006.00,8072.00,8138.00,8204.00},
                {11636.00,11732.00,11828.00,11924.00},
                {15266.00,15392.00,15518.00,15644.00}};
        mts=new MatrixImmutable(ts);
        Assertions.assertTrue(mt2.equals(mts));
        Assertions.assertFalse(mt.equals(mts));
        t11=new double[][] {{111, 112, 113}, {121, 122, 123}, {131, 132, 133}, {141, 142, 143}};
        mt11=new MatrixImmutable(t11);
        IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mt.multiplication(mt11);
        });
        Assertions.assertEquals("Кількість стовпчиків першої матриці повино дорівнювати кількості рядків другої матриці.",thrown1.getMessage());
    }

    @Test
    void transpose() {
        double[][] ts;
        Matrix mt2, mts;
        mt2=mt.transpose();
        ts=new double[][] {{11, 21, 31, 41}, {12, 22, 32, 42}, {13, 23, 33, 43}};
        mts=new MatrixImmutable(ts);
        Assertions.assertTrue(mt2.equals(mts));
        Assertions.assertFalse(mt.equals(mts));
    }

    @Test
    void diagonal() {
        double[] v={11,22,33,44,55};
        double[][] ts;
        Matrix mt2, mts;
        mt2=mt.diagonal(v);
        ts=new double[][] {{11, 0, 0, 0, 0}, {0, 22, 0, 0, 0}, {0, 0, 33, 0, 0}, {0, 0, 0, 44, 0}, {0, 0, 0, 0, 55}};
        mts=new MatrixImmutable(ts);
        Assertions.assertTrue(mt2.equals(mts));
        Assertions.assertFalse(mt.equals(mts));
    }

    @Test
    void testDiagonal() {
        double[][] v={{11},{22},{33},{44},{55}};
        double[][] vh={{11,22,33,44,55}};
        double[][] ts;
        MatrixImmutable mt2, mts, mtv;
        mtv=new MatrixImmutable(v);
        mt2=mt.diagonal(mtv);
        ts=new double[][] {{11, 0, 0, 0, 0}, {0, 22, 0, 0, 0}, {0, 0, 33, 0, 0}, {0, 0, 0, 44, 0}, {0, 0, 0, 0, 55}};
        mts=new MatrixImmutable(ts);
        Assertions.assertTrue(mt2.equals(mts));
        Assertions.assertFalse(mt.equals(mts));

        mtv=new MatrixImmutable(vh);
        mt2=mt.diagonal(mtv);
        ts=new double[][] {{11, 0, 0, 0, 0}, {0, 22, 0, 0, 0}, {0, 0, 33, 0, 0}, {0, 0, 0, 44, 0}, {0, 0, 0, 0, 55}};
        mts=new MatrixImmutable(ts);
        Assertions.assertTrue(mt2.equals(mts));
        Assertions.assertFalse(mt.equals(mts));
    }

    @Test
    void identity() {
        double[][] ts;
        MatrixImmutable mt2, mts;
        mt2=mt.identity(5);
        ts=new double[][] {{1, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};
        mts=new MatrixImmutable(ts);
        Assertions.assertTrue(mt2.equals(mts));
        Assertions.assertFalse(mt.equals(mts));
    }

    @Test
    void random_row() {
        IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            MatrixImmutable mts=mt.random_row(-1);
        });
        Assertions.assertEquals("Розмірність матриці повина бутит більше нуля.",thrown1.getMessage());
        MatrixImmutable mts1=mt.random_row(3);
        Assertions.assertNotEquals(mts1.get_element(0,0), mts1.get_element(0,1));
    }

    @Test
    void random_col() {
        IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            MatrixImmutable mts=mt.random_col(-1);
        });
        Assertions.assertEquals("Розмірність матриці повина бутит більше нуля.",thrown1.getMessage());
        MatrixImmutable mts1=mt.random_col(3);
        Assertions.assertNotEquals(mts1.get_element(0,0), mts1.get_element(1,0));
    }

    @Test
    void inverse() {
        double[][] t1, ti;
        MatrixImmutable mt1, mti, mts, mts1, mts1s;
        t1=new double[][] {{2, 5, 7}, {6, 3, 4}, {5, -2, -3}};
        mt1=new MatrixImmutable(t1);
        mts=mt1.inverse(mt1);
        ti=new double[][] {{1, -1, 1}, {-38, 41, -34}, {27, -29, 24}};
        mti=new MatrixImmutable(ti);
        Assertions.assertTrue(mti.equals(mts));
        Assertions.assertFalse(mt.equals(mts));
        mts1=mt1.multiplication(mti);
        mts1s=new MatrixImmutable(new double[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}});
        Assertions.assertTrue(mts1.equals(mts1s));
        IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            MatrixImmutable mt_sn=mt.inverse(mt);
        });
        Assertions.assertEquals("Кількість рядків матриці повина дорівнювати кількості стовпчиків.",thrown1.getMessage());
        MatrixImmutable mt4=new MatrixImmutable(new double[][] {{11, 12, 13}, {21, 22, 23}, {31, 32, 33}});
        IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            MatrixImmutable mt_sn=mt4.inverse(mt4);
        });
        Assertions.assertEquals("Матриця вироджена, тому не може бути обернена.",thrown2.getMessage());
    }

    @Test
    void set_element() {
        IllegalArgumentException thrown0 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mt.set_element(4, 1, 41);
        });
        Assertions.assertEquals("В об'єкті immutable потрібно використовувати метод set_element_im.",thrown0.getMessage());
    }

    @Test
    void set_row() {
        IllegalArgumentException thrown0 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mt.set_row(4, new double[]{21.1, 22.1, 23.1});
        });
        Assertions.assertEquals("В об'єкті immutable потрібно використовувати метод set_row_im.",thrown0.getMessage());
    }

    @Test
    void set_col() {
        IllegalArgumentException thrown0 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mt.set_col(3, new double[]{12.1, 22.1, 32.1, 42.1});
        });
        Assertions.assertEquals("В об'єкті immutable потрібно використовувати метод set_col_im.",thrown0.getMessage());
    }

    @Test
    void set_table() {
        IllegalArgumentException thrown0 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mt.set_table(new double[][] {{111, 112, 113, 114}, {121, 122, 123, 124}, {131, 132, 133, 134}, {141, 142, 143, 144}});
        });
        Assertions.assertEquals("В об'єкті immutable потрібно використовувати метод set_table_im.",thrown0.getMessage());
    }

}