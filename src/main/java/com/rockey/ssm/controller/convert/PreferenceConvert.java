package main.java.com.rockey.ssm.controller.convert;

import org.springframework.core.convert.converter.Converter;

public class PreferenceConvert implements Converter<String[],String> {

	public String convert(String[] strs) {
		// TODO Auto-generated method stub
		StringBuffer sb =null;
		if(strs!=null){
			sb = new StringBuffer(); 
			for(String str:strs){
				sb.append(str+",");
			}
			return sb.toString().substring(0,sb.length()-1);
		}
		return null;
	}

}
