package com.example.dragonquest.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dragonquest.DAOinterface.InsertDataInterface;
import com.example.dragonquest.model.CopyTable;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class CopyTableDAO implements InsertDataInterface {
	@Autowired
	EntityManager entityManager;
	
	public boolean CopyTable(CopyTable copyTable) {
		Query query = entityManager
				.createNativeQuery("INSERT INTO :table1 SELECT * FROM :table2")
				.setParameter("table1", copyTable.GetCurrentTableName())
				.setParameter("table2", copyTable.GetOriginalTableName());
		int resultNum = query.executeUpdate();
		boolean result = false;
		if(resultNum != 0) {
			result = true;
		}
		return result;
	}
}
