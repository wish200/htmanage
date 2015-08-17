package com.huiting.manage.services.common.impl;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;





import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.huiting.manage.dto.common.SearchDto;
import com.huiting.manage.services.common.HSSFFileCreateService;

@Service("hssfFileCreateServiceImpl")
public class HSSFFileCreateServiceImpl implements HSSFFileCreateService{

	@Override
	public void CreateXslFile(HSSFWorkbook hssfWorkbook,List<SearchDto> searchDtos) {
		if(searchDtos!=null){
			HSSFSheet hssfSheet=hssfWorkbook.createSheet();// 创建以个sheet页
			HSSFRow row =null;
			row=hssfSheet.createRow((short)0);
			int k=0;
			int f;
			row.createCell(k++).setCellValue("序号");
			row.createCell(k++).setCellValue("一级风险");
			row.createCell(k++).setCellValue("二级风险");
			row.createCell(k++).setCellValue("指标名称");
			row.createCell(k++).setCellValue("当前指标值");
			row.createCell(k++).setCellValue("同比值");
			row.createCell(k++).setCellValue("环比值");
			row.createCell(k++).setCellValue("更新频率");
			row.createCell(k++).setCellValue("数据期次");
			row.createCell(k++).setCellValue("预警");
			for(int i=0,j=searchDtos.size() ;i<j;i++){
				row= hssfSheet.createRow((short)i+1);//创建一行数据
				f=0;
				row.createCell(f++).setCellValue(i+1);
				/*row.createCell(f++).setCellValue(searchDtos.get(i).getCdIndexBaseDto().getLev1riskname());
				row.createCell(f++).setCellValue(searchDtos.get(i).getCdIndexBaseDto().getLev2riskname());*/
			}
		}
	}

	@Override
	public void CreateXslFileToHtml(HSSFWorkbook hssfWorkbook, String xml,String title) {
		xml=xml.replaceAll("&nbsp", "").replaceAll("  ", " ");
		 HSSFCellStyle titleStyle=hssfWorkbook.createCellStyle();
		   titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //设置边框样式
		   titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);     //左边框
		   titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);    //右边框
		   titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);    //顶边框
		   titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//字体居中
		   titleStyle.setAlignment(HSSFCellStyle.VERTICAL_CENTER);
