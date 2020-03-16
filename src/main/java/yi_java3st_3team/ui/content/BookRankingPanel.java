package yi_java3st_3team.ui.content;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class BookRankingPanel extends JPanel {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setBounds(100, 100, 800, 600);
					frame.setContentPane(new BookRankingPanel());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BookRankingPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pBast = new JPanel();
		pBast.setBorder(new EmptyBorder(30, 30, 30, 30));
		add(pBast);
		pBast.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBast = new JLabel("대여 베스트 도서");
		lblBast.setBorder(new EmptyBorder(10, 0, 10, 0));
		lblBast.setHorizontalAlignment(SwingConstants.CENTER);
		lblBast.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		pBast.add(lblBast, BorderLayout.NORTH);
		
		JPanel pBastList = new JPanel();
		pBast.add(pBastList, BorderLayout.CENTER);
		pBastList.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pList = new JPanel();
		pBastList.add(pList);
		pList.setLayout(new BorderLayout(0, 0));
		
		JPanel pRank = new JPanel();
		pList.add(pRank, BorderLayout.WEST);
		pRank.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblRank = new JLabel("1");
		lblRank.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblRank.setHorizontalAlignment(SwingConstants.CENTER);
		lblRank.setPreferredSize(new Dimension(30, 15));
		pRank.add(lblRank);
		
		JPanel pBookInfo = new JPanel();
		pList.add(pBookInfo, BorderLayout.CENTER);
		pBookInfo.setLayout(new BorderLayout(0, 0));
		
		JPanel pBookImg = new JPanel();
		pBookInfo.add(pBookImg, BorderLayout.WEST);
		pBookImg.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblBookImg = new JLabel("img");
		lblBookImg.setPreferredSize(new Dimension(100, 140));
		lblBookImg.setHorizontalAlignment(SwingConstants.CENTER);
		pBookImg.add(lblBookImg);
		
		JPanel pTitle = new JPanel();
		pBookInfo.add(pTitle, BorderLayout.CENTER);
		pTitle.setLayout(new BorderLayout(0, 0));
		
		JPanel pLeft = new JPanel();
		pLeft.setBorder(new EmptyBorder(0, 20, 0, 20));
		pTitle.add(pLeft, BorderLayout.WEST);
		pLeft.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblTitName = new JLabel("도서명");
		lblTitName.setHorizontalAlignment(SwingConstants.LEFT);
		pLeft.add(lblTitName);
		
		JLabel lblTitWriter = new JLabel("저자/역자");
		lblTitWriter.setHorizontalAlignment(SwingConstants.LEFT);
		pLeft.add(lblTitWriter);
		
		JLabel lblTitPls = new JLabel("출판사");
		lblTitPls.setHorizontalAlignment(SwingConstants.LEFT);
		pLeft.add(lblTitPls);
		
		JLabel lblTitCat = new JLabel("분류");
		lblTitCat.setHorizontalAlignment(SwingConstants.LEFT);
		pLeft.add(lblTitCat);
		
		JPanel pRight = new JPanel();
		pTitle.add(pRight, BorderLayout.CENTER);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblName = new JLabel("New label");
		pRight.add(lblName);
		
		JLabel lblWriter = new JLabel("New label");
		pRight.add(lblWriter);
		
		JLabel lblPls = new JLabel("New label");
		pRight.add(lblPls);
		
		JLabel lblCat = new JLabel("New label");
		pRight.add(lblCat);
		
		JPanel panel_1 = new JPanel();
		pBastList.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		pBastList.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		pBastList.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		pBastList.add(panel_4);
		
		JPanel pNew = new JPanel();
		pNew.setBorder(new EmptyBorder(30, 30, 30, 30));
		add(pNew);
		pNew.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNew = new JLabel("신착도서");
		lblNew.setBorder(new EmptyBorder(10, 0, 10, 0));
		lblNew.setHorizontalAlignment(SwingConstants.CENTER);
		lblNew.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		pNew.add(lblNew, BorderLayout.NORTH);
		
		JPanel pNewList = new JPanel();
		pNew.add(pNewList, BorderLayout.CENTER);
	}

}
