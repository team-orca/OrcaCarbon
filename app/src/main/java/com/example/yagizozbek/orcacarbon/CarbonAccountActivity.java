package com.example.yagizozbek.orcacarbon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CarbonAccountActivity extends AppCompatActivity {

    private final static double mNaturalGasEmission   = 22.9858546;
    private final static double mElectricityEmission  = 7.71107029;
    private final static double mFuelOilEmission      = 32.4729618;
    private final static double mPropanEmission       = 17.8393898;

    private double totalEmission;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carbon_account);

    }

    public void calculate(View v) {
        totalEmission = 0;
        EditText mEdit_Gas = (EditText) findViewById(R.id.editText);
        EditText mEdit_Electricity = (EditText) findViewById(R.id.editText2);
        EditText mEdit_Propan = (EditText) findViewById(R.id.editText3);
        EditText mEdit_Car = (EditText) findViewById(R.id.editText4);

        String gasCubeMeter = mEdit_Gas.getText().toString();
        double mGasCubeMeter = Double.parseDouble(gasCubeMeter);

        String kWatts = mEdit_Electricity.getText().toString();
        double mKWatts = Double.parseDouble(kWatts);

        String propanLiters = mEdit_Propan.getText().toString();
        double mLiters = Double.parseDouble(propanLiters);

        String kmInMonth = mEdit_Car.getText().toString();
        double mKmInMonth = Double.parseDouble(kmInMonth);


        TextView mView_Gas = (TextView) findViewById(R.id.textView5);
        mView_Gas.setText("Carbon footprint of Natural Gas : " + naturalGasEmission(mGasCubeMeter) + " kg/mon");

        TextView mView_Electricity = (TextView) findViewById(R.id.textView6);
        mView_Electricity.setText("Carbon footprint of Electricity : " + electricityEmission(mKWatts) + " kg/mon");

        TextView mView_Propan = (TextView) findViewById(R.id.textView7);
        mView_Propan.setText("Carbon footprint of Propan : " + propanEmission(mLiters) + " kg/mon");

        TextView mView_Car = (TextView) findViewById(R.id.textView8);
        mView_Car.setText("Carbon footprint of Your Car : " + automobileEmission(mKmInMonth) + " kg/mon");

        TextView mView_Total = (TextView) findViewById(R.id.textView9);
        mView_Total.setText("TOTAL CARBON FOOTPRINT : " + (int) totalEmission + " kg/mon");

        TextView mView_Trees = (TextView) findViewById(R.id.textView10);
        mView_Trees.setText(needTrees() + " trees are needed to offset your carbon footprint");

    }

    public int naturalGasEmission(double cubeMeter) {
        totalEmission += (mNaturalGasEmission * cubeMeter) / 12;
        return (int) (mNaturalGasEmission * cubeMeter) / 12;
    }

    public int electricityEmission(double kWatts) {
        totalEmission += (mElectricityEmission * kWatts) / 12;
        return (int) (mElectricityEmission* kWatts) / 12;
    }


    public int propanEmission(double liters) {
        totalEmission += (mPropanEmission * liters) / 12;
        return (int) (mPropanEmission * liters) / 12;
    }

    public int automobileEmission(double km) {
        totalEmission += (0.109 * km);
        return (int) (0.109 * km);
    }

    public int needTrees() {
        return (int) (totalEmission / 1.81436);
    }


}

