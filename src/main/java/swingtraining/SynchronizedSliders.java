package swingtraining;

import javax.swing.*;
import java.awt.*;

public class SynchronizedSliders {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SynchronizedSliders::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Synchronized JScrollBar and JSlider");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        BoundedRangeModel model = new DefaultBoundedRangeModel(50, 0, 0, 100);

        JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
        scrollBar.setModel(model);

        JSlider slider = new JSlider(JSlider.HORIZONTAL);
        slider.setModel(model);

        frame.add(scrollBar);
        frame.add(slider);

        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}
