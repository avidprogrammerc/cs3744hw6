package com.example.cs3744hw6;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class HW6Activity extends Activity {

	private String commandLineArgs = ("A simple Android application or not");
	private String[] commandArray;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hw6_activity);
		commandArray = commandLineArgs.split("\\s+");
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		LinearLayout ll = (LinearLayout) findViewById(R.id.button_layout);
		for (int i = 0; i < commandArray.length; i++) {
			final Button button = new Button(this);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					ll.getWidth(), ll.getHeight() / commandArray.length);
			params.setMargins(1, 1, 1, 1);
			button.setLayoutParams(params);
			button.setText(commandArray[i]);
			button.setBackgroundColor(android.graphics.Color.WHITE);
			button.setTextColor(android.graphics.Color.BLUE);
			button.setPadding(1, 1, 1, 1);
			button.setClickable(true);
			button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Log.i("CLICKED!", button.getText().toString());
				}
			});
			ll.addView(button);
		}
	}
}
