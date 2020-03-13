package yi_java3st_3team.ui;

import java.awt.Font;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.paint.Color;
import yi_java3st_3team.ui.service.StatisticUIService;

@SuppressWarnings("serial")
public class BookInfoPanelBarChart extends JFXPanel implements InitScene {
	private StatisticUIService service;
	private BarChart<String, Number> barChart;
	public BookInfoPanelBarChart() {

	}
	public BarChart<String, Number> getBarChart() {
		return barChart;
	}
	@Override
	public Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root, Color.ALICEBLUE);
		
		//막 대형 차트의 X 축과 Y 축을 정의하고 레이블을 설정
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		javafx.scene.text.Font font = new javafx.scene.text.Font(16);
		xAxis.tickLabelFontProperty().set(font);
		yAxis.tickLabelFontProperty().set(font);
		barChart = new BarChart<>(xAxis, yAxis);
		barChart.setLegendVisible(false);
		barChart.setTitle("대여 반납 통계");
		barChart.setStyle("-fx-font-size: " + 25 + "px;");;
		barChart.setPrefSize(900, 600);
		barChart.setData(getChartData());
		root.getChildren().add(barChart);

		return scene;
	}
	public XYChart.Series<String, Number> getChartData(int data1,int data2, int data3, int data4) {
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();
		dataSeries.getData().add(new XYChart.Data<>("대여가능",data1));
		dataSeries.getData().add(new XYChart.Data<>("대여중", data2));
		dataSeries.getData().add(new XYChart.Data<>("전체", data3));
		dataSeries.getData().add(new XYChart.Data<>("평균대여일", data4));
		return dataSeries;
	}
	private ObservableList<XYChart.Series<String, Number>> getChartData() {
		service = new StatisticUIService();
		ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();
		int data1 = service.selectLendableBooks();
		int data2 = service.selectDuringLendBooks();
		int data3 = service.selectTotalBooks();
		int data4 = service.selectAvgRendDate();
		list.add(getChartData(data1,data2,data3,data4));
		return list;
	}
}
