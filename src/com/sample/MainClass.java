package com.sample;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import com.model.LottoEnum;
import com.model.LottoMachine;
import com.model.SelfChoose;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		LottoMachine machine = new LottoMachine();
		
		HashSet<HashSet> hashSet = new HashSet<>();
		HashSet<Integer> hi = new HashSet<>();
		TreeSet<Integer> tree = new TreeSet<>();
		
		int keyin = 0;
		int choose = 0;
		
		List<Integer> list = null;
		Integer[] treeArr = new Integer[tree.size()];

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
					//System.out.print("1)多組電腦選號 2)多組自選號碼 3)結束：");
					System.out.print("1)多組電腦選號 2)結束：");
					keyin = scanner.nextInt();
					if(keyin < 1 && keyin > 2) {
						System.out.println("輸入錯誤，請再輸入一次");
						continue;
					}else {
						switch(keyin) {
							case 1:
								System.out.print("請問要選幾組號碼：");
								choose = scanner.nextInt();
								
								for(int i=0; i<choose; i++) {
									hi = machine.pc_choose();
									System.out.printf("第 %02d 次電腦選號：%s%n", i+1, hi);
									hashSet.add(hi);
								}
								tree = machine.open();
								System.out.printf("開獎號碼：%s%n", tree);
								
								machine.judgment(hashSet, tree);
								System.out.println("--------------------");
								
								break;
								
							/*case 2:
								System.out.print("請問要選幾組號碼：");
								choose = scanner.nextInt();
								
								scanner.nextLine();
								SelfChoose self = new SelfChoose();
								
								for(int i=1; i<=choose; i++) {
									System.out.printf("第 %02d 次自選號碼：%n", i);
									for(int j=0; j<6; j++) {
										
										System.out.printf("第 %d 次輸入：", j+1);
										int tmp = scanner.nextInt();
										
										for(int k=0; k<self.list.size(); k++) {
											for(int m=0; m<self.list.size(); m++) {
	
												tmp = scanner.nextInt();
												System.out.println();
												
												if(self.list.get(k) == self.list.get(m)) {
													System.out.println("資料重複，請再輸入一次");
													continue;
												}else {
													list = self.check(tmp);
												}
											}
										}
										
									}
								}
								
								tree = machine.open();
								System.out.printf("開獎號碼：%s%n", tree);
								
								machine.judgment(list, tree.toArray(treeArr));
								System.out.println("--------------------");
								
								break;*/
							}
					}
				}while(keyin != 2);
			}
		}while(keyin != 5);
		
		System.out.println("結束");
	}
}
