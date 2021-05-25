package it.unitn.lingProg2;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class clickCase implements EventHandler<MouseEvent> {



    @Override
    public void handle(MouseEvent event) {
        Casella tmp = (Casella) (event.getSource());
        if(tmp.nearZero()){
            tmp.getGrigliaDiGioco().swap(tmp,tmp.getZero());
        }

        System.out.println("hai premuto il numero: "+tmp.getNumero());
    }
}
