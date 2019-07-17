package com.example.sanath.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FindCountryActivity extends AppCompatActivity {

    TextView next;
    ImageView imageView_Flag;
    List<CountryItem> list;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_country);

        random =new Random();

        //
        imageView_Flag = (ImageView) findViewById(R.id.imageView_Flag);
        list = new ArrayList<>();


        //add all flags and names to the list
        for (int i =0; i< new DataBase().answers.length; i++){
            list.add(new CountryItem(new DataBase().answers[i],new DataBase().flags[i]));
        }

        //Shuffle the countries
        Collections.shuffle(list);



        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(FindCountryActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.countries));
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mySpinner.setAdapter(arrayAdapter);
    }

    //Set flag image to the screen
        private void newQuestion(int number){
            imageView_Flag.setImageResource(list.get(number-1).getImage());

            int correct_answer = random.nextInt(4)+1;
        }


    public void toMainScreen(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}
