package swingtraining;

import swingtraining.notification.EventSourceComponent;
import swingtraining.notification.StatefulEventListenerImpl;

import javax.swing.*;

public class StatefulNotification {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Stateful Notification Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);

            EventSourceComponent button = new EventSourceComponent("Click Me");
            button.addStatefulEventListener(new StatefulEventListenerImpl());

            frame.add(button);
            frame.setVisible(true);
        });
    }
}
