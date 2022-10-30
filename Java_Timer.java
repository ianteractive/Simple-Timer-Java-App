import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Java_Timer extends JFrame {

	private JPanel contentPane;
	//variables declaration here
	Timer tm;
	int timer_seconds = 0;
	int timer_minutes = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Java_Timer frame = new Java_Timer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Java_Timer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//tm.start method call here
				tm.start();
			}
		});
		btnStart.setBounds(47, 164, 89, 23);
		contentPane.add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//tm.stop method call here
				tm.stop();
			}
		});
		btnStop.setBounds(179, 164, 89, 23);
		contentPane.add(btnStop);
		
		JLabel timer_label = new JLabel("00");
		timer_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		timer_label.setHorizontalAlignment(SwingConstants.CENTER);
		timer_label.setBounds(162, 45, 46, 14);
		contentPane.add(timer_label);
		
		JLabel label_min = new JLabel("00");
		label_min.setHorizontalAlignment(SwingConstants.CENTER);
		label_min.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_min.setBounds(106, 45, 46, 14);
		contentPane.add(label_min);
		
		JLabel lblNewLabel = new JLabel(":");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(147, 45, 21, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer_seconds = 0;
				timer_minutes = 0;
				JOptionPane.showMessageDialog(null, "Timer has been reset!");
				tm.stop();
			}
		});
		btnReset.setBounds(179, 211, 89, 23);
		contentPane.add(btnReset);
		
		tm = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//format 00:00 timer
				String formattedStr1 = String.format("%02d", timer_seconds);
				timer_label.setText(formattedStr1);
				timer_seconds++;
				//60 seconds
				if(timer_seconds==60) {
					timer_minutes++;
					String formattedStr = String.format("%02d", timer_minutes);
					label_min.setText(formattedStr);
					timer_seconds = 1;
				}
				//stop when the timer is 25 minutes
				if(timer_minutes==25) {
					tm.stop();
					java.awt.Toolkit.getDefaultToolkit().beep();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException y) {
						
					}
					JOptionPane.showMessageDialog(null, "Time's up!");
				}
				
			}
		});
	}
}
