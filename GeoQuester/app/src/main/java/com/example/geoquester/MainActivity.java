package com.example.geoquester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private final Logger logger = Logger.getLogger(MainActivity.class.getName());
    private Handler logHandler;
    private final Date dat = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(), " - onCreate()", Toast.LENGTH_SHORT).show();

        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);
        logHandler = new ConsoleHandler();
        logHandler.setLevel(Level.ALL);
        logHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                dat.setTime(record.getMillis());
                return dat + "\n ----- "
                        + record.getMessage() + "\n";
            }
        });

        logger.addHandler(logHandler);

        AutoCompleteTextView cityTextView = (AutoCompleteTextView) findViewById(R.id.cityTextView);
        Button searchButton = findViewById(R.id.search_button);

        final TextView temperature = findViewById(R.id.temperature);
        final TextView fellingTemperature = findViewById(R.id.fellingTemperature);
        final TextView pressure = findViewById(R.id.pressure);
        final TextView humidity = findViewById(R.id.humidity);
        final TextView rainfall = findViewById(R.id.rainfall);
        final TextView windSpeed = findViewById(R.id.windSpeed);
        final TextView windDirection = findViewById(R.id.windDirection);

        String[] cities = getResources().getStringArray(R.array.cities);
        List<String> catList = Arrays.asList(cities);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, catList);
        cityTextView.setAdapter(adapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logger.log(Level.FINE, "Search button pressed");
//                temperature.setText();
//                fellingTemperature.setText();
//                pressure.setText();
//                humidity.setText();
//                rainfall.setText();
//                windSpeed.setText();
//                windDirection.setText();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
        logger.log(Level.INFO, "onStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(), "Повторный запуск!! - onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
        logger.log(Level.INFO, "onRestoreInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
        logger.log(Level.INFO, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
        logger.log(Level.INFO, "onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
        logger.log(Level.INFO, "onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
        logger.log(Level.INFO, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
        logger.log(Level.INFO, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
        logger.log(Level.INFO, "onDestroy");
    }
}
