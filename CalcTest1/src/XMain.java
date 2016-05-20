import com.borland.silktest.jtf.Desktop;
import org.junit.Before;
import com.borland.silktest.jtf.BaseState;
import org.junit.Test;
import com.microfocus.silktest.jtf.swing.JButton;
import com.borland.silktest.jtf.common.types.MouseButton;
import com.borland.silktest.jtf.common.types.Point;

public class XMain {

	private Desktop desktop = new Desktop();

	@Before
	public void baseState() {
		BaseState baseState = new BaseState();
		baseState.execute(desktop);
	}

	@Test
	public void main() {
		desktop.<JButton> find("Калькулятор.C").select();
		desktop.<JButton> find("Калькулятор.7").select();
		desktop.<JButton> find("Калькулятор.+").select();
		desktop.<JButton> find("Калькулятор.8").select();
		desktop.<JButton> find("Калькулятор.Button").select();
		/*desktop.<JButton> find("Калькулятор.C").select();
		desktop.<JButton> find("Калькулятор.9").select();
		desktop.<JButton> find("Калькулятор.9").select();
		desktop.<JButton> find("Калькулятор.9").doubleClick(MouseButton.LEFT, new Point(29, 16));
		desktop.<JButton> find("Калькулятор.-").pressMouse(MouseButton.LEFT, new Point(17, 15));
		desktop.<JButton> find("Калькулятор.4").select();
		desktop.<JButton> find("Калькулятор.4").select();
		desktop.<JButton> find("Калькулятор.4").doubleClick(MouseButton.LEFT, new Point(23, 15));
		desktop.<JButton> find("Калькулятор.Button").select();
		desktop.<JButton> find("Калькулятор.C").select();
		desktop.<JButton> find("Калькулятор.9").select();
		desktop.<JButton> find("Калькулятор.9").select();
		desktop.<JButton> find("Калькулятор.9").doubleClick(MouseButton.LEFT, new Point(19, 29));
		desktop.<JButton> find("Калькулятор.-").select();
		desktop.<JButton> find("Калькулятор.4").select();
		desktop.<JButton> find("Калькулятор.4").select();
		desktop.<JButton> find("Калькулятор.4").doubleClick(MouseButton.LEFT, new Point(26, 27));
		desktop.<JButton> find("Калькулятор.Button").select();
		desktop.<JButton> find("Калькулятор.6").select();
		desktop.<JButton> find("Калькулятор.6").select();
		desktop.<JButton> find("Калькулятор.Button2").select();
		desktop.<JButton> find("Калькулятор.1").select();
		desktop.<JButton> find("Калькулятор.1").select();
		desktop.<JButton> find("Калькулятор.1").doubleClick(MouseButton.LEFT, new Point(16, 13));
		desktop.<JButton> find("Калькулятор.Button").select();
		desktop.<JButton> find("Калькулятор.3").select();
		desktop.<JButton> find("Калькулятор.3").select();
		desktop.<JButton> find("Калькулятор.3").doubleClick(MouseButton.LEFT, new Point(23, 19));
		desktop.<JButton> find("Калькулятор.Button4").select();
		desktop.<JButton> find("Калькулятор.1").select();
		desktop.<JButton> find("Калькулятор.0").select();
		desktop.<JButton> find("Калькулятор.Button").select();
		desktop.<JButton> find("Калькулятор.C").select();*/
	}

}