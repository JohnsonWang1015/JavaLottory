package com.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LottoMachine implements LottoFunction{
	
	protected int lottoMax;
	private int ballMax;
	private HashSet<Integer> hashSet;
	private TreeSet<Integer> treeSet;
	
	public void setLottoState(LottoEnum state) {
		switch(state) {
			case BIGLOTTO:
				lottoMax = 49;
				ballMax = 6;
				break;
			case POWERLOTTO:
				lottoMax = 38;
				ballMax = 6;
				break;
			case TODAY539:
				lottoMax = 39;
				ballMax = 5;
				break;
			case DOUBLEWIN:
				lottoMax = 24;
				ballMax = 12;
				break;
		}
	}

	@Override
	public HashSet<Integer> pc_choose() {
		
		HashSet<Integer> hashSet = new HashSet<>();
		
		while(hashSet.size() < ballMax) {
			int random = new Random().nextInt(lottoMax) + 1;
			hashSet.add(random);
		}
		
		return hashSet;
	}

	@Override
	public TreeSet<Integer> open() {
		
		TreeSet<Integer> treeSet = new TreeSet<>();
		
		while(treeSet.size() < ballMax) {
			treeSet.add(new Random().nextInt(lottoMax) + 1);
		}
		return treeSet;
	}

	@Override
	public void judgment(HashSet<HashSet> hashSet, TreeSet<Integer> treeSet) {
		
		Set<Integer> set = new TreeSet<>();
		List<Integer> list = new ArrayList<>();
		
		for(HashSet h : hashSet) {
			for(Integer i : treeSet) {
				if(h.contains(i)) {
					set.add(i);
					list.add(i);
				}
			}
		}
		
		System.out.printf("中獎號碼：%s，共中 %d 個%n", set, set.size());
		System.out.printf("全部中獎號碼：%s，全部共中 %d 個%n", list, list.size());
	}
	
	public void judgment(List<Integer> list, Integer[] arr) {
		Set<Integer> set = new TreeSet<>();
		
		for(int i : list) {
			for(int j : arr) {
				if(i == j) {
					set.add(j);
				}
			}
		}
		
		System.out.printf("中獎號碼：%s，共中 %d 個%n", set, set.size());
	}

}
