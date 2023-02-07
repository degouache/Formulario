package com.beatrizcriado.beatrizcriadotarta;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText name;
    EditText surname;
    EditText age;
    String username;
    String userSurname;
    String userAge;
    RadioGroup radioGroup;
    CheckBox checkBox;
    EditText contestName;
    String userContestName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linearlayout_main);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        age = findViewById(R.id.age);
        radioGroup = findViewById(R.id.radiogroup);
        checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(this);
        contestName = findViewById(R.id.contestName);

    }

    public void register(View view) {
        Log.d("MainActivity", "Button clicked");
        username = name.getText().toString();
        userSurname = surname.getText().toString();
        userAge = age.getText().toString();
        userContestName = contestName.getText().toString();
        int userAgeInt = 0;

        if (!userAge.equals("")) {
            userAgeInt = Integer.parseInt(userAge);
        }

        if (username.equals("") || userSurname.equals("") || userAge.equals("")) {
            Toast.makeText(this, "Empty name, surname or age", Toast.LENGTH_SHORT).show();
        } else if (userAgeInt < 18) {
            Toast.makeText(this, "You're not old enough to participate", Toast.LENGTH_SHORT).show();
        } else if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Select gender", Toast.LENGTH_SHORT).show();
        } else if ( checkBox.isChecked() && userContestName.equals("")) {
            Toast.makeText(this, "You need to write the contest name", Toast.LENGTH_SHORT).show();
                } else {
            Toast.makeText(this, "You're subscribed", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            contestName.setVisibility(View.VISIBLE);

        } else {
            contestName.setVisibility(View.GONE);
        }
    }
}
