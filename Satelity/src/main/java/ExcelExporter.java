import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelExporter {

    public void exportToExcel(SatelliteMap satelliteMap, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Satellites");

        int rownum = 0;
        Row headerRow = sheet.createRow(rownum++);
        createHeaderRow(headerRow);

        List<Satellite> sortedSatellites = satelliteMap.getSortedSatellites();

        for (Satellite satellite : sortedSatellites) {
            Row row = sheet.createRow(rownum++);
            fillSatelliteRow(satellite, row);
        }

        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }

        finally {
            workbook.close();
        }
    }

    private void createHeaderRow(Row row) {
        String[] headers = {
                "Name", "Status", "Position", "NORAD", "COSPAR Number", "Operator", "Launch Date",
                "Launch Site", "Launch Vehicle", "Launch Mass", "Dry Mass", "Manufacturer", "Model Bus",
                "Orbit", "Expected Lifetime", "Channels Num", "Free To Air Only", "Declination Now",
                "Declination Max", "Update Date", "Band"
        };

        for (int i = 0; i < headers.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(headers[i]);
        }
    }

    private void fillSatelliteRow(Satellite satellite, Row row) {
        row.createCell(0).setCellValue(satellite.getName());
        row.createCell(1).setCellValue(satellite.getStatus());
        row.createCell(2).setCellValue(satellite.getPosition());
        row.createCell(3).setCellValue(satellite.getNorad());
        row.createCell(4).setCellValue(satellite.getCosparNum());
        row.createCell(5).setCellValue(satellite.getOperator());
        row.createCell(6).setCellValue(satellite.getLaunchDate());
        row.createCell(7).setCellValue(satellite.getLaunchSite());
        row.createCell(8).setCellValue(satellite.getLaunchVehicle());
        row.createCell(9).setCellValue(satellite.getLaunchMass());
        row.createCell(10).setCellValue(satellite.getDryMass());
        row.createCell(11).setCellValue(satellite.getManufacturer());
        row.createCell(12).setCellValue(satellite.getModelBus());
        row.createCell(13).setCellValue(satellite.getOrbit());
        row.createCell(14).setCellValue(satellite.getExpectedLifetime());
        row.createCell(15).setCellValue(satellite.getChannelsNum());
        row.createCell(16).setCellValue(satellite.getFreeToAirOnly());
        row.createCell(17).setCellValue(satellite.getDeclinationNow());
        row.createCell(18).setCellValue(satellite.getDeclinationMax());
        row.createCell(19).setCellValue(satellite.getUpdateDate());
        row.createCell(20).setCellValue(satellite.getBand());
    }

}
