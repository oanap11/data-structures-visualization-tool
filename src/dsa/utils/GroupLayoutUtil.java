package dsa.utils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import java.util.Arrays;
import java.util.List;

public class GroupLayoutUtil {
    private static final int TEXTFIELD_WIDTH = 50;  

    public static GroupLayout createCustomLayout(JPanel panel, List<JComponent> components) {
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup().addContainerGap();
        for (JComponent component : components) {
            int preferredWidth = component instanceof JTextField ? TEXTFIELD_WIDTH : GroupLayout.DEFAULT_SIZE;
            hGroup.addComponent(component, GroupLayout.PREFERRED_SIZE, preferredWidth, GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        }
        hGroup.addContainerGap();
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(hGroup));

        GroupLayout.ParallelGroup vGroup = layout.createParallelGroup(Alignment.BASELINE);
        for (JComponent component : components) {
            vGroup.addComponent(component, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
        }
        layout.setVerticalGroup(layout.createSequentialGroup().addContainerGap().addGroup(vGroup).addContainerGap());

        return layout;
    }

    public static GroupLayout createCustomLayoutForArrayNorthPanel(
            JPanel panel, JTextField inputTextField, JButton pushButton, JButton popButton,
            JComponent separator1, JTextField sizeText, JButton sizeButton, JLabel sizeLabel,
            JComponent separator2, JButton resetButton) {

        return createCustomLayout(panel, Arrays.asList(
            inputTextField, pushButton, popButton, separator1, sizeText, sizeButton, sizeLabel, separator2, resetButton
        ));
    }

    public static GroupLayout createCustomLayoutForListNorthPanel(
            JPanel panel, JTextField inputTextField, JButton enqueueButton, JButton dequeueButton) {

        return createCustomLayout(panel, Arrays.asList(inputTextField, enqueueButton, dequeueButton));
    }

    public static GroupLayout createCustomLayoutForBSTNorthPanel(
            JPanel panel, JTextField insertText, JButton insertButton, JTextField delText, JButton delButton) {

        return createCustomLayout(panel, Arrays.asList(insertText, insertButton, delText, delButton));
    }

    public static GroupLayout createCustomLayoutForSinglyListNorthPanel(
            JPanel panel, JTextField addNodeField, JButton addButton, JTextField deleteNodeField, JButton deleteButton) {

        return createCustomLayout(panel, Arrays.asList(addNodeField, addButton, deleteNodeField, deleteButton));
    }
}
