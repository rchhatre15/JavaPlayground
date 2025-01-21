import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Interest extends InterestTableGUI implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent arg0) {
		if(arg0.getSource() == simple) {
			int princeInt = Integer.parseInt(principalField.getText());
			int rateInt = Integer.parseInt(rateField.getText());
			double timeInt = verticalSlider.getValue();
			String ans = "";
			for(int i = 1; i <= timeInt; i++) {
				double interest = princeInt + (princeInt * (rateInt/100.0) * i);
				ans += "Year " + i + " --> $" + interest + "\n";
			}
			result.setText(ans);
			System.out.println(ans);
		}
		else if(arg0.getSource() == compound) {
			
				int princeInt = Integer.parseInt(principalField.getText());
				int rateInt = Integer.parseInt(rateField.getText());
				double timeInt = verticalSlider.getValue();
				String ans = "";
				for(int i = 1; i <= timeInt; i++) {
					double interest = princeInt * Math.pow((1 + rateInt/100.0), i);
					ans += "Year " + i + " --> $" + interest + "\n";
				}
				result.setText(ans);
				System.out.println(ans);
			
		}
		else if(arg0.getSource() == both) {
			int princeInt = Integer.parseInt(principalField.getText());
			int rateInt = Integer.parseInt(rateField.getText());
			double timeInt = verticalSlider.getValue();
			
			String ans = "";
			for(int i = 0; i < timeInt; i++) {
				double comp = princeInt * Math.pow((1 + rateInt/100.0), i);
				double simple = princeInt + (princeInt * (rateInt/100.0) * i);
				ans += "Year " + i + "--> Simple: $" + simple + " Compound: $" + comp + "\n";
			}
			result.setText(ans);
			System.out.println(ans);
		}

	}
}
