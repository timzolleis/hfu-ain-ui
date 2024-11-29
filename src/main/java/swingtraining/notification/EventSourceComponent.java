package swingtraining.notification;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EventSourceComponent extends JButton {
    private final List<StatefulEventListener> listeners = new ArrayList<>();
    private int clickCount = 0;

    public EventSourceComponent(String text) {
        super(text);
        addActionListener(e -> {
            clickCount++;
            Event event = new Event(this, "Button clicked" + clickCount + " times");
            fireEvent(event);
        });
    }


    public void addStatefulEventListener(StatefulEventListener listener) {
        listeners.add(listener);
    }

    public void removeStatefulEventListener(StatefulEventListener listener) {
        listeners.remove(listener);
    }

    protected void fireEvent(Event event) {
        for (StatefulEventListener listener : listeners) {
            listener.handleChangedState(event);
        }
    }


}
