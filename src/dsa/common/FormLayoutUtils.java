package dsa.common;

import java.awt.Container;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FormLayoutUtils {
    public static GroupLayout setupLoginPanelLayout(JPanel mainPanel, JLabel userLabel, JTextField userTextField,
                                            JLabel passLabel, JPasswordField passField, JButton loginButton,
                                            JButton registerButton, JLabel loginLabel) {
        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);

        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(107, 107, 107)
                    .addGroup(mainPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(passLabel)
                        .addComponent(userLabel)
                        .addGroup(mainPanelLayout.createParallelGroup(Alignment.TRAILING, false)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addGroup(mainPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                    .addComponent(userTextField)
                                    .addComponent(passField, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)))))
                    .addContainerGap(95, Short.MAX_VALUE))
                .addGroup(Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginLabel, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
                    .addGap(161, 161, 161))
        );

        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addComponent(loginLabel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(userLabel)
                        .addComponent(userTextField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addGap(28, 28, 28)
                    .addGroup(mainPanelLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(passLabel)
                        .addComponent(passField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addGap(51, 51, 51)
                    .addGroup(mainPanelLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addGap(73, 73, 73))
        );
        
        return mainPanelLayout;
    }
    
    public static GroupLayout setupRegisterPanelLayout(JPanel mainPanel, JButton registerButton, JButton resetButton,
    		JLabel userLabel, JLabel passLabel, JLabel emailLabel, JTextField emailTextField,
    		JPasswordField passField, JTextField userTextField, JButton backButton, JLabel logo) {
    	GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(passLabel)
                            .addComponent(userLabel, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailLabel))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                            .addComponent(userTextField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))))
                .addGap(135, 135, 135))
            .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo)
                .addGap(222, 222, 222))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(logo))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(backButton)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(userTextField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel))
                .addGap(39, 39, 39)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(passLabel)
                    .addComponent(passField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                .addGap(115, 115, 115))
        );
        
        return mainPanelLayout;
    }
    
    public static void setCommonLayout(JPanel mainPanel, Container contentPane) {

        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(mainPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
    }

}

