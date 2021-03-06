package techkids.mad3.trungnt.student;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddStudentActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnSave;
    EditText editTextName, editTextClass, editTextBirthday;
    DatePickerDialog datePickerDialogBirthday;
    SimpleDateFormat dateFormatter;
    RadioButton radioButtonMale, radioButtonFemale;
    Spinner spinnerBirthdayPlace;
    CheckBox checkMusic;
    RadioButton radioButtonGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        btnSave = (Button) this.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        setDataDatePickerDialogBirthday();
    }

    @Override
    public void onClick(View v) {
        editTextName = (EditText) this.findViewById(R.id.editTextName);
        editTextClass = (EditText) this.findViewById(R.id.editTextClass);
        editTextBirthday = (EditText) this.findViewById(R.id.editTextBirthday);
        radioButtonMale = (RadioButton) this.findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton) this.findViewById(R.id.radioButtonFemale);
        spinnerBirthdayPlace = (Spinner) this.findViewById(R.id.spinnerBirthdayPlace);
        spinnerBirthdayPlace.setOnItemSelectedListener(new CustomOnItemSelectedListener());


        int id = v.getId();

        if (id == R.id.editTextBirthday)
            datePickerDialogBirthday.show();

        if (id == R.id.btnSave)
        {

            if (editTextName.getText().toString().isEmpty()
             || editTextName.getText().length() == 0
             || editTextClass.getText().toString().isEmpty()
             || editTextClass.getText().length() == 0
             || (radioButtonMale.isChecked() == false && radioButtonFemale.isChecked()==false)
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

                //String name = editTextName.getText().toString();
                //String className = editTextClass.getText().toString();
                //String birthday = editTextBirthday.getText().toString();
                String birthdayPlace = spinnerBirthdayPlace.getSelectedItem().toString();


                //day du lieu sinh vien vao intent va bundle
                Student student = new Student("Nguyen Tran Trung", "MAD3", "18-02-1986", birthdayPlace, 1 , 1);
                Bundle bundle = new Bundle();
                bundle.putSerializable("student1", student);
                Intent intentDisplay = new Intent(AddStudentActivity.this, DisplayActivity.class);
                intentDisplay.putExtras(bundle);
                startActivity(intentDisplay);
            }
        }
    }

    //dinh nghia phuong thuc hien thi Hop thoai Calendar trong editTextBirthday
    private void setDataDatePickerDialogBirthday()
    {
        editTextBirthday = (EditText) this.findViewById(R.id.editTextBirthday);
        editTextBirthday.setOnClickListener(this);
        editTextBirthday.setInputType(InputType.TYPE_NULL);

        Calendar newCalendar = Calendar.getInstance();
        datePickerDialogBirthday = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                editTextBirthday.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }
}
