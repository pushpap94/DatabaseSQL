package hp.test.com.databasesql;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText name;
    Button btn;
    String username, userpass, newusername;
    Context ctx=this;
    DatabaseOperations Dop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name=(EditText)findViewById(R.id.editText6);
        btn=(Button)findViewById(R.id.button7);

        Bundle Bn=getIntent().getExtras();
        username=Bn.getString("user_name");
        userpass=Bn.getString("user_pass");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newusername=name.getText().toString();
                Dop=new DatabaseOperations(ctx);
                Dop.updateUserInfo(Dop, username,userpass,newusername);

                Toast.makeText(getApplicationContext(), "Updation Success", Toast.LENGTH_LONG).show();
                finish();

            }
        });
    }
}
