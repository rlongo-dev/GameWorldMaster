package views;
import javax.swing.JOptionPane;

//Quick and dirty class to throw a Dialog Box up anywhere in the code
public class MessageBox {

	
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
}
