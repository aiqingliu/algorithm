package tool;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Console {

	/**
	 * 提示信息
	 * @param Object
	 */
	public void info(Object Object) {
		long now = System.currentTimeMillis();
		Date date = new Date(now);
		System.out.println(date + ":" + this.getClass() + ":" + Object.toString());
	}
	
	/**
	 * 提示信息
	 * @param methodName
	 */
	public void info(String methodName) {
		long now = System.currentTimeMillis();
		Date date = new Date(now);
		System.out.println(date + ":" + this.getClass() + "." + methodName + "()");
	}
	
	/**
	 * 提示信息
	 * @param methodName
	 */
	public void info(String methodName, Object object) {
		long now = System.currentTimeMillis();
		Date date = new Date(now);
//		Timestamp timestamp = new Timestamp(date.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String timeStr = sdf.format(date);
		try {
			if (object instanceof String) {
				System.out.println(timeStr + ":" + this.getClass() + "." + methodName + "()" + ":" + object);
			} else if (object instanceof String[]){
				System.out.println(timeStr + ":" + this.getClass() + "." + methodName + "()" + ":" + Arrays.toString((String[])object));
			} else if (object instanceof Object[]){
				System.out.println(timeStr + ":" + this.getClass() + "." + methodName + "()" + ":" + Arrays.toString((Object[])object));
			} else if (object instanceof List){
				System.out.println(timeStr + ":" + this.getClass() + "." + methodName + "()" + ":" + object.toString());
			} else {
				System.out.println(timeStr + ":" + this.getClass() + "." + methodName + "()" + ":" + object);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * 提示信息
	 * @param methodName
	 */
	public void info(String methodName, String message) {
		long now = System.currentTimeMillis();
		Date date = new Date(now);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String timeStr = sdf.format(date);
		System.out.println(timeStr + ":" + this.getClass() + "." + methodName + "()" + ":" + message);
	}
	
}
