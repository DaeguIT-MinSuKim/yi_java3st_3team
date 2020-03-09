package yi_java3st_3team.ui.content;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import yi_java3st_3team.dto.Grade;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.dto.ZipCode;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Rectangle;
import java.awt.Font;

@SuppressWarnings("serial")
public class MemberJoinPanel extends AbsItemPanel<Member> implements ActionListener {
	private JTextField tfID;
	private JTextField tfName;
	private JTextField tfPW;
	private Dimension picDimension = new Dimension(100, 150);
	private JLabel lblPic;
	private JTextField tfPWCheck;
	private JDateChooser tfBirthday;
	private JTextField tfTel;
	private JTextField tfZip;
	private JTextField tfAddress;
	private JTextField tfDetailAdress;
	private String picPath;
	private JButton btnPic;

	public MemberJoinPanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JPanel pEast = new JPanel();
		add(pEast, BorderLayout.EAST);
		pEast.setLayout(new BoxLayout(pEast, BoxLayout.Y_AXIS));

		lblPic = new JLabel("");
		lblPic.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPic.setPreferredSize(picDimension);
		lblPic.setSize(picDimension);
		setPic(getClass().getClassLoader().getResource("no-image.png").getPath());
		pEast.add(lblPic);
		
		btnPic = new JButton("회원 이미지");
		pEast.add(btnPic);

		JPanel pCenter = new JPanel();
		add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 2, 0, 20));

		JLabel lblID = new JLabel("ID");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblID);

		tfID = new JTextField();
		pCenter.add(tfID);
		tfID.setColumns(10);

		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblName);

		tfName = new JTextField();
		pCenter.add(tfName);
		tfName.setColumns(10);

		JLabel lblPW = new JLabel("비밀번호");
		lblPW.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblPW);

		tfPW = new JTextField();
		pCenter.add(tfPW);
		tfPW.setColumns(10);

		JLabel lblPWCheck = new JLabel("비밀번호 확인");
		lblPWCheck.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblPWCheck);
		
		tfPWCheck = new JTextField();
		pCenter.add(tfPWCheck);
		tfPWCheck.setColumns(10);
		
		JLabel lblBirthday = new JLabel("생년월일");
		lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblBirthday);
		
		tfBirthday = new JDateChooser(new Date(), "yyyy-MM-dd");
		pCenter.add(tfBirthday);
		
		JLabel lblTel = new JLabel("전화번호");
		lblTel.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblTel);
		
		tfTel = new JTextField();
		pCenter.add(tfTel);
		tfTel.setColumns(10);
		
		JLabel lblZip = new JLabel("우편번호");
		lblZip.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblZip);
		
		JPanel pZip = new JPanel();
		pCenter.add(pZip);
		pZip.setLayout(new GridLayout(0, 2, 20, 0));
		
		tfZip = new JTextField();
		tfZip.setText("");
		tfZip.setHorizontalAlignment(SwingConstants.RIGHT);
		tfZip.setColumns(7);
		pZip.add(tfZip);
		
		JButton btnZip = new JButton("우편번호 검색");
		btnZip.setFont(new Font("굴림", Font.PLAIN, 11));
		pZip.add(btnZip);
		
		JLabel lblAddress = new JLabel("주소");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblAddress);
		
		tfAddress = new JTextField();
		pCenter.add(tfAddress);
		tfAddress.setColumns(10);
		
		JPanel pGarbage = new JPanel();
		pCenter.add(pGarbage);
		
		tfDetailAdress = new JTextField();
		pCenter.add(tfDetailAdress);
		tfDetailAdress.setColumns(10);
	}

	private void setPic(byte[] mberImg) {
		lblPic.setIcon(new ImageIcon(new ImageIcon(mberImg).getImage().getScaledInstance((int)picDimension.getWidth(),
				(int)picDimension.getHeight(), Image.SCALE_DEFAULT)));
	}
	
	private void setPic(String imgPath) {
		picPath = imgPath;
		lblPic.setIcon(new ImageIcon(new ImageIcon(imgPath).getImage().getScaledInstance((int) picDimension.getWidth(),
				(int) picDimension.getHeight(), Image.SCALE_DEFAULT)));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnPic) {
			btnPicAction(e);
		}
	}

	private void btnPicAction(ActionEvent e) {
		JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG or PNG or GIF", "jpg", "png", "gif");
		chooser.setFileFilter(filter);
		
		int res = chooser.showOpenDialog(null);
		if (res != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		picPath = chooser.getSelectedFile().getPath();
		setPic(picPath);
	}
	

	@Override
	public Member getItem() {
		validCheck();
		String mberId = tfID.getText().trim();
		String mberPass;
		String mberName;
		Date mberBrthdy;
		ZipCode mberZip;
		String mberBassAd;
		String mberDetailAd;
		String mberTel;
		byte[] mberImg;
		int totalLeCnt;
		int lendBookCnt;
		Grade grade;
		int lendPsbCdt;
		Date joinDt;
		int wdrCdt;
		return null;
	}

	@Override
	public void validCheck() {

	}

	@Override
	public void setItem(Member item) {
		tfID.setText(item.getMberId());
		tfName.setText(item.getMberName());
	}

	@Override
	public void clearTf() {
		tfID.setText("");
		tfName.setText("");
		tfPW.setText("");
		tfPWCheck.setText("");
		tfBirthday.setDate(new Date());
		tfTel.setText("");
		tfZip.setText("");
		tfAddress.setText("");
		tfDetailAdress.setText("");
		setPic(getClass().getClassLoader().getResource("no-Image.png").getPath());
		

	}
}
