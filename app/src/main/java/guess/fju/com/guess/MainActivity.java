package guess.fju.com.guess;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int secret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random = new Random();
        secret = random.nextInt(100)+1;
//        TextView answer = findViewById(R.id.secret);
//        answer.setText(secret);
    }

    public void send(View view) {
        EditText ednumber = findViewById(R.id.number);
        int number = Integer.parseInt(ednumber.getText().toString());
        getSharedPreferences("NUMBER",MODE_PRIVATE)
                .edit()
                .putInt("NUMBER",number)
                .apply();
        int low = 1;
        int high = 100;
        int number2 = getSharedPreferences("NUMBER",MODE_PRIVATE)
                .getInt("")
        if(number > secret) {
            high = number;
            new AlertDialog.Builder(this)
                    .setMessage(low + " to " + high)
                    .setTitle("secret")
                    .show();
        }else if(number < secret) {
            low = number;
            new AlertDialog.Builder(this)
                    .setMessage(low + " to " + high)
                    .setTitle("secret")
                    .show();
        }else{
            new AlertDialog.Builder(this)
                    .setMessage("Yes, the number is " + secret)
                    .setTitle("secret")
                    .show();
        }
    }
}
