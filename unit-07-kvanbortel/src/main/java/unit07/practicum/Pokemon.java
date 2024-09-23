/* Author: Kayla Van Bortel */

package unit07.practicum;

public class Pokemon {
    private String name;
    private PokeType type;
    private int level;

    public Pokemon(String name, PokeType type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
    }

    public Pokemon(String name, PokeType type) {
        this.name = name;
        this.type = type;
        this.level = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokeType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        level = level + 1;
        if (level > 100) {
            level = 100;
        }
    }

    @Override
    public String toString() {
        return "Pokemon{name=<" + name + ">, type=<" + type + ">, level=<" + level + ">}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pokemon) {
            Pokemon other = (Pokemon)obj;
            return other.getType() == type && other.getLevel() == level;
        }
        else {
            return false;
        }
    }
}
