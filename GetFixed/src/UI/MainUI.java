package UI;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.*;

import javax.swing.table.*;

import java.util.*;

import Control.*;
import Model.*;

public class MainUI extends JFrame {

	private JPanel contentPane;
	private JPanel mainMenuPanel;
	private JPanel secondaryMenuPanel;
	private JPanel contentPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainUI() {
		setResizable(false);
		setTitle("GetFixed");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 570);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		mainMenuPanel = new JPanel();
		mainMenuPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		mainMenuPanel.setBounds(10, 11, 838, 36);
		contentPane.add(mainMenuPanel);
		mainMenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		contentPanel = new JPanel();
		contentPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		contentPanel.setBounds(10, 105, 838, 414);
		contentPane.add(contentPanel);
		contentPanel.setLayout(null);

		secondaryMenuPanel = new JPanel();
		secondaryMenuPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		secondaryMenuPanel.setBounds(10, 58, 838, 36);
		contentPane.add(secondaryMenuPanel);
		secondaryMenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// ////////////////////////////////////////////////////////
		// ////////////////////////////////////////////////////////
		// /////////////////SALES/////////////////////////////////
		// ///////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////

		JButton btnSales = new JButton("Sales");
		mainMenuPanel.add(btnSales);
		btnSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondaryMenuPanel.removeAll();
				contentPanel.removeAll();

