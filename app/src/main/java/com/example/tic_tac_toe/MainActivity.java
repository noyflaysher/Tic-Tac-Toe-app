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
    private ImageView line, playerTurnImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button startBtn= findViewById(R.id.main_activity_btn_start);

        btn0= findViewById(R.id.main_activity_btn1);
        btn1= findViewById(R.id.main_activity_btn2);
        btn2= findViewById(R.id.main_activity_btn3);
        btn3= findViewById(R.id.main_activity_btn4);
        btn4= findViewById(R.id.main_activity_btn5);
        btn5= findViewById(R.id.main_activity_btn6);
        btn6= findViewById(R.id.main_activity_btn7);
        btn7= findViewById(R.id.main_activity_btn8);
        btn8= findViewById(R.id.main_activity_btn9);
        line= findViewById(R.id.imageView4);
        playerTurnImg= findViewById(R.id.main_activity_turnPlay);

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

//        startBtn.setOnClickListener(view -> {
//            startAgain();
//        });




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
            image.setImageResource(R.drawable.x_icon_3);
            System.out.println("player" + playerTurn);
            System.out.println("toal " + totalSelectedBoxes);

        }
        else{
            image.setImageResource(R.drawable.o_icon_small_3);
            System.out.println("player" + playerTurn);
            System.out.println("toal " + totalSelectedBoxes);
        }

        if(checkWin()){
            String message="";
            if(playerTurn==1)
            {
                message="Player 1 is the winner";

            }
            if(playerTurn==2)
            {
                message="Player 2 is the winner";
            }


            WinDialog winDialog=new WinDialog(MainActivity.this,message,MainActivity.this);
            winDialog.setCancelable(false);
            winDialog.show();


            System.out.println("win");
        }

        else if(totalSelectedBoxes==9){
            WinDialog winDialog=new WinDialog(MainActivity.this,"It is a draw! no winner..",MainActivity.this);
            winDialog.setCancelable(false);
            winDialog.show();
            System.out.println("game Over - not win");
        }

        else{
            totalSelectedBoxes++;
            changePlayerTurn();
        }
    }

    private void changePlayerTurn(){
        if(playerTurn==1){
            playerTurn=2;
            playerTurnImg.setImageResource(R.drawable.oplay);

        }

        else{
            playerTurn=1;
            playerTurnImg.setImageResource(R.drawable.xplay);
        }
    }

    private boolean checkWin(){
        boolean win=false;

        for(int i=0;i<combinationsToWin.size();i++){
            final int[] combination = combinationsToWin.get(i);
            if(boxPositions[combination[0]]==playerTurn && boxPositions[combination[1]]==playerTurn && boxPositions[combination[2]]==playerTurn){
                win=true;
                if(combination[0]==3 && combination[1]==4 && combination[2]==5){
                    line.setImageResource(R.drawable.mark6);
                }
                if(combination[0]==1 && combination[1]==4 && combination[2]==7){
                    line.setImageResource(R.drawable.mark4);
                }
                if(combination[0]==2 && combination[1]==5 && combination[2]==8){
                    line.setImageResource(R.drawable.mark5);
                }
                if(combination[0]==0 && combination[1]==3 && combination[2]==6){
                    line.setImageResource(R.drawable.mark3);
                }
                if(combination[0]==2 && combination[1]==4 && combination[2]==6){
                    line.setImageResource(R.drawable.mark2);
                }
                if(combination[0]==0 && combination[1]==4 && combination[2]==8){
                    line.setImageResource(R.drawable.mark1);
                }
                if(combination[0]==6 && combination[1]==7 && combination[2]==8){
                    line.setImageResource(R.drawable.mark7);
                }
                if(combination[0]==0 && combination[1]==1 && combination[2]==2){
                    line.setImageResource(R.drawable.mark8);
                }
            }

        }
        return win;
    }

    public void startAgain(){
        totalSelectedBoxes=0;
        playerTurn=1;
        boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        line.setImageResource(R.drawable.empty);

        btn0.setImageResource(R.drawable.images);
        btn1.setImageResource(R.drawable.images);
        btn2.setImageResource(R.drawable.images);
        btn3.setImageResource(R.drawable.images);
        btn4.setImageResource(R.drawable.images);
        btn5.setImageResource(R.drawable.images);
        btn6.setImageResource(R.drawable.images);
        btn7.setImageResource(R.drawable.images);
        btn8.setImageResource(R.drawable.images);
        playerTurnImg.setImageResource(R.drawable.xplay);
        System.out.println("restart game");
    }


}