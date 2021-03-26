package com.example.matrixcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText A [] [] = new EditText [3] [3];
    EditText B [] [] = new EditText[3][3];
    int a[] [] = new int [3] [3];
    int b[] [] = new int [3][3];
    int c [] [] = new int[3][3];
    int adj[][] = new int[3][3];
    int i,j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(i=0;i<3;i++) {
            for (j = 0; j < 3; j++) {
                String s = "A"+i+j;
                A[i][j] = findViewById(getResources().getIdentifier(s, "id", getPackageName()));
            }
        }
        for(i=0;i<3;i++) {
            for(j=0;j<3;j++) {
                String n ="B"+i+j;
                B[i] [j]=findViewById(getResources().getIdentifier(n,"id",getPackageName()));
            }
        }
    }

    public void Addition(View view) {

        for(i=0;i<3;i++) {
            for(j=0;j<3;j++) {
                a[i][j]=Integer.parseInt(A[i][j].getText().toString());
                b[i][j]=Integer.parseInt(B[i][j].getText().toString());
            }
        }
        for(i=0;i<3;i++) {
            for(j=0;j<3;j++) {
                c[i][j]=a[i][j]+b[i][j];
            }
        }
        String r [][] = new String [3][3];
        for(i=0;i<3;i++) {
            for(j=0;j<3;j++) {
               r [i][j] = Integer.toString(c[i][j]);
            }
        }

           Intent intent = new Intent(this,Matrix.class);
           Bundle mBundle = new Bundle();
           mBundle.putSerializable("result",r);
           intent.putExtras(mBundle);
           String p = "    A + B  =  ";
           intent.putExtra("Extra",p);
           startActivity(intent);
    }


    public void Subtraction(View view) {
        for(i=0;i<3;i++) {
            for(j=0;j<3;j++) {
                a[i][j]=Integer.parseInt(A[i][j].getText().toString());
                b[i][j]=Integer.parseInt(B[i][j].getText().toString());
            }
        }
        for(i=0;i<3;i++) {
            for(j=0;j<3;j++) {
                c[i][j]=a[i][j]-b[i][j];
            }
        }
        String r [][] = new String [3][3];
        for(i=0;i<3;i++) {
            for(j=0;j<3;j++) {
                r [i][j] = Integer.toString(c[i][j]);
            }
        }

        Intent intent = new Intent(this,Matrix.class);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable("result",r);
        intent.putExtras(mBundle);
        String p = "    A - B  =  ";
        intent.putExtra("Extra",p);
        startActivity(intent);
    }

    public void Multiplication(View view) {
        for(i=0;i<3;i++) {
            for(j=0;j<3;j++) {
                a[i][j]=Integer.parseInt(A[i][j].getText().toString());
                b[i][j]=Integer.parseInt(B[i][j].getText().toString());
            }
        }
        for( i=0;i<3;i++)
        {
            for( j=0;j<3;j++)
            {
                c[i][j]=0;
                for(int k=0;k<3;k++) {
                    c[i] [j] += a[i] [k] * b[k][j];
                }
            }
        }
        String r [][] = new String [3][3];
        for(i=0;i<3;i++) {
            for(j=0;j<3;j++) {
                r [i][j] = Integer.toString(c[i][j]);
            }
        }

        Intent intent = new Intent(this,Matrix.class);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable("result",r);
        intent.putExtras(mBundle);
        String p = "    A x B  =  ";
        intent.putExtra("Extra",p);
        startActivity(intent);
    }

    public void Determinant(View view) {
        for(i=0;i<3;i++) {
            for(j=0;j<3;j++) {
                a[i][j]=Integer.parseInt(A[i][j].getText().toString());
            }
        }
          int det =a[0][0]*(a[1][1]*a[2][2]-a[2][1]*a[1][2]) - a[0][1]*(a[1][0]*a[2][2]-a[2][0]*a[1][2]) + a[0][2]*(a[1][0]*a[2][1]-a[2][0]*a[1][1]);
          Toast.makeText(this,"Determinant of A = "+det,Toast.LENGTH_LONG).show();
        }

    public void Adjoint(View view) {
        for(i=0;i<3;i++) {
            for(j=0;j<3;j++) {
                a[i][j]=Integer.parseInt(A[i][j].getText().toString());
            }
        }
        adj[0][0] = a[1][1]*a[2][2] - a[2][1]*a[1][2];
        adj[0][1] = -(a[1][0]*a[2][2] - a[2][0]*a[1][2]);
        adj[0][2] = a[1][0]*a[2][1] - a[2][0]*a[1][1];
        adj[1][0] = -(a[0][1]*a[2][2] - a[2][1]*a[0][2]);
        adj[1][1] = a[0][0]*a[2][2] - a[2][0]*a[0][2];
        adj[1][2] = -(a[0][0]*a[2][1] - a[2][0]*a[0][1]);
        adj[2][0] = a[0][1]*a[1][2] - a[0][2]*a[1][1];
        adj[2][1] = -(a[0][0]*a[1][2] - a[1][0]*a[0][2]);
        adj[2][2] = a[0][0]*a[1][1] - a[1][0]*a[0][1];
        for( i=0;i<3;i++)
        {
            for( j=0;j<3;j++)
            {
                    c[i] [j] = adj[j] [i];
            }
        }
        String r [][] = new String [3][3];
        for(i=0;i<3;i++) {
            for(j=0;j<3;j++) {
                r [i][j] = Integer.toString(c[i][j]);
            }
        }

        Intent intent = new Intent(this,Matrix.class);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable("result",r);
        intent.putExtras(mBundle);
        String p = "ADJOINT \n OF A =";
        intent.putExtra("Extra",p);
        startActivity(intent);

    }

    public void Inverse(View view) {
        for(i=0;i<3;i++) {
            for(j=0;j<3;j++) {
                a[i][j]=Integer.parseInt(A[i][j].getText().toString());
            }
        }
        adj[0][0] = a[1][1]*a[2][2] - a[2][1]*a[1][2];
        adj[0][1] = -(a[1][0]*a[2][2] - a[2][0]*a[1][2]);
        adj[0][2] = a[1][0]*a[2][1] - a[2][0]*a[1][1];
        adj[1][0] = -(a[0][1]*a[2][2] - a[2][1]*a[0][2]);
        adj[1][1] = a[0][0]*a[2][2] - a[2][0]*a[0][2];
        adj[1][2] = -(a[0][0]*a[2][1] - a[2][0]*a[0][1]);
        adj[2][0] = a[0][1]*a[1][2] - a[0][2]*a[1][1];
        adj[2][1] = -(a[0][0]*a[1][2] - a[1][0]*a[0][2]);
        adj[2][2] = a[0][0]*a[1][1] - a[1][0]*a[0][1];
        int det =a[0][0]*(a[1][1]*a[2][2]-a[2][1]*a[1][2]) - a[0][1]*(a[1][0]*a[2][2]-a[2][0]*a[1][2]) + a[0][2]*(a[1][0]*a[2][1]-a[2][0]*a[1][1]);
        if(det == 0) {
            Toast.makeText(this," Matrix A is Not Invertible as it's determinant is zero",Toast.LENGTH_LONG).show();
        }
        else {
            float res[][] = new float[3][3];
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    c[i][j] = adj[j][i];
                    res[i][j] = c[i][j] / det;
                }
            }
            String r[][] = new String[3][3];
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    r[i][j] = Float.toString(res[i][j]);
                }
            }

            Intent intent = new Intent(this, Matrix.class);
            Bundle mBundle = new Bundle();
            mBundle.putSerializable("result", r);
            intent.putExtras(mBundle);
            String p = "INVERSE \n OF A =";
            intent.putExtra("Extra", p);
            startActivity(intent);
        }
    }
}