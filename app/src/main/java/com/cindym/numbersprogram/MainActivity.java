package com.cindym.numbersprogram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnNaturalNumbers, primeFactor, sequenceNumber;
    private TextView serverResults;

    public static final int TOTAL_COUNT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serverResults = (TextView) findViewById(R.id.rsServerResponse);
        btnNaturalNumbers = (Button) findViewById(R.id.btnNaturalNumbers);
        primeFactor = (Button) findViewById(R.id.primeFactor);
        sequenceNumber = (Button) findViewById(R.id.sequenceNumber);


        btnNaturalNumbers.setOnClickListener(this);
        primeFactor.setOnClickListener(this);
        sequenceNumber.setOnClickListener(this);

    }

    private void primeFactors(long n){

        while (n%2==0)
        {
            n /= 2;
        }

        // n must be odd at this point. So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            while (n%i == 0)
            {
                n /= i;
            }
        }

        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2)
        serverResults.setText("The largest prime factor of the number 600851475143 is: " + n);

    }
    private void naturalNumbers(){

        int multiple3 =0;
        int multiple5 =0;
        int sum =0;

        for (int x = 1; x < TOTAL_COUNT; x++){
            multiple3 = 3 * x;
            multiple5 = 5 * x;

            if(multiple3 < TOTAL_COUNT){

               sum+=multiple3 ;

            }

            if(multiple5 < TOTAL_COUNT){

                sum+=multiple5 ;

            }
        }

        serverResults.setText("The sum of all the multiples of 3 or 5 below 1000 is: " + sum);

    }

    private void sequence(){

      int num1 = 1, num2 = 2;
        int tot = 0;
        int sum = 0;

        for (int x = 1; x < 4000000; x++){

            tot = num1 + num2;
            if(tot < 4000000){

                num1 = num2;
                num2 = tot;

                //check if its an odd value then add to the sum
                if((tot%2)==0){

                    sum += tot;

                }

            }else{

                break;
            }

        }
        serverResults.setText("The sum of the even-valued terms: " + sum);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btnNaturalNumbers:

                naturalNumbers();
                break;
            case R.id.primeFactor:

                primeFactors(600851475143L);
                break;
            case R.id.sequenceNumber:

                sequence();
                break;

        }
    }
}
