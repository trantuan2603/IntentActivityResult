package com.landsoft.intentactivityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ReplayActivity extends AppCompatActivity {
    public static final String RESULT = "RESULT" ;
    public static final String BUNDLE_RESULT = "BUNDLE_RESULT";
    public static final int RESULT_CODE = 1995 ;
    private TextView tvNumberA, tvNumberB;
    private Button btnReplay;
    private double numberA, numberB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replay);
        mappedWiget();
        getOnData();
        tvNumberA.setText(String.valueOf(numberA));
        tvNumberB.setText(String.valueOf(numberB));
        setOnClick();
    }

    private void getOnData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(InputActivity.BUNDLE);
        numberA = Double.parseDouble(bundle.getString(InputActivity.NUMBERA));
        numberB = Double.parseDouble(bundle.getString(InputActivity.NUMBERB));
    }


    private void setOnClick() {
        btnReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString(RESULT,String.valueOf(numberA+numberB));
                intent.putExtra(BUNDLE_RESULT,bundle);
                setResult(RESULT_CODE,intent);
                finish();
            }
        });
    }

    private void mappedWiget(){
        tvNumberA = findViewById(R.id.tv_number_A);
        tvNumberB = findViewById(R.id.tv_number_B);
        btnReplay = findViewById(R.id.btn_replay);
    }


}
