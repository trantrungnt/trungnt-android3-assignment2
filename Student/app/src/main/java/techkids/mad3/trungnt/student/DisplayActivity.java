package techkids.mad3.trungnt.student;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static techkids.mad3.trungnt.student.R.*;

/**
 * Created by TrungNT on 4/6/2016.
 */
public class DisplayActivity extends AppCompatActivity {
    TextView txtName, txtClass;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_display);

        //lay du lieu tu bundle
        Bundle bundle = getIntent().getExtras();
        //Student student;
        student = (Student) bundle.getSerializable("student1");
        txtName = (TextView) this.findViewById(R.id.txtName);
        txtClass = (TextView) this.findViewById(R.id.txtClass);
        txtName.setText(student.getNameStudent());
        txtClass.setText(student.getClassName());
    }

}
