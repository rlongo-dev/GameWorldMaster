package views;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;

import model.TableData;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
	private JPanel contentPane;
	private JButton btnLoadTable;
	private JScrollPane scpTableList;
	private JList<String> lstTables;
	private JPanel tabMain;
	private JPanel tabData;
	private JPanel tabStoryLine;
	private JTabbedPane tabbedPane;
	private JTextField textField;
	private JTable tblDataTable;
	private JScrollPane scpDataTable;
	private ATableModel tabModel;

	/**
	 * Launch the application.
	*/ 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		initComponents();
		createEvents();
	}

	////////////////////////////
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		tabMain = new JPanel();
		tabbedPane.addTab("Main", null, tabMain, null);
		
		tabData = new JPanel();
		tabbedPane.addTab("Database", null, tabData, null);
		tabData.setLayout(null);
		
		JLabel lblTables = new JLabel("Tables");
		lblTables.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTables.setHorizontalAlignment(SwingConstants.CENTER);
		lblTables.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTables.setBounds(78, 35, 72, 24);
		tabData.add(lblTables);
		
		scpTableList = new JScrollPane();
		scpTableList.setBounds(43, 66, 148, 127);
		tabData.add(scpTableList);
		//Initializing array of strings for table names in another class to keep this clean
		TableData TableNames = new TableData();
		String [] strArray = TableNames.getDbTables();

		lstTables = new JList<String>(strArray);
		scpTableList.setViewportView(lstTables);
		//scrollPane.setColumnHeaderView(lstTables);
		lstTables.setLayoutOrientation(JList.VERTICAL);
		
		btnLoadTable = new JButton("Load Tables");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		btnLoadTable.setBounds(64, 206, 107, 24);
		tabData.add(btnLoadTable);
		
		textField = new JTextField();
		textField.setBounds(43, 248, 223, 24);
		tabData.add(textField);
		textField.setColumns(10);

		scpDataTable = new JScrollPane();
		scpDataTable.setBounds(342, 35, 592, 347);
		tabData.add(scpDataTable);
		tabModel = new ATableModel();
		tblDataTable = new JTable(tabModel);
		scpDataTable.setViewportView(tblDataTable);
		
		tabStoryLine = new JPanel();
		tabbedPane.addTab("StoryLine", null, tabStoryLine, null);
		
	}
	
	private void createEvents() {
		btnLoadTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MessageBox.infoBox("Load Tables button clicked", "Table Button Clicked");
			}
		});
		
	}
	
	
	public class ATableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private ArrayList<String> strColNames;
		private Object[][] objArray;
		
		public ATableModel() {
			strColNames = new ArrayList<String>();
			strColNames.add("Foo1");
			strColNames.add("Foo2");
			Object[][] objArray = new Object [2][2];
			objArray[0][0] = 1;
			objArray[0][1] = "FooNess";
			objArray[1][0] = 2;
			objArray[1][1] = "FooNasty";
		}
		
		public ATableModel(Object[][] objArray, ArrayList<String> strColNames) {
			this.objArray = objArray;
			this.strColNames = strColNames;
		}
		
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return strColNames.size();
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			//return objArray.length;
			return 2;
		}

		@Override
		public Object getValueAt(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return objArray[arg0][arg1];
		}

	}
	
}
