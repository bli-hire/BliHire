package com.empatkepala.view;

import com.empatkepala.entity.CV;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Ryan Bagus Susilo on 8/8/2017.
 */
public class MyPdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<CV> cvs = (List<CV>) model.get("cv");

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(60);
        table.setWidths(new int[] {1, 3});

        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase("Id CV"));
        hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Nama"));
        hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("UID"));
        hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(hcell);

        for (CV cv : cvs) {

            PdfPCell cell;

            cell = new PdfPCell(new Phrase(Long.toString(cv.getIdCV()), headFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(cv.getFullName(), headFont));
            cell.setPaddingLeft(5);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(String.valueOf(cv.getUid()), headFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingRight(5);
            table.addCell(cell);
        }

        document.add(table);
    }
}