				JButton btnMakeASale = new JButton("Create sale");
				secondaryMenuPanel.add(btnMakeASale);
				btnMakeASale.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						contentPanel.removeAll();
						CreateSaleUI createSaleUi = new CreateSaleUI(contentPanel, secondaryMenuPanel);
						createSaleUi.make();
					}
				});

				JButton btnShowSale = new JButton("Show sale");
				secondaryMenuPanel.add(btnShowSale);
				btnShowSale.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						contentPanel.removeAll();
						ShowSaleUI showSaleUi = new ShowSaleUI(contentPanel, secondaryMenuPanel, btnShowSale);
						showSaleUi.make();

					}
				});
				invalidate();
				revalidate();
				repaint();
				setVisible(true);

			}
		});
		mainMenuPanel.add(btnSales);

		// ////////////////////////////////////////////////////////
		// ////////////////////////////////////////////////////////
		// /////////////////LEASES/////////////////////////////////
		// ///////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////

		JButton btnLeases = new JButton("Leases");
		btnLeases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				secondaryMenuPanel.removeAll();

				JButton btnStartLease = new JButton("Start lease");
				secondaryMenuPanel.add(btnStartLease);
				btnStartLease.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						contentPanel.removeAll();
						StartLeaseUI startLeaseUi = new StartLeaseUI(contentPanel, secondaryMenuPanel);
						startLeaseUi.make();
					}
				});

				JButton btnShowLease = new JButton("Show lease");
				secondaryMenuPanel.add(btnShowLease);
				btnShowLease.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						contentPanel.removeAll();
						ShowLeaseUI showLeaseUi = new ShowLeaseUI(contentPanel, secondaryMenuPanel, btnShowLease);
						showLeaseUi.make();
					}
				});

				JButton btnEndLease = new JButton("End lease");
				secondaryMenuPanel.add(btnEndLease);
				btnEndLease.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						contentPanel.removeAll();
						EndLeaseUI endLeaseUi = new EndLeaseUI(contentPanel, secondaryMenuPanel, btnEndLease);
						endLeaseUi.make();
					}
				});

				invalidate();
				revalidate();
				repaint();
				setVisible(true);

			}
		});
		mainMenuPanel.add(btnLeases);

		// ////////////////////////////////////////////////////////
		// ////////////////////////////////////////////////////////
		// /////////////////ORDERS/////////////////////////////////
		// ///////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////

		JButton btnOrders = new JButton("Orders");
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondaryMenuPanel.removeAll();

				JButton btnCreateOrder = new JButton("Create order");
				secondaryMenuPanel.add(btnCreateOrder);

				JButton btnShowOrder = new JButton("Show order");
				secondaryMenuPanel.add(btnShowOrder);
				btnShowOrder.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						contentPanel.removeAll();

						ShowOrderUI showOrderUi = new ShowOrderUI(contentPanel, secondaryMenuPanel);
						showOrderUi.make();
					}
				});
				invalidate();
				revalidate();
				repaint();
				setVisible(true);
			}
		});
		mainMenuPanel.add(btnOrders);

		// ////////////////////////////////////////////////////////
		// ////////////////////////////////////////////////////////
		// /////////////////PRODUCTS/////////////////////////////////
		// ///////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////

		JButton btnProducts = new JButton("Products");
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondaryMenuPanel.removeAll();

				JButton btnAddProduct = new JButton("Add product");
				secondaryMenuPanel.add(btnAddProduct);
				btnAddProduct.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						contentPanel.removeAll();

						AddProductUI addProductUI = new AddProductUI(contentPanel, secondaryMenuPanel);
						addProductUI.make();
					}
				});

				JButton btnShowProducts = new JButton("Show product");
				secondaryMenuPanel.add(btnShowProducts);
				btnShowProducts.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						contentPanel.removeAll();

						ShowProductUI shwoProductUI = new ShowProductUI(contentPanel, secondaryMenuPanel,
								btnShowProducts);
						shwoProductUI.make();
					}
				});

				invalidate();
				revalidate();
				repaint();
				setVisible(true);

			}
		});
		mainMenuPanel.add(btnProducts);

		// ////////////////////////////////////////////////////////
		// ////////////////////////////////////////////////////////
		// /////////////////SERVICES/////////////////////////////////
		// ///////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////

		JButton btnServices = new JButton("Services");
		btnServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				secondaryMenuPanel.removeAll();

				JButton btnAddService = new JButton("Add service");
				secondaryMenuPanel.add(btnAddService);
				btnAddService.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						contentPanel.removeAll();
						AddServiceUI addServiceUI = new AddServiceUI(contentPanel, secondaryMenuPanel);
						addServiceUI.make();
					}
				});

				JButton btnShowService = new JButton("Show service");
				secondaryMenuPanel.add(btnShowService);
				btnShowService.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						contentPanel.removeAll();
						ShowServiceUI showServiceUI = new ShowServiceUI(contentPanel, secondaryMenuPanel,
								btnShowService);
						showServiceUI.make();
					}
				});
				invalidate();
				revalidate();
				repaint();
				setVisible(true);
			}
		});
		mainMenuPanel.add(btnServices);

		// ////////////////////////////////////////////////////////
		// ////////////////////////////////////////////////////////
		// /////////////////CUSTOMERS/////////////////////////////////
		// ///////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////

		JButton btnCustomers = new JButton("Customers");
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				secondaryMenuPanel.removeAll();

				JButton btnAddCustomer = new JButton("Add customer");
				secondaryMenuPanel.add(btnAddCustomer);
				btnAddCustomer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						contentPanel.removeAll();

						AddCustomerUI addCustomerUI = new AddCustomerUI(contentPanel, secondaryMenuPanel);
						addCustomerUI.make();
					}
				});

				JButton btnShowCustomer = new JButton("Show customer");
				secondaryMenuPanel.add(btnShowCustomer);
				btnShowCustomer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						contentPanel.removeAll();

						ShowCustomerUI showCustomerUI = new ShowCustomerUI(contentPanel, secondaryMenuPanel,
								btnShowCustomer);
						showCustomerUI.make();

					}
				});

				invalidate();
				revalidate();
				repaint();
				setVisible(true);
			}
		});
		mainMenuPanel.add(btnCustomers);

		// ////////////////////////////////////////////////////////
		// ////////////////////////////////////////////////////////
		// /////////////////EMOLOYEES/////////////////////////////////
		// ///////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////

		JButton btnEmployees = new JButton("Employees ");
		btnEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				secondaryMenuPanel.removeAll();

				JButton btnAddEmployee = new JButton("Add employee");
				secondaryMenuPanel.add(btnAddEmployee);
				btnAddEmployee.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						contentPanel.removeAll();

						AddEmployeeUI addEmployeeUI = new AddEmployeeUI(contentPanel, secondaryMenuPanel);
						addEmployeeUI.main();
					}
				});

				JButton btnShowEmployee = new JButton("Show employee");
				secondaryMenuPanel.add(btnShowEmployee);
				btnShowEmployee.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						contentPanel.removeAll();
						ShowEmployeeUI showEmployeeUI = new ShowEmployeeUI(contentPanel, secondaryMenuPanel,
								btnAddEmployee);
						showEmployeeUI.make();

					}
				});

				invalidate();
				revalidate();
				repaint();
				setVisible(true);
			}
		});
		mainMenuPanel.add(btnEmployees);

		// ////////////////////////////////////////////////////////
		// ////////////////////////////////////////////////////////
		// /////////////////STATISTICS/////////////////////////////////
		// ///////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////

		JButton btnStatistics = new JButton("Statictics");
		mainMenuPanel.add(btnStatistics);

		JButton btnLogout = new JButton("Logout");
		mainMenuPanel.add(btnLogout);

	}
}