package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private SudokuBoard gameBoard;
    private Solver gameBoardSolver;
    Button solveBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gameBoard = findViewById(R.id.SudokuBoard);
        gameBoardSolver = gameBoard.getSolver();

        solveBTN = findViewById(R.id.solve);


    }

    public void BTN1Press(View view) {
        gameBoardSolver.setNumberPos(1);
        gameBoard.invalidate();
    }

    public void BTN2Press(View view) {
        gameBoardSolver.setNumberPos(2);
        gameBoard.invalidate();
    }

    public void BTN3Press(View view) {
        gameBoardSolver.setNumberPos(3);
        gameBoard.invalidate();
    }

    public void BTN4Press(View view) {
        gameBoardSolver.setNumberPos(4);
        gameBoard.invalidate();
    }

    public void BTN5Press(View view) {
        gameBoardSolver.setNumberPos(5);
        gameBoard.invalidate();
    }

    public void BTN6Press(View view) {
        gameBoardSolver.setNumberPos(6);
        gameBoard.invalidate();
    }

    public void BTN7Press(View view) {
        gameBoardSolver.setNumberPos(7);
        gameBoard.invalidate();
    }

    public void BTN8Press(View view) {
        gameBoardSolver.setNumberPos(8);
        gameBoard.invalidate();
    }

    public void BTN9Press(View view) {
        gameBoardSolver.setNumberPos(9);
        gameBoard.invalidate();
    }
    public void Press(View view) {
        gameBoardSolver.random(gameBoard);
    }
    public void Solve(View view) {
        if (solveBTN.getText().toString().equals(getString(R.string.Solve))) {
            solveBTN.setText(R.string.Clear);

            gameBoardSolver.getEmptyBoxIndexes();


             SolveBoardThread solveBoardThread = new SolveBoardThread();
             new Thread(solveBoardThread).start();
             gameBoard.invalidate();
        } else {
            solveBTN.setText(R.string.Solve);

            gameBoardSolver.resetBoard();
            gameBoard.invalidate();
        }


    }
    class SolveBoardThread implements Runnable {

        @Override
        public void run() {
            gameBoardSolver.solve(gameBoard);
        }
    }

}