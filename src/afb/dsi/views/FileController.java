package afb.dsi.views;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import afb.dsi.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileController implements Initializable{
	
	@FXML
	private ImageView imageView;
	@FXML
	private ImageView imageView1;
	@FXML
	private ImageView imageView2;
	@FXML
	private ImageView imageView3;
	@FXML
	private HBox hBox;
	@FXML
	private ScrollPane scrollPaneId;
	//Reference to the main application
	private Main mainApp;
	
	String str = "0003.jpg";
	String link = "/afb/dsi/views/";
	int count = 0;
	
	private Desktop desktop = Desktop.getDesktop();
	
	//  Is called by the main application to give back reference to itself.
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	public void handleLoadFile() {
		
		FileChooser fileChooser = new FileChooser();
		
		String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
		System.out.println("currentPath: "+currentPath);
		fileChooser.setInitialDirectory(new File("C:\\numarch\\inScan"));
		//fileChooser.setInitialDirectory(new File(currentPath));
		
		//Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
		
		fileChooser.getExtensionFilters().add(extFilter);
		
		//show save file dialog
		File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
		if (file != null) {
            openFile(file);
            List<File> files = Arrays.asList(file);
//            printLog(textArea, files);
        }
		
		
	}
	
	@FXML
	private void dragDetected(MouseEvent event) {
		String[] ress = {"image-003.jpg", "image-004.jpg", "0003.jpg"};
		str = ress[count];
		Image image=new Image(link + str);
	    imageView = (ImageView) event.getTarget();
	    
	    imageView.setImage(image);
	    imageView.setFitWidth(400);
	    imageView.setPreserveRatio(true);
	    imageView.setSmooth(true);
	    imageView.setCache(true);
	    
	  //creating HBox to add imageview
      //HBox hBox=new HBox();
      //hBox.getChildren().add(imageView);
	    
	    System.out.println("Drag Image: "+(count++)+" : "+str);
	    if (count > (ress.length - 1)) {
	    	count = 0;
	    }
//	    //adding scroll pane to the scene
//	    Scene scene = new Scene(hBox, 400, 400);
//	    primaryStage.setScene(scene);
//	    //showing the output
//	    primaryStage.show();
	} 
	
	@FXML
	private void dragOver() {
		
	}
	
	private void openFile(File file) {
        try {
            this.desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("I Entered");
		
		Image image1=new Image("/afb/dsi/scrs/image-000.jpg");
		Image image2=new Image("/afb/dsi/scrs/image-001.jpg");
		Image image3=new Image("/afb/dsi/scrs/image-002.jpg");
		Image image4=new Image("/afb/dsi/scrs/0003.jpg");
		Image image5=new Image("/afb/dsi/scrs/openaccount.jpg");
		
	
		imageView1.setImage(image1);
		imageView1.setFitWidth(600);
		imageView1.setPreserveRatio(true);
		imageView1.setSmooth(true);
		imageView1.setCache(true);
		imageView1.setX(5);
	    imageView1.setY(100);
		
		
		imageView2.setImage(image2);
		imageView2.setFitWidth(600);
		imageView2.setPreserveRatio(true);
		imageView2.setSmooth(true);
		imageView2.setCache(true);
		
		
		imageView3.setImage(image3);
	    imageView3.setFitWidth(600);
	    imageView3.setPreserveRatio(true);
	    imageView3.setSmooth(true);
	    imageView3.setCache(true);
	    
	    ImageView imageView4=new ImageView();
	    imageView4.setImage(image4);
	    imageView4.setFitWidth(400);
	    imageView4.setFitHeight(600);
	    imageView4.setPreserveRatio(true);
	    imageView4.setSmooth(true);
	    imageView4.setCache(true);
	    
	    ImageView imageView5=new ImageView();
	    imageView5.setImage(image5);
	    imageView5.setFitWidth(400);
	    imageView5.setFitHeight(600);
	    imageView5.setPreserveRatio(true);
	    imageView5.setSmooth(true);
	    imageView5.setCache(true);
	    
	  //creating VBox to add image views
	    hBox=new HBox(1);
	    hBox.getChildren().add(imageView1);
	    hBox.getChildren().add(imageView2);
	    hBox.getChildren().add(imageView3);
	    hBox.getChildren().add(imageView4);
	    hBox.getChildren().add(imageView5);
	    
	    //scrollPaneId = new ScrollPane();
	    scrollPaneId.setContent(hBox);
	   

	}
	
	
			
}
