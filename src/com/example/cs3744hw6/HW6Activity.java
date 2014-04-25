package com.example.cs3744hw6;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class HW6Activity extends Activity {

	private String commandLineArgs;
	private String[] commandArray;

	private HW6GLSurfaceView glView;
	private HW6Model model;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hw6_activity);
		model = new HW6Model();
		commandLineArgs = getString(R.string.commandLine);
		commandArray = model.setCompoundData(commandLineArgs);
		glView = (HW6GLSurfaceView) findViewById(R.id.glSurfaceView);
        glView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        glView.setModel(model);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		LinearLayout ll = (LinearLayout) findViewById(R.id.button_layout);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				ll.getWidth(), 0, 1);
		params.setMargins(0, 2, 0, 0);
		
		for (int i = 0; i < commandArray.length; i++) {
			final Button button = new Button(this);
			button.setLayoutParams(params);
			button.setText(commandArray[i]);
			button.setTextSize(12f);
			button.setBackgroundColor(android.graphics.Color.WHITE);
			button.setTextColor(android.graphics.Color.BLUE);
			button.setClickable(true);
			button.setId(i);
			button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					model.setSelectedWordIndex(button.getId());
					Log.i("CLICKED!", button.getText().toString());
				}
			});
			ll.addView(button);
			
		}
		ll.setPadding(0,0,0,2);
	}
}