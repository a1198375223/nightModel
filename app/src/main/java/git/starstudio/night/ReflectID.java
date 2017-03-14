package git.starstudio.night;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 使用映射Id的方式来切换主题
 */

public class ReflectID extends AppCompatActivity implements View.OnClickListener,ThemeManager.OnThemeChangeListener{

    private static boolean isNormalTheme;

    private ActionBar mActionBar;
    private TextView mTextView;
    private Button mButton;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflect_id);
        ThemeManager.registerThemeChangeListener(this);
        isNormalTheme = true;
        mActionBar = getSupportActionBar();
        mButton = (Button) findViewById(R.id.button);
        mTextView = (TextView) findViewById(R.id.textView);
        mButton.setOnClickListener(this);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
    }



    @Override
    public void onClick(View v) {
        ThemeManager.setThemeMode(ThemeManager.getThemeMode() == ThemeManager.ThemeMode.DAY
                ? ThemeManager.ThemeMode.NIGHT : ThemeManager.ThemeMode.DAY);
    }

    public void initTheme() {
        mTextView.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(ReflectID.this, R.color.textColor)));
        mButton.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(ReflectID.this, R.color.textColor)));
        mRelativeLayout.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(ReflectID.this, R.color.backgroundColor)));
        // 设置标题栏颜色
        if(mActionBar != null){
            mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(ThemeManager.getCurrentThemeRes(ReflectID.this, R.color.colorPrimary))));
        }
        // 设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(getResources().getColor(ThemeManager.getCurrentThemeRes(ReflectID.this, R.color.colorPrimary)));
        }
    }

    @Override
    public void onThemeChanged() {
        initTheme();
    }
}
