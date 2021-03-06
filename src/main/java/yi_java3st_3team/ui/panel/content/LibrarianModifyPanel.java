package yi_java3st_3team.ui.panel.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
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
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import yi_java3st_3team.dto.Grade;
import yi_java3st_3team.dto.Librarian;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.dto.Title;
import yi_java3st_3team.dto.ZipCode;
import yi_java3st_3team.ui.dialog.ZipDialog;
import yi_java3st_3team.ui.exception.InvalidCheckException;
import yi_java3st_3team.ui.listener.MyDocumentListener;
import yi_java3st_3team.ui.panel.AbsItemPanel;
import yi_java3st_3team.ui.service.LibrarianService;

@SuppressWarnings("serial")
public class LibrarianModifyPanel extends AbsItemPanel<Librarian> implements ActionListener {
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
	private JButton btnPic;
	private Dimension picDimension = new Dimension(100, 150);
	private JLabel lblPWCheck;
	private JTextField tfID;
	private JButton btnZip;
	private ZipDialog zipDialog;
	private JFrame member;

	public LibrarianModifyPanel() {
		setLayout(new BorderLayout(0, 0));

		JPanel pEast = new JPanel();
		pEast.setBackground(Color.WHITE);
		add(pEast, BorderLayout.EAST);
		pEast.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel pLeft = new JPanel();
		pLeft.setBackground(Color.WHITE);
		pEast.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		JPanel pContent = new JPanel();
		pContent.setBackground(Color.WHITE);
		pEast.add(pContent);
		
		lblPic = new JLabel();
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPic.setPreferredSize(new Dimension(100, 150));
		lblPic.setSize(new Dimension(100, 150));
		setPic(getClass().getClassLoader().getResource("no-image.png").getPath());
		pContent.setLayout(new GridLayout(0, 1, 0, -30));
		pContent.add(lblPic);
		
		JPanel pBtn = new JPanel();
		pBtn.setBackground(Color.WHITE);
		pContent.add(pBtn);
		
		btnPic = new JButton("증명사진");
		btnPic.addActionListener(this);
		pBtn.setLayout(new BorderLayout(0, 0));
		pBtn.add(btnPic, BorderLayout.NORTH);
		
		JPanel pRight = new JPanel();
		pRight.setBackground(Color.WHITE);
		pEast.add(pRight);

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
		pID.setLayout(new GridLayout(0, 1, 20, 0));
		
		tfID = new JTextField();
		tfID.setForeground(Color.GRAY);
		tfID.setColumns(10);
		tfID.setEditable(false);
		tfID.setText("이메일 입력");
		tfID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tfID.getText().equals("이메일 입력")) {
					tfID.setText("");
					tfID.setForeground(Color.BLACK);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(tfID.getText().equals("")) {
					tfID.setText("이메일 입력");
					tfID.setForeground(Color.GRAY);
				}
			}
		});
		pID.add(tfID);

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
		tfTel.setText("앞자리를 포함하여 하이픈(-)을 입력하여 주세요.");
		tfTel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tfTel.getText().equals("앞자리를 포함하여 하이픈(-)을 입력하여 주세요.")) {
					tfTel.setText("");
					tfTel.setForeground(Color.BLACK);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(tfTel.getText().equals("")) {
					tfTel.setText("앞자리를 포함하여 하이픈(-)을 입력하여 주세요.");
					tfTel.setForeground(Color.GRAY);
				}
			}
		});
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
		//tfZip.setText("");
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

	private void setPic(String imgPath) {
		picPath = imgPath;
		lblPic.setIcon(new ImageIcon(new ImageIcon(imgPath).getImage().getScaledInstance((int) picDimension.getWidth(),
				(int) picDimension.getHeight(), Image.SCALE_DEFAULT)));
	}
	
	@Override
	public Librarian getItem() {
		validCheck();
		String lbId = tfID.getText().trim();
		String lbPass = new String(pfPW1.getPassword());
		String lbName = tfName.getText().trim();
		Date lbBirthDay = tfBirthday.getDate();
		ZipCode lbZip = new ZipCode(Integer.parseInt(tfZip.getText()));
		String lbBassAd = tfAddress.getText().trim();
		String lbDetailAd = tfDetailAdress.getText().trim();
		String lbTel = tfTel.getText().trim();
		byte[] lbImg = getImage();
		return new Librarian(lbId, lbPass, lbName, lbBirthDay, lbZip, lbBassAd, lbDetailAd, lbTel, lbImg);
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
		if(tfID.getText().equals("") || pfPW1.getPassword().equals("") || tfName.getText().equals("") || tfZip.getText().equals("") 
				|| tfAddress.getText().equals("") || tfTel.getText().equals("") || tfBirthday.getDate()==new Date()){
					throw new InvalidCheckException();
				}
	}

	@Override
	public void setItem(Librarian item) {
		tfID.setText(item.getLbId());
		pfPW1.setText("");
		pfPW2.setText("");
		tfName.setText(item.getLbName());
		tfBirthday.setDate(item.getLbBirthDay());
		tfZip.setText(item.getLbZip().getZipCode() + "");
		tfAddress.setText(item.getLbBassAd());
		tfDetailAdress.setText(item.getLbDetailAd());
		tfTel.setText(item.getLbTel());
		if (item.getLbImg() == null) {
			setPic(getClass().getClassLoader().getResource("no-image.png").getPath());
		} else {
			setPic(item.getLbImg());
		}
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
		setPic(getClass().getClassLoader().getResource("no-image.png").getPath());
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnPic) {
			btnPicAction(e);
		}
		if(e.getSource() == btnZip) {
			btnZipAction(e);
		}
	}

	private void btnZipAction(ActionEvent e) {
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

	private void btnPicAction(ActionEvent e) {
		JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG or PNG or GIF", "jpg", "png", "gif");
		chooser.setFileFilter(filter);

		int res = chooser.showOpenDialog(null);
		if (res != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "사진을 선택하지 않으셨습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		picPath = chooser.getSelectedFile().getPath();
		setPic(picPath);
	}

	public void setPicImageIcon(ImageIcon icon) {
		lblPic.setIcon(new ImageIcon(icon.getImage().getScaledInstance((int) picDimension.getWidth(),
				(int) picDimension.getHeight(), Image.SCALE_DEFAULT)));
	}
}
