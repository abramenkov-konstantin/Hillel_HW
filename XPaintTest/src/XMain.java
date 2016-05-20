import com.borland.silktest.jtf.Desktop;
import org.junit.Before;
import com.borland.silktest.jtf.BaseState;
import org.junit.Test;
import com.microfocus.silktest.jtf.swing.JPanel;
import com.borland.silktest.jtf.common.types.MouseButton;
import com.borland.silktest.jtf.common.types.Point;
import com.microfocus.silktest.jtf.swing.JButton;
import com.microfocus.silktest.jtf.swing.JComboBox;
import com.microfocus.silktest.jtf.swing.JMenuItem;
import com.microfocus.silktest.jtf.swing.JHorizontalScrollBar;
import com.microfocus.silktest.jtf.swing.JList;
import com.microfocus.silktest.jtf.swing.JTextField;

public class XMain {

	private Desktop desktop = new Desktop();

	@Before
	public void baseState() {
		BaseState baseState = new BaseState();
		baseState.execute(desktop);

		//start recording 
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(47, 25));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(356, 126));
		desktop.<JButton> find("My First App.Red").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(77, 70));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(217, 166));
		desktop.<JMenuItem> find("My First App.Line MenuItem").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(36, 68));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(343, 276));
		desktop.<JComboBox> find("My First App.Width").select("5");
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(101, 124));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(299, 285));
		desktop.<JButton> find("My First App.Oval").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(183, 83));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(392, 184));
		desktop.<JButton> find("My First App.Blue").select();
		desktop.<JButton> find("My First App.Line").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(224, 38));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(380, 201));
		desktop.<JButton> find("My First App.RRectangle").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(180, 146));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(359, 339));
		desktop.<JComboBox> find("My First App.Width").select("15");
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(57, 91));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(212, 237));
		desktop.<JMenuItem> find("My First App.Oval MenuItem").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(289, 35));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(431, 154));
		desktop.<JMenuItem> find("My First App.About").select();
		desktop.<JMenuItem> find("My First App.About").select();
		desktop.<JButton> find("Message.OK").select();
		desktop.<JMenuItem> find("My First App.3").select();
		desktop.<JPanel> find("My First App.XPanel").click(MouseButton.LEFT, new Point(129, 10));
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(120, 22));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(208, 82));
		desktop.<JMenuItem> find("My First App.Open").select();
		desktop.<JButton> find("Open.Button").select();
		desktop.<JHorizontalScrollBar> find("Open.HorizontalScrollBar").scrollTo(100);
		desktop.<JButton> find("Open.Button").select();
		desktop.<JButton> find("Open.Button").select();
		desktop.<JButton> find("Open.Button").select();
		desktop.<JButton> find("Open.Button").select();
		desktop.<JHorizontalScrollBar> find("Open.HorizontalScrollBar").scrollTo(1757);
		desktop.<JList> find("Open.FilePane$4").clickItem("image002.jpg", MouseButton.LEFT, new Point(108, 5));
		desktop.<JButton> find("Open.Open").select();
		desktop.<JButton> find("Open.Cancel").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(66, 96));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(179, 131));
		desktop.<JButton> find("My First App.Green").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(101, 39));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(236, 98));
		desktop.<JButton> find("My First App.Red").select();
		desktop.<JButton> find("My First App.Black").select();
		desktop.<JButton> find("My First App.Blue").select();
		desktop.<JButton> find("My First App.Green").select();
		desktop.<JButton> find("My First App.Red").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(198, 14));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(307, 50));
		desktop.<JMenuItem> find("My First App.Save").select();
		desktop.<JTextField> find("Save.File Name").typeKeys("111.jpg");
		desktop.<JButton> find("Save.Save").select();
		//end recording
	}

	@Test
	public void main() {
		desktop.<JPanel> find("My First App.XPanel").click(MouseButton.LEFT, new Point(33, 31));
		desktop.<JButton> find("My First App.Black").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(13, 14));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(412, 156));
		desktop.<JButton> find("My First App.Red").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(118, 61));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(387, 162));
		desktop.<JButton> find("My First App.Green").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(53, 126));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(395, 175));
		desktop.<JButton> find("My First App.Blue").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(196, 192));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(387, 234));
		desktop.<JButton> find("My First App.Other").select();
		desktop.<JPanel> find("My Line Color.MainSwatchPanel").click(MouseButton.LEFT, new Point(182, 46));
		desktop.<JPanel> find("My Line Color.MainSwatchPanel").click(MouseButton.LEFT, new Point(231, 44));
		desktop.<JButton> find("My Line Color.OK").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(149, 217));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(371, 145));
		desktop.<JComboBox> find("My First App.Width").select("4");
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(78, 139));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(295, 147));
		desktop.<JButton> find("My First App.Rectangle").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(117, 60));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(305, 255));
		desktop.<JButton> find("My First App.Oval").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(52, 145));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(182, 291));
		desktop.<JButton> find("My First App.Line").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(241, 143));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(376, 281));
		desktop.<JButton> find("My First App.RRectangle").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(344, 56));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(451, 166));
		desktop.<JButton> find("My First App.Paint").select();
		desktop.<JButton> find("My First App.Blue").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(86, 60));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(375, 78));
		desktop.<JMenuItem> find("My First App.Line MenuItem").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(215, 14));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(319, 112));
		desktop.<JMenuItem> find("My First App.Oval MenuItem").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(20, 83));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(66, 198));
		desktop.<JMenuItem> find("My First App.15").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(113, 36));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(276, 156));
		desktop.<JMenuItem> find("My First App.Green MenuItem").select();
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(287, 127));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(435, 245));
		desktop.<JPanel> find("My First App.XPanel").pressMouse(MouseButton.LEFT, new Point(258, 283));
		desktop.<JPanel> find("My First App.XPanel").releaseMouse(MouseButton.LEFT, new Point(385, 369));
		desktop.<JMenuItem> find("My First App.About").select();
		desktop.<JMenuItem> find("My First App.About").select();
		desktop.<JButton> find("Message.OK").select();
	}

}