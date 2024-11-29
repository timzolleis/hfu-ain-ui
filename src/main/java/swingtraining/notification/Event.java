package swingtraining.notification;

import lombok.Getter;

import java.util.EventObject;

public class Event extends EventObject {
    @Getter
    private final String message;

    public Event(final Object source, final String message) {
        super(source);
        this.message = message;
    }
}
