package com.sample;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.model.LottoEnum;
import com.model.LottoMachine;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		LottoMachine machine = new LottoMachine();
		
		HashSet<HashSet> hashSet = new HashSet<>();
		HashSet<Integer> hi = new HashSet<>();
		TreeSet<Integer> tree = new TreeSet<>();
		
		int keyin = 0;
		int choose = 0;
		
		do {
			System.out.print("1)大樂透 2)威力彩 3)今彩539 4)運動彩 5)結束：");
			keyin = scanner.nextInt();
			
			if(keyin < 1 && keyin > 5) {
				System.out.println("輸入錯誤，請再輸入一次");
				continue;
			}else {
				switch(keyin) {
					case 1:
						machine.setLottoState(LottoEnum.BIGLOTTO);
						break;
					case 2:
						machine.setLottoState(LottoEnum.POWERLOTTO);
						break;
					case 3:
						machine.setLottoState(LottoEnum.TODAY539);
						break;
					case 4:
						machine.setLottoState(LottoEnum.SPORTS);
						break;
				}
				if(keyin == 5) break;
				
				do {
					System.out.print("1)多組電腦選號 2)多組自選號碼 3)結束：");
					keyin = scanner.nextInt();
					if(keyin < 1 && keyin > 3) {
						System.out.println("輸入錯誤，請再輸入一次");
						continue;
					}else {
						switch(keyin) {
						case 1:
							System.out.print("請問要選幾組號碼：");
							choose = scanner.nextInt();
							
							for(int i=0; i<choose; i++) {
								hi = machine.pc_choose();
								System.out.printf("第 %d 次電腦選號：%s%n", i+1, hi);
								hashSet.add(hi);
							}
							tree = machine.open();
							System.out.printf("開獎號碼：%s%n", tree);
							
							judgment(hashSet, tree);
							
							break;
						case 2:
							System.out.print("請問要選幾組號碼：");
							choose = scanner.nextInt();
							break;
						}
					}
				}while(keyin != 3);
			}
		}while(keyin != 5);
		
		System.out.println("結束");
	}
	
	public static void judgment(HashSet<HashSet> hashSet, TreeSet<Integer> treeSet) {
		
		Set<Integer> set = new TreeSet<>();
		for(HashSet h : hashSet) {
			for(Integer i : treeSet) {
				if(h.contains(i)) {
					set.add(i);
				}
			}
			
		}
		System.out.printf("中獎號碼：%s，共中 %d 個%n", set, set.size());
	}
}
