package PROP;

/**
 * Created by mhitz on 27/10/16.
 */
public class PalabraPeso {
    private String text;
    private double peso;

    public PalabraPeso(String text, double peso) {
        this.text = text;
        this.peso = peso;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
