package afb.dsi.views;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import afb.dsi.Main;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;

public class ManageFileController {
	
	    //Reference to the main application
		private Main mainApp;
		
		private Desktop desktop = Desktop.getDesktop();
		
		//  Is called by the main application to give back reference to itself.
		public void setMainApp(Main mainApp) {
			this.mainApp = mainApp;
		}
		
	// Opens the filechosser to let a user select an address book to load
		@FXML
		public void handleLoadFile() {
			
			FileChooser fileChooser = new FileChooser();
			
			//Set extension filter
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
	                "XML files (*.xml)", "*.xml");
			
			fileChooser.getExtensionFilters().add(extFilter);
			
			//show save file dialog
			File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
			if (file != null) {
                openFile(file);
                List<File> files = Arrays.asList(file);
//                printLog(textArea, files);
            }
		}
		
		private void openFile(File file) {
	        try {
	            this.desktop.open(file);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
