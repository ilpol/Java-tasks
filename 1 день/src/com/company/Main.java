package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //1 задача
        System.out.println(sleepIn(false, true));
        //2 задача
        System.out.println(sumDouble(2, 2));
        //3 задача
        System.out.println(altPairs("CodingHorror"));
        //Задача повышенной сложности
        complexTask("3 3 5\n1 2 3\n4 5 6\n7 8 9\ng 3 2\nr 3 2\nc 2 3\ng 2 2\ng 3 2");
        complexTask("2 3 3\n1 2 4\n3 1 5\nc 2 1\nr 1 2\ng 1 3");
    }

    public static boolean sleepIn(boolean weekday, boolean vacation) {
        if (vacation)
            return  true;
        else return !weekday;
    }

    public static int sumDouble(int a, int b) {
        if (a != b)
            return a + b;
        else
            return 2 * (a + b);
    }

    public static String altPairs(String str) {
        StringBuilder resStr = new StringBuilder();
        int strLength = str.length();
        for (int i = 0; i< strLength; i = i + 4){
            resStr.append(str.charAt(i));
            if ((i + 1) < strLength)
                resStr.append(str.charAt(i + 1));
        }
        return resStr.toString();
    }

    public static void complexTask (String inParams) {
        String[] lines = inParams.split("\n");
        String[] firstLineParams = (lines[0]).split(" ");
        String[] curLine;
        int n = Integer.parseInt(firstLineParams[0]);
        int m = Integer.parseInt(firstLineParams[1]);
        int k = Integer.parseInt(firstLineParams[2]);
        int[][] matrix = new int [n][m];

        //создаем матрицу
        for (int i = 0; i < n; i++) {
            curLine = lines[i + 1].split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(curLine[j]);
            }
        }

        //интерпретация последующих k строк
        int lastLine = k + n + 1;
        for (int i = n + 1; i < lastLine; i++) {
            curLine = lines[i].split(" ");
            if (curLine[0].equals("r"))
                changeMatrix(Integer.parseInt(curLine[1]) - 1,Integer.parseInt(curLine[2]) - 1, m,true, matrix);
            else if (curLine[0].equals("c"))
                changeMatrix(Integer.parseInt(curLine[1]) - 1,Integer.parseInt(curLine[2]) - 1, n,false, matrix);
            else
                System.out.println(matrix[Integer.parseInt(curLine[1]) - 1][Integer.parseInt(curLine[2]) - 1]);
        }
    }

    public static void changeMatrix(int row1, int row2, int len, boolean boolRow, int matrix [][]){
      if (boolRow) {
          for (int i = 0; i < len; i++) {
              int t = matrix[row1][i];
              matrix[row1][i] = matrix[row2][i];
              matrix[row2][i] = t;
          }
      }
      else {
          for (int i = 0; i < len; i++) {
              int t = matrix[i][row1];
              matrix[i][row1] = matrix[i][row2];
              matrix[i][row2] = t;
          }
      }
    }
}
