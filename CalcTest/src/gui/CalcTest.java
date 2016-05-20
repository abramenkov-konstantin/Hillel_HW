package gui;

import com.borland.silktest.jtf.Desktop;
import org.junit.Before;
import com.borland.silktest.jtf.BaseState;
import org.junit.Test;
import com.microfocus.silktest.jtf.swing.JButton;

public class CalcTest {

	private Desktop desktop = new Desktop();

	@Before
	public void baseState() {
		BaseState baseState = new BaseState();
		baseState.execute(desktop);
	}

	@Test
	public void main() {
		desktop.<JButton> find("Калькулятор.5").select();
		desktop.<JButton> find("Калькулятор.Button").select();
		desktop.<JButton> find("Калькулятор.6").select();
		desktop.<JButton> find("Калькулятор.Button2").select();
		desktop.<JButton> find("Калькулятор.C").select();
		desktop.<JButton> find("Калькулятор.1").select();
		desktop.<JButton> find("Калькулятор.Button4").select();
		desktop.<JButton> find("Калькулятор.3").select();
		desktop.<JButton> find("Калькулятор.Button2").select();
		desktop.<JButton> find("Калькулятор.C").select();
		desktop.<JButton> find("Калькулятор.2").select();
		desktop.<JButton> find("Калькулятор.5").select();
		desktop.<JButton> find("Калькулятор.-").select();
		desktop.<JButton> find("Калькулятор.9").select();
		desktop.<JButton> find("Калькулятор.Button2").select();
		desktop.<JButton> find("Калькулятор.C").select();
	}

}