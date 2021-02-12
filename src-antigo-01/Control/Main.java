package Control;
import javax.swing.SwingUtilities;

import View.MainFrame;

public class Main {

	public static void main(String[] args) {
		//new MainFrame();
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new MainFrame();
				
			}
		});
		
	}
	
	public void teste() {
		System.out.println(" sdasfasdf asdf adsf adsfsdasfasdf asdf adsf adsf");
		
		
	}

}

