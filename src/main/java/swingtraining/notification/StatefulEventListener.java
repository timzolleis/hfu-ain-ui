package swingtraining.notification;

import java.util.EventListener;

public interface StatefulEventListener extends EventListener {

    void handleChangedState(final Event event);
}
