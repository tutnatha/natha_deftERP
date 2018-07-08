package org.natha.defterp;

import com.defterp.modules.accounting.entities.Account;
import com.defterp.modules.accounting.queryBuilders.AccountQueryBuilder;
import com.defterp.modules.commonClasses.QueryWrapper;

public class runAccountQuery {

	public runAccountQuery(){
		AccountQueryBuilder aqb = new AccountQueryBuilder();
		QueryWrapper query = aqb.getFindAllQuery();
		
		System.out.println(query.toString());
		
//		QueryWrapper accounts = super.findWithQuery(query);
//		if (query != null && !query.isEmpty()) {
			//Account account = query.accounts.get(0);
//        }
	}
	
	public static void main(){
		runAccountQuery x = new runAccountQuery();
	}
}
