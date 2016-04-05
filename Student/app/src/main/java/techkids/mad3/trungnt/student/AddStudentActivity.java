package techkids.mad3.trungnt.student;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddStudentActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnSave;
    EditText editTextName, editTextClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        btnSave = (Button) this.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        editTextName = (EditText) this.findViewById(R.id.editTextName);
        editTextClass = (EditText) this.findViewById(R.id.editTextClass);

        int id = v.getId();
        if (id == R.id.btnSave)
        {

            if (editTextName.getText().toString().isEmpty()
             || editTextName.getText().length() == 0
             || editTextClass.getText().toString().isEmpty()
             || editTextClass.getText().length() ==0
            )

            {
                Context context = this;
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                // set title
                alertDialogBuilder.setTitle("WARNING ...");

                // set dialog message
                alertDialogBuilder
                        .setMessage("You need to type your data!")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }else
            {
                //luu du lieu hoac hien thi du lieu ....
            }
        }
    }
}
