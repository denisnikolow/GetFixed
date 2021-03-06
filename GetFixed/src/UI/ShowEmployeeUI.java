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
import Control.CtrEmployee;
import Control.CtrFunctionality;
import Control.CtrOrder;
import Control.CtrProduct;
import Control.CtrSale;
import Control.CtrService;
import Control.CtrSupplier;
import Model.Department;
import Model.Employee;

public class ShowEmployeeUI {
	private JTable table;
	private JPanel contentPanel;
	private JPanel secondaryMenuPanel;
	private JTextField txtSearch;
	private JButton btnShowEmployee;
	CtrDepartment departmentCtr = new CtrDepartment();
	CtrEmployee employeeCtr = new CtrEmployee();
	CtrFunctionality functionalityCtr = new CtrFunctionality();
	protected Department department;

	ShowEmployeeUI(JPanel contentPanel, JPanel secondaryMenuPanel, JButton btnShowEmployee) {
		this.contentPanel = contentPanel;
		this.secondaryMenuPanel = secondaryMenuPanel;
		this.btnShowEmployee = btnShowEmployee;
	}

	void make() {
		contentPanel.removeAll();

		functionalityCtr.removeAllIds();
		functionalityCtr.removeAllClicks();

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null } },
				new String[] { "ID", "Name", "Surname", "Address", "Telephone", "E-mail", "Password", "Department" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class, String.class,
					String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] canEdit = new boolean[] { false, true, true, true, true, true, true, true };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		table.setBounds(10, 27, 588, 195);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 52, 818 + functionalityCtr.getAddWidth(), 300);
		table.setFillsViewportHeight(true);
		contentPanel.add(scrollPane);
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		JButton btnRemove = new JButton("Remove row");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] rows = table.getSelectedRows();
				for (int index = 0; index < rows.length; index++) {
					model.removeRow(rows[index] - index);
				}
			}
		});
		btnRemove.setBounds(720 + functionalityCtr.getAddWidth(), 11, 105, 23);
		contentPanel.add(btnRemove);

		model.removeRow(0);

		for (Object[] object : employeeCtr.addAllEmployees()) {
			model.addRow(object);
		}

		JRadioButton rdbtnAalborg = new JRadioButton("Aalborg");
		rdbtnAalborg.setBounds(222, 11, 109, 23);
		rdbtnAalborg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				department = departmentCtr.findByName(rdbtnAalborg.getText());
				int departmentId = department.getId();

				if (rdbtnAalborg.isSelected()) {
					functionalityCtr.addId(departmentId);
					functionalityCtr.addClick();

					if (functionalityCtr.getClicks() <= 1) {
						model.getDataVector().removeAllElements();
						model.fireTableDataChanged();
					}

					for (Object[] object : employeeCtr.addAllEmployeesForDepartment(departmentId)) {
						model.addRow(object);
					}
				} else {
					functionalityCtr.removeId(departmentId);
					for (int rows = 0; rows < table.getRowCount(); rows++) {
						ArrayList<String> values = new ArrayList<>();
						for (int columns = 0; columns < table.getColumnCount(); columns++) {
							values.add(table.getValueAt(rows, columns).toString());
						}
						String departmentName = values.get(7);
						values.clear();
						if (departmentName.equals(rdbtnAalborg.getText())) {
							model.removeRow(rows);
							rows--;
						}
					}
				}
			}
		});
		contentPanel.add(rdbtnAalborg);

		JRadioButton rdbtnAarhus = new JRadioButton("Aarhus");
		rdbtnAarhus.setBounds(333, 11, 109, 23);
		rdbtnAarhus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				department = departmentCtr.findByName(rdbtnAarhus.getText());
				int departmentId = department.getId();

				if (rdbtnAarhus.isSelected()) {
					functionalityCtr.addId(departmentId);
					functionalityCtr.addClick();

					if (functionalityCtr.getClicks() <= 1) {
						model.getDataVector().removeAllElements();
						model.fireTableDataChanged();
					}

					for (Object[] object : employeeCtr.addAllEmployeesForDepartment(departmentId)) {
						model.addRow(object);
					}
				} else {
					functionalityCtr.removeId(departmentId);
					for (int rows = 0; rows < table.getRowCount(); rows++) {
						ArrayList<String> values = new ArrayList<>();
						for (int columns = 0; columns < table.getColumnCount(); columns++) {
							values.add(table.getValueAt(rows, columns).toString());
						}
						String departmentName = values.get(7);
						values.clear();
						if (departmentName.equals(rdbtnAarhus.getText())) {
							model.removeRow(rows);
							rows--;
						}
					}
				}
			}
		});
		contentPanel.add(rdbtnAarhus);

		JRadioButton rdbtnOdense = new JRadioButton("Odense");
		rdbtnOdense.setBounds(444, 11, 109, 23);
		rdbtnOdense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				department = departmentCtr.findByName(rdbtnOdense.getText());
				int departmentId = department.getId();

				if (rdbtnOdense.isSelected()) {
					functionalityCtr.addId(departmentId);
					functionalityCtr.addClick();

					if (functionalityCtr.getClicks() <= 1) {
						model.getDataVector().removeAllElements();
						model.fireTableDataChanged();
					}

					for (Object[] object : employeeCtr.addAllEmployeesForDepartment(departmentId)) {
						model.addRow(object);
					}
				} else {
					for (int rows = 0; rows < table.getRowCount(); rows++) {
						ArrayList<String> values = new ArrayList<>();
						for (int columns = 0; columns < table.getColumnCount(); columns++) {
							values.add(table.getValueAt(rows, columns).toString());
						}
						String departmentName = values.get(7);
						values.clear();
						if (departmentName.equals(rdbtnOdense.getText())) {
							model.removeRow(rows);
							rows--;
						}
					}
				}
			}
		});
		contentPanel.add(rdbtnOdense);

		JRadioButton rdbtnCopenhagen = new JRadioButton("Copenhagen");
		rdbtnCopenhagen.setBounds(555, 11, 109, 23);
		rdbtnCopenhagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				department = departmentCtr.findByName(rdbtnCopenhagen.getText());
				int departmentId = department.getId();

				if (rdbtnCopenhagen.isSelected()) {
					functionalityCtr.addId(departmentId);
					functionalityCtr.addClick();

					if (functionalityCtr.getClicks() <= 1) {
						model.getDataVector().removeAllElements();
						model.fireTableDataChanged();
					}

					for (Object[] object : employeeCtr.addAllEmployeesForDepartment(departmentId)) {
						model.addRow(object);
					}
				} else {
					for (int rows = 0; rows < table.getRowCount(); rows++) {
						ArrayList<String> values = new ArrayList<>();
						for (int columns = 0; columns < table.getColumnCount(); columns++) {
							values.add(table.getValueAt(rows, columns).toString());
						}
						String departmentName = values.get(7);
						values.clear();
						if (departmentName.equals(rdbtnCopenhagen.getText())) {
							model.removeRow(rows);
							rows--;
						}
					}
				}
			}
		});
		contentPanel.add(rdbtnCopenhagen);

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
					model.addRow(employeeCtr.addEmployeeById(Integer.parseInt(search)));
				} else {
					model.addRow(employeeCtr.addEmployeeByName(search));
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
						values.add(table.getValueAt(i, x).toString());

					}
					employeeCtr.updateEmployee(Integer.parseInt(values.get(0)), values.get(1), values.get(2),
							values.get(3), values.get(4), values.get(5), values.get(6), values.get(7));
				}
			}
		});
		btnUpdate.setBounds(639 + functionalityCtr.getAddWidth(), 355, 89, 23);
		contentPanel.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int[] vals = table.getSelectedRows();
				boolean flag = true;
				for (int i : vals) {

					try {
						Employee employee = employeeCtr.findById(Integer.parseInt(table.getValueAt(i, 0).toString()));
						int id = employee.getId();
						employeeCtr.deleteEmployee(id);
					} catch (Exception e1) {
						e1.printStackTrace();
						flag = false;
					}

				}
				btnShowEmployee.doClick();
			}

		});
		btnDelete.setBounds(739 + functionalityCtr.getAddWidth(), 355, 89, 23);
		contentPanel.add(btnDelete);

		contentPanel.invalidate();
		contentPanel.revalidate();
		contentPanel.repaint();
		contentPanel.setVisible(true);

	}
}
