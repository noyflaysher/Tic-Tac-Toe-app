package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        btn0.setOnClickListener(view-> {

            if(isBoxSelected(0)){

            }

        });
        btn1.setOnClickListener(view-> {

            if(isBoxSelected(1)){

            }
        });
        btn2.setOnClickListener(view-> {

            if(isBoxSelected(2)){

            }
        });
        btn3.setOnClickListener(view-> {

            if(isBoxSelected(3)){

            }
        });
        btn4.setOnClickListener(view-> {

            if(isBoxSelected(4)){

            }
        });
        btn5.setOnClickListener(view-> {

            if(isBoxSelected(5)){

            }
        });
        btn6.setOnClickListener(view-> {

            if(isBoxSelected(6)){

            }
        });
        btn7.setOnClickListener(view-> {

            if(isBoxSelected(7)){

            }
        });
        btn8.setOnClickListener(view-> {

            if(isBoxSelected(8)){

            }
        });






    }

    private boolean isBoxSelected(int position){

        boolean selected= false;

        if(boxPositions[position]==1)
            selected=true;

        return selected;
    }
}