/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.natha.defterp;

import javax.persistence.EntityManager;
import com.defterp.modules.accounting.entities.Account;
/**
 *
 * @author wisty
 */
public class JPASelectDemo {
    public static void main(String[] args) {
		EntityManager entityManager = JPAUtility.getEntityManager();	
		Account acc = entityManager.find(Account.class, new Integer(1));
		System.out.println("Name:"+ acc.getName()+", City:"+ acc.getTitle());
		JPAUtility.close();		
		System.out.println("Done");
	}
}
