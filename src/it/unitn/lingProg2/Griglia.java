package it.unitn.lingProg2;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Griglia extends GridPane {
    private int dim;
    private int column_row_dim;
    private clickCase eventClick;
    private Casella zero;
    private Casella grigliaNodi[][];


    public Griglia(int dim,clickCase eventClick){

        this.eventClick = eventClick;
        this.dim = dim;
        this.column_row_dim = (int)Math.sqrt((double)dim);
        grigliaNodi = new Casella[column_row_dim][column_row_dim];
        this.zero = new Casella(0,null,this);

        initializeArray();


    }

    private void initializeArray(){
        Integer[] intArray = new Integer[dim];
        for( int i = 0; i<dim;i++) {
            intArray[i] = i;
        }

        List<Integer> intList = Arrays.asList(intArray);

        Collections.shuffle(intList);

        intList.toArray(intArray);

        for(int i = 0; i<dim; i++ ){
            Casella tmp;
            if(intArray[i]==0){
                tmp = zero;
            }else{
                tmp = new Casella(intArray[i],zero,this);
                tmp.addEventHandler(MouseEvent.MOUSE_CLICKED, eventClick);
            }
            this.add(tmp,i%column_row_dim,i/column_row_dim);
            grigliaNodi[i%column_row_dim][i/column_row_dim] = tmp;
        }


    }

    public void swap(Casella first, Casella second){
        int firstRow = this.getRowIndex(first);
        int firstCol =this.getColumnIndex(first);
        int secondRow = this.getRowIndex(second);
        int secondCol = this.getColumnIndex(second);
        this.getChildren().removeAll(first,second);
        this.add(first, secondCol, secondRow);
        this.add(second, firstCol, firstRow);

        grigliaNodi[firstCol][firstRow]=second;
        grigliaNodi[secondCol][secondRow]=first;

        if(checkWin()){
            System.out.println("hai vinto");
        }
    }

    public boolean checkWin(){
        for(int i = 0; i<dim-1 ; i++ ){
            if(grigliaNodi[i%column_row_dim][i/column_row_dim].getNumero() != i+1){
                return false;
            }

        }

        return true;
    }


}
