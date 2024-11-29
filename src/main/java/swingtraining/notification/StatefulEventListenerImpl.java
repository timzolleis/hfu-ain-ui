package swingtraining.notification;

public class StatefulEventListenerImpl implements StatefulEventListener {
    @Override
    public void handleChangedState(Event event) {
        System.out.println("Event received from: " + event.getSource());
        System.out.println("Event received: " + event.getMessage());
    }
}
