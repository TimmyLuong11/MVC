import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame1 extends JFrame
{
	private static final int Initial_Value = 1;
	private JTextField totalTextField;
	private JTextField inputTextField;
	private JButton clearButton;
	private JButton multiplyButton;
	private Font f32 = new Font("SanSarif", Font.BOLD, 32);
	private Integer total;
	private Model model;
	
	public MainFrame1() 
	{
		total = new Integer(Initial_Value);
		
		JPanel content = new JPanel();
		
		totalTextField = new JTextField(10);
		totalTextField.setFont(f32);
		JLabel input = new JLabel("Input");
		input.setFont(f32);
		content.add(input);
		inputTextField = new JTextField(10);
		inputTextField.setFont(f32);
		clearButton = new JButton("Clear");
		clearButton.setFont(f32);
		multiplyButton = new JButton("Mulitply");
		multiplyButton.setFont(f32);
		JLabel output = new JLabel("Output");
		output.setFont(f32);
		
		
		content.add(inputTextField);
		content.add(multiplyButton);
		content.add(output);
		content.add(totalTextField);
		content.add(clearButton);
		
		multiplyButton.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String inputStr = "";
				try {
					inputStr= inputTextField.getText();
					model.multiplyBy(inputStr);
					totalTextField.setText(model.getValue());
				}
				catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(MainFrame1.this, "Bad Human!?!");
				}
			}
		});
		
		clearButton.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				model.reset();
				totalTextField.setText(Initial_Value);
			}
		});
		
		add(content);
		setSize(new Dimension(500,500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
