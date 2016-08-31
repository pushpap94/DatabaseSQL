package hp.test.com.databasesql;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    Button btn;
    EditText name, pass, confirmpass;
    String user_name, user_pass, con_pass;

    Context ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btn=(Button)findViewById(R.id.button5);
        name=(EditText)findViewById(R.id.editText);
        pass=(EditText)findViewById(R.id.editText2);
        confirmpass=(EditText)findViewById(R.id.editText2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_name= name.getText().toString();
                user_pass=pass.getText().toString();
                con_pass=confirmpass.getText().toString();


                if(!(user_pass.equals(con_pass))){
                    Toast.makeText(getBaseContext(),"passwords are not matching",Toast.LENGTH_LONG).show();
                    name.setText(" ");
                    pass.setText(" ");
                    confirmpass.setText(" ");
                }
                else
                {

                    DatabaseOperations DB= new DatabaseOperations(ctx);
                    DB.putInformation(DB,user_name,user_pass);

                    Toast.makeText(getApplicationContext(),"Registraction Success...",Toast.LENGTH_LONG).show();
                    finish();

                }
            }
        });
    }
}
