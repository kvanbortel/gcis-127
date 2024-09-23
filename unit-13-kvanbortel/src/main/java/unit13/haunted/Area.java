/** This class creates a room with a name, type, and optional evil
 *  Author: Kayla Van Bortel */

package unit13.haunted;

public class Area {
    private String name;
    private AreaType type;
    private String evilPresence;

    public Area(String name, AreaType type) {
        this.name = name;
        this.type = type;
        this.evilPresence = null;
    }

    public Area(Area area) { // For the deep copy
        name = area.name;
        type = area.type;
        evilPresence = area.evilPresence;
    }

    public String getName() {
        return name;
    }

    public AreaType getType() {
        return type;
    }

    public boolean isHaunted() {
        return evilPresence != null;
    }

    public void haunt(String evilPresence) {
        this.evilPresence = evilPresence;
    }

    @Override
    public String toString() {
        String s = name + " [" + type;
        if (evilPresence != null) {
            s += "/" + evilPresence;
        }
        return s + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Area) {
            Area other = (Area)obj;
            return name.equals(other.getName());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return name.hashCode();
    }
}
