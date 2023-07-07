/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: PascalsTriangleGenerator.java
 * Author: Java Foundation
 * Author: Duc Ta
 * Author: Bryan Khor
 * **********************************************
 */

package assignment03PartD;

public class PascalsTriangleGenerator {

    public PascalsTriangleGenerator() {
    }

    public int[] computeRow(int rowToCompute) {
        int[] pascalTriangle = new int[rowToCompute];

        // If the rowToCompute is 1, return 1
        if (rowToCompute == 1) {
            pascalTriangle[0] = 1;
            return pascalTriangle;
        }

        int[] pascalTriangle2 = computeRow(rowToCompute - 1);
        pascalTriangle[0] = pascalTriangle[rowToCompute - 1] = 1;
        int i = 1;
        while (i < rowToCompute - 1) {
            pascalTriangle[i] = pascalTriangle2[i - 1] + pascalTriangle2[i];
            i++;
        }
        return pascalTriangle;
    }
}
