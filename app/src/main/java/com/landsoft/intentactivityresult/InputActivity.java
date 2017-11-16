package com.landsoft.intentactivityresult;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {
    public static final String NUMBERA = "NUMBERA";
    public static final String NUMBERB = "NUMBERB";
    public static final String BUNDLE = "BUNDLE" ;
    public static final int REQUEST_CODE = 1987;
    private EditText edtNumberA, edtNumberB;
    private Button btnSendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        mappedWidget();
        acttionClick();
    }

    private void   mappedWidget(){
        edtNumberA = findViewById(R.id.edt_number_a);
        edtNumberB = findViewById(R.id.edt_number_b);
        btnSendData = findViewById(R.id.btn_send_data);
    }

    private void acttionClick(){
        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberA = edtNumberA.getText().toString().trim();
                String numberB = edtNumberB.getText().toString().trim();
                if (TextUtils.isEmpty(numberA) || TextUtils.isEmpty(numberB)){
                    Toast.makeText(InputActivity.this, " input number A or B",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(InputActivity.this, ReplayActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(NUMBERA,numberA);
                    bundle.putString(NUMBERB,numberB);
                    intent.putExtra(BUNDLE,bundle);
                    startActivityForResult(intent,REQUEST_CODE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_CODE == requestCode){
            if (ReplayActivity.RESULT_CODE == resultCode){
                Intent intent = data;
                Bundle bundle = intent.getBundleExtra(ReplayActivity.BUNDLE_RESULT);
                String result =  bundle.getString(ReplayActivity.RESULT);
                Toast.makeText(InputActivity.this," Number A + Number B = " + result, Toast.LENGTH_SHORT ).show();
            }
        }
    }
}
