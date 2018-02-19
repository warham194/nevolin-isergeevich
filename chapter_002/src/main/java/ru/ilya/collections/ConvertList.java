package ru.ilya.collections;

/**
 * Created by Lenovo2 on 04.02.2018.
 */

import java.util.ArrayList;
 import java.util.List;
public class ConvertList {
    /**
     * method for convert List<int[]> to ArrayList.
     *@param list List<int[]>.
     * @return List <Integer> .
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> con = new ArrayList<>();
        for (int[] lines : list) {
            for (int i : lines) {
                con.add(i);
            }
        }
        return con;
    }


    /**
     * method for convert int[][] to ArrayList.
     *@param array int[][]
     * @return the listLoop List <Integer> Array
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] lines : array) {
            for (int i : lines) {
                list.add(i);
            }
        }
        return list;
    }
    /**
     * method for convert ArrayList to int[][] array.
     * @param list<Integer>
     * @param rows \
     * @return the array2D int[][]
     */
    public int[][] toArray(List<Integer> list, int rows) {
      //  int cell = (list.size())/rows;
        int q = 0;
        int a = 0;
        double s = Math.ceil(rows);
        int value = (int) s;
        int[][] array2D = new int[rows][value];
        for (int i : list) {
            if (q == value) {
                q = 0;
                a++;
            }
            array2D[a][q] = i;
            q++;
    }

        /*
        if (list.size() % rows == 0) {
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cell; j++) {
                    array2D[i][j] = list.get(q);
                    q++;
                }
            }
        } else {
            int cell2 = (list.size())/rows +1;
            array2D = new int[rows][cell2];
            int a = 0;
            for(int i : list){         //
               if (q == cell2) {
                   q = 0;
                   a++;
               }
            array2D[a][q] = i;
            q++;
        }

    }
    */
        return array2D;
   }
}
