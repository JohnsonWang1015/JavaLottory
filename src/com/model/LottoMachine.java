package com.model;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class LottoMachine implements LottoFunction{
	
	private int lottoMax;
	private HashSet<Integer> hashSet;
	private TreeSet<Integer> treeSet;
	
	public void setLottoState(LottoEnum state) {
		switch(state) {
			case BIGLOTTO:
				lottoMax = 49;
				break;
			case POWERLOTTO:
				lottoMax = 38;
				break;
			case TODAY539:
				lottoMax = 39;
				break;
			case SPORTS:
				lottoMax = 30;
				break;
		}
	}

	@Override
	public HashSet<Integer> pc_choose() {
		
		HashSet<Integer> hashSet = new HashSet<>();
		
		while(hashSet.size() < 6) {
			int random = new Random().nextInt(lottoMax) + 1;
			hashSet.add(random);
		}
		
		return hashSet;
	}

	@Override
	public TreeSet<Integer> open() {
		
		TreeSet<Integer> treeSet = new TreeSet<>();
		
		while(treeSet.size() < 6) {
			treeSet.add(new Random().nextInt(lottoMax) + 1);
		}
		return treeSet;
	}

}
