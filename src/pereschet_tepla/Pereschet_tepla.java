package pereschet_tepla;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.math.*;

public class Pereschet_tepla {
        JFrame frame;
        JPanel panel;
        JLabel tpod;
        JLabel tobr;
        JLabel vpod;
        JLabel vobr;
        JTextField tf1;
        JTextField tf2;
        JTextField tf3;
        JTextField tf4;
        JTextField otvet;
        JButton raschet;
        JButton sbros;
        
   public static void main(String[] args) {
       new Pereschet_tepla().go();
    }
    
    
    public void go() {
        frame = new JFrame("Пересчет по Tх.в.");
        panel = new JPanel();
        
        tpod = new JLabel("T подающая");
        tobr = new JLabel ("T обратная");
        vpod = new JLabel ("Расход подающей");
        vobr = new JLabel ("Расход обратной");
        
        tf1 = new JTextField(10);
        tf2 = new JTextField(10);
        tf3 = new JTextField(10);
        tf4 = new JTextField(10);
        otvet = new JTextField(10);
        
        raschet = new JButton("Расчёт");
        sbros = new JButton("Сброс");
        
        raschet.addActionListener(new RaschetButtonListener());
        sbros.addActionListener(new sbrosButtonListener());
        
        panel.add(tpod);
        panel.add(tobr);
        panel.add(vpod);
        panel.add(vobr);
        panel.add(tf1);
        panel.add(tf2);
        panel.add(tf3);
        panel.add(tf4);
        panel.add(otvet);
        panel.add(sbros);
        panel.add(raschet);
        
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(500, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
}
    
   public class RaschetButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            String t1 = tf1.getText();
            String t2 = tf2.getText();
            String t3 = tf3.getText();
            String t4 = tf4.getText();
            
            double c1 = Double.parseDouble(t1);
            double c2 = Double.parseDouble(t2);
            double c3 = Double.parseDouble(t3);
            double c4 = Double.parseDouble(t4);
            
            double c5 = (((c1-15)*c3)/1000) - (((c2-15)*c4)/1000);
            double newDouble = new BigDecimal(c5).setScale(3, RoundingMode.UP).doubleValue();
            
            String t5 = Double.toString(newDouble);
            otvet.setText(t5);
            
        }
        
    }
    
    class sbrosButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            tf1.setText(null);
            tf2.setText(null);
            tf3.setText(null);
            tf4.setText(null);
            
        }
    }
}

