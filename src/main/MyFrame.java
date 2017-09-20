package main;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import button.CircleButton;
import button.LineButton;
import button.RectButton;
import button.TextButton;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {

	private JPanel contentPane;
	private LineButton btnLine;
	private RectButton btnRect;
	private CircleButton btnCircle;
	private TextButton btnText;
	private JButton btnDel;
	private JButton btnColor;
	private JPanel btnPanel;
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenuItem mOpen;
	private JMenuItem mSave;
	private JFileChooser chooser;
	private MyPanel drawPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
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
	public MyFrame() {
		setAlwaysOnTop(true);
		setResizable(false);
		setMinimumSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		mOpen = new JMenuItem("Open");
		mOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 打开文件
				openFile();
			}
		});
		menuFile.add(mOpen);
		
		mSave = new JMenuItem("Save");
		mSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 保存文件
				saveFile();
			}
		});
		
		menuFile.add(mSave);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnPanel = new JPanel();
		
		drawPanel = new MyPanel();
		GroupLayout gl = new GroupLayout(contentPane);
		gl.setHorizontalGroup(
			gl.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl.createSequentialGroup()
					.addComponent(drawPanel, GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPanel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
		);
		gl.setVerticalGroup(
			gl.createParallelGroup(Alignment.TRAILING)
				.addComponent(btnPanel, GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
				.addComponent(drawPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
		);
		btnPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnLine = new LineButton("线条");
		btnLine.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				drawPanel.setInterface(btnLine);
			}
		});
		btnPanel.add(btnLine);
		
		btnRect = new RectButton("矩形");
		btnRect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				drawPanel.setInterface(btnRect);
			}
		});
		btnPanel.add(btnRect);
		
		btnCircle = new CircleButton("圆形");
		btnCircle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				drawPanel.setInterface(btnCircle);
			}
		});
		btnPanel.add(btnCircle);
		
		btnText = new TextButton("文本");
		btnText.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				drawPanel.setInterface(btnText);
			}
		});
		btnPanel.add(btnText);
		
		btnDel = new JButton("删除");
		btnPanel.add(btnDel);
		
		btnColor = new JButton("颜色");
		btnPanel.add(btnColor);
		contentPane.setLayout(gl);
		
		 chooser = new JFileChooser();
	}

	// 保存文件
	protected void saveFile() {
		
		int value = chooser.showSaveDialog(MyFrame.this);
		if(value == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile().getAbsoluteFile();
			makeFile(file);
		}
	}

	// 创建文件，并写入特定内容，使得下次打开时可以进行解析，并显示
	private void makeFile(File file) {
		try {
			file.createNewFile();
			System.out.println(file.getAbsolutePath());

			// writeData
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 打开文件
	protected void openFile() {
		int value = chooser.showOpenDialog(MyFrame.this);
		if(value == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			loadFile(file);
		}
	}

	// 加载选中的文件 -- 将内容显示出来，并可以继续编辑
	private void loadFile(File file) {
		System.out.println("打开文件："+file.getAbsolutePath());
	}

}
