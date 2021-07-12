package com.model;

import java.util.HashSet;

public class SelfChoose extends LottoMachine{

	@Override
	public HashSet<Integer> pc_choose() {
		HashSet<Integer> hashSet = new HashSet<>();
		while(hashSet.size() < 6) {
			
		}
		return super.pc_choose();
	}
	
}
