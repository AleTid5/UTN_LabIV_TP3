package Ejercicio3.App.Elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

@SuppressWarnings("serial")
public class Alert extends JFrame {
	public Alert(String title, String body) {
		getContentPane().setBackground(Color.WHITE);
		setSize(400, 200);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setUndecorated(true);
		getContentPane().setLayout(null);

		JTextPane txtTitle = new JTextPane();
		txtTitle.setFont(new Font("Dialog", Font.BOLD, 12));
		txtTitle.setForeground(Color.WHITE);
		txtTitle.setText(title);
		txtTitle.setEditable(false);
		txtTitle.setBackground(new Color(60, 179, 113));
		txtTitle.setBounds(0, 0, 400, 26);		
		StyledDocument doc = txtTitle.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		getContentPane().add(txtTitle);

		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(this.close(this));
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setBackground(new Color(60, 179, 113));
		btnAceptar.setBounds(162, 163, 95, 25);
		getContentPane().add(btnAceptar);

		JEditorPane txtBody = new JEditorPane();
		txtBody.setEditable(false);
		txtBody.setBounds(12, 69, 376, 57);
		getContentPane().add(txtBody);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		txtBody.setText(body);
		this.setVisible(true);
	}

	public ActionListener close(JFrame alert) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alert.setVisible(false);
			}
		};
	}
}
