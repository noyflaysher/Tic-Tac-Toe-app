package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<int[]> combinationsToWin= new ArrayList<>();

    private int[] boxPositions = {0,0,0,0,0,0,0,0,0};

    private int playerTurn= 1;
    private int totalSelectedBoxes=1;

    private ImageButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn= findViewById(R.id.main_activity_btn_start);

        btn0= findViewById(R.id.main_activity_btn1);
        btn1= findViewById(R.id.main_activity_btn2);
        btn2= findViewById(R.id.main_activity_btn3);
        btn3= findViewById(R.id.main_activity_btn4);
        btn4= findViewById(R.id.main_activity_btn5);
        btn5= findViewById(R.id.main_activity_btn6);
        btn6= findViewById(R.id.main_activity_btn7);
        btn7= findViewById(R.id.main_activity_btn8);
        btn8= findViewById(R.id.main_activity_btn9);

        combinationsToWin.add(new int[] {0,1,2});
        combinationsToWin.add(new int[] {3,4,5});
        combinationsToWin.add(new int[] {6,7,8});
        combinationsToWin.add(new int[] {0,3,6});
        combinationsToWin.add(new int[] {1, 4,7});
        combinationsToWin.add(new int[] {2,5,8});
        combinationsToWin.add(new int[] {2,4,6});
        combinationsToWin.add(new int[] {0,4,8});

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("0");
                if(isBoxFree(0)){
                    turnAction((ImageButton) view,0);
                    System.out.println("01");
                }
            }
        });

//        btn0.setOnClickListener(view-> {
//
//            if(isBoxSelected(0)){
//                turnAction((ImageButton) view,0);
//            }
//
//        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxFree(1)){
                    turnAction((ImageButton) view,1);
                }
            }
        });
        btn2.setOnClickListener(view-> {

            if(isBoxFree(2)){
                turnAction((ImageButton) view,2);
            }
        });
        btn3.setOnClickListener(view-> {

            if(isBoxFree(3)){
                turnAction((ImageButton) view,3);
            }
        });
        btn4.setOnClickListener(view-> {

            if(isBoxFree(4)){
                turnAction((ImageButton) view,4);
            }
        });
        btn5.setOnClickListener(view-> {

            if(isBoxFree(5)){
                turnAction((ImageButton) view,5);
            }
        });
        btn6.setOnClickListener(view-> {

            if(isBoxFree(6)){
                turnAction((ImageButton) view,6);
            }
        });
        btn7.setOnClickListener(view-> {

            if(isBoxFree(7)){
                turnAction((ImageButton) view,7);
            }
        });
        btn8.setOnClickListener(view-> {

            if(isBoxFree(8)){
                turnAction((ImageButton) view,8);
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAgain();
            }
        });






    }

    private boolean isBoxFree(int position){

        boolean selected= true;

        if(boxPositions[position]==1 ||boxPositions[position]==2 )
            selected=false;

        return selected;
    }

    private void turnAction(ImageButton image, int position){
        boxPositions[position]=playerTurn;
        if(playerTurn==1){
            image.setImageResource(R.drawable.x_img);
            image.setBackgroundColor(000);
            System.out.println("player" + playerTurn);

        }
        else{
            image.setImageResource(R.drawable.o_img);
            System.out.println("player" + playerTurn);
        }

        if(checkWin()){
            System.out.println("win");
        }

        else if(totalSelectedBoxes==9){
            System.out.println("game Over - not win");
        }

//        else{
//            totalSelectedBoxes++;
//
//            changePlayerTurn();
//        }
        totalSelectedBoxes++;
        System.out.println("total: "+totalSelectedBoxes);
        changePlayerTurn();


    }

    private void changePlayerTurn(){
        if(playerTurn==1){
            playerTurn=2;
            //change imagebutton view to turn x
        }

        else{
            playerTurn=1;
            //change imagebutton view to turn y
        }
    }

    private boolean checkWin(){
        boolean win=false;
        for(int i=0;i<combinationsToWin.size();i++){
            final int[] combination = combinationsToWin.get(i);
            if(boxPositions[combination[0]]==playerTurn && boxPositions[combination[1]]==playerTurn && boxPositions[combination[2]]==playerTurn){
                win=true;
            }
        }
        return win;
    }

    private void startAgain(){
        totalSelectedBoxes=0;
        playerTurn=1;
        boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        btn0.setImageResource(R.drawable.square_icon);
        btn1.setImageResource(R.drawable.square_icon);
        btn2.setImageResource(R.drawable.square_icon);
        btn3.setImageResource(R.drawable.square_icon);
        btn4.setImageResource(R.drawable.square_icon);
        btn5.setImageResource(R.drawable.square_icon);
        btn6.setImageResource(R.drawable.square_icon);
        btn7.setImageResource(R.drawable.square_icon);
        btn8.setImageResource(R.drawable.square_icon);
        System.out.println("restart game");
    }


}