package com.example.alc4phase1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mButton, mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button_alc);
        mButton2 = findViewById(R.id.button_me);


    }

public void launchAlcActivity(View view){
    Intent intent = new Intent (this, AboutALC.class);
    startActivity(intent);
}
public void launchMyProfileActivity(View view){
        Intent intent = new Intent(this, MyProfile.class);
        startActivity(intent);
}

}
