import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  

class OnlineExamSystem extends JFrame implements ActionListener  
{   
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    OnlineExamSystem(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);
	jb[0].addActionListener(this);
	jb[1].addActionListener(this);
	jb[2].addActionListener(this);
	jb[3].addActionListener(this);  
        add(b1);
	add(b2);
	add(jb[0]);
	add(jb[1]);
	add(jb[2]);
	add(jb[3]);  
        set();  
        l.setBounds(30,40,600,20); 
        jb[0].setBounds(50,80,200,20);  
        jb[1].setBounds(50,110,200,20);  
        jb[2].setBounds(50,140,200,20);  
        jb[3].setBounds(50,170,200,20);  
        b1.setBounds(100,240,150,30);  
        b2.setBounds(270,240,150,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,150);  
        setVisible(true);  
        setSize(800,350);  
    }  

    public void actionPerformed(ActionEvent e)  
    {  
	if(jb[0].isSelected() || jb[1].isSelected() || jb[2].isSelected() || jb[3].isSelected())
       	 b1.setEnabled(true);

        if(e.getSource()==b1)  
        {  
            if(check())  
                {count=count+1;}  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(600,20+30*x,150,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  

        for(int i=0,y=1;i<x;i++,y++)  
        {  
            if(e.getActionCommand().equals("Bookmark"+y))  
            {  
                if(check())  
                    count=count+1;  
                now=current;  
                current=m[y];  
                set();  
                ((JButton)e.getSource()).setEnabled(false);  
                current=now-1;   
            }  
        }  

        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;    
            JOptionPane.showMessageDialog(this,"correct answers="+count);
	    JOptionPane.showMessageDialog(this,"Project created by Mukund, Pratik, Jaswant & Yash");  
            System.exit(0);  
        }  
    }  

    void set()  
    {   b1.setEnabled(false); 
        jb[4].setSelected(true);
	
        if(current==0)  
        {  
            l.setText("Que1: Which keyword is not a part of exception handling");  
            jb[0].setText("try");jb[1].setText("finally");jb[2].setText("thrown");jb[3].setText("catch");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: Java source code is compiled into");  
            jb[0].setText("source code");jb[1].setText(".obj");jb[2].setText(".exe");jb[3].setText("Bytecode+");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: Which package is directly available to our class without importing it?");  
            jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("net");jb[3].setText("lang");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: Object is a ____ of a class.");  
            jb[0].setText("variable");jb[1].setText("instance");jb[2].setText("wrapper");jb[3].setText("none of these");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: Method of Interface is  ____.");  
            jb[0].setText("abstract");jb[1].setText("static");jb[2].setText("public");jb[3].setText("private");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: Which one among these is not a keyword?");  
            jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: Which keyword must be used to inherit a class? ");  
            jb[0].setText("super");jb[1].setText("this");jb[2].setText("extent");  
            jb[3].setText("extends");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: Which keyword is used by method to refer to the object that invoked it?");  
            jb[0].setText("import");jb[1].setText("catch");jb[2].setText("abstract");  
            jb[3].setText("this");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: which function is not present in Applet class?");  
            jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("destroy");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: Which of the following is a method having same name as that of class?");  
            jb[0].setText("finalize");jb[1].setText("delete");jb[2].setText("constructor");jb[3].setText("class");  
        }
	
       l.setBounds(30,40,600,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  

    boolean check()  
    {  
        if(current==0)  
            return(jb[2].isSelected());  
        if(current==1)  
            return(jb[3].isSelected());  
        if(current==2)  
            return(jb[3].isSelected());  
        if(current==3)  
            return(jb[1].isSelected());  
        if(current==4)  
            return(jb[0].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[3].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    }  

    public static void main(String s[])  
    {  
        new OnlineExamSystem("Online Test Of Java");  
    }  
}  