//		   titleStyle.setWrapText(true);
		 Document doc = Jsoup.parse(xml);
		   
		 Elements trNodes=doc.getElementsByTag("tr");
		 Elements tdNodes=null;
		 Element trElement=null;
		 Element tdnode=null;
	     HSSFSheet hssfSheet=hssfWorkbook.createSheet(title.replaceAll("&nbsp;", "").replaceAll(" ", ""));
	     HSSFRow hssfRow=null;
	     HSSFCell hssfCell=null;
	     Map<Integer, Map<Integer,Integer>> haveRowCls=new HashMap<Integer, Map<Integer,Integer>>();//用来存放已经被包含的行和列。KEY为行数LIST为列数
		 Map<Integer,Integer> haveCls=null;
		 int clsWith=3500;
		 int  haveClsSize;
		  for(int row=0;row<trNodes.size();row++){
			   hssfRow=hssfSheet.createRow(row);
			   trElement =  trNodes.get(row); 
			   tdNodes = trElement.getElementsByTag("td");
			   int excelCls=0;//execl的列
			   for(int tdCls=0;tdCls<tdNodes.size();tdCls++){//表格中的TD列数
				   haveRowCls.remove(row-1);
				   if(haveRowCls.get(row)!=null){
					   haveCls=haveRowCls.get(row);
					   haveClsSize=haveCls.size();
					   for (int i = 0; i < haveClsSize; i++) {
						   if(haveCls.get(excelCls)!=null){
							   hssfCell=hssfRow.createCell(excelCls);//如果本被合并单元格
							   hssfCell.setCellStyle(titleStyle);//设置
							   hssfCell.setCellValue("");
							   excelCls++;
						   };
					   }
				   };
				   if(row==0){
					   hssfSheet.setColumnWidth(tdCls, clsWith);
				   }
				   hssfCell=hssfRow.createCell(excelCls);
				   tdnode =  tdNodes.get(tdCls);
				   String d=tdnode.text();
				  /* if(isNumeric(d)){
					   hssfCell.setCellValue(Double.parseDouble(d));
				   }else{*/
					   hssfCell.setCellValue(d);
				   /*}*/
				  
				   //				   System.out.println("我在写入--第"+row+"行--第"+excelCls+"列--值为--"+node.getTextContent());
				   if(tdnode.attr("rowspan")!=null&&!"".equals(tdnode.attr("rowspan"))&&tdnode.attr("colspan")!=null&&!"".equals(tdnode.attr("colspan"))){
					   int rowR=Integer.parseInt(tdnode.attr("rowspan"));//横向垮了多少列
					   int clsR=Integer.parseInt(tdnode.attr("colspan"));//纵向垮了多少行
					   CellRangeAddress range=new CellRangeAddress(row, row+rowR-1, excelCls, excelCls+clsR-1);
					   hssfSheet.addMergedRegion(range);//第二行 二到三列
					   RegionUtil.setBorderBottom(HSSFCellStyle.BORDER_THIN, range, hssfSheet, hssfWorkbook);
					   RegionUtil.setBorderLeft(HSSFCellStyle.BORDER_THIN, range, hssfSheet, hssfWorkbook);
					   RegionUtil.setBorderRight(HSSFCellStyle.BORDER_THIN, range, hssfSheet, hssfWorkbook);
					   RegionUtil.setBorderTop(HSSFCellStyle.BORDER_THIN, range, hssfSheet, hssfWorkbook);
					   for (int j = 0; j < rowR; j++) {//表现为行数--
						  if(haveRowCls.get(row+j)==null){//如果这一行还没有则
							  haveCls=new HashMap<Integer, Integer>(); //new ArrayList<Integer>();
						  }else{
							  haveCls=haveRowCls.get(row+j); 
						  }
						  for (int r = 0; r < clsR; r++) {
							  haveCls.put(excelCls+r, 9999);
//							  System.out.println("我在合并第"+(row+j)+"行第"+(excelCls+r)+"列-----");
						  }
						  haveRowCls.put(row+j, haveCls);
					   }
				   }else if(tdnode.attr("rowspan")!=null&&!"".equals(tdnode.attr("rowspan"))){
					   int rowR=Integer.parseInt(tdnode.attr("rowspan"));//只是合并行
					   CellRangeAddress range=new CellRangeAddress(row, row+rowR-1,excelCls , excelCls);
					   hssfSheet.addMergedRegion(range );//第二行 二到三列
					   RegionUtil.setBorderBottom(HSSFCellStyle.BORDER_THIN, range, hssfSheet, hssfWorkbook);
					   RegionUtil.setBorderLeft(HSSFCellStyle.BORDER_THIN, range, hssfSheet, hssfWorkbook);
					   RegionUtil.setBorderRight(HSSFCellStyle.BORDER_THIN, range, hssfSheet, hssfWorkbook);
					   RegionUtil.setBorderTop(HSSFCellStyle.BORDER_THIN, range, hssfSheet, hssfWorkbook);
					   for (int j = 0; j < rowR; j++) {//表现为行数--
							  if(haveRowCls.get(row+j)==null){//如果这一行还没有则
								  haveCls=new HashMap<Integer, Integer>(); //new ArrayList<Integer>();
							  }else{
								  haveCls=haveRowCls.get(row+j); 
							  }
							  haveCls.put(excelCls, 9999);
//							  System.out.println("我在合并第"+(row+j)+"行第"+(excelCls)+"列++++++++");
							  haveRowCls.put(row+j, haveCls);
						 }
				   }else if(tdnode.attr("colspan")!=null&&!"".equals(tdnode.attr("colspan"))){
					   int clsR=Integer.parseInt(tdnode.attr("colspan"));
					   CellRangeAddress range=new CellRangeAddress(row, row, excelCls, excelCls+clsR-1);
					   hssfSheet.addMergedRegion(range);//第二行 二到三列
					   RegionUtil.setBorderBottom(HSSFCellStyle.BORDER_THIN, range, hssfSheet, hssfWorkbook);
					   RegionUtil.setBorderLeft(HSSFCellStyle.BORDER_THIN, range, hssfSheet, hssfWorkbook);
					   RegionUtil.setBorderRight(HSSFCellStyle.BORDER_THIN, range, hssfSheet, hssfWorkbook);
					   RegionUtil.setBorderTop(HSSFCellStyle.BORDER_THIN, range, hssfSheet, hssfWorkbook);
					   excelCls=excelCls+clsR-1;
					   if(row==0&&clsR<=2){
						   hssfSheet.setColumnWidth(tdCls, clsWith*(clsR-1));
					   }
				   }
				   hssfCell.setCellStyle(titleStyle); 
				   excelCls++;//没次完成后将列数据加一列
			   }
			}
	     /*
	      * 
	      * Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		 Map<Integer, Integer> mapCls=new HashMap<Integer, Integer>();
		 for(int i=0;i<trNodes.getLength();i++){ 
	        hssfRow= hssfSheet.createRow(i);
	    	 Element tableElement = (Element) trNodes.item(i);  
	    	 NodeList tdNodes = tableElement.getElementsByTagName("td");
	    	 int cls=0;
	    	 for(int j=0;j<tdNodes.getLength();j++){ 
	    		 if(map.get(cls)!=null){
					  if(map.get(cls)-1>1){//行数大于1
						  map.put(cls, map.get(cls)-1); 
						 
					  }else {
						  map.remove(cls);
					  }
					  if(map.size()>0){
						  cls++;
						  Object[] key=map.keySet().toArray();
						   for (int k = 0; k < key.length; k++) {
							   int object = (Integer) key[k];
							   if(object==cls){
								   cls++;
							   }
						   }
					  }
//					  cls++;  
				  }
	    		 if(mapCls.get(cls)!=null){
					  if(mapCls.get(cls)-1>1){//行数大于1
						  mapCls.put(cls, mapCls.get(cls)-1); 
						  
						
					  }else {
						  mapCls.remove(cls);
					  }
					  if(mapCls.size()>0){
						  cls+=(mapCls.size()+1);
					  }
				  };
				  hssfCell=hssfRow.createCell(cls);
				  Node node =  tdNodes.item(j);
				  hssfCell.setCellValue(node.getTextContent().trim());
				  
				  if(node.getAttributes().getNamedItem("rowspan")!=null&&node.getAttributes().getNamedItem("colspan")!=null){
					   int rowR=Integer.parseInt(node.getAttributes().getNamedItem("rowspan").getTextContent());//横向垮了多少列
					   int clsR=Integer.parseInt(node.getAttributes().getNamedItem("colspan").getTextContent());//纵向垮了多少行
					   CellRangeAddress cellRangeAddres=  new CellRangeAddress(i, i+rowR-1, cls, cls+clsR-1);
					   RegionUtil.setBorderTop(1, cellRangeAddres,hssfSheet , hssfWorkbook);
					   RegionUtil.setBorderBottom(1, cellRangeAddres,hssfSheet , hssfWorkbook);
					   RegionUtil.setBorderLeft(1, cellRangeAddres,hssfSheet , hssfWorkbook);
					   RegionUtil.setBorderRight(1, cellRangeAddres,hssfSheet , hssfWorkbook);
					   hssfSheet.addMergedRegion(new CellRangeAddress(i, i+rowR-1, cls, cls+clsR-1));//第二行 二到三列
					   for (int k = 0; k < rowR; k++) {
						   mapCls.put(j+k, clsR);
					   }
					   cls=cls+clsR-1;
				   }else if(node.getAttributes().getNamedItem("rowspan")!=null){
					   int rowR=Integer.parseInt(node.getAttributes().getNamedItem("rowspan").getTextContent());
					   CellRangeAddress cellRangeAddres= new CellRangeAddress(i, i+rowR-1,j , j);
					   RegionUtil.setBorderTop(1, cellRangeAddres,hssfSheet , hssfWorkbook);
					   RegionUtil.setBorderBottom(1, cellRangeAddres,hssfSheet , hssfWorkbook);
					   RegionUtil.setBorderLeft(1, cellRangeAddres,hssfSheet , hssfWorkbook);
					   RegionUtil.setBorderRight(1, cellRangeAddres,hssfSheet , hssfWorkbook);
					   hssfSheet.addMergedRegion( new CellRangeAddress(i, i+rowR-1,j , j));//第二行 二到三列
					   map.put(j, rowR);
				   }else if(node.getAttributes().getNamedItem("colspan")!=null){
					   int clsR=Integer.parseInt(node.getAttributes().getNamedItem("colspan").getTextContent());
					   hssfSheet.addMergedRegion(new CellRangeAddress(i, i, cls, cls+clsR-1));//第二行 二到三列
					   cls=cls+clsR-1;
				   }else{
					   hssfCell.setCellStyle(titleStyle);
				   }
				   cls++;
	    		 
	    	 }
	     }*/

	}
	public static void main(String[] args) {
		String d="99.a";
		System.out.println(isNumeric(d));
	}
	public static boolean isNumeric(String str){ 
//	    Pattern pattern = Pattern.compile("^\\-?\\+?[0-9]+(.[0-9]*)?$"); 
	    Pattern pattern = Pattern.compile("^[-]*[0-9]*[.]?[0-9]*$"); 
	    return pattern.matcher(str).matches();    
	}

}
