package com.sample;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import com.sample.BottleOfWineApp.Question;

import javax.swing.JScrollPane;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BottleOfWineUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea output;
	
	private PromptCallback callback;
	
	private List<Question> knowledge;
	
	private JFrame frame;

	public BottleOfWineUI(List<Question> k, PromptCallback cb) {
		super(new BorderLayout());
		callback = cb;
		knowledge = k;
		output = new JTextArea(1, 10);
		output.setEditable(false);
		JScrollPane outputPane = new JScrollPane(output, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(outputPane, BorderLayout.CENTER);
		setPreferredSize(new Dimension(640, 480));
		
		frame = new JFrame("How to choose bottle of wine DEMO");
		
		JButton button = new JButton("Choose bottle");
		button.setVerticalAlignment(AbstractButton.TOP);
		button.addMouseListener(new RunButtonHandler(frame));
		button.setActionCommand("run");
		add(button, BorderLayout.NORTH);
		
		callback.setOutput(output);
	}
	
	public void createAndShow() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setOpaque(true);
		frame.setContentPane(this);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private class RunButtonHandler extends MouseAdapter {
		private JFrame frame;
		public RunButtonHandler(JFrame f) { frame = f; }; 
		public void mouseReleased(MouseEvent e) {
			callback.run(frame, knowledge);
		}
	}
}
