package unit13.haunted;

import java.util.Collection;

public interface Configuration<C extends Configuration<C>> {
    public abstract Collection<C> getSuccessors();
    public abstract boolean isValid();
    public abstract boolean isGoal();
}
