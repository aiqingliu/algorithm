package function.leetcode;

import java.math.BigDecimal;
import java.util.Random;

import tool.AUtil;

import base.Base;

/**
 * 寻找正序数组的中位数
 *
 * @author liuaiqing
 */
public class F4 extends Base {
	
	private Integer[] g1;// 数组一
	private Integer[] g2;// 数组二
	private Integer[] gs;// 合并数组
	
	
	public F4() {
		
	}
	
	/**
	 * romdTwo 随机两个数组出来
	 */
	public void romdTwo() {
		methodName = "romdTwo";
		message = "随机两个数组出来";
		info(methodName, message);
		
		Random random = new Random();
		
		g1 = new Integer[random.nextInt(4)+1];
		g2 = new Integer[random.nextInt(4)+1];
		
		for (int i = 0; i < g1.length; i++) {
			g1[i] = random.nextInt(20) * i + random.nextInt(20);
		}
		
		for (int i = 0; i < g2.length; i++) {
			g2[i] = random.nextInt(20) * i + random.nextInt(20);
		}

//		g1 = new Integer[]{9, 21, 51};
//		g2 = new Integer[]{5, 22, 30};

		F912 f912 = new F912();
		f912.sort1(g1);
		f912.sort1(g2);
	}
	
	/**
	 * sumTwo 合并数组
	 */
	public void sumTwo() {
		String methodName = "sumTwo";
		String message = "合并数组";
		info(methodName, message);
		try {
			if (AUtil.isNotEmpty(g1) && AUtil.isNotEmpty(g2)) {
				// 用作合并的数组
				gs = new Integer[g1.length + g2.length];
				// 开始位置
				int g1s = 0, g2s = 0;
				// 合并数组
				while (g1s < g1.length || g2s < g2.length) {
					if (g1s >= g1.length) {
						gs[g1s+g2s] = g2[g2s];
						g2s++;
					} else if (g2s >= g2.length) {
						gs[g1s+g2s] = g1[g1s];
						g1s++;
					} else if (g1[g1s] < g2[g2s]) {
						gs[g1s+g2s] = g1[g1s];
						g1s++;
					} else if (g1[g1s] >= g2[g2s]){
						gs[g1s+g2s] = g2[g2s];
						g2s++;
					}
				}
				info(methodName, gs);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * function1 合并数组再取中值
	 */
	public void function1() {
		String methodName = "function1";
		String message = "合并数组再取中值";
		info(methodName, message);
		// 随机两个数组
		romdTwo();
		// 合并两个数组
		sumTwo();
		// 打印中值
		if ((gs.length%2) == 0) {
			info(methodName, "数组的中值:" + ((gs[(gs.length / 2) - 1] + gs[gs.length / 2]) / 2));
		} else {
			info(methodName, "数组的中值:" + gs[gs.length / 2]);
		}
	}
	
	/**
	 * function2 计算数组中值出现位置,移动数组次数,得出中值
	 */
	public void function2() {
		String methodName = "function2";
		String message = "计算数组中值出现位置,得出中值";
		info(methodName, message);
		// 随机两个有序数组
		romdTwo();

		int l = 0;
		int l1 = 0;// 下标位置1
		int l2 = 0;// 下标位置2
		int k = 0;// 移动的次数,当数组是偶数个内容则移动(L/2-1和L/2)次,当数组是奇数个内容则移动(L/2)次

		l = g1.length + g2.length;

		int m = 0;// g1移动下标
		int n = 0;// g2移动下标
		BigDecimal sum = BigDecimal.ZERO;
		// 中值包含在长的数组中或两个数组各含一个
		for (int i = 0; i < (g1.length>=g2.length?g1.length:g2.length) && i < l / 2; i++) {
			// 临时的值
			int temp = 0;
			// 当数组不需要移动时
			if (l < 2) {
				sum = AUtil.isNotEmpty(g1) ? (AUtil.isNotEmpty(g2) ? BigDecimal.valueOf(g2[0]) : BigDecimal.ZERO) : BigDecimal.valueOf(g1[0]);
				break;
			}
			// 数组1和数组2存在一个可以移动
			// 当数组1大于数组2且数组2未将溢出或数组2大于数组1但数组1将溢出都移动数组2下标
			temp = g1[m] > g2[n] ? g1[m] : g2[n];
			if ((n < g2.length - 1 && g1[m] > g2[n+1]) || (n < g2.length - 1 && m >= g1.length - 1) || (m < g1.length - 1 && n < g2.length - 1 && g1[m+1] >= g2[n+1])) {
				n++;
				k++;
			}
			// 当数组2大于数组1且数组1未将溢出或数组1大于数组3但数组3将溢出都移动数组1下标
			else if ((m < g1.length - 1 && g2[n] > g1[m+1]) || (m < g1.length - 1 && n >= g2.length - 1)  || (n < g2.length - 1 && m < g1.length - 1 && g1[m+1] <= g2[n+1])) {
				m++;
				k++;
			}

			// 偶数数组
			if ((l%2) == 0) {
				if (k == l / 2 - 1 || k == l / 2) {
					sum = sum.add(BigDecimal.valueOf(temp).divide(BigDecimal.valueOf(2)));
				}
			}
			// 奇数数组
			else {
				if (k == l / 2) {
					sum = BigDecimal.valueOf(temp);
				}
			}

		}
		// 合并两个数组
		sumTwo();
		info(methodName, "两数组的中:" + sum);
	}

}
