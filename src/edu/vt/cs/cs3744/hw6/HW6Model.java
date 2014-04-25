package edu.vt.cs.cs3744.hw6;

/**
 * This is a representation of a word's length.
 * 
 * @author Chris Conley
 * @version April 25, 2014
 *
 */
public class HW6Model
{
    private float scale, translationY;
    private String[] data = null;
    private int[] lengths = null;
    private int maxLength = 0;
    private int selectedIndex = -1;
    private boolean selected = false;

    /**
     * Creates a new model
     */
    public HW6Model() {
        data = new String[0];
        scale = 1.0f;
        translationY =0.0f;
        update();
    }

    /**
     * Sets the length of each word into an array
     * Determines what the maximum word length is
     */
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

    /**
     * Given a String, this will chop it up into individual words
     * 
     * @param d Original String
     * @return String[] array of 'words'
     */
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

    /**
     * Changes the selectedIndex
     * 
     * @param index newIndex
     */
    public void setSelectedWordIndex(int index)
    {
    	selectedIndex = index;
    }
    
    /**
     * Returns the selectedIndex
     * 
     * @return int
     */
    public int getSelectedWordIndex()
    {
    	return selectedIndex;
    }
    
    /**
     * Sets the scale for the glSurfaceView
     * 
     * @param s scale factor
     */
    public void setScale(float s) {
        scale = s;
    }

    /**
     * Gets the scale for the glSurfaceView
     * 
     * @return float
     */
    public float getScale() {
        return scale;
    }

    /**
     * Sets the translation for the glSurfaceView
     * 
     * @param y translation factor
     */
    public void setTranslationY(float y) {
        translationY = y;
    }

    /**
     * Gets the scale for the glSurfaceView
     * 
     * @return float
     */
    public float getTranslationY() {
        return translationY;
    }
    
    /**
     * Get the length of the longest string
     * 
     * @return int
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * Get the size of the String array
     * 
     * @return int
     */
    public int getCount() {
        return data.length;
    }

    /**
     * Get the lengths of each String in the array
     * 
     * @return int[]
     */
    public int[] getLengths() {
        return lengths;
    }

    
    /**
     * Used for selection
     * 
     * @param id Button ID
     * @return if the ID's match, then reurn the current selected value
     */
	public boolean isSelected(int id) {
		if (id == selectedIndex)
			return selected;
		return false;
	}

	/**
	 * Sets the value of selected
	 * 
	 * @param value true/false
	 */
	public void setSelected(boolean value){
		selected = value;
	}
}
