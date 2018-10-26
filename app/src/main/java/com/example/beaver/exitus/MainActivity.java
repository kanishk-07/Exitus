package com.example.beaver.exitus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int Counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText)findViewById(R.id.user);
        Password = (EditText)findViewById(R.id.pass);
        Info = (TextView)findViewById(R.id.info);
        Login = (Button)findViewById(R.id.login_button);

        Info.setText("");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Username.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userName, String password){
        Log.i("info", "Username : " + userName + " and Password : " + password);
        if(userName.equals("admin") && password.equals("1234")){
            Intent intent = new Intent(MainActivity.this, Dashboard.class);
            startActivity(intent);
        }
        else{
            Counter--;
            Info.setText("No of Attempts Remaining : " + (String.valueOf(Counter)));
            if(Counter == 0){
                Login.setEnabled(false);
            }
        }
    }
}
