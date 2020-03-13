package yi_java3st_3team.ui.dialog;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import yi_java3st_3team.dto.ZipCode;
import yi_java3st_3team.ui.content.MemberJoinPanel;
import yi_java3st_3team.ui.service.MemberUIService;
import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class ZipDialog extends JDialog implements ActionListener  {
	private JTextField tfCtprvn;
	private JTextField tfSigngu;
	private JTextField tfRoadName;
	private JTextField tfBuldOrigin;
	private JTextField tfBuldVice;
	private JTextField tfZipCode;
	private JTextField tfAd;
	private JTextField tfDetailAd;
	private JButton btnCheck;
	private JPanel pCheck;
	private JPanel pResult;
	private ZipCode zip;
	private MemberUIService service;
	private JPanel pAdd;
	private JLabel label;
	private JButton btnAdd;
	private JLabel label_1;
	private JLabel label_2;
	private String addrFull;
	private String DetailAd;
	private String zipCode;

	public ZipDialog(JFrame member,String title) {
		super(member, title, true);
		service = new MemberUIService();
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		pCheck = new JPanel();
		getContentPane().add(pCheck);
		pCheck.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblCtprvn = new JLabel("도");
		lblCtprvn.setHorizontalAlignment(SwingConstants.CENTER);
		pCheck.add(lblCtprvn);
		
		tfCtprvn = new JTextField();
		pCheck.add(tfCtprvn);
		tfCtprvn.setColumns(10);
		
		JLabel lblSigngu = new JLabel("시");
		lblSigngu.setHorizontalAlignment(SwingConstants.CENTER);
		pCheck.add(lblSigngu);
		
		tfSigngu = new JTextField();
		pCheck.add(tfSigngu);
		tfSigngu.setColumns(10);
		
		JLabel lblRoadName = new JLabel("도로명");
		lblRoadName.setHorizontalAlignment(SwingConstants.CENTER);
		pCheck.add(lblRoadName);
		
		tfRoadName = new JTextField();
		pCheck.add(tfRoadName);
		tfRoadName.setColumns(10);
		
		JLabel lblBuldOrigin = new JLabel("건물본번");
		lblBuldOrigin.setHorizontalAlignment(SwingConstants.CENTER);
		pCheck.add(lblBuldOrigin);
		
		tfBuldOrigin = new JTextField();
		pCheck.add(tfBuldOrigin);
		tfBuldOrigin.setColumns(10);
		
		JLabel lblBuldVice = new JLabel("건물부번");
		lblBuldVice.setHorizontalAlignment(SwingConstants.CENTER);
		pCheck.add(lblBuldVice);
		
		tfBuldVice = new JTextField();
		pCheck.add(tfBuldVice);
		tfBuldVice.setColumns(10);
		
		JLabel lblAir = new JLabel("");
		pCheck.add(lblAir);
		
		btnCheck = new JButton("검색");
		btnCheck.addActionListener(this);
		pCheck.add(btnCheck);
		
		JPanel panel = new JPanel();
		pCheck.add(panel);
		
		pResult = new JPanel();
		getContentPane().add(pResult);
		pResult.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblZipCode = new JLabel("우편번호");
		lblZipCode.setHorizontalAlignment(SwingConstants.CENTER);
		pResult.add(lblZipCode);
		
		tfZipCode = new JTextField();
		pResult.add(tfZipCode);
		tfZipCode.setColumns(10);
		
		JLabel lblAd = new JLabel("기본주소");
		lblAd.setHorizontalAlignment(SwingConstants.CENTER);
		pResult.add(lblAd);
		
		tfAd = new JTextField();
		pResult.add(tfAd);
		tfAd.setColumns(10);
		
		JLabel lblDetailAd = new JLabel("상세주소");
		lblDetailAd.setHorizontalAlignment(SwingConstants.CENTER);
		pResult.add(lblDetailAd);
		
		tfDetailAd = new JTextField();
		pResult.add(tfDetailAd);
		tfDetailAd.setColumns(10);
		
		label_2 = new JLabel("");
		pResult.add(label_2);
		
		pAdd = new JPanel();
		pResult.add(pAdd);
		pAdd.setLayout(new GridLayout(0, 3, 0, 0));
		
		label_1 = new JLabel("");
		pAdd.add(label_1);
		
		btnAdd = new JButton("등록");
		pAdd.add(btnAdd);
		
		label = new JLabel("");
		pAdd.add(label);
	}
	
	
//	private void validCheck() {
//		if(tfCtprvn.getText().equals("") || tfSigngu.getText().equals("") || tfRoadName.getText().equals("") || tfBuldOrigin.getText().equals("")){
//			throw new InvalidCheckException();
//		}
//	}
	
	public String getAddrFull() {
		return addrFull;
	}

//	public void setAddrFull(String addrFull) {
//		this.addrFull = addrFull;
//	}
	public String getDetailAd() {
		return DetailAd;
	}

	public String getZipCode() {
		return zipCode;
	}


	public JTextField getTfZipCode() {
		return tfZipCode;
	}


	public void setTfZipCode(JTextField tfZipCode) {
		this.tfZipCode = tfZipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public void setDetailAd(String detailAd) {
		DetailAd = detailAd;
	}
	
	public JButton getBtnAdd() {
		return btnAdd;
	}
	
	public JTextField getTfDetailAd() {
		return tfDetailAd;
	}

	public ZipCode getItem() {
		String ctprvn = tfCtprvn.getText().trim();
		String signgu = tfSigngu.getText().trim();
		String roadName = tfRoadName.getText().trim();
		int buldNoOriginNo = Integer.parseInt(tfBuldOrigin.getText());
		int buldNoViceNo = Integer.parseInt(tfDetailAd.getText());
		return new ZipCode(ctprvn, signgu, roadName, buldNoOriginNo, buldNoViceNo);
	}

	
	public void setItem(ZipCode item) {
		tfCtprvn.setText(item.getCtprvn());
		tfSigngu.setText(item.getSigngu());
		tfRoadName.setText(item.getRoadName());
		tfBuldOrigin.setText(item.getBuldNoOriginNo()+"");
		tfBuldVice.setText(item.getBuldNoViceNo()+"");
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCheck) {
			btnCheckActionPerformed(e);
		}
	}

	protected void btnCheckActionPerformed(ActionEvent e) {
		String ctprvn = tfCtprvn.getText().trim();
		String signgu = tfSigngu.getText().trim();
		String roadName = tfRoadName.getText().trim();
		int buldNoOriginNo = Integer.parseInt(tfBuldOrigin.getText().trim());
		int buldNoViceNo = Integer.parseInt(tfBuldVice.getText().trim());
		ZipCode zipCode = new ZipCode(ctprvn, signgu, roadName, buldNoOriginNo, buldNoViceNo);
		zip = service.zipCodeCheck(zipCode);
		 if(zip != null) {
			 tfZipCode.setText(zip.getZipCode() +"");
			StringBuilder addr = new StringBuilder();
			 addr.append(zip.getCtprvn()+" ");
			 addr.append(zip.getSigngu()+" ");
			 addr.append(zip.getRoadName()+" ");
			 addr.append(zip.getBuldNoOriginNo()+"-");
			 addr.append(zip.getBuldNoViceNo()+" ");
			 addrFull = addr.toString();
			 tfAd.setText(addrFull);
		 }else {
			 JOptionPane.showMessageDialog(null, "우편 번호를 찾을 수 없습니다");
		 }
	}

}
