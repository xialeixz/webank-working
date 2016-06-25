package org.webank.working.routine.test.date;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.time.DateUtils;

public class TimeLimitUtils {

private static final Map<Integer, Integer> DATE_FIELDS_AND_DEFAULT_VALUE = new TreeMap<Integer, Integer>();
	
	static {
		DATE_FIELDS_AND_DEFAULT_VALUE.put(Calendar.YEAR, 0);			//不存在设置year的默认值情况
		DATE_FIELDS_AND_DEFAULT_VALUE.put(Calendar.MONTH, 0);
		DATE_FIELDS_AND_DEFAULT_VALUE.put(Calendar.DAY_OF_MONTH, 1);
		DATE_FIELDS_AND_DEFAULT_VALUE.put(Calendar.HOUR_OF_DAY, 0);
		DATE_FIELDS_AND_DEFAULT_VALUE.put(Calendar.MINUTE, 0);
		DATE_FIELDS_AND_DEFAULT_VALUE.put(Calendar.SECOND, 0);
	}
	
	/**
	 * 获取特定时间，例如：输入2016-02-13 12：12：32，DAY_OF_MONTH，true则返回2016-02-13 00：00：00
	 * 首先截取指定域以后的时间，然后用实参填充，返回结果，如果autoFillData为true，则会给未定实参的位置赋值0
	 * @param field 截取时间精度（包括：YEAR,MONTH,DAY_OF_MONTH,HOUR_OF_DAY,MINUTE,SECOND）
	 * @param fillData 填充数据值，当autoFillData为true时默认填充0
	 * @return
	 */
	public static final Calendar getTimeLimit(int field, int... fillData){
		return getTimeLimit(null, field, true, fillData);
	}
	
	/**
	 * 获取特定时间，例如：输入2016-02-13 12：12：32，DAY_OF_MONTH，true则返回2016-02-13 00：00：00
	 * 首先截取指定域以后的时间，然后用实参填充，返回结果，如果autoFillData为true，则会给未定实参的位置赋值0
	 * @param now 特定时间源
	 * @param field 截取时间精度（包括：YEAR,MONTH,DAY_OF_MONTH,HOUR_OF_DAY,MINUTE,SECOND）
	 * @param fillData 填充数据值，当autoFillData为true时默认填充0
	 * @return
	 */
	public static final Calendar getTimeLimit(Calendar now, int field, int... fillData){
		return getTimeLimit(now, field, true, fillData);
	}
	
	/**
	 * 获取特定时间，例如：输入2016-02-13 12：12：32，DAY_OF_MONTH，true则返回2016-02-13 00：00：00
	 * 首先截取指定域以后的时间，然后用实参填充，返回结果，如果autoFillData为true，则会给未定实参的位置赋值0
	 * @param now 特定时间源
	 * @param field 截取时间精度（包括：YEAR,MONTH,DAY_OF_MONTH,HOUR_OF_DAY,MINUTE,SECOND）
	 * @param autoFillData 是否默认填充数据
	 * @param fillData 填充数据值，当autoFillData为true时默认填充0
	 * @return
	 */
	public static final Calendar getTimeLimit(Calendar now, int field, boolean autoFillData, int... fillData){
		
		if(null == now){
			now = Calendar.getInstance();
		}
		
		if(!DATE_FIELDS_AND_DEFAULT_VALUE.keySet().contains(field)){
			throw new IllegalArgumentException("The field " + field + " is not supported");
		}
		
		List<Integer> fields = new ArrayList<Integer>(DATE_FIELDS_AND_DEFAULT_VALUE.keySet());
		Calendar tmp = DateUtils.truncate(now, field);
		int index = fields.indexOf(field) + 1;
		if(index >= fields.size()){
			return tmp;
		}
		int dataIndex = 0;
		for(int i = index; i< fields.size();i++){
			
			if(dataIndex >= fillData.length){ 
				if(autoFillData){
					tmp.set(fields.get(i), DATE_FIELDS_AND_DEFAULT_VALUE.get(fields.get(i)));
				} else {
					continue;
				}
			}else {
				tmp.set(fields.get(i), fillData[dataIndex]);
			}
			dataIndex++;
		}
		
		return tmp;
	}
}
