package yi_java3st_3team.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import yi_java3st_3team.dto.Lending;
import yi_java3st_3team.ui.panel.content.MailService;
import yi_java3st_3team.ui.panel.list.MemberBookOverdueTblPanel;
import yi_java3st_3team.ui.service.LendingUiService;

@SuppressWarnings("serial")
public class MemberBookOverdueUIPanel extends JPanel implements ActionListener {
	private JButton btnSelAll;
	private MemberBookOverdueTblPanel pCenter;
	private boolean allChk;
	private JButton btnSendMail;
	private LendingUiService service;
	public MemberBookOverdueUIPanel() {
		initialize();
	}
	private void initialize() {
		setBorder(new EmptyBorder(50, 30, 50, 30));
		setBackground(Color.WHITE);
		service = new LendingUiService();
		setLayout(new BorderLayout(0, 0));
		
		JPanel pNorth = new JPanel();
		pNorth.setBackground(Color.WHITE);
		pNorth.setBorder(new EmptyBorder(10, 10, 20, 10));
		add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblTitle = new JLabel("연체회원 목록");
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		pNorth.add(lblTitle);
		
		JPanel pDummy = new JPanel();
		pDummy.setBackground(Color.WHITE);
		pNorth.add(pDummy);
		
		btnSelAll = new JButton("모두선택/모두해제");
		btnSelAll.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnSelAll.addActionListener(this);
		pNorth.add(btnSelAll);
		
		pCenter = new MemberBookOverdueTblPanel();
		List<Lending> list = service.showOverDueList();
		if(list!=null) {
			pCenter.loadData(list);
		}
		pCenter.setBackground(Color.WHITE);
		add(pCenter, BorderLayout.CENTER);
		
		JPanel pSouth = new JPanel();
		pSouth.setBorder(new EmptyBorder(30, 0, 0, 0));
		pSouth.setBackground(Color.WHITE);
		add(pSouth, BorderLayout.SOUTH);
		
		btnSendMail = new JButton("메일 보내기");
		btnSendMail.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnSendMail.addActionListener(this);
		pSouth.add(btnSendMail);
	}
	
	public void loadData() {
		List<Lending> list = service.showOverDueList();
		if(list!=null) {
			pCenter.loadData(list);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSendMail) {
			try {
				btnSendMailActionPerformed(e);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == btnSelAll) {
			btnSelAllActionPerformed(e);
		}
	}
	protected void btnSelAllActionPerformed(ActionEvent e) {
		TableModel model = pCenter.getTable().getModel();
		if(!allChk) {
			for(int i=0;i<model.getRowCount();i++) {
				model.setValueAt(true, i, 6);
			}
			allChk = true;
		}
		else {
			for(int i=0;i<model.getRowCount();i++) {
				model.setValueAt(false, i, 6);
			}
			allChk = false;
		}
	}
	protected void btnSendMailActionPerformed(ActionEvent e) throws ParseException {
		TableModel model = pCenter.getTable().getModel();
		for(int i=0;i<model.getRowCount();i++) {
			if((boolean)model.getValueAt(i, 6)) {
				String email = (String)model.getValueAt(i, 2);
				// 현재까지 연체된 일수 구하기
				
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date now = new Date();
				String returnString = (String) (model.getValueAt(i, 5));
				Date returnD = sdf1.parse(returnString);
				long result = now.getTime() - returnD.getTime();
				long resultDay = result / (24 * 60 * 60 * 1000);
				resultDay = Math.abs(resultDay);

				//메일로 보낼 대여일
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date lendDate = sdf2.parse((String)(model.getValueAt(i, 4)));
				String lendStr = new SimpleDateFormat("yyyy년 MM월 dd일").format(lendDate);
				
				//메일로 보낼 반납예정일
				Date returnDate = sdf2.parse((String)(model.getValueAt(i, 5)));
				String returnStr = new SimpleDateFormat("yyyy년 MM월 dd일").format(returnDate);
				
				
				
				//보낼 이메일 형식
				StringBuilder message = new StringBuilder();
				
				String title = " [ " + (String)model.getValueAt(i, 3) + "님 대구도서관 도서 연체 메일 ] ";
				
				message.append(" [ 대구도서관에서 안내 드립니다 ]" +System.getProperty("line.separator"));
				message.append(System.getProperty("line.separator"));
				message.append((String)model.getValueAt(i, 3) + "님께서 대출중인 도서가 " + resultDay + "일 연체 중에 있습니다." + System.getProperty("line.separator"));
				message.append("내용을 참고 하시어 연체 도서를 반납하여 주시길 바랍니다. " +System.getProperty("line.separator"));
				message.append(System.getProperty("line.separator"));
				message.append("1.도서 대출도서관 : 대구 3조 도서관" + System.getProperty("line.separator"));
				message.append(System.getProperty("line.separator"));
				message.append("2.연체도서 상세 " +  System.getProperty("line.separator"));
				message.append("도서 대출일 : " + lendStr + System.getProperty("line.separator"));
				message.append("반납 예정일 : " + returnStr + System.getProperty("line.separator"));
				message.append("대출 도서명 : " + (String)model.getValueAt(i, 1) + System.getProperty("line.separator"));
				message.append(System.getProperty("line.separator"));
				message.append("문의전화 : 053 - 3333 - 3333");
				
				String totalMessage = message.toString();
				if(MailService.naverMailSend(email,title,totalMessage)) {
					JOptionPane.showMessageDialog(null, "메일 발송이 성공하였습니다");
				}
			}
		}
	}
}
