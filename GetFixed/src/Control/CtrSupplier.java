package Control;

import Model.*;
import DB.*;

import java.util.ArrayList;

public class CtrSupplier {
	public CtrSupplier() {

	}

	public ArrayList<Supplier> findAllSuppliers() {
		IFDBSupplier dbSupplier = new DBSupplier();
		ArrayList<Supplier> allSupplier = new ArrayList<Supplier>();
		allSupplier = dbSupplier.getAllSupplier(false);
		return allSupplier;
	}

	public Supplier findByName(String name) {
		IFDBSupplier dbSupplier = new DBSupplier();
		return dbSupplier.searchSupplierByName(name, true);
	}

	public Supplier findById(int id) {
		IFDBSupplier dbSupplier = new DBSupplier();
		return dbSupplier.searchSupplierById(id, true);
	}

	public int updateSupplier(int id, String name, String surname, String address,
			String telephone, String email) {
		IFDBSupplier dbSupplier = new DBSupplier();
		Supplier supplier = new Supplier();

		supplier.setId(id);
		supplier.setName(name);
		supplier.setSurname(surname);
		supplier.setAddress(address);
		supplier.setTelephone(telephone);
		supplier.setEmail(email);
		return dbSupplier.updateSupplier(supplier);

	}

	public void insertSupplier(String name, String surname, String address,
			String telephone, String email) throws Exception {
		Supplier supplier = new Supplier();
		supplier.setName(name);
		supplier.setSurname(surname);
		supplier.setAddress(address);
		supplier.setTelephone(telephone);
		supplier.setEmail(email);

		try {
			DBConnection.startTransaction();
			DBSupplier dbSupplier = new DBSupplier();
			dbSupplier.insertSupplier(supplier);
			DBConnection.commitTransaction();
		} catch (Exception e) {
			DBConnection.rollbackTransaction();
			throw new Exception("Supplier not inserted");
		}
	}
	
	public void deleteSupplier(int id) throws Exception {

		try {
			DBConnection.startTransaction();
			DBSupplier dbSupplier = new DBSupplier();
			dbSupplier.deleteSupplier(id);
			DBConnection.commitTransaction();
		} catch (Exception e) {
			DBConnection.rollbackTransaction();
			throw new Exception("Supplier not deleted");
		}
	}

        public Object[] addSupplierById(int id) {
		Supplier supplier = findById(id);
		Object[] object = null;
		object = new Object[] { supplier.getId(), supplier.getName(),
				supplier.getSurname(), supplier.getAddress(),
				supplier.getTelephone(), supplier.getEmail()};

		return object;
	}

	public Object[] addSupplierByName(String name) {
		Supplier supplier = findByName(name);
		Object[] object = null;
		object = new Object[] { supplier.getId(), supplier.getName(),
				supplier.getSurname(), supplier.getAddress(),
				supplier.getTelephone(), supplier.getEmail()
				 };

		return object;
	}

	
	public ArrayList<Object[]> addAllSuppliers() {
		ArrayList<Supplier> supplierList = findAllSuppliers();
		Object[] object = null;
		ArrayList<Object[]> objectArray = new ArrayList<Object[]>();
		for (Supplier supplier : supplierList) {
			object = new Object[] { supplier.getId(), supplier.getName(),
					supplier.getSurname(), supplier.getAddress(),
					supplier.getTelephone(), supplier.getEmail()};
			objectArray.add(object);
		}
		return objectArray;
	}

}
