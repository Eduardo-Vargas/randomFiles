import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChessGui extends Application {

    private Stage window;
    private TableView<Sample> table;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Sample window for CS1331");

        TableColumn<Sample, String> eventColumn = new TableColumn<>("Event");
        eventColumn.setMinWidth(200);
        eventColumn.setCellValueFactory(new PropertyValueFactory<>("a"));

        TableColumn<Sample, String> siteColumn = new TableColumn<>("Site");
        siteColumn.setMinWidth(200);
        siteColumn.setCellValueFactory(new PropertyValueFactory<>("b"));

        TableColumn<Sample, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setMinWidth(100);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("c"));

        TableColumn<Sample, String> whiteColumn = new TableColumn<>("White");
        whiteColumn.setMinWidth(100);
        whiteColumn.setCellValueFactory(new PropertyValueFactory<>("d"));

        TableColumn<Sample, String> blackColumn = new TableColumn<>("Black");
        blackColumn.setMinWidth(100);
        blackColumn.setCellValueFactory(new PropertyValueFactory<>("e"));

        TableColumn<Sample, String> resultColumn = new TableColumn<>("Result");
        resultColumn.setMinWidth(100);
        resultColumn.setCellValueFactory(new PropertyValueFactory<>("f"));

        table = new TableView<>();
        table.setItems(this.getList());
        table.getColumns().addAll(eventColumn, siteColumn, dateColumn, whiteColumn, blackColumn, resultColumn);

        Button viewButton = new Button("View Game");
        Button dismissButton = new Button("Dismiss");
        TilePane tileButtons = new TilePane(Orientation.HORIZONTAL);

        tileButtons.getChildren().addAll(viewButton, dismissButton);
        VBox vBox = new VBox();

        vBox.getChildren().addAll(table, tileButtons);



        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    public ObservableList<Sample> getList() {
        ObservableList<Sample> samples = FXCollections.observableArrayList();
        samples.add(new Sample("move1", "move2","move3", "move4", "move5", "move6" ));
        samples.add(new Sample("taco1", "taco2","taco3", "taco4", "taco5", "taco6" ));
        samples.add(new Sample("ratatouille1", "ratatouille2","ratatouille3", "ratatouille4", "ratatouille5", "ratatouille6" ));
        return samples;
    }

}
