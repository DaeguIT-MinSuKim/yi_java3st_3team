package yi_java3st_3team.ui.chart;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import yi_java3st_3team.ui.service.StatisticUIService;

@SuppressWarnings("serial")
public class MemberInfoPanelPieChart extends JFXPanel implements InitScene{
	private StatisticUIService service;
	private PieChart pieChart;
	
	@Override
	public Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root);
		root.setAutoSizeChildren(true);
		
		pieChart = new PieChart();
		pieChart.setPrefSize(900, 650);
		pieChart.setData(getChartData());
		pieChart.setTitle("이용자 현황");
		pieChart.setStyle("-fx-font-size: " + 20 + "px;");
		pieChart.setLegendVisible(true);	// 범례 표시 유무
		pieChart.setLegendSide(Side.BOTTOM);// 범례 위치
		pieChart.setLabelLineLength(30);	// 원의 둘레 가장자리와 라벨간의 거리 지정
		pieChart.setClockwise(true); 		// 시계방향 배치여부
		pieChart.setLabelsVisible(true);	// 레이블 표시여부
		
		for(Data d : pieChart.getData()) {
			d.nameProperty().bind(Bindings.concat(d.getName(), " ", d.pieValueProperty(), " 명"));
		}
		
		root.getChildren().add(pieChart);

		return scene;
	}
	
	private ObservableList<Data> getChartData() {
		ObservableList<Data> list = FXCollections.observableArrayList();
		service = new StatisticUIService();
		int[] memCounts = service.selectMemberCounts();
		list.addAll(new PieChart.Data("우수회원", memCounts[2]), new PieChart.Data("일반회원", memCounts[1]));
		return list;
	}
}
