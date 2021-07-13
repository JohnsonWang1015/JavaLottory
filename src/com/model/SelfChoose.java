package com.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SelfChoose extends LottoMachine{
	
	public List<Integer> list = new ArrayList<>();;
	
	public List<Integer> check(int num) {
			
		for(int i=0; i<list.size(); i++) {
			if(num <= super.lottoMax && num >= 1) {
				list.add(num);
				
			}else {
				try {
					System.out.println("輸入資料錯誤");
					list.clear();
					check(num);
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
		return list;
	}
}
