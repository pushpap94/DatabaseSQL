package hp.test.com.databasesql;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    EditText pass;
    Button btn;
    Bundle bundle;
    String Username;
    String Password;

    DatabaseOperations Dop;
    Context Ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        pass=(EditText)findViewById(R.id.editText7);
        btn=(Button)findViewById(R.id.button8);

        bundle=getIntent().getExtras();
        Username=bundle.getString("user_name");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Password=pass.getText().toString();
                Dop=new DatabaseOperations(Ctx);
                Cursor Cr=Dop.getUserPass(Dop, Username);
                Cr.moveToFirst();
                boolean loginstatus= false;
                do
                {
                    if(pass.equals(Cr.getString(0))){
                        loginstatus=true;
                    }

                }while(Cr.moveToNext());

                if(loginstatus){

                    Dop.deleteUser(Dop,Username,Password);

                Toast.makeText(getApplicationContext(), "User removed successfully...", Toast.LENGTH_LONG).show();
                finish();

                }else
                {
                    Toast.makeText(getApplicationContext(), "Inavlid user ...Try later", Toast.LENGTH_LONG).show();
                    finish();
                }

            }
        });
    }
}
