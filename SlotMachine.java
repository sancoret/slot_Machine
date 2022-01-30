//"TEST #4 - @Author Santiago Velasquez"//



import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.util.Random;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class SlotMachine extends Application
{

   
   ImageView pic1View, pic2View, pic3View; 


   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }
   
   @Override
   public void start(Stage primaryStage)
   {
      
      
      Label lbAmountInserted = new Label("Amount Inserted: $");
      Label lbAmountWon = new Label("Amount Won This spin: $0.00");
      Label lbTotalAmountW = new Label("Total Amount Won: $0.00");
     
      TextField tfAmountInserted = new TextField();
      
      
      // Create the Image components.
      Image pic1 = new Image("file:cherry.jpg");
      Image pic2 = new Image("file:plum.jpg");
      Image pic3 = new Image("file:seven.jpg");
      
      // Create the ImageView components.
      pic1View = new ImageView(pic1);
      pic2View = new ImageView(pic2);
      pic3View = new ImageView(pic3);
        
      
      // Resize the moon image, preserving its aspect ratio.
      pic1View.setFitWidth(100);
      pic1View.setPreserveRatio(true);
      
      // Resize the ship image, preserving its aspect ratio.
      pic2View.setFitWidth(100);
      pic2View.setPreserveRatio(true);

      // Resize the sunset image, preserving its aspect ratio.
      pic3View.setFitWidth(100);
      pic3View.setPreserveRatio(true);

      
     
      Button b = new Button("Spin");
       b.setOnAction(new EventHandler<ActionEvent>() {
    
      	public void handle(ActionEvent e) {
         
        
        	double AmountWon;
         double AmountInserted = Double.parseDouble(tfAmountInserted.getText()); 
         
        	Random random = new Random();
        	int randomNumber1 = random.nextInt(3) + 1; //generates 1, 2, 3
        	switch(randomNumber1) {
              case 1:
                pic1View.setImage(pic1);
            	break;
              case 2:
               pic1View.setImage(pic2);
            	break;
              case 3:
                pic1View.setImage(pic3);
            	break;
               
            }
        
        	 int randomNumber2 = random.nextInt(3) + 1; //generates 1, 2, 3
        	switch(randomNumber2) {
              case 1:
                pic2View.setImage(pic1);
            	break;
              case 2:
                 pic2View.setImage(pic2);
            	break;
              case 3:
                 pic2View.setImage(pic3);
            	break;
               
           }
        
        	 int randomNumber3 = random.nextInt(3) + 1; //generates 1, 2, 3
        	switch(randomNumber3) {
              case 1:
                pic3View.setImage(pic1);
            	break;
              case 2:
                pic3View.setImage(pic2);
            	break;
              case 3:
                pic3View.setImage(pic3);
            	break;
               
               
                
            }
            
            if(randomNumber1 == randomNumber2 && randomNumber2 == randomNumber3){
              System.out.println("all 3 match");
               AmountWon = AmountInserted * 3; 
              
              
            } else if(randomNumber1 == randomNumber2 || randomNumber2 == randomNumber3 || randomNumber1 == randomNumber3 ){
              System.out.println("2 match");
               AmountWon = AmountInserted * 2;
              
            } else {
				AmountWon = 0.0;
				System.out.println("NONE MATCHED!");
			}
            
            
             lbAmountWon.setText(String.format("Amount Won This spin: $%,.2f", AmountWon));
             Double totalAmountWon = Double.parseDouble(lbTotalAmountW.getText().substring(19));
             lbTotalAmountW.setText("Total Amount Won: $" + (totalAmountWon + AmountWon));

          }
           
   		});
    
     
           
           
      // Create a GridPane.
      GridPane gridpane = new GridPane();
      
      // Add the ImageViews to the GridPane.
      gridpane.add(pic1View, 0, 0);     // Col 0, Row 0
      gridpane.add(pic2View, 1, 0);     // Col 1, Row 0
      gridpane.add(pic3View, 3, 0);   // Col 2, Row 0
      gridpane.add(lbAmountInserted, 0, 3);
      gridpane.add(b, 2, 6 );
      gridpane.add(lbAmountWon, 3, 2);
      gridpane.add(lbTotalAmountW, 3, 3);
      gridpane.add(tfAmountInserted, 1, 3);


      // Set the gap sizes.
      gridpane.setVgap(10);
      gridpane.setHgap(10);
      
      // Set the GridPane's padding.
      gridpane.setPadding(new Insets(30));
      
      // Create a Scene with the GridPane as its root node.
      Scene scene = new Scene(gridpane);
      
      // Add the Scene to the Stage.
      primaryStage.setScene(scene);
      
      // Set the stage title.
      primaryStage.setTitle("Las Vegas Slot Machine");
      
            
      // Show the window.
      primaryStage.show();
   }
   
            
   
           
}