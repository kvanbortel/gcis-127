package unit13.assignment2;

import java.util.Collection;

public interface Configuration<C extends Configuration<C>> {
    public abstract Collection<C> getSuccessors();
    public abstract boolean isValid();
    public abstract boolean isGoal();
}
