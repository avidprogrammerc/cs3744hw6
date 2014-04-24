package com.example.cs3744hw6;

public class HW6Model
{
    private float scale, translationY;
    private String[] data = null;
    private String selectedString;
    private int[] lengths = null;
    private int maxLength = 0;

    public HW6Model() {
        data = new String[0];
        scale = 1.0f;
        translationY =0.0f;
        update();
    }

    private void update() {
        lengths = new int[data.length];
        maxLength = 0;
        for (int i = 0; i < data.length; i++) {
            lengths[i] = data[i].length();
            if (lengths[i] > maxLength) {
                maxLength = lengths[i];
            }
        }
    }

    public String[] setCompoundData(String d) {
        if (d != null) {
            data = d.split(" ");
        }
        else {
            data = new String[0];
        }
        update();
        return data;
    }
    
    public String setSelectedData(String d)
    {
    	if(d != null)
    	{
    		selectedString = d;
    	}
    	else
    	{
    		selectedString = "";
    	}
    	return selectedString;
    }

    public void setScale(float s) {
        scale = s;
    }

    public float getScale() {
        return scale;
    }

    public void setTranslationY(float y) {
        translationY = y;
    }

    public float getTranslationY() {
        return translationY;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getCount() {
        return data.length;
    }

    public int[] getLengths() {
        return lengths;
    }
}
