package Window;
/**
 * 显示日志信息
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.*;

import GetDatabaseData.Getdata;
import JdbcConnector.DBOperation;
import JdbcConnector.MyDBConnection;
import Window.MyButton;
//import sun.jvm.hotspot.ui.action.ShowAction;
import Window.testJComboBox;
import Window.testJComboBox.RwJComboBox;
import logSeparation.Head;
import logSeparation.updata_Log;
//import sun.jvm.hotspot.ui.action.ShowAction;
public class Window5 implements MouseListener {
	private JLabel label1=new JLabel("日志信息");//用户选择的数据表
	public  JFrame frame = new JFrame("Show Log");//展示日志信息
	private MyButton btn1=new MyButton("重新查询");
	private MyButton btn2=new MyButton("退出");
	JPanel  panel = new JPanel();		// 新建按钮组件面板
	JTable table1;		// 显示数据表的表格
	JScrollPane jscrollpane1 = new JScrollPane();//产生滚轮的对象，在数据表显示的时候应用
	private int distinguish;//用来记录鼠标悬停在哪个位置
	private Connection conn=null;//与特定的数据库连接，上下文用sql语句执行
	private Statement stmt=null;
	MyDBConnection myDB=new MyDBConnection();
	public DBOperation myOpr=new DBOperation(myDB);
	updata_Log log = new updata_Log();
	public Window5(MyDBConnection myDB) {
		conn=myDB.getMyConnection();//取得对象
		stmt=myDB.getMyStatement();//取得sql语句
	}
	Getdata dGetdata=new Getdata(myDB);
	String[] result_tuple = Window6.keys.split(",");
	
	
	Head head = new Head();
	Vector<String> getHead = head.head();  //获取表头
	
	public Window5() {
		// TODO Auto-generated constructor stub
	}
	
	public void show() {
		
		frame.setLayout(null);//定义空布局
		frame.setSize(600,600);///
		frame.setLocation(400, 200);
		
		Font font=new Font("DotumChe",Font.BOLD,12);//Font用于设计字体样式
		Font font1=new Font("DotumChe",Font.BOLD,20);
		label1.setFont(font1);
		label1.setForeground(Color.black);//设置字体颜色
		
		btn1.setContentAreaFilled(false);//设置button组件透明
		btn1.setFont(font);
	    btn1.setForeground(Color.black);
	    btn1.setBorder(BorderFactory.createRaisedBevelBorder());//设置突出button组件
	    btn2.setContentAreaFilled(false);
		btn2.setFont(font);
		btn2.setBorder(BorderFactory.createRaisedBevelBorder());
	    btn2.setForeground(Color.black);
	    
	    JPanel bj = new JPanel() {//设置背景
			protected void paintComponent(Graphics g) {
				Image bg;
				try {
					bg = ImageIO.read(new File("src/image/开始背景5.PNG"));
					g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		//把数据表和属性列加进来
		Vector<Vector<String>> rowdata = log.Read_Log(dGetdata.getuserName(Window6.text3), Window6.text3, result_tuple[0]); //获取日志的数据表
		table1 = new JTable(rowdata,this.getHead);	
		
		jscrollpane1.setBounds(90, 90, 400, 400);//表格位置
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jscrollpane1.setViewportView(table1);
		
		label1.setBounds(260,0,200,100);
		
		btn1.setBounds(120,500,125,40);
		btn2.setBounds(300,500,125,40);
		
		frame.setContentPane(bj);
    	frame.setLayout(null);
		frame.add(label1);
		frame.add(btn1);
		frame.add(btn2);
		frame.add(jscrollpane1);
		
		btn1.addMouseListener(this);//添加鼠标监听
		btn2.addMouseListener(this);
		
		frame.setVisible(true);
	}
	public void show1() {
		frame.setLayout(null);//定义空布局
		frame.setSize(600,600);///
		frame.setLocation(400, 200);
		
		Font font=new Font("DotumChe",Font.BOLD,12);//Font用于设计字体样式
		Font font1=new Font("DotumChe",Font.BOLD,20);
		label1.setFont(font1);
		label1.setForeground(Color.black);//设置字体颜色
		
		btn1.setContentAreaFilled(false);//设置button组件透明
		btn1.setFont(font);
	    btn1.setForeground(Color.black);
	    btn1.setBorder(BorderFactory.createRaisedBevelBorder());//设置突出button组件
	    btn2.setContentAreaFilled(false);
		btn2.setFont(font);
		btn2.setBorder(BorderFactory.createRaisedBevelBorder());
	    btn2.setForeground(Color.black);
	    
	    JPanel bj = new JPanel() {//设置背景
			protected void paintComponent(Graphics g) {
				Image bg;
				try {
					bg = ImageIO.read(new File("src/image/开始背景5.PNG"));
					g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		//把数据表和属性列加进来
		Vector<Vector<String>> rowCurrentdata = log.Read_Log(dGetdata.getuserName(Window2.sheetname), Window2.sheetname, result_tuple[0]); //获取日志的数据表
		table1 = new JTable(rowCurrentdata,this.getHead);	
		
		jscrollpane1.setBounds(90, 90, 400, 400);//表格位置
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jscrollpane1.setViewportView(table1);
		
		label1.setBounds(260,0,200,100);
		
		btn1.setBounds(120,500,125,40);
		btn2.setBounds(300,500,125,40);
		
		frame.setContentPane(bj);
    	frame.setLayout(null);
		frame.add(label1);
		frame.add(btn1);
		frame.add(btn2);
		frame.add(jscrollpane1);
		
		btn1.addMouseListener(this);//添加鼠标监听
		btn2.addMouseListener(this);
		
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// 鼠标点击时要执行的方法
		if(distinguish==1){	   
			show();
			frame.setVisible(false);
			//展示下一个界面
			Window6 window6=new Window6();
			window6.show();
		}
		if(distinguish==2){
			int n = JOptionPane.showConfirmDialog(null, "Exit?", "End",JOptionPane.YES_NO_OPTION);
			myDB.closeMyConnection();
			if(n==JOptionPane.YES_OPTION){
			System.exit(1);
			}   
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == btn1) {
			distinguish=1;//鼠标悬停在btn1处则把distinguish置1
			btn1.setForeground(Color.red);//改变颜色
			btn1.setBorder(BorderFactory.createLoweredBevelBorder());//组件凹陷
			btn2.setForeground(Color.black);
			btn2.setBorder(BorderFactory.createRaisedBevelBorder());
		}
		if (arg0.getSource() == btn2) {
			distinguish=2;//鼠标悬停在btn1处则把distinguish置2
			btn1.setForeground(Color.black);
			btn1.setBorder(BorderFactory.createRaisedBevelBorder());
			btn2.setForeground(Color.red);
			btn2.setBorder(BorderFactory.createLoweredBevelBorder());
			}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		distinguish=0;
		label1.setForeground(Color.black);
		btn1.setContentAreaFilled(false);
	    btn1.setForeground(Color.black);
	    btn1.setBorder(BorderFactory.createRaisedBevelBorder());
	    btn2.setContentAreaFilled(false);
		btn2.setBorder(BorderFactory.createRaisedBevelBorder());
	    btn2.setForeground(Color.black);
	}
	
//	public static void main(String[] args) {
//		Window5 window5=new Window5();
//		window5.show();
//		}

}
