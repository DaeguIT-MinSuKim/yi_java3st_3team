package yi_java3st_3team.ui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import yi_java3st_3team.dto.Grade;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.dto.ZipCode;
import yi_java3st_3team.ui.exception.InvalidCheckException;
import yi_java3st_3team.ui.panel.list.MemberTblPanel;
import yi_java3st_3team.ui.service.MemberUIService;

@SuppressWarnings("serial")
public class MemberUpdateDialog extends JDialog implements ActionListener {
	private ZipCode zipCode;
	private final JPanel contentPanel = new JPanel();
	private static JFrame frame;
	private JButton btnCancel;
	private JTextField tfID;
	private JTextField tfName;
	private JDateChooser tfBirthday;
	private JTextField tfTel;
	private JTextField tfAd;
	private JLabel lblPic;
	private Dimension picDimension = new Dimension(100, 150);
	private String picPath;
	private JButton btnUpdate;
	private String defaultImg = getClass().getClassLoader().getResource("no-image.png").getPath();
	private JButton btnPic;
	private MemberUIService service;
	private JButton btnZip;
	private ZipDialog zipDialog;
	private JFrame zipFrame;
	private MemberTblPanel pMemberList;
	private MemberUpdateDialog updateDialog;
	private JTextField tfGrade;
	private Member member;


