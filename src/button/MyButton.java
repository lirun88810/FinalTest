package button;
import javax.swing.JButton;

import item.Type;
import main.MyInterface;

/**
 * 
 * @author lirun
 *
 */
@SuppressWarnings("serial")
public abstract class MyButton extends JButton implements MyInterface{
	
	public MyButton() {
		super();
	}
	
	public MyButton(String text) {
		super(text);
	}
	
}
