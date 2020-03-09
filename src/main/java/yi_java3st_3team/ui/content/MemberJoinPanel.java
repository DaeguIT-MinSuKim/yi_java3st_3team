package yi_java3st_3team.ui.content;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import yi_java3st_3team.dto.Member;
import yi_java3st_3team.dto.ZipCode;
import yi_java3st_3team.ui.exception.InvalidCheckException;
import yi_java3st_3team.ui.listener.MyDocumentListener;

@SuppressWarnings("serial")
public class MemberJoinPanel extends AbsItemPanel<Member> implements ActionListener {
	private JTextField tfID;
	private JTextField tfName;
	private Dimension picDimension = new Dimension(100, 150);
	private JLabel lblPic;
	private JDateChooser tfBirthday;
	private JTextField tfTel;
	private JTextField tfZip;
	private JTextField tfAddress;
	private JTextField tfDetailAdress;
	private String picPath;
	private JButton btnPic;
	private JPasswordField pfPW;
	private JPasswordField pfPWCheck;

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

		pfPW = new JPasswordField();
		pCenter.add(pfPW);

		JLabel lblPWCheck = new JLabel("비밀번호 확인");
		lblPWCheck.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblPWCheck);

		pfPWCheck = new JPasswordField();
		pCenter.add(pfPWCheck);

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
		//tfZip.setText("");
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

	DocumentListener docListener = new MyDocumentListener() {
		@Override
		public void msg() {
			String pw1 = new String(pfPW.getPassword());
			String pw2 = new String(pfPWCheck.getPassword());
			if (pw1.length() == 0 || pw2.length() == 0) {
				JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.");
			} else if (pw1.equals(pw2)) {
				JOptionPane.showMessageDialog(null, "비밀번호가 일치하였습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			}
		}
	};

	private void setPic(byte[] mberImg) {
		lblPic.setIcon(new ImageIcon(new ImageIcon(mberImg).getImage().getScaledInstance((int) picDimension.getWidth(),
				(int) picDimension.getHeight(), Image.SCALE_DEFAULT)));
	}

	private void setPic(String imgPath) {
		picPath = imgPath;
		lblPic.setIcon(new ImageIcon(new ImageIcon(imgPath).getImage().getScaledInstance((int) picDimension.getWidth(),
				(int) picDimension.getHeight(), Image.SCALE_DEFAULT)));
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPic) {
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
		String mberPass = new String(pfPW.getPassword());
		String mberName = tfName.getText().trim();
		Date mberBrthdy = tfBirthday.getDate();
		ZipCode mberZip = new ZipCode(Integer.parseInt(tfZip.getText()));
		String mberBassAd = tfAddress.getText().trim();
		String mberDetailAd = tfDetailAdress.getText().trim();
		String mberTel = tfTel.getText().trim();
		byte[] mberImg = getImage();
		return new Member(mberId, mberPass, mberName, mberBrthdy, mberZip, mberBassAd, mberDetailAd, mberTel, mberImg);
	}

	private byte[] getImage() {
		byte[] pic = null;
		File file = new File(picPath);
		try (InputStream is = new FileInputStream(file)) {
			pic = new byte[is.available()];
			is.read(pic);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	@Override
	public void validCheck() {
		if(tfID.getText().equals("") || pfPW.getPassword().equals("") || tfName.getText().equals("") || tfZip.getText().equals("") 
				|| tfAddress.getText().equals("") || tfDetailAdress.getText().equals("") || tfTel.getText().equals("") || tfBirthday.getDate()==new Date()){
					throw new InvalidCheckException();
				}
	}

	@Override
	public void setItem(Member item) {
		tfID.setText(item.getMberId());
		pfPW.setText("");
		pfPWCheck.setText("");
		tfName.setText(item.getMberName());
		tfBirthday.setDate(item.getMberBrthdy());
		tfZip.setText(item.getMberZip() + "");
		tfAddress.setText(item.getMberBassAd());
		tfDetailAdress.setText(item.getMberDetailAd());
		tfTel.setText(item.getMberTel());
		if (item.getMberImg() == null) {
			setPic(getClass().getClassLoader().getResource("no-image.png").getPath());
		} else {
			setPic(item.getMberImg());
		}
//		  private int totalLeCnt;
//		  private int lendBookCnt;
//		  private Grade grade;
//		  private int lendPsbCdt; 
//		  private Date joinDt; 
//		  private int wdrCdt;
	}

	@Override
	public void clearTf() {
		tfID.setText("");
		tfName.setText("");
		pfPW.setText("");
		pfPWCheck.setText("");
		tfBirthday.setDate(new Date());
		tfTel.setText("");
		tfZip.setText("");
		tfAddress.setText("");
		tfDetailAdress.setText("");
		setPic(getClass().getClassLoader().getResource("no-Image.png").getPath());
	}
	
}
