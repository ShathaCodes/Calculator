import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; 
import javax.swing.border.*;

/*
 * <applet code="Calculator" width=400 height=500> </applet>
 */

public class Calculator extends Applet {
	
    JLabel l; 
	JPanel p1,p2,p3;
	double result;
    JButton [] bn;
	JButton b1,b2,bb1,bb2,bb3,bb4,bb5;
	boolean cl=false,op=false;
	String s="",s1="",s2="";
	double ss1=0,ss2=0;
	
	public void init() {
		
    setLayout(new BorderLayout());

    p1 = new JPanel();
    p2 = new JPanel();
	p2.setPreferredSize(new Dimension(100, 300));
	p2.setBorder(new EmptyBorder(5, 5, 5, 5) );
    p2.setLayout(new GridLayout(5,5,4,3));
    p3 = new JPanel();
	p3.setPreferredSize(new Dimension(100, 300));
	p3.setBorder(new EmptyBorder(5, 5, 5, 5) );
    p3.setLayout(new GridLayout(6,6,5,1));
	
	l = new JLabel("0.0");
	l.setPreferredSize(new Dimension(390, 40));
	l.setBorder( new EtchedBorder() );
	
	bn= new JButton[10];
	for(int i=0;i<10;i++)
		bn[i] = new JButton(""+i);
	b1= new JButton(".");
	b2= new JButton("=");
	bb1= new JButton("C");
	bb2= new JButton("+");
	bb3= new JButton("-");
	bb4= new JButton("*");
	bb5= new JButton("/");
	
	bb1.setForeground(Color.red);

	p1.add(l);
	for(int i=1;i<10;i++)
		p2.add(bn[i]);
	p2.add(bn[0]);
	p2.add(b1);
	p2.add(b2);
	p3.add(bb1);
	p3.add(bb2);
	p3.add(bb3);
	p3.add(bb4);
	p3.add(bb5);
	MyActionListener ma = new MyActionListener();
	for(int i=0;i<10;i++)
		bn[i].addActionListener(ma);
	b1.addActionListener(ma);
	b2.addActionListener(ma);
	bb1.addActionListener(ma);
	bb2.addActionListener(ma);
	bb3.addActionListener(ma);
	bb4.addActionListener(ma);
	bb5.addActionListener(ma);
    add(p1, BorderLayout.NORTH);
    add(p2, BorderLayout.CENTER);
    add(p3, BorderLayout.EAST);

	}
	class MyActionListener implements ActionListener
	{
		public void calcul()
		{
			if(!s1.equals(""))
		    ss1= Double.parseDouble(s1);
			if(!s2.equals(""))
		    ss2= Double.parseDouble(s2);
		    if(s.equals("+"))result=ss1+ss2;
		    if(s.equals("-"))result=ss1-ss2;
			if(s.equals("*"))result=ss1*ss2;
		    if(s.equals("/"))
			{
				if(ss2 != (0)) result=ss1/ss2;
			    else { l.setText("You can not devise by zero!"); clear(); return;}
			}
			l.setText(""+result);
		    op=false;
		    s2="";
			s1=""+result;
		}
		public void clear(){
				result=0;
				s1=s2=s="";
				ss1=ss2=0;
				op=false;
			
		}
	    public void actionPerformed(ActionEvent e)
	    {
			 
	     	Object event=e.getSource();
			
		    for(int i=0;i<10;i++)
		        if(bn[i].equals(event) ){
			        if( op==true) {s2 += "" +i ;l.setText(s2);}
			        else {s1+= ""+i; l.setText(s1);}
		        }
		    if(event.equals(bb2)){
				if(op==true) calcul();
			    op=true;
			    s="+";	
		    }
		    if(event.equals(bb3)){
				if(op==true) calcul();
			    op=true;
			    s="-"	;
		    }
		    if(event.equals(bb4)){
				if(op==true) calcul();
			    op=true;
			    s="*"	;
		    }
		    if(event.equals(bb5)){
				if(op==true) calcul();
			    op=true;
			    s="/"	;
		    }
		    if(event.equals(bb1)){
				clear();
				l.setText(""+result);
		    }
		    if(event.equals(b1)){
			    if (op==false) s1 += ".";
			    else s2+= ".";
		    }
	      	if(event.equals(b2)){
			    calcul();
		    }
	    }
	}
}









