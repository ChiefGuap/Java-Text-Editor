import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TextEditor extends JFrame implements ActionListener{
	
	JTextArea textArea;
	JScrollPane scrollPane;
	JLabel fontLabel; 
	JSpinner fontSizeSpinner; 
	JButton fontColorButton;
	JComboBox fontBox; 
	TextEditor(){
		// The page setup of how the page looks like in the Text Editor
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Java Text Editor");
		this.setSize(500, 500);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		// Some little slight adjustments to make the text editor a bit more cleaner 
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Arial",Font.PLAIN, 20));
		
		//ScrollPane so you can scroll up and down
		scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(450,450));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		// This is to give the user clarity that the button  aside them is to chnage the font size
		fontLabel = new JLabel("Font: "); 
		
		// To change the size of the font to any size that you want
		fontSizeSpinner = new JSpinner();
		fontSizeSpinner.setPreferredSize(new Dimension(50,25));
		fontSizeSpinner.setValue(20);
		fontSizeSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int) fontSizeSpinner.getValue()));
				
			}
			
		});
		
		// To change the color of the font to anything that you want 
		fontColorButton = new JButton("Color");
		fontColorButton.addActionListener(this); 
		
		//Letting the user choose whatever font they want to use
		
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		fontBox = new JComboBox(fonts); 
		fontBox.addActionListener(this);
		fontBox.setSelectedItem("Arial");
		
		
		this.add(fontLabel);  
		this.add(fontSizeSpinner);
		this.add(fontColorButton);
		this.add(fontBox);
		this.add(scrollPane);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==fontColorButton) {
			JColorChooser colorChooser = new JColorChooser();
			
			Color color = colorChooser.showDialog(null, "Choose a color", Color.black); 
			
			textArea.setForeground(color);
		}
		
		if(e.getSource()==fontBox) {
			textArea.setFont(new Font((String)fontBox.getSelectedItem(),Font.PLAIN,textArea.getFont().getSize()));
		}
		
	}

}
