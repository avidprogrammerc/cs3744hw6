package com.example.cs3744hw6;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.opengl.GLSurfaceView;

public class HW6Renderer implements GLSurfaceView.Renderer
{
    private HW6Model model = null;
    private float scaleY = 1.0f;
    private float translationY = 0.0f;
    private FloatBuffer vertexBuffer = null;
    private ShortBuffer indexBuffer = null;
    private int lineCount = 0;

    public HW6Renderer(HW6Model m)
    {
        super();
        model = m;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        setData(model.getMaxLength(), model.getLengths());
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, model.getTranslationY() * (Math.abs(model.getScale()) + 1), 0.0f);
        gl.glScalef(1.0f, model.getScale(), 1.0f);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glColor4f(0.0f, 0.0f, 1.0f, 1.0f);
        indexBuffer.position(0);
        gl.glDrawElements(GL10.GL_TRIANGLES, 6 * lineCount, GL10.GL_UNSIGNED_SHORT, indexBuffer);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
    }

    public void setData(int m, int[] c) {
        short n = (short) c.length;
        lineCount = n;
        float[] dataArray = new float[n * 12 + 12];
        short[] indexArray = new short[n * 11 + 5];
        for (short i = 0; i < n; i++) {
            dataArray[12*i] = -1.0f + 2.0f / (m + 2.0f);
            dataArray[12*i+1] = 1.0f - (i + 1) * 2.0f / (n + 2.0f);
            dataArray[12*i+2] = 0.0f;
            dataArray[12*i+3] = -1.0f + 2.0f / (m + 2.0f);
            dataArray[12*i+4] = 1.0f - (i + 2.0f) * 2.0f / (n + 2.0f);
            dataArray[12*i+5] = 0;
            dataArray[12*i+6] = -1.0f + (c[i] + 1.0f) * 2.0f / (m + 2.0f);
            dataArray[12*i+7] = 1.0f - (i + 2.0f) * 2.0f / (n + 2.0f);
            dataArray[12*i+8] = 0.0f;
            dataArray[12*i+9] = -1.0f + (c[i] + 1.0f) * 2.0f / (m + 2.0f);
            dataArray[12*i+10] = 1.0f - (i + 1.0f) * 2.0f / (n + 2.0f);
            dataArray[12*i+11] = 0.0f;
            indexArray[6*i] = (short) (4 * i);
            indexArray[6*i+1] = (short) (4 * i + 1);
            indexArray[6*i+2] = (short) (4 * i + 2);
            indexArray[6*i+3] = (short) (4 * i + 0);
            indexArray[6*i+4] = (short) (4 * i + 2);
            indexArray[6*i+5] = (short) (4 * i + 3);
            indexArray[6*n+5*i] = (short) (4 * i);
            indexArray[6*n+5*i+1] = (short) (4 * i + 1);
            indexArray[6*n+5*i+2] = (short) (4 * i + 2);
            indexArray[6*n+5*i+3] = (short) (4 * i + 3);
            indexArray[6*n+5*i+4] = (short) (4 * i);
        }
        dataArray[12*n] = -1;
        dataArray[12*n+1] = 1;
        dataArray[12*n+2] = 0;
        dataArray[12*n+3] = -1;
        dataArray[12*n+4] = -1;
        dataArray[12*n+5] = 0;
        dataArray[12*n+6] = 1;
        dataArray[12*n+7] = -1;
        dataArray[12*n+8] = 0;
        dataArray[12*n+9] = 1;
        dataArray[12*n+10] = 1;
        dataArray[12*n+11] = 0;
        indexArray[11*n] = (short) (4 * n);
        indexArray[11*n+1] = (short) (4 * n + 1);
        indexArray[11*n+2] = (short) (4 * n + 2);
        indexArray[11*n+3] = (short) (4 * n + 3);
        indexArray[11*n+4] = (short) (4 * n);

        ByteBuffer db = ByteBuffer.allocateDirect(4 * dataArray.length);
        db.order(ByteOrder.nativeOrder());
        vertexBuffer = db.asFloatBuffer();
        vertexBuffer.put(dataArray);
        vertexBuffer.position(0);

        ByteBuffer ib = ByteBuffer.allocateDirect(2 * indexArray.length);
        ib.order(ByteOrder.nativeOrder());
        indexBuffer = ib.asShortBuffer();
        indexBuffer.put(indexArray);
        indexBuffer.position(0);
    }

    public void setScaleY(float s) {
        scaleY = s;
    }

    public float getScaleY() {
        return scaleY;
    }

    public void setTranslationY(float t) {
        translationY = t;
    }

    public float getTranslationY() {
        return translationY;
    }
}
