import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class URLprompt extends JFrame {
	private JButton OKButton;
	private JLabel Warning, empty1, empty2;
	private JPanel panel, buttonpanel;

	public URLprompt() {
		panel = new JPanel(new GridLayout(2, 1));
		buttonpanel = new JPanel(new GridLayout(1, 3));
		Warning = new JLabel("                       WARNING:Invalid URL!");
		OKButton = new JButton("OK!");
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		empty1 = new JLabel();
		empty2 = new JLabel();
		panel.add(Warning);
		buttonpanel.add(empty1);
		buttonpanel.add(OKButton);
		buttonpanel.add(empty2);
		add(panel, BorderLayout.NORTH);
		add(buttonpanel, BorderLayout.CENTER);

		setSize(450, 90);
		setVisible(true);
	}
}