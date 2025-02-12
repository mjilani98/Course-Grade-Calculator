package com.example.hw2q1;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Display screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add event handler button
        Button button = findViewById(R.id.btnCalculate);
        ButtonHandler temp = new ButtonHandler();
        button.setOnClickListener(temp);
    }

    private class ButtonHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            //get inputs from the user

            //get programming assignment
            EditText txtAssignment = findViewById(R.id.proAssignmentInput);
            String strAssignment = txtAssignment.getText().toString();
            float programmingAssignment = -1;
            try {
                programmingAssignment = Float.parseFloat(strAssignment);

                //if the user entered grade more than 200 show an error message
                if(programmingAssignment > 200)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),"Programming assignment:\nEnter grade between 0-200",Toast.LENGTH_LONG);
                    toast.show();

                    programmingAssignment = -1;
                }
            }
            catch (NumberFormatException e)//if the user left the input empty
            {
                Toast toast = Toast.makeText(getApplicationContext(),"Programming assignment:\n\tInvalid input",Toast.LENGTH_LONG);
                toast.show();
            }

            //get midterm
            EditText txtMidterm = findViewById(R.id.midtermInput);
            String strMidterm = txtMidterm.getText().toString();
            float midterm = -1;
            try {
                midterm = Float.parseFloat(strMidterm);

                //if the user entered grade more than 100 show an error message
                if(midterm > 100)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),"Midterm:\nEnter grade between 0-100",Toast.LENGTH_LONG);
                    toast.show();

                    midterm = -1;
                }
            }
            catch (NumberFormatException e) //if the user left the input empty
            {
                Toast toast = Toast.makeText(getApplicationContext(),"Midterm:\nInvalid input",Toast.LENGTH_LONG);
                toast.show();
            }

            //get final grade
            EditText txtFinal = findViewById(R.id.finalInput);
            String strFinal = txtFinal.getText().toString();
            float finalEx = -1;
            try{
                finalEx = Float.parseFloat(strFinal);

                //if the user entered grade more than 100 show an error message
                if(finalEx > 100)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),"Final exam:\nEnter grade between 0-100",Toast.LENGTH_LONG);
                    toast.show();

                    finalEx = -1;
                }

            }
            catch (NumberFormatException e)
            {
                Toast toast = Toast.makeText(getApplicationContext(),"Final exam:\nInvalid input",Toast.LENGTH_LONG);
                toast.show();
            }

            //check if the user enters all inputs correctly
            if(programmingAssignment >= 0 && midterm >= 0 && finalEx >= 0)
            {
                //create a grade calculator object
                GradeCalculator calculator =  new GradeCalculator(programmingAssignment,midterm,finalEx);

                //get the final grade
                float finalGrade = calculator.getFinalGrade();

                //get the letter grade
                char letterGrade = calculator.getLetterGrade();

                String finalOutput = finalGrade + "  (" + letterGrade+")";
                //setting the output to the text view
                TextView output = findViewById(R.id.gradeOutput);
                output.setText(finalOutput);
            }


        }
    }


}