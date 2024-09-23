/* This program simulates the bridge with its inUse state
 * Author: Kayla Van Bortel
 */

package unit11.assignment.part2;

public class Bridge {
    private boolean inUse = false;

    public boolean enterBridge() {
        /** If the bridge in in use, block other Woolies from crossing. Otherwise, the current Woolie is using it and
         * it is allowed to cross.
         */
        synchronized(this) {
            if (inUse) {
                return false;
            }
            inUse = true;
            return true;
        }
    }

    public void leaveBridge() {
        /** When the Woolie leaves, the bridge is no longer in use */
        synchronized(this) {
            inUse = false;
        }
    }
}
