package yi_java3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.Color;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import yi_java3st_3team.dto.Grade;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.dto.ZipCode;
import yi_java3st_3team.ui.content.AbsItemPanel;
import yi_java3st_3team.ui.content.MemberJoinPanel;
import yi_java3st_3team.ui.dialog.ZipDialog;
import yi_java3st_3team.ui.exception.InvalidCheckException;
import yi_java3st_3team.ui.listener.MyDocumentListener;
import yi_java3st_3team.ui.service.MemberUIService;

@SuppressWarnings("serial")
public class MemberProfileModifyPanel extends AbsItemPanel<Member> implements ActionListener {
	private JTextField tfName;
	private JDateChooser tfBirthday;
	private JTextField tfTel;
	private JTextField tfZip;
	private JTextField tfAddress;
	private JTextField tfDetailAdress;
	private String picPath;
	private JPasswordField pfPW1;
	private JPasswordField pfPW2;
	private JLabel lblPic;
	private Dimension picDimension = new Dimension(150, 200);
	private String defaultImg = getClass().getClassLoader().getResource("no-image.png").getPath();
	private JLabel lblPWCheck;
	private Member findMber;
	private JTextField tfID;
	private JButton btnIDCheck;
	private JButton btnZip;
	private MemberUIService service;
	private ZipDialog zipDialog;
	private JFrame member;
	private MemberProfileModifyPanel tMember;
	private MemberJoinPanel pMember;
	private Grade grade;
	private JButton btnSave;
	private JButton btnCancel;

	public MemberProfileModifyPanel() {
		service = new MemberUIService();
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(40, 20, 30, 40));
		setLayout(new BorderLayout(0, 0));

		JPanel pEast = new JPanel();
		pEast.setBackground(Color.WHITE);
		add(pEast, BorderLayout.EAST);
		pEast.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pContent = new JPanel();
		pContent.setBorder(new EmptyBorder(0, 70, 0, 50));
		pContent.setBackground(Color.WHITE);
		pEast.add(pContent);

		lblPic = new JLabel();
		lblPic.setBackground(Color.WHITE);
		
		lblPic.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPic.setPreferredSize(picDimension);
		lblPic.setSize(picDimension);
		//setPicStr(defaultImg);
		pContent.setLayout(new GridLayout(0, 1, 0, -30));
		pContent.add(lblPic);
		
		pDetail = new JPanel();
		pDetail.setBackground(Color.WHITE);
		pContent.add(pDetail);
		pDetail.setLayout(new BorderLayout(0, 0));
		
		btnPic = new JButton("증명사진");
		btnPic.addActionListener(this);
		btnPic.setPreferredSize(new Dimension(20, 30));
		pDetail.add(btnPic, BorderLayout.NORTH);
		
		lblGrade = new JLabel("");
		lblGrade.setBackground(Color.WHITE);
		lblGrade.setBorder(new EmptyBorder(0, 0, 100, 0));
		lblGrade.setFont(new Font("문체부 제목 돋음체", Font.BOLD, 25));
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		pDetail.add(lblGrade);

