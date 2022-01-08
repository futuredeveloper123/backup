package kr.co.dajsoft.view;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;
import kr.co.dajsoft.domain.Item;
public class ExcelView extends AbstractXlsView {
	@Override
	protected void buildExcelDocument(Map<String,Object> model, Workbook workbook,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Item> list = (List<Item>)model.get("list");
		
		Sheet sheet = workbook.createSheet();
		
		workbook.setSheetName(0,"ITEM");
		
		Row firstRow = sheet.createRow(0);
		Cell cell = firstRow.createCell(0);
		cell.setCellValue("상품명 ");
		
		cell=firstRow.createCell(1);
		cell.setCellValue("설명");
		
		cell=firstRow.createCell(2);
		cell.setCellValue("가격" );
		
		//데이터출력
		int idx = 1; 
		for(Item item: list) {
			
			Row row= sheet.createRow(idx);
			
			cell = row.createCell(0);
			cell.setCellValue(item.getItemname());
			cell = row.createCell(1);
			cell.setCellValue(item.getDescription());
			cell = row.createCell(2);
			cell.setCellValue(item.getPrice());
			
			idx=idx+1;
		}
	}


}
	


