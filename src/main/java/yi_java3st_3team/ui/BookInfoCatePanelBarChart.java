package yi_java3st_3team.ui;

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
public class BookInfoCatePanelBarChart extends JFXPanel implements InitScene {
	private StatisticUIService service;
	private BarChart<String, Number> barChart;
	public BookInfoCatePanelBarChart() {

	}
	public BarChart<String, Number> getBarChart() {
		return barChart;
	}
	@Override
	public Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root, Color.WHITE);
		
		//막 대형 차트의 X 축과 Y 축을 정의하고 레이블을 설정
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		javafx.scene.text.Font font = new javafx.scene.text.Font(16);
		xAxis.tickLabelFontProperty().set(font);
		yAxis.tickLabelFontProperty().set(font);
		barChart = new BarChart<>(xAxis, yAxis);
		barChart.setLegendVisible(false);
		barChart.setTitle("카테고리별 보유도서 현황");
		barChart.setStyle("-fx-font-size: " + 25 + "px;");
		barChart.setPrefSize(900, 650);
		barChart.setData(getChartData());
		root.getChildren().add(barChart);

		return scene;
	}
	public XYChart.Series<String, Number> getChartData(int[] cateCounts) {
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();
		dataSeries.getData().add(new XYChart.Data<>("지식학문",cateCounts[0]));
		dataSeries.getData().add(new XYChart.Data<>("철학", cateCounts[1]));
		dataSeries.getData().add(new XYChart.Data<>("종교", cateCounts[2]));
		dataSeries.getData().add(new XYChart.Data<>("사회과학", cateCounts[3]));
		dataSeries.getData().add(new XYChart.Data<>("자연과학", cateCounts[4]));
		dataSeries.getData().add(new XYChart.Data<>("기술과학", cateCounts[5]));
		dataSeries.getData().add(new XYChart.Data<>("예술", cateCounts[6]));
		dataSeries.getData().add(new XYChart.Data<>("언어", cateCounts[7]));
		dataSeries.getData().add(new XYChart.Data<>("문학", cateCounts[8]));
		dataSeries.getData().add(new XYChart.Data<>("역사", cateCounts[9]));
		return dataSeries;
	}
	private ObservableList<XYChart.Series<String, Number>> getChartData() {
		service = new StatisticUIService();
		ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();
		int[] cateCounts = service.selectCountByCate();
		list.add(getChartData(cateCounts));
		return list;
	}
}
