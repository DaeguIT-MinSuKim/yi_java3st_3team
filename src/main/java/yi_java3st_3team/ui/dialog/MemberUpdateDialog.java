package yi_java3st_3team.ui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import yi_java3st_3team.dto.LargeClassification;
import yi_java3st_3team.dto.Member;
import yi_java3st_3team.ui.service.BookUiService;
import yi_java3st_3team.ui.service.MemberUIService;

@SuppressWarnings("serial")
public class MemberUpdateDialog extends JDialog implements ActionListener {

	
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
	private JComboBox<Grade> cmbGrade;
	private String defaultImg = getClass().getClassLoader().getResource("no-image.png").getPath();
	private JButton btnPic;
	private MemberUIService service;

//	public static void main(String[] args) {
//		try {
//			MemberUpdateDialog dialog = new MemberUpdateDialog(frame, "실험");
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public MemberUpdateDialog(JFrame frame, String title) {
		super(frame, title, true);
		setBounds(100, 100, 454, 430);
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
			
			
				JButton btnZip = new JButton("검색");
				pUpdate.add(btnZip);
			
			
				JLabel lblGrade = new JLabel("등급");
				lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
				pUpdate.add(lblGrade);
			
			
				cmbGrade = new JComboBox();
				pUpdate.add(cmbGrade);
			
		
		
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
				btnUpdate.addActionListener(this);
				btnUpdate.setActionCommand("OK");
				buttonPane.add(btnUpdate);
				getRootPane().setDefaultButton(btnUpdate);
			
			
				btnCancel = new JButton("  취소  ");
				btnCancel.addActionListener(this);
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			
				setService(service);
	}

	private void setService(MemberUIService service) {
		this.service = service;
		setCmbList(service.showGradeList());
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
		tfID.setText(item.getMberId());
		tfName.setText(item.getMberName());
		tfBirthday.setDate(item.getMberBrthdy());
		tfTel.setText(item.getMberTel());
		tfAd.setText(String.format("(%d) %s %s",item.getMberZip().getZipCode(),item.getMberBassAd(),item.getMberDetailAd()));
		cmbGrade.setSelectedItem(item.getGrade().getGradeName());
		
		if(item.getMberImg() ==null || item.getMberImg().length == 0) {
			setStr(defaultImg);
		}else {
			setByte(item.getMberImg());
			setStr(item.getMberImg().toString());
		}
		
	}
	
	public void setCmbList(List<Grade> gradeList){
		DefaultComboBoxModel<Grade> model = new DefaultComboBoxModel<Grade>(new Vector<>(gradeList));
		cmbGrade.setModel(model);
		cmbGrade.setSelectedIndex(-1);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
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
}
