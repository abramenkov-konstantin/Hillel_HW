package view;
import javax.swing.JPanel;

public class XPanel extends JPanel
{
	private static final long serialVersionUID = -8564103764114908270L;

	public XPanel() 
	{	
		setLayout(null);		
		setBounds(0,0,500,600);
			
		FunctionalPanel fp = new FunctionalPanel(this);
		
		add(fp);
	}
}