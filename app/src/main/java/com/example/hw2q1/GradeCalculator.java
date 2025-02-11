package com.example.hw2q1;

public class GradeCalculator
{
    private float programmingAssignment;

    private float midterm;

    private float finalExam;

    private float finalGrade;

    private char letterGrade;

    public GradeCalculator(float assignments,float mid,float finalEx)
    {
        this.programmingAssignment = assignments;
        this.midterm = mid;
        this.finalExam = finalEx;

    }

    //setting programming assignment
    public void setProgrammingAssignment(float assignments)
    {
        this.programmingAssignment = assignments;
    }

    //setting midterm
    public void setMidterm(float mid)
    {
        this.midterm = mid;
    }

    //setting final exam
    public void setFinalExam(float finale)
    {
       this.finalExam = finale;
    }

    //get the final grade
    public float getFinalGrade()
    {
        finalGrade = ((60*programmingAssignment)/200) + ((20*midterm)/100) + ((20*finalExam)/100);

        return finalGrade;
    }

    public char getLetterGrade()
    {
        if (finalGrade >= 90 && finalGrade <= 100) {
            letterGrade ='A';
        } else if (finalGrade >= 80 && finalGrade < 90) {
            letterGrade = 'B';
        } else if (finalGrade >= 70 && finalGrade < 80) {
            letterGrade = 'C';
        } else if (finalGrade >= 0 && finalGrade < 70) {
            letterGrade = 'D';
        } else {
            letterGrade = 'E';
        }

        return letterGrade;
    }
}
