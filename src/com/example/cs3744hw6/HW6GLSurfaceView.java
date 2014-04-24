package com.example.cs3744hw6;

import android.content.Context;
import android.util.AttributeSet;
import android.opengl.GLSurfaceView;

public class HW6GLSurfaceView extends GLSurfaceView
{
    HW6Model model = null;
    private HW6Renderer renderer = null;

    public HW6GLSurfaceView(Context context){
        super(context);
    }

    public HW6GLSurfaceView(Context context, AttributeSet attr){
        super(context, attr);
    }

    public HW6Renderer getRenderer(){
        return renderer;
    }

    public void setModel(HW6Model m) {
        model = m;
        renderer = new HW6Renderer(model);
        setRenderer(renderer);
    }
}
