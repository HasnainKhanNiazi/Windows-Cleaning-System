import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	Timer tm;
    int x = 0;
    int time = 1000;
    String[] list = {"D:Users/11029356/workspace/NewDPS/pic2.png",
    				"D:Users/11029356/workspace/NewDPS/pic1.jpg",
    				"D:Users/11029356/workspace/NewDPS/pic13.jpg",
    		};
    JLabel label;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Home");
		frame.getContentPane().setBackground(Color.decode("#1a1a1a"));
		frame.getContentPane().setForeground(new Color(64, 224, 208));
		frame.setBounds(100, 100, 738, 494);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddUser = new JLabel("Add Customer");
		lblAddUser.setForeground(Color.WHITE);
		lblAddUser.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAddUser.setBounds(59, 67, 89, 14);
		frame.getContentPane().add(lblAddUser);
		
		JLabel lblUserInfo = new JLabel("Customer Info");
		lblUserInfo.setForeground(Color.WHITE);
		lblUserInfo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUserInfo.setBounds(282, 67, 103, 14);
		frame.getContentPane().add(lblUserInfo);
		
		JLabel lblModifyData = new JLabel("Modify Data");
		lblModifyData.setForeground(Color.WHITE);
		lblModifyData.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblModifyData.setBounds(511, 67, 80, 14);
		frame.getContentPane().add(lblModifyData);
		
		JButton button = new JButton("");
		button.setBackground(Color.decode("#1a1a1a"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Add_User();
			}
		});
		button.setBorder(null);
		button.setIcon(new ImageIcon("D:\\Users\\11029356\\workspace\\NewDPS\\Add User.png"));
		button.setBounds(64, 9, 74, 56);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new User_Info();
			}
		});
		button_1.setBorder(null);
		button_1.setBackground(Color.decode("#1a1a1a"));
		button_1.setIcon(new ImageIcon("D:\\Users\\11029356\\workspace\\NewDPS\\info-user.png"));
		button_1.setBounds(287, 9, 74, 58);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setBackground(Color.decode("#1a1a1a"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Modify_Data();
			}
		});
		button_2.setBorder(null);
		button_2.setIcon(new ImageIcon("D:\\Users\\11029356\\workspace\\NewDPS\\Modify User.png"));
		button_2.setBounds(511, 9, 74, 56);
		frame.getContentPane().add(button_2);
		
		label = new JLabel("");
		tm = new Timer(time, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setimages(x);
				x+=1;
				if(x>=list.length){
					x = 0;
				}
			}
		});
		label.setBounds(0, 95, 732, 370);
		frame.getContentPane().add(label);
		tm.start();
		frame.setVisible(true);
		
		
		
	}
	public void setimages(int j){	
		if(j==0){
			label.setIcon(new ImageIcon(new ImageIcon("pic1.jpg").getImage().getScaledInstance(800, 490, Image.SCALE_DEFAULT)));
			j++;
		}
		else if(j==1){
			label.setIcon(new ImageIcon(new ImageIcon("pic2.png").getImage().getScaledInstance(800, 490, Image.SCALE_DEFAULT)));
			j++;
		}
		else if(j==2){
			label.setIcon(new ImageIcon(new ImageIcon("pic3.jpg").getImage().getScaledInstance(800, 490, Image.SCALE_DEFAULT)));
			j=0;
		}
	}
}
