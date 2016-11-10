/**
 * Created by mhitz on 27/10/16.
 */
package PROP;
public class TermFrequency {
    private String text;
    private double frequency;

    public TermFrequency(String text, double frequency) {
        this.text = text;
        this.frequency = frequency;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
}
