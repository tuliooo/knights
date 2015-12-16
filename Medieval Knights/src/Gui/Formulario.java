package Gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import Dominio.Raza;

public class Formulario extends JComboBox<String>  implements ItemListener{
    private JComboBox<String> combo1;
    public Formulario() {
        combo1=new JComboBox<String>();
        combo1.setBounds(10,10,80,20);
       
        combo1.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent arg0) {
        if (arg0.getSource()==combo1) {
        	
            String seleccionado=(String)combo1.getSelectedItem();
            System.out.println(seleccionado);
        }
    }
  

	    
}