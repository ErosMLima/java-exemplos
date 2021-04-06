package digytal.java.desktop;

import javax.swing.UIManager;

import digytal.java.desktop.form.FormularioPrincipal;

public class DigytalJavaDesktopSample {
	public static void main(String[] args) {
		try {
			String lf = UIManager.getSystemLookAndFeelClassName();
			UIManager.setLookAndFeel(lf);
			FormularioPrincipal frm = new FormularioPrincipal();
			frm.setSize(550,550);
			frm.setVisible(true);
			
		} catch (Exception e) {
			//logger.error(e);
			System.exit(0);
		}
		
	}
}