		JPanel pCenter = new JPanel();
		pCenter.setBackground(Color.WHITE);
		add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 2, 0, 15));

		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("굴림", Font.PLAIN, 17));
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblID);

		JPanel pID = new JPanel();
		pID.setBackground(Color.WHITE);
		pCenter.add(pID);
		pID.setLayout(new GridLayout(0, 2, 20, 0));

		tfID = new JTextField();
		tfID.setForeground(Color.GRAY);
		tfID.setColumns(10);
		tfID.setEditable(false);
		pID.add(tfID);

		btnIDCheck = new JButton("ID 중복확인");
		btnIDCheck.addActionListener(this);
		btnIDCheck.setFont(new Font("굴림", Font.PLAIN, 12));
		pID.add(btnIDCheck);

		JLabel lblName = new JLabel("이름");
		lblName.setFont(new Font("굴림", Font.PLAIN, 17));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblName);

		tfName = new JTextField();
		pCenter.add(tfName);
		tfName.setColumns(10);

		JLabel lblPW1 = new JLabel("비밀번호");
		lblPW1.setFont(new Font("굴림", Font.PLAIN, 17));
		lblPW1.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblPW1);

		pfPW1 = new JPasswordField();
		pfPW1.getDocument().addDocumentListener(docListener);
		pCenter.add(pfPW1);

		JLabel lblPW2 = new JLabel("비밀번호 확인");
		lblPW2.setFont(new Font("굴림", Font.PLAIN, 17));
		lblPW2.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblPW2);

		pfPW2 = new JPasswordField();
		pfPW2.getDocument().addDocumentListener(docListener);
		pCenter.add(pfPW2);

		JPanel pAir2 = new JPanel();
		pAir2.setBackground(Color.WHITE);
		pCenter.add(pAir2);

		lblPWCheck = new JLabel("비밀번호 중복확인");
		lblPWCheck.setHorizontalAlignment(SwingConstants.CENTER);
		lblPWCheck.setForeground(Color.GRAY);
		lblPWCheck.setFont(new Font("굴림", Font.BOLD, 11));
		pCenter.add(lblPWCheck);

		JLabel lblBirthday = new JLabel("생년월일");
		lblBirthday.setFont(new Font("굴림", Font.PLAIN, 17));
		lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblBirthday);

		tfBirthday = new JDateChooser(new Date(), "yyyy-MM-dd");
		pCenter.add(tfBirthday);

		JLabel lblTel = new JLabel("전화번호");
		lblTel.setFont(new Font("굴림", Font.PLAIN, 17));
		lblTel.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblTel);

		tfTel = new JTextField();
		tfTel.setForeground(Color.GRAY);
		tfTel.setFont(new Font("굴림", Font.PLAIN, 11));
		pCenter.add(tfTel);
		tfTel.setColumns(10);

		JLabel lblZip = new JLabel("우편번호");
		lblZip.setFont(new Font("굴림", Font.PLAIN, 17));
		lblZip.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblZip);

		JPanel pZip = new JPanel();
		pZip.setBackground(Color.WHITE);
		pCenter.add(pZip);
		pZip.setLayout(new GridLayout(0, 2, 20, 0));

		tfZip = new JTextField();
		tfZip.setHorizontalAlignment(SwingConstants.LEFT);
		tfZip.setColumns(7);
		pZip.add(tfZip);

		btnZip = new JButton("우편번호 검색");
		btnZip.addActionListener(this);
		btnZip.setFont(new Font("굴림", Font.PLAIN, 12));
		pZip.add(btnZip);

		JLabel lblAddress = new JLabel("주소");
		lblAddress.setFont(new Font("굴림", Font.PLAIN, 17));
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		pCenter.add(lblAddress);

		tfAddress = new JTextField();
		pCenter.add(tfAddress);
		tfAddress.setColumns(10);

		JPanel pGarbage = new JPanel();
		pGarbage.setBackground(Color.WHITE);
		pCenter.add(pGarbage);

		tfDetailAdress = new JTextField();
		pCenter.add(tfDetailAdress);
		tfDetailAdress.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.SOUTH);

		btnSave = new JButton("수정");
		btnSave.addActionListener(this);
		btnSave.setPreferredSize(new Dimension(80, 30));
		panel.add(btnSave);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setPreferredSize(new Dimension(80, 30));
		panel.add(btnCancel);

		tMember = this;
	}

	public MemberProfileModifyPanel gettMember() {
		return tMember;
	}

	public void settMember(MemberProfileModifyPanel tMember) {
		this.tMember = tMember;
	}

	public void setService(MemberUIService service) {
		this.service = service;
	}

	DocumentListener docListener = new MyDocumentListener() {
		@Override
		public void msg() {
			String pw1 = new String(pfPW1.getPassword());
			String pw2 = new String(pfPW2.getPassword());
			if (pw1.length() == 0 || pw2.length() == 0) {
				lblPWCheck.setText("");
			} else if (pw1.equals(pw2)) {
				lblPWCheck.setText("비밀번호 일치");
				lblPWCheck.setForeground(Color.BLACK);
			} else {
				lblPWCheck.setText("비밀번호 불일치");
				lblPWCheck.setForeground(Color.RED);
			}
		}
	};
	private JPanel pDetail;
	private JLabel lblGrade;
	private JButton btnPic;

	public JTextField getTfName() {
		return tfName;
	}

	public JDateChooser getTfBirthday() {
		return tfBirthday;
	}

	public JTextField getTfTel() {
		return tfTel;
	}

	public JTextField getTfZip() {
		return tfZip;
	}

	public JTextField getTfAddress() {
		return tfAddress;
	}

	public JTextField getTfDetailAdress() {
		return tfDetailAdress;
	}

	public JTextField getTfID() {
		return tfID;
	}

	public JPasswordField getPfPW1() {
		return pfPW1;
	}

	public JLabel getLblPic() {
		return lblPic;
	}

	private void setPic(byte[] mberImg) {
		lblPic.setIcon(new ImageIcon(new ImageIcon(mberImg).getImage().getScaledInstance((int) picDimension.getWidth(),
				(int) picDimension.getHeight(), Image.SCALE_DEFAULT)));
	}

	private void setPicStr(String imgPath) {
		picPath = imgPath;
		lblPic.setIcon(new ImageIcon(new ImageIcon(imgPath).getImage()
				.getScaledInstance((int)picDimension.getWidth(), (int) picDimension.getHeight(), Image.SCALE_DEFAULT)));
	}

	@Override
	public Member getItem() {
		validCheck();
		String mberId = tfID.getText().trim();
		String mberPass = new String(pfPW1.getPassword());
		String mberName = tfName.getText().trim();
		Date mberBrthdy = tfBirthday.getDate();
		ZipCode mberZip = new ZipCode(Integer.parseInt(tfZip.getText()));
		String mberBassAd = tfAddress.getText().trim();
		String mberDetailAd = tfDetailAdress.getText().trim();
		String mberTel = tfTel.getText().trim();
		byte[] mberImg = getImage();
		int wdrCdt = 0;
		if (lblGrade.getText().equals("우수회원")) {
			grade = new Grade(2);
		} else {
			grade = new Grade(1);
		}

		int lendPsbCdt = 0;
		int odCnt = 0;
		return new Member(mberId, mberPass, mberName, mberBrthdy, mberZip, mberBassAd, mberDetailAd, mberTel, mberImg,
				wdrCdt, grade, lendPsbCdt, odCnt);
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
		if (tfID.getText().equals("") || pfPW1.getPassword().equals("") || tfName.getText().equals("")
				|| tfZip.getText().equals("") || tfAddress.getText().equals("") || tfTel.getText().equals("")
				|| tfBirthday.getDate() == new Date()) {
			throw new InvalidCheckException();
		}
	}

	public JLabel getLblPWCheck() {
		return lblPWCheck;
	}

	public void setLblPWCheck(JLabel lblPWCheck) {
		this.lblPWCheck = lblPWCheck;
	}

	@Override
	public void clearTf() {
		tfID.setText("");
		tfName.setText("");
		pfPW1.setText("");
		pfPW2.setText("");
		tfBirthday.setDate(new Date());
		tfTel.setText("");
		tfZip.setText("");
		tfAddress.setText("");
		tfDetailAdress.setText("");
		setPicStr(getClass().getClassLoader().getResource("no-image.png").getPath());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPic) {
			btnPicActionPerformed(e);
		}
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnSave) {
			btnSaveActionPerformed(e);
		}

		if (e.getSource() == btnZip) {
			btnZipActionPerformed(e);
		}

	}

	@Override
	public void setItem(Member item) {
		tfID.setText(item.getMberId());
		pfPW1.setText("");
		pfPW2.setText("");
		tfName.setText(item.getMberName());
		tfBirthday.setDate(item.getMberBrthdy());
		tfZip.setText(item.getMberZip() + "");
		tfAddress.setText(item.getMberBassAd());
		tfDetailAdress.setText(item.getMberDetailAd());
		lblGrade.setText(item.getGrade().getGradeName());
		tfTel.setText(item.getMberTel());
		if (item.getMberImg() == null) {
			setPicStr(getClass().getClassLoader().getResource("no-image.png").getPath());
		} else {
			setPic(item.getMberImg());
		}
	}

	public MemberJoinPanel getpMember() {
		return pMember;
	}

	public void setPicImageIcon(ImageIcon icon) {
		lblPic.setIcon(new ImageIcon(icon.getImage().getScaledInstance((int) picDimension.getWidth(),
				(int) picDimension.getHeight(), Image.SCALE_DEFAULT)));
	}

	protected void btnZipActionPerformed(ActionEvent e) {

		zipDialog = new ZipDialog(member, "우편번호 검색");
		zipDialog.getBtnAdd().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zipDialog.setDetailAd(zipDialog.getTfDetailAd().getText());
				zipDialog.setZipCode(zipDialog.getTfZipCode().getText());
				tfZip.setText(zipDialog.getZipCode());
				tfAddress.setText(zipDialog.getAddrFull());
				tfDetailAdress.setText(zipDialog.getDetailAd());
				zipDialog.dispose();
			}
		});

		zipDialog.setBounds(50, 50, 350, 550);
		zipDialog.setVisible(true);

	}

	public JPasswordField getPfPW2() {
		return pfPW2;
	}

	public void setPfPW2(JPasswordField pfPW2) {
		this.pfPW2 = pfPW2;
	}

	protected void btnCancelActionPerformed(ActionEvent e) {
		tMember.clearTf();

	}

	protected void btnSaveActionPerformed(ActionEvent e) {
		if(tMember.getLblPWCheck().getText().equals("비밀번호 불일치") || tMember.getPfPW2().getPassword().length==0) {
			JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요.");
			return;
		}else {
			try {
				Member updateMem = tMember.getItem();
				service.updateMember(updateMem);
				JOptionPane.showMessageDialog(null, String.format("%s님의 프로필 수정이 완료되었습니다.", updateMem.getMberName()));
			} catch (InvalidCheckException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}

	}

	public void initTf(Member member) {

		tfID.setText(member.getMberId());
		tfName.setText(member.getMberName());
		pfPW1.setText(member.getMberPass());
		tfBirthday.setDate(member.getMberBrthdy());
		tfTel.setText(member.getMberTel());
		tfZip.setText(member.getMberZip().getZipCode() + "");
		tfAddress.setText(member.getMberBassAd());
		tfDetailAdress.setText(member.getMberDetailAd());
		if (member.getGrade().getGradeNo() == 1) {
			lblGrade.setText("일반회원");
		} else {
			lblGrade.setText("우수회원");
		}
		
		if(member.getMberImg() == null || member.getMberImg().length == defaultImg.length() || member.getMberImg().length == 0) {
			setPicStr(defaultImg);
		} else {
			setPic(member.getMberImg());
		}
//		pMember.getTfID().setText(member.getMberId());
//		pMember.getTfName().setText(member.getMberName());
//		pMember.getPfPW1().setText(member.getMberPass());
//		pMember.getTfBirthday().setDate(member.getMberBrthdy());
//		pMember.getTfTel().setText(member.getMberTel());
//		pMember.getTfZip().setText(member.getMberZip().getZipCode()+"");
//		pMember.getTfAddress().setText(member.getMberBassAd());
//		pMember.getTfDetailAdress().setText(member.getMberDetailAd());
//		lblNewLabel.setText(member.getGrade().getGradeName());
//		ImageIcon icon = new ImageIcon(member.getMberImg());
//		pMember.setPicImageIcon(icon);
//		pMember.getTfID().setEditable(false);
	}

	protected void btnPicActionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG or PNG or GIF", "jpg", "png", "gif");
		chooser.setFileFilter(filter);

		int res = chooser.showOpenDialog(null);
		if (res != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "사진을 선택하지 않으셨습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		picPath = chooser.getSelectedFile().getPath();
		setPicStr(picPath);
	}
}
