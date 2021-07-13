package com.model;

import java.util.HashSet;
import java.util.TreeSet;

public interface LottoFunction {
	
	public HashSet<Integer> pc_choose();
	public TreeSet<Integer> open();
	public void judgment(HashSet<HashSet> hashSet, TreeSet<Integer> treeSet);
	
}
