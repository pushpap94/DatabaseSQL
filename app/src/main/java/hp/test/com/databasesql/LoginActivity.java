package hp.test.com.databasesql;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText name, password;
    Button btn;
    String username, userpass;
    Context ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name=(EditText)findViewById(R.id.editText4);
        password=(EditText)findViewById(R.id.editText5);
        btn=(Button)findViewById(R.id.button6);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle b= getIntent().getExtras();
                int status = b.getInt("status");
                if(status==1)
                {
                    Toast.makeText(getApplicationContext(),"please wait...", Toast.LENGTH_LONG).show();
                    username=name.getText().toString();
                    userpass=password.getText().toString();
                    DatabaseOperations Dop=new DatabaseOperations(ctx);
                    Cursor cr=Dop.getInformation(Dop);
                    cr.moveToFirst();
                    boolean loginstatus=false;
                    String NAME="";
                    do {

                        if (username.equals(cr.getString(0))&& (userpass.equals(cr.getString(1))))
                        {

                            loginstatus=true;
                            NAME=cr.getString(0);
                        }

                    }while(cr.moveToNext());

                   if(loginstatus)
                    {
                        Toast.makeText(getApplicationContext(),"Login success....\n Welcome"+NAME, Toast.LENGTH_LONG).show();
                        finish();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Login failed....", Toast.LENGTH_LONG).show();
                        finish();
                    }



                }
                else if(status==2) {

                    Toast.makeText(getApplicationContext(), "please wait...", Toast.LENGTH_LONG).show();
                    username = name.getText().toString();
                    userpass = password.getText().toString();
                    DatabaseOperations Dop = new DatabaseOperations(ctx);
                    Cursor cr = Dop.getInformation(Dop);
                    cr.moveToFirst();
                    boolean loginstatus = false;
                    String NAME = "";
                    do {

                        if (username.equals(cr.getString(0)) && (userpass.equals(cr.getString(1)))) {

                            loginstatus = true;
                            NAME = cr.getString(0);
                        }

                    } while (cr.moveToNext());

                    if (loginstatus) {
                        Toast.makeText(getApplicationContext(), "Login success....\n Welcome" + NAME, Toast.LENGTH_LONG).show();
                        Intent i = new Intent(LoginActivity.this,UpdateActivity.class);

                        Bundle Bn=new Bundle();
                        Bn.putString("user_name", NAME);
                        Bn.putString("user_pass", userpass);
                        i.putExtras(Bn);

                        startActivity(i);

                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Login failed....", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }
                else if(status==3)
                {


                    Toast.makeText(getApplicationContext(),"please wait...", Toast.LENGTH_LONG).show();
                    username=name.getText().toString();
                    userpass=password.getText().toString();
                    DatabaseOperations Dop=new DatabaseOperations(ctx);
                    Cursor cr=Dop.getInformation(Dop);
                    cr.moveToFirst();
                    boolean loginstatus=false;
                    String NAME="";
                    do {

                        if (username.equals(cr.getString(0))&& (userpass.equals(cr.getString(1))))
                        {

                            loginstatus=true;
                            NAME=cr.getString(0);
                        }

                    }while(cr.moveToNext());

                    if(loginstatus)
                    {
                        Toast.makeText(getApplicationContext(),"Login success....\n Welcome"+NAME, Toast.LENGTH_LONG).show();
                        Intent i = new Intent(LoginActivity.this, DeleteActivity.class);

                        Bundle B=new Bundle();
                        B.putString("user_name", NAME);
                        i.putExtras(B);
                        startActivity(i);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Login failed....", Toast.LENGTH_LONG).show();
                        finish();
                    }

                }

            }
        });
    }
}
