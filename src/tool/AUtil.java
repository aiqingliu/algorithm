package tool;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class AUtil {
	
	/**
	 * 判断对象是不是为空
	 * 
	 * @param obj 对象
	 * @return boolean 返回值
	 */
	public static boolean isEmpty(Object obj) {
		if (null == obj)
			return true;

		if (obj instanceof List<?>) {
			return ((List<?>) obj).size() <= 0;
		}

		if (obj instanceof Map<?, ?>) {
			return ((Map<?, ?>) obj).size() <= 0;
		}

		if (obj instanceof Set<?>) {
			return ((Set<?>) obj).size() <= 0;
		}

		if (obj instanceof String) {
			return ((String) obj).trim().length() <= 0;
		}

		if (obj instanceof StringBuffer) {
			return ((StringBuffer) obj).toString().length() <= 0;
		}

		if (obj instanceof Double) {
			return ((Double) obj).isNaN();
		}

		return false;
	}

	/**
	 * 判断对象是不是为非空
	 * 
	 * @param obj 对象
	 * @return boolean 返回值
	 */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}
}
