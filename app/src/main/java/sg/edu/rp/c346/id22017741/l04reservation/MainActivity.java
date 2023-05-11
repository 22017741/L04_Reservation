package sg.edu.rp.c346.id22017741.l04reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etPhone;
    EditText etSize;
    DatePicker dp;
    TimePicker tp;
    RadioGroup tableChoice;
    RadioButton Smoking;
    RadioButton nonSmoking;
    Button btnReset;
    Button btnSubmit;
    TextView tvDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.etName);
        etPhone=findViewById(R.id.etPhone);
        etSize=findViewById(R.id.etSize);
        dp=findViewById(R.id.dp);
        tp=findViewById(R.id.tp);
        tableChoice=findViewById(R.id.tableChoice);
        Smoking=findViewById(R.id.Smoking);
        nonSmoking=findViewById(R.id.nonSmoking);
        btnReset=findViewById(R.id.btnReset);
        btnSubmit=findViewById(R.id.btnSubmit);
        tvDisplay=findViewById(R.id.tvDisplay);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etName.getText().toString().trim();
                String number=etPhone.getText().toString().trim();
                String paxSize=etSize.getText().toString().trim();
                RadioButton selectedRadioButton = findViewById(tableChoice.getCheckedRadioButtonId());
                String smokingArea = selectedRadioButton.getText().toString();
                int pax=paxSize.isEmpty() ? 0 : Integer.parseInt(paxSize);
                Calendar calendar=Calendar.getInstance();
                calendar.set(dp.getYear(), dp.getMonth(), dp.getDayOfMonth(), tp.getCurrentHour(), tp.getCurrentMinute());
                SimpleDateFormat dateFormat=new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault());
                String dateTime=dateFormat.format(calendar.getTime());

                // validate inputs
                if (name.isEmpty() || number.isEmpty() || pax == 0) {
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // display input values
                String displayText="Name: "+name+"\nPhone: "+number+"\nPax: "+pax+"\nDate/Time: "+dateTime
                        +"\n"+smokingArea;
                tvDisplay.setText(displayText);

                // display input values in a toast
                Toast.makeText(MainActivity.this, displayText, Toast.LENGTH_SHORT).show();
                return;
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // clear input fields and display
                etName.setText("");
                etPhone.setText("");
                etSize.setText("");
                tvDisplay.setText("");
            }
        });
    }
}