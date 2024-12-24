package TypingGame;

import javax.swing.*;
import java.awt.*;

public class OptionsMenu extends JPanel {
    private final JFrame parentFrame;
    private final JPanel previousMenu;
    private static boolean isFullScreen = true;

    public OptionsMenu(JFrame frame, JPanel previousMenu) {
        this.parentFrame = frame;
        this.previousMenu = previousMenu;
        initializeOptionsMenu();
    }

    private void initializeOptionsMenu() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);

        JLabel titleLabel = new JLabel("Options");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JCheckBox fullscreenToggle = new JCheckBox("Fullscreen", isFullScreen);
        fullscreenToggle.setFont(new Font("Arial", Font.PLAIN, 24));
        fullscreenToggle.setBackground(Color.BLACK);
        fullscreenToggle.setForeground(Color.WHITE);
        fullscreenToggle.setFocusPainted(false);
        fullscreenToggle.setAlignmentX(Component.CENTER_ALIGNMENT);
        fullscreenToggle.addActionListener(e -> toggleFullScreen(fullscreenToggle.isSelected()));

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 24));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setBackground(Color.DARK_GRAY);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(200, 50));
        backButton.addActionListener(e -> goBack());

        add(Box.createVerticalGlue());
        add(titleLabel);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(fullscreenToggle);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(backButton);
        add(Box.createVerticalGlue());
    }

    private void toggleFullScreen(boolean enableFullscreen) {
        isFullScreen = enableFullscreen;
        parentFrame.dispose();
        parentFrame.setUndecorated(isFullScreen);
        if (isFullScreen) {
            parentFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        } else {
            parentFrame.setSize(1000, 800);
            parentFrame.setLocationRelativeTo(null);
        }
        parentFrame.setVisible(true);
    }

    private void goBack() {
        parentFrame.setContentPane(previousMenu);
        parentFrame.revalidate();
    }
}


