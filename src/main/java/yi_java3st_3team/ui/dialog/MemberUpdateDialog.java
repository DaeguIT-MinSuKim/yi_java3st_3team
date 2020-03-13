package yi_java3st_3team.ui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class MemberUpdateDialog extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCancel;
	private JTextField tfID;
	private JTextField tfName;
	private JTextField textField_2;
	private JDateChooser tfBirthday;
	private JTextField tfTel;
	private JTextField tfAd;
	private JLabel lblPic;
	private Dimension picDimension = new Dimension(100, 150);
	private String picPath;

	public static void main(String[] args) {
		try {
			MemberUpdateDialog dialog = new MemberUpdateDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MemberUpdateDialog() {
		setBounds(100, 100, 454, 430);
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setHgap(10);
		borderLayout.setVgap(10);
		getContentPane().setLayout(borderLayout);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 10, 0));
		{
			JPanel pUpdate = new JPanel();
			contentPanel.add(pUpdate);
			pUpdate.setLayout(new GridLayout(0, 2, 0, 10));
			{
				JLabel lblID = new JLabel("ID");
				lblID.setHorizontalAlignment(SwingConstants.CENTER);
				pUpdate.add(lblID);
			}
			{
				tfID = new JTextField();
				pUpdate.add(tfID);
				tfID.setColumns(10);
			}
			{
				JLabel lblName = new JLabel("이름");
				lblName.setHorizontalAlignment(SwingConstants.CENTER);
				pUpdate.add(lblName);
			}
			{
				tfName = new JTextField();
				pUpdate.add(tfName);
				tfName.setColumns(10);
			}
			{
				JLabel lbl = new JLabel("비밀번호");
				lbl.setHorizontalAlignment(SwingConstants.CENTER);
				pUpdate.add(lbl);
			}
			{
				textField_2 = new JTextField();
				pUpdate.add(textField_2);
				textField_2.setColumns(10);
			}
			{
				JLabel lblBirthday = new JLabel("생년월일");
				lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
				pUpdate.add(lblBirthday);
			}
			{
				tfBirthday = new JDateChooser(new Date(), "yyyy-MM-dd");
				pUpdate.add(tfBirthday);
			}
			{
				JLabel lblTel = new JLabel("전화번호");
				lblTel.setHorizontalAlignment(SwingConstants.CENTER);
				pUpdate.add(lblTel);
			}
			{
				tfTel = new JTextField();
				pUpdate.add(tfTel);
				tfTel.setColumns(10);
			}
			{
				JLabel lblAd = new JLabel("주소");
				lblAd.setHorizontalAlignment(SwingConstants.CENTER);
				pUpdate.add(lblAd);
			}
			{
				tfAd = new JTextField();
				pUpdate.add(tfAd);
				tfAd.setColumns(10);
			}
			{
				JLabel lblAir = new JLabel("");
				pUpdate.add(lblAir);
			}
			{
				JButton btnZip = new JButton("검색");
				pUpdate.add(btnZip);
			}
			{
				JLabel lblGrade = new JLabel("등급");
				lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
				pUpdate.add(lblGrade);
			}
			{
				JComboBox cmbGrade = new JComboBox();
				cmbGrade.setModel(new DefaultComboBoxModel(new String[] {"일반", "우수"}));
				pUpdate.add(cmbGrade);
			}
		}
		{
			JPanel pImage = new JPanel();
			contentPanel.add(pImage);
			pImage.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JPanel pImg = new JPanel();
				pImage.add(pImg);
				pImg.setLayout(new GridLayout(0, 1, 0, 10));
				{
					lblPic = new JLabel();
					lblPic.setHorizontalAlignment(SwingConstants.CENTER);
					lblPic.setPreferredSize(new Dimension(100, 150));
					lblPic.setSize(new Dimension(100, 150));
					setPic(getClass().getClassLoader().getResource("no-image.png").getPath());
					pImg.add(lblPic);
				}
				{
					JPanel pBtn = new JPanel();
					pImg.add(pBtn);
					{
						JButton btnPic = new JButton("  회원 이미지  ");
						pBtn.add(btnPic);
					}
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnUpdate = new JButton("수정");
				btnUpdate.setActionCommand("OK");
				buttonPane.add(btnUpdate);
				getRootPane().setDefaultButton(btnUpdate);
			}
			{
				btnCancel = new JButton("취소");
				btnCancel.addActionListener(this);
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
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
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		dispose();
	}
}
