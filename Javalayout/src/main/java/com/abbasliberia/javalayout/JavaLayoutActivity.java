package com.abbasliberia.javalayout;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.util.TypedValue;

public class JavaLayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button myButton = new Button(this);
        myButton.setText("press me");
        myButton.setBackgroundColor(Color.BLUE);

        EditText myText = new EditText(this);

        myButton.setId(1);
        myText.setId(2);

        RelativeLayout myLayout = new RelativeLayout(this);
        myLayout.setBackgroundColor(Color.MAGENTA);

        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.addRule(RelativeLayout.CENTER_VERTICAL);

        RelativeLayout.LayoutParams textParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        textParams.addRule(RelativeLayout.ABOVE, myButton.getId());
        textParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textParams.setMargins(0, 0, 0, 80);

        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 200, r.getDisplayMetrics());

        myText.setWidth(px);

        myLayout.addView(myButton, buttonParams);
        myLayout.addView(myText, textParams);
        setContentView(myLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


}
