package edu.vt.cs.cs3744.hw6;

import android.content.Context;
import android.util.AttributeSet;
import android.opengl.GLSurfaceView;

/**
 * Custom GLSurfaceView
 * 
 * @author Chris Conley
 * @version April 24, 2014
 */
public class HW6GLSurfaceView extends GLSurfaceView
{
    HW6Model model = null;
    private HW6Renderer renderer = null;

    /**
     * Constructor that takes a context
     * 
     * @param context context
     */
    public HW6GLSurfaceView(Context context){
        super(context);
    }

    /**
     * Constructor that takes a context and atribute set
     * 
     * @param context context
     * @param attr ArtibuteSet
     */
    public HW6GLSurfaceView(Context context, AttributeSet attr){
        super(context, attr);
    }

    /**
     * Gets the Renderer used for theis GLSurfaceView
     * 
     * @return renderer
     */
    public HW6Renderer getRenderer(){
        return renderer;
    }

    /**
     * Sets the model for the GLSurfaceView
     * 
     * @param m model
     */
    public void setModel(HW6Model m) {
        model = m;
        renderer = new HW6Renderer(model);
        setRenderer(renderer);
    }
}
