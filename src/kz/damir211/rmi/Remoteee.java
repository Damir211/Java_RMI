package kz.damir211.rmi;

import java.io.Serializable;
import java.util.Arrays;

public class Remoteee implements Serializable {

    private static final long serialVersionUID = 1L;

    public Remoteee(int[][] table) {
        super();
        this.table = table;
    }
    private int[][] table;

    public int[][] getTable() {
        return table;
    }

    public void setTable(int[][] table) {
        this.table = table;
    }


    @Override
    public String toString() {
        String old = String.format("\nМассив:\n"+Arrays.deepToString(table)+"\n");
        
        int col = 0;
        int max = table[0][0];
        int min = table[0][0];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(table[i][j]<0){
                    col++;
                }
                if(table[i][j]<min){
                    min=table[i][j];
                }
                if(table[i][j]>max){
                    max=table[i][j];
                }
            }
        }
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(table[i][j]==min){
                    table[i][j]=table[i][j]+col;
                }else if(table[i][j]==max){
                    table[i][j]=table[i][j]+col;
                }
            }
        }
        return String.format(old+"\nОтрицательных элементов: %s\nМаксимальный элемент: %s\nМинимальный элемент: %s\n\n Массив:\n%s",col,max,min,Arrays.deepToString(table));
    }

}
