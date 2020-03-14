package yi_java3st_3team.ui.content;

import yi_java3st_3team.dto.PublishingCompany;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

import com.sun.javafx.logging.PulseLogger;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import yi_java3st_3team.ui.exception.InvalidCheckException;
import yi_java3st_3team.ui.list.BookPlsTblPanel;
import yi_java3st_3team.ui.service.PublishingCompanyUiService;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class BookPlsManageMentPanel extends AbsItemPanel<PublishingCompany> implements ActionListener {
	private JTextField tfCode;
	private JTextField tfName;
	private PublishingCompanyUiService service;
	private BookPlsTblPanel pPlsList;
	private JButton btnCancel;
	private JButton btnAdd;

	public BookPlsManageMentPanel() {
		service = new PublishingCompanyUiService();
		initialize();
	}

	private void initialize() {
		setLayout(new GridLayout(0, 2, 0, 0));

		JPanel pContent = new JPanel();
		pContent.setBackground(Color.WHITE);
		add(pContent);
		pContent.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("");
		pContent.add(lblNewLabel);

		JPanel pPlsCon = new JPanel();
		pPlsCon.setBackground(Color.WHITE);
		pContent.add(pPlsCon);
		pPlsCon.setLayout(new BorderLayout(0, 0));

		pInputs = new JPanel();
		pInputs.setBorder(new EmptyBorder(50, 50, 50, 50));
		pInputs.setBackground(Color.WHITE);
		pPlsCon.add(pInputs, BorderLayout.CENTER);
		pInputs.setLayout(new GridLayout(0, 2, 0, 15));

		JLabel lblCode = new JLabel("출판사 코드");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblCode.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		pInputs.add(lblCode);

		tfCode = new JTextField();
		tfCode.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		tfCode.setEditable(false);
		tfCode.setColumns(10);
		pInputs.add(tfCode);

		JLabel lblName = new JLabel("출판사 이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		pInputs.add(lblName);

		tfName = new JTextField();
		tfName.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		tfName.setColumns(10);
		pInputs.add(tfName);

		JPanel pBtns = new JPanel();
		pBtns.setBackground(Color.WHITE);
		pPlsCon.add(pBtns, BorderLayout.SOUTH);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pBtns.add(btnCancel);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setPreferredSize(new Dimension(10, 0));
		pBtns.add(lblNewLabel_2);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		btnAdd.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pBtns.add(btnAdd);

		JLabel lblNewLabel_1 = new JLabel("");
		pContent.add(lblNewLabel_1);

		JPanel pList = new JPanel();
		pList.setBorder(new EmptyBorder(20, 20, 20, 20));
		pList.setBackground(Color.WHITE);
		add(pList);
		pList.setLayout(new BorderLayout(0, 0));

		pPlsList = new BookPlsTblPanel();
		pPlsList.loadData(service.showPlsListAll());
		pPlsList.setPopupMenu(createPopupMenu());
		pList.add(pPlsList, BorderLayout.CENTER);
		
		setService(service);
	}

	public void setService(PublishingCompanyUiService service) {
		this.service = service;
		tfCode.setText((service.getLastCode()+1)+"");
	}
	
	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(myPopupMenuListener);
		popMenu.add(updateItem);
		
		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(myPopupMenuListener);
		popMenu.add(deleteItem);
		
		return popMenu;
	}
	
	ActionListener myPopupMenuListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if(e.getActionCommand().contentEquals("수정")) {
					PublishingCompany upDate = pPlsList.getSelectedItem();
					setItem(upDate);
					btnAdd.setText("수정");
				}
				
				if(e.getActionCommand().contentEquals("삭제")) {
					PublishingCompany deletePls = pPlsList.getSelectedItem();
					int result = JOptionPane.showConfirmDialog(null, "선택된 정보를 삭제하겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
					
					if(result == JOptionPane.CLOSED_OPTION) {
					} else if (result == JOptionPane.YES_OPTION) {
						service.removePls(deletePls);
						pPlsList.removeRow();
						pPlsList.loadData(service.showPlsListAll());
						JOptionPane.showMessageDialog(null, "삭제되었습니다");
					} else {
					}
					
				}
			} catch (RuntimeException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
			
		}
	};
	private JPanel pInputs;

	@Override
	public PublishingCompany getItem() {
		int plsNo = Integer.parseInt(tfCode.getText());
		String plsName = tfName.getText();
		return new PublishingCompany(plsNo, plsName);
	}

	@Override
	public void setItem(PublishingCompany item) {
		tfCode.setText(item.getPlsNo() + "");
		tfName.setText(item.getPlsName());
	}

	@Override
	public void clearTf() {
		tfCode.setText("");
		tfName.setText("");
	}

	@Override
	public void validCheck() {
		if (tfCode.getText().contentEquals("") || tfName.getText().contentEquals("")) {
			throw new InvalidCheckException();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			if(e.getActionCommand().contentEquals("수정")) {
				btnUpdateActionPerFormed(e);
			} else {				
				btnAddActionPerformed(e);
			}
		}
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
	}

	private void btnUpdateActionPerFormed(ActionEvent e) {
		PublishingCompany newPls = getItem();
		service.modifyPls(newPls);
		pPlsList.updateRow(newPls, pPlsList.getSelectedRowIdx());
		btnAdd.setText("추가");
		clearTf();
		setService(service);
		pPlsList.loadData(service.showPlsListAll());
		JOptionPane.showMessageDialog(null, "수정되었습니다.");
	}
	
	protected void btnAddActionPerformed(ActionEvent e) {
		try {
			PublishingCompany newPls = getItem();
			service.addPls(newPls);
			pPlsList.addItem(newPls);
			clearTf();
			pPlsList.loadData(service.showPlsListAll());
			setService(service);
			JOptionPane.showMessageDialog(null, "추가되었습니다.");
		} catch (InvalidCheckException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (Exception e1) {
			SQLException e2 = (SQLException) e1;
			if(e2.getErrorCode() == 1062) {
				JOptionPane.showMessageDialog(null, "코드 중복");
				System.err.println(e2.getMessage());
				return;
			} 
			e1.printStackTrace();
		}
	}

	protected void btnCancelActionPerformed(ActionEvent e) {
		clearTf();
		setService(service);
		btnAdd.setText("추가");
	}
}
