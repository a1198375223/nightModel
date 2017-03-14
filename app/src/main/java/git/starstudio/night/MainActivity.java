package git.starstudio.night;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button_reflect_id);
        Button button2 = (Button) findViewById(R.id.button_daynight_theme);
        Button button3 = (Button) findViewById(R.id.button_custom_theme);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_custom_theme:
                Intent intent1 = new Intent(this, CustomTheme.class);
                startActivity(intent1);
                break;
            case R.id.button_daynight_theme:
                Intent intent2 = new Intent(this, DayNightTheme.class);
                startActivity(intent2);
                break;
            case R.id.button_reflect_id:
                Intent intent3 = new Intent(this, ReflectID.class);
                startActivity(intent3);
                break;
            default:
        }
    }


}
