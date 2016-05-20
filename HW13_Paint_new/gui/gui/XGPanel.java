package gui;
import javax.swing.JPanel;

public class XGPanel extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XGPanel(XCommand cmd) 
	{
		setLayout(null);
		
		XColor cp = new XColor( cmd );
		XWidth wp = new XWidth( cmd );
		XFigure fp = new XFigure( cmd );
		XPanel xp = new XPanel( cmd );
		
		cp.setBounds(0, 0, 100, 160);
		wp.setBounds(0, 160, 100, 90);
		fp.setBounds(0, 250, 100, 160);
		xp.setBounds(100, 0, 560, 480);
		
		add(wp);
		add(cp);
		add(fp);
		add(xp);
		
	}
}
