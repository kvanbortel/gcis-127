package unit06;

public class Mug {
    private int size;
    private String color;
    private int fillLevel;
    private String phrase;
    private Material material;

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }    

    public int getFillLevel() {
        return fillLevel;
    } 

    public String getPhrase() {
        return phrase;
    } 

    public Material getMaterial() {
        return material;
    } 

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public Mug(int size, String color, int fillLevel, String phrase, Material material) {
        this.size = size;
        this.color = color;
        this.fillLevel = fillLevel;
        this.phrase = phrase;
        this.material = material;
    }

    public void fill(int ounces) {
        fillLevel = fillLevel + ounces;
        if (fillLevel > size) {
            fillLevel = size;
        }
    }

    public int drain(int ounces) {
        fillLevel -= ounces;
        int drank = ounces;
        if (fillLevel < 0) {
            drank = ounces + fillLevel;
            fillLevel = 0;
        }
        return drank;
    }

    @Override
    public String toString() {
        return "A " + color + " " + material + " mug that says '" + phrase + "'" + " and costs $" + material.getPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Mug) {
            Mug other = (Mug)obj;
            return material.equals(other.material) && size == other.size;
        }
        else {
            return false;
        }
    }

}
