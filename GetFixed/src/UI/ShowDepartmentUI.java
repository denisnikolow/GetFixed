package UI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Control.CtrCustomer;
import Control.CtrDepartment;
import Control.CtrDepartment;
import Control.CtrFunctionality;
import Control.CtrOrder;
import Control.CtrProduct;
import Control.CtrSale;
import Control.CtrService;
import Model.Department;


public class ShowDepartmentUI {
	private JTable table;
	private JPanel contentPanel;
	private JTextField txtSearch;
	private JButton btnShowDepartment;
	CtrProduct productCtr = new CtrProduct();
	CtrDepartment departmentCtr = new CtrDepartment();
	CtrCustomer customerCtr = new CtrCustomer();
	CtrService serviceCtr = new CtrService();
	CtrFunctionality functionalityCtr = new CtrFunctionality();
	CtrSale saleCtr = new CtrSale();
	CtrOrder orderCtr = new CtrOrder();
	ArrayList<String> saleID = new ArrayList<>();
	protected Department department;
	
	ShowDepartmentUI(JPanel contentPanel, JButton btnShowDepartment){
		this.contentPanel = contentPanel;
			this.btnShowDepartment = btnShowDepartment;
	}
	
	
	void make(){
		contentPanel.removeAll();

		functionalityCtr.removeAllIds();
		functionalityCtr.removeAllClicks();

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null,
						null, null, null, null } },
				new String[] { "ID", "Name",
						"Address",  "Location", "Telephone", "E-mail",
						 }) {
			Class[] columnTypes = new Class[] { Integer.class,
					String.class, String.class, String.class,
					String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] canEdit = new boolean[] { false, true,
					true, true, true, true, true, true };

			public boolean isCellEditable(int rowIndex,
					int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		table.setBounds(10, 27, 588, 195);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 52, 818, 300);
		table.setFillsViewportHeight(true);
		contentPanel.add(scrollPane);
		DefaultTableModel model = (DefaultTableModel) table
				.getModel();

		JButton btnRemove = new JButton("Remove row");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] rows = table.getSelectedRows();
				for (int index = 0; index < rows.length; index++) {
					model.removeRow(rows[index] - index);
				}
			}
		});
		btnRemove.setBounds(720, 11, 105, 23);
		contentPanel.add(btnRemove);

		model.removeRow(0);

		for (Object[] object : departmentCtr.addAllDepartments()) {
			model.addRow(object);
		}
		

		
		txtSearch = new JTextField();
		txtSearch.setBounds(15, 11, 86, 25);
		contentPanel.add(txtSearch);
		txtSearch.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(111, 11, 89, 25);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				functionalityCtr.addClick();
				String search = txtSearch.getText();
				boolean flag = false;
				try {
					Integer.parseInt(search);
					flag = true;
				} catch (Exception e2) {
				}

				if (functionalityCtr.getClicks() <= 1) {
					int rowCount = model.getRowCount();
					for (int i = rowCount - 1; i >= 0; i--) {
						model.removeRow(i);
					}
				}

				if (flag) {
					model.addRow(departmentCtr
							.addDepartmentById(Integer
									.parseInt(search)));
				} else {
					model.addRow(departmentCtr
							.addDepartmentByName(search));
				}

				txtSearch.setText("");
			}
		});
		contentPanel.add(btnSearch);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] vals = table.getSelectedRows();
				for (int i : vals) {
					ArrayList<String> values = new ArrayList<>();
					for (int x = 0; x < table.getColumnCount(); x++) {
						values.add(table.getValueAt(i, x)
								.toString());

					}
					departmentCtr.updateDepartment(
							Integer.parseInt(values.get(0)),
							values.get(1), values.get(2),
							values.get(3), values.get(4),
							values.get(5));
				}
			}
		});
		btnUpdate.setBounds(639, 380, 89, 23);
		contentPanel.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int[] vals = table.getSelectedRows();
				boolean flag = true;
				for (int i : vals) {

					try {
						Department department = departmentCtr
								.findById(Integer
										.parseInt(table
												.getValueAt(i,
														0)
												.toString()));
						int id = department.getId();
						departmentCtr.deleteDepartment(id);
					} catch (Exception e1) {
						e1.printStackTrace();
						flag = false;
					}

				}
				btnShowDepartment.doClick();
			}

		});
		btnDelete.setBounds(739, 380, 89, 23);
		contentPanel.add(btnDelete);

		contentPanel.invalidate();
		contentPanel.revalidate();
		contentPanel.repaint();
		contentPanel.setVisible(true);

	}
}