package git.starstudio.night;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * 自定义主题切换夜间模式
 */

public class CustomTheme extends AppCompatActivity implements View.OnClickListener{

    private boolean isNormalTheme;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_theme);
        isNormalTheme = true;
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (isNormalTheme) {
            setTheme(R.style.Night);
            isNormalTheme = false;
        } else {
            setTheme(R.style.AppTheme);
            isNormalTheme = true;
        }
        setContentView(R.layout.activity_custom_theme);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }
}
