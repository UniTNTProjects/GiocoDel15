package it.unitn.lingProg2;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Casella extends StackPane {
    private final int  PIXEL_DIM = 100;
    private int numero;
    private Rectangle rect;
    private Text text;
    private Griglia grigliaDiGioco;
    private Casella zero;
    public Casella(int numero,Casella zero,Griglia grigliaDiGioco){

        this.grigliaDiGioco = grigliaDiGioco;
        this.zero = zero;


        if(numero==0){
            rect = new Rectangle(PIXEL_DIM,PIXEL_DIM, Color.WHITE);
            rect.setStroke(Color.WHITE);
            text=new Text("");

        }else{
            rect = new Rectangle(PIXEL_DIM,PIXEL_DIM, Color.GREEN);
            rect.setStroke(Color.BLACK);
            text = new Text(Integer.toString(numero));
            text.setFont(new Font(25));
            text.setStroke(Color.BLACK);
        }

        this.numero = numero;
        this.getChildren().addAll(rect,text);
    }

    public int getNumero() {
        return numero;
    }

    public Casella getZero() {
        return zero;
    }

    public int getX() {
        return grigliaDiGioco.getColumnIndex(this);
    }

    public int getY() {
        return grigliaDiGioco.getRowIndex(this);
    }

    public Griglia getGrigliaDiGioco() {
        return grigliaDiGioco;
    }

    public boolean nearZero(){
        int tmpXZero = zero.getX();
        int tmpYZero = zero.getY();
        int tmpX = getX();
        int tmpY = getY();


        if((tmpXZero == tmpX && Math.abs(tmpYZero-tmpY)==1)||(tmpYZero == tmpY && Math.abs(tmpXZero-tmpX)==1)){
            return true;
        }else{
            return false;
        }


    }

}
