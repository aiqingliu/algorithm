package function.leetcode;

import base.Base;
import tool.AUtil;

/**
 * 数组排序
 *
 * @author liuaiqing
 */
public class F912 extends Base {

	/**
	 * sort1 循环数组,遇到小的值就往前交换
	 * @param g
	 */
	public void sort1(Integer[] g) {
		methodName = "sort1";
		message = "排序数组";
		info(methodName, message);
		// 数组不为空
		if (AUtil.isNotEmpty(g)) {
			for (int i = 0; i < g.length; i++) {
				int temp = g[i];
				int j = i + 1;
				while (j < g.length) {
					if (g[j] < g[i]) {
						g[i] = g[j];
						g[j] = temp;
					}
					j++;
				}
			}
		}
		info(methodName, g);
	}

	/**
	 * sort2 拆分数组为前后两部分,前一部分比后一部分任意值都小
	 * @param g
	 */
	public void sort2(Integer[] g) {
		String methodName = "sort2";
		String message = "";
		
	}
}