	public MemberUpdateDialog(JFrame frame, String title) {
		super(frame, title, true);
		zipDialog = new ZipDialog(zipFrame, "우편번호 검색");
		setBounds(100, 100, 700, 450);
		service = new MemberUIService();
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setHgap(10);
		borderLayout.setVgap(10);
		getContentPane().setLayout(borderLayout);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 10, 0));

		JPanel pUpdate = new JPanel();
		contentPanel.add(pUpdate);
		pUpdate.setLayout(new GridLayout(0, 2, 0, 10));

		JLabel lblID = new JLabel("ID");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		pUpdate.add(lblID);

		tfID = new JTextField();
		tfID.setEditable(false);
		pUpdate.add(tfID);
		tfID.setColumns(10);
		

		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		pUpdate.add(lblName);

		tfName = new JTextField();
		pUpdate.add(tfName);
		tfName.setColumns(10);

		JLabel lblBirthday = new JLabel("생년월일");
		lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		pUpdate.add(lblBirthday);

		tfBirthday = new JDateChooser(new Date(), "yyyy-MM-dd");
		pUpdate.add(tfBirthday);

		JLabel lblTel = new JLabel("전화번호");
		lblTel.setHorizontalAlignment(SwingConstants.CENTER);
		pUpdate.add(lblTel);

		tfTel = new JTextField();
		pUpdate.add(tfTel);
		tfTel.setColumns(10);

		JLabel lblAd = new JLabel("주소");
		lblAd.setHorizontalAlignment(SwingConstants.CENTER);
		pUpdate.add(lblAd);

		tfAd = new JTextField();
		pUpdate.add(tfAd);
		tfAd.setColumns(10);

		JLabel lblAir = new JLabel("");
		pUpdate.add(lblAir);

		btnZip = new JButton("검색");
		btnZip.addActionListener(this);
		pUpdate.add(btnZip);
		
		JLabel lblGrade = new JLabel("등급");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		pUpdate.add(lblGrade);
		
		tfGrade = new JTextField();
		tfGrade.setEditable(false);
		pUpdate.add(tfGrade);
		tfGrade.setColumns(10);

		JPanel pImage = new JPanel();
		contentPanel.add(pImage);
		pImage.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pImg = new JPanel();
		pImage.add(pImg);
		pImg.setLayout(new GridLayout(0, 1, 0, 10));

		lblPic = new JLabel();
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPic.setPreferredSize(picDimension);
		lblPic.setSize(picDimension);
		setStr(defaultImg);
		pImg.add(lblPic);

		JPanel pBtn = new JPanel();
		pImg.add(pBtn);

		btnPic = new JButton("  회원 이미지  ");
		btnPic.addActionListener(this);
		pBtn.add(btnPic);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		btnUpdate = new JButton("  수정  ");
		btnUpdate.setPreferredSize(new Dimension(75, 25));
		btnUpdate.addActionListener(this);
		btnUpdate.setActionCommand("OK");
		buttonPane.add(btnUpdate);
		getRootPane().setDefaultButton(btnUpdate);

		btnCancel = new JButton("  취소  ");
		btnCancel.setPreferredSize(new Dimension(75, 25));
		btnCancel.addActionListener(this);
		btnCancel.setActionCommand("Cancel");
		buttonPane.add(btnCancel);

		setService(service);
	}

	private void setService(MemberUIService service) {
		this.service = service;
	}

	private void setByte(byte[] mberImg) {
		lblPic.setIcon(new ImageIcon(new ImageIcon(mberImg).getImage().getScaledInstance((int) picDimension.getWidth(),
				(int) picDimension.getHeight(), Image.SCALE_DEFAULT)));
	}

	private void setStr(String imgPath) {
		picPath = imgPath;
		lblPic.setIcon(new ImageIcon(new ImageIcon(imgPath).getImage().getScaledInstance((int) picDimension.getWidth(),
				(int) picDimension.getHeight(), Image.SCALE_DEFAULT)));
	}

	public void setItem(Member item) {
		zipCode = item.getMberZip();
		tfID.setText(item.getMberId());
		tfName.setText(item.getMberName());
		tfBirthday.setDate(item.getMberBrthdy());
		tfTel.setText(item.getMberTel());
		tfAd.setText(String.format("(%d) %s %s", item.getMberZip().getZipCode(), item.getMberBassAd(),
				item.getMberDetailAd()));
		
		if(item.getGrade().getGradeNo() == 1) {
			tfGrade.setText("일반");
		} else if(item.getGrade().getGradeNo() == 2) {
			tfGrade.setText("우수");
		}
		
		if (item.getMberImg() == null || item.getMberImg().length == 0){
			setStr(defaultImg);
		} else {
			setByte(item.getMberImg());
		}
	}

	
	
	public void validCheck() {
		if (tfID.getText().contentEquals("") || tfName.getText().contentEquals("")
				|| tfTel.getText().contentEquals("") || tfAd.getText().contentEquals("")) {
			throw new InvalidCheckException();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnZip) {
			btnZipActionPerformed(e);
		}
		if (e.getSource() == btnPic) {
			btnPicActionPerformed(e);
		}
		if (e.getSource() == btnUpdate) {
			btnUpdateActionPerformed(e);
		}
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
	}

	protected void btnCancelActionPerformed(ActionEvent e) {
		dispose();
	}

	protected void btnUpdateActionPerformed(ActionEvent e) {
		try {
			Member upMember = getItem();
			service.updateCountMember(upMember);
			JOptionPane.showMessageDialog(null, String.format("[  %s ] 님의 정보가 수정 되었습니다.",upMember.getMberName()));
			dispose();
		} catch (InvalidCheckException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private Member getItem() {
		validCheck();
		String mberId = tfID.getText().trim();
		String mberName = tfName.getText().trim();
		Date mberBrthdy = tfBirthday.getDate();
		String mberTel = tfTel.getText().trim();
		byte[] mberImg = getImage();
		Grade gradeName = new Grade(tfGrade.getText().trim());
		Grade grade = new Grade(gradeName.getGradeName().equals("일반")? 1 : 2);
		ZipCode zip = null;
		String mberBassAd = null;
		String mberDetailAd = null;
		
		if(zipDialog.getTfZipCode().getText().equals("")) {
			//우편번호 검색 안했을 경우
			int zipcode = Integer.parseInt(tfAd.getText().substring(tfAd.getText().indexOf("(")+1, tfAd.getText().indexOf(")")));
			zip = new ZipCode(zipcode);
			mberBassAd = tfAd.getText().substring(tfAd.getText().indexOf(" ")+1, tfAd.getText().lastIndexOf(" "));
			//mberDetailAd = zipDialog.getDetailAd().trim();
			mberDetailAd =tfAd.getText().substring(tfAd.getText().lastIndexOf(" "),tfAd.getText().length()-1);
		}
		else {
			//우편번호 검색했을 경우
			zip = new ZipCode(Integer.parseInt(zipDialog.getTfZipCode().getText().trim()));
			mberBassAd = zipDialog.getAddrFull().trim();
			mberDetailAd = zipDialog.getDetailAd().trim();
		}
		return new Member(mberId, mberName, mberBrthdy, zip, mberBassAd, mberDetailAd, mberTel, mberImg, grade);
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
		setStr(picPath);
		
	}
	protected void btnZipActionPerformed(ActionEvent e) {
		zipDialog.getBtnAdd().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				zipDialog.setDetailAd(zipDialog.getTfDetailAd().getText());
				zipDialog.setZipCode(zipDialog.getTfZipCode().getText());
				tfAd.setText("(" + zipDialog.getZipCode() + ")"+" "+ zipDialog.getAddrFull() +" "+ zipDialog.getDetailAd());
				zipDialog.dispose();
			}
		});
		zipDialog.setBounds(100, 100, 500, 500);
		zipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		zipDialog.setVisible(true);
	}
}
