package afb.dsi;
	
import java.io.IOException;

import afb.dsi.views.FileController;
import afb.dsi.views.ManageFileController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private BorderPane rootLayout;
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Numarch");
		
		initRootLayout();
		
		showFileOverview();
		
		//showManageFileOverview();
	}
	
	/**
	 * init root layout
	 */
	public void initRootLayout() {
		
		
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/afb/dsi/views/RootLayout.fxml"));
			
			rootLayout = (BorderPane) loader.load();
			
			// show the scene containing de layout
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			
			
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void showFileOverview() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/afb/dsi/views/FileOverview.fxml"));
			AnchorPane fileOverview = (AnchorPane) loader.load();
			
			rootLayout.setCenter(fileOverview);
			
			FileController controler = loader.getController();
			controler.setMainApp(this);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void showManageFileOverview() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/afb/dsi/views/ManageFileOverview.fxml"));
			AnchorPane manageFileOverview = (AnchorPane) loader.load();
			
			rootLayout.setLeft(manageFileOverview);
			
			ManageFileController controler = loader.getController();
			controler.setMainApp(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
}
