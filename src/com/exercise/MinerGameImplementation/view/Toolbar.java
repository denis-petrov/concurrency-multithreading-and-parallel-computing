package com.exercise.MinerGameImplementation.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JButton startButton;
    private JButton stopButton;
    private ButtonListener listener;

    public Toolbar() {
        setLayout(new FlowLayout(FlowLayout.CENTER));

        initVariables();

        add(startButton);
        add(stopButton);
    }

    private void initVariables() {
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        startButton.addActionListener(this);
        stopButton.addActionListener(this);
    }

    public void setButtonListener(ButtonListener listener) {
        this.listener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (this.listener == null)
            return;
        if ((JButton) event.getSource() == startButton) {
            listener.startClicked();
        } else {
            this.listener.stopClicked();
        }
    }
}
