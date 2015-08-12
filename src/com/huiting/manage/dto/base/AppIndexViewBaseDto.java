package com.huiting.manage.dto.base;

import java.io.Serializable;
import java.text.NumberFormat;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @ClassName: AppIndexViewBaseDto
 * @Description: APP_INDEXVIEW
 * @author Zou_ZhuoQi
 * @date 2013-12-20 下午1:29:54
 * 
 */
@Alias("appIndexViewBaseDto")
public class AppIndexViewBaseDto extends AppIndexViewBaseDtoKey implements
		Serializable {

	private static final long serialVersionUID = 1L;
	private String indexvalue;

	private String lmonvalue;

	private String lyearvalue;

	private String ctolyearvalue;

	private String ctolmonvalue;

	private String tide;

	private String color;
	private String dataunit;

	public String getOldIndexvalue(){
		return indexvalue = indexvalue== null ? "" :indexvalue.trim();
	}
	public String getIndexvalue() {
		 NumberFormat nf=NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		String i;
		if(indexvalue==null){
			i="--";
		}else {
			double d=Double.parseDouble(indexvalue.trim());
			if("I0401000900N".equals(indexcode)){
				nf.setMaximumFractionDigits(4);
				nf.setMinimumFractionDigits(4);
			}
			if("I0103000100Y".equals(indexcode)){
				i=d==0?"A":d==1?"B":d==2?"C":d==3?"D":"--";
			}
			else if(dataunit!=null&&!"%".equals(dataunit)){
				nf.setMinimumFractionDigits(0);
				i=d>1000000||d<-1000000?nf.format(d/1000000)+"百万"+getDataunit() :nf.format(d)+getDataunit() ;	
			}else{
				i=d>1000000||d<-1000000?nf.format(d/1000000)+"百万"+getDataunit() :d==0?"0":nf.format(d)+getDataunit() ;	
			}
			
		}
		return i;
	}

	public void setIndexvalue(String indexvalue) {
		this.indexvalue = indexvalue== null ? null :indexvalue.trim() ;
	}

	public String getLmonvalue() {
		 NumberFormat nf=NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		String i;
		if(lmonvalue==null){
			i="--";
		}else {
			double d=Double.parseDouble(lmonvalue.trim());
			if("I0401000900N".equals(indexcode)){
				nf.setMaximumFractionDigits(4);
				nf.setMinimumFractionDigits(4);
			}
			if("I0103000100Y".equals(indexcode)){
				i=d==0?"A":d==1?"B":d==2?"C":d==3?"D":"--";
			}else if(dataunit!=null&&!"%".equals(dataunit)){
				nf.setMinimumFractionDigits(0);
				i=d>1000000||d<-1000000?nf.format(d/1000000)+"百万"+getDataunit():nf.format(d)+getDataunit() ;	
			}else {
				i=d>1000000||d<-1000000?nf.format(d/1000000)+"百万"+getDataunit() :d==0?"0":nf.format(d)+getDataunit() ;	
			}
		}
		return i;
	}

	public void setLmonvalue(String lmonvalue) {
		this.lmonvalue = lmonvalue== null ?null:lmonvalue.trim() ;
	}

	public String getLyearvalue() {
		 NumberFormat nf=NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		String i;
		if(lyearvalue==null){
			i="--";
		}else {
			double d=Double.parseDouble(lyearvalue.trim());
			if("I0401000900N".equals(indexcode)){
				nf.setMaximumFractionDigits(4);
				nf.setMinimumFractionDigits(4);
			}
			if("I0103000100Y".equals(indexcode)){
				i=d==0?"A":d==1?"B":d==2?"C":d==3?"D":"--";
			}else if(dataunit!=null&&!"%".equals(dataunit)){
				nf.setMinimumFractionDigits(0);
				i=d>1000000||d<-1000000?nf.format(d/1000000)+"百万"+getDataunit() :nf.format(d)+getDataunit() ;	
			}else{
				i=d>1000000||d<-1000000?nf.format(d/1000000)+"百万"+getDataunit() :d==0?"0":nf.format(d)+getDataunit() ;	
			}
		}
		return i;
	}

	public void setLyearvalue(String lyearvalue) {
		this.lyearvalue = lyearvalue== null ? null :lyearvalue.trim() ;
	}

	public String getCtolyearvalue() {
		return ctolyearvalue== null ? "--" :ctolyearvalue.trim();
	}

	public void setCtolyearvalue(String ctolyearvalue) {
		this.ctolyearvalue = ctolyearvalue== null ?null :ctolyearvalue.trim() ;
	}

	public String getCtolmonvalue() {
		return ctolmonvalue== null ? "--" :ctolmonvalue.trim();
	}

	public void setCtolmonvalue(String ctolmonvalue) {
		this.ctolmonvalue = ctolmonvalue== null ? null :ctolmonvalue.trim() ;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTide() {
		return tide;
	}

	public void setTide(String tide) {
		this.tide = tide == null ? null : tide.trim();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color == null ? null : color.trim();
	}

	public String getDataunit() {
		return dataunit== null ? "" : dataunit.trim();
	}

	public void setDataunit(String dataunit) {
		this.dataunit = dataunit== null ? null : dataunit.trim();
	}
	
}