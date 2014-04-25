package edu.vt.cs.cs3744.hw6;

import com.example.cs3744hw6.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * This is the main acitvity class that is loaded when the Android Application starts.
 * 
 * @author Chris Conley
 * @version April 25, 2014
 *
 */
public class HW6Activity extends Activity {

	private String commandLineArgs;
	private String[] commandArray;

	private HW6GLSurfaceView glView;
	private HW6Model model;

	/**
	 * Initializes the Android Activity.
	 * Creates a new HW6Model and sets the GLSurfaceView to
	 * the correct xml tag. This also sets the GLSurfaceView model
	 * 
	 * @param savedInstanceState the last state of the activity
	 */
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

	/**
	 * Adds a button for each word in a String to a LinearLayout.
	 * Also sets some conditions for margins, text size, etc...
	 * 
	 * @param hasFocus System parameter
	 */
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		LinearLayout ll = (LinearLayout) findViewById(R.id.button_layout);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				ll.getWidth(), 0, 1);
		params.setMargins(0, 3, 0, 0);
		
		for (int i = 0; i < commandArray.length; i++) {
			final Button button = new Button(this);  // Has to be final in order for event handling to work (onClick method)
			button.setId(i);  						 // Used by the model to identify which button is pressed so that the selection drawing can be applied
			button.setText(commandArray[i]);
			button.setTextSize(12f);
			button.setBackgroundColor(android.graphics.Color.WHITE);
			button.setTextColor(android.graphics.Color.BLUE);
			button.setClickable(true);
			button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if(!model.isSelected(button.getId()))
					{
						model.setSelectedWordIndex(button.getId());
						model.setSelected(true);
					}
					else
					{
						model.setSelectedWordIndex(-1);
						model.setSelected(false);
					}
					Log.i("CLICKED!", button.getText().toString());
				}
			});
			ll.addView(button, params);
		}
		ll.setPadding(0,0,0,3);
	}
}
