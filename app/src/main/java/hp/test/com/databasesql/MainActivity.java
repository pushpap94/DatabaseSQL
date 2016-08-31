package hp.test.com.databasesql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button login, register, update, delete;

    int status=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login=(Button)findViewById(R.id.button);
        register=(Button)findViewById(R.id.button2);
        update =(Button)findViewById(R.id.button3);
        delete=(Button)findViewById(R.id.button4);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                status = 1;
                Bundle b= new Bundle();
                b.putInt("status", status);
                Intent i= new Intent(MainActivity.this,LoginActivity.class);
                i.putExtras(b);
                startActivity(i);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(i);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                status = 2;
                Bundle b= new Bundle();
                b.putInt("status", status);
                Intent i= new Intent(MainActivity.this, LoginActivity.class);
                i.putExtras(b);
                startActivity(i);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                status = 3;
                Bundle b= new Bundle();
                b.putInt("status", status);
                Intent i= new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
