package input;

public class PriceListRowParser implements UploadRowParser<PriceListUploadRow> {

    private final static int MANUFACTURER_NAME_IDX = 0;
    private final static int MODEL_NAME_IDX = 1;
    private final static int FEATURES_IDX = 2;
    private final static int DETAIL_NUMBER_IDX = 3;
    private final static int DETAIL_NAME_IDX = 4;
    private final static int QUANTITY_IDX = 5;
    private final static int MIN_QUANTITY_IDX = 6;
    private final static int PRICE_IDX = 7;

    private final static String FILTER_INTEGER_REGEXP = "[\\s\\u00A0]";

    @Override
    public PriceListUploadRow parse(FileRow row) throws ParseRowException {
        boolean parseErrorFound = false;
        PriceListUploadRow uploadRow = new PriceListUploadRow();

        if (!row.isFieldEmpty(MANUFACTURER_NAME_IDX)) {
            uploadRow.setManufacturerName(row
                    .getStringFieldValue(MANUFACTURER_NAME_IDX));
        }

        if (!row.isFieldEmpty(MODEL_NAME_IDX)) {
            uploadRow.setModel(row.getStringFieldValue(MODEL_NAME_IDX));
        }

        if (!row.isFieldEmpty(FEATURES_IDX)) {
            uploadRow.setFeature(row.getStringFieldValue(FEATURES_IDX));
        }

        if (!row.isFieldEmpty(DETAIL_NUMBER_IDX)) {
            uploadRow.setDetailNumber(row
                    .getStringFieldValue(DETAIL_NUMBER_IDX));
        }

        if (!row.isFieldEmpty(DETAIL_NAME_IDX)) {
            uploadRow.setDetailName(row.getStringFieldValue(DETAIL_NAME_IDX));
        }

        if (!row.isFieldEmpty(QUANTITY_IDX)) {
            String quantity = row.getStringFieldValue(QUANTITY_IDX).replaceAll(FILTER_INTEGER_REGEXP, "");
            try {
                Integer.parseInt(quantity);
            } catch (NumberFormatException nfe) {
                parseErrorFound = true;
            }
            uploadRow.setQuantity(quantity);
        } else {
            uploadRow.setQuantity("0");
        }

        if (!row.isFieldEmpty(MIN_QUANTITY_IDX)) {
            String minQuantity = row.getStringFieldValue(MIN_QUANTITY_IDX).replaceAll(FILTER_INTEGER_REGEXP, "");
            try {
                if (Integer.parseInt(minQuantity) > 0) {
                    uploadRow.setMinimalQuantity(minQuantity);
                }
            } catch (NumberFormatException nfe) {
                parseErrorFound = true;
                uploadRow.setMinimalQuantity(minQuantity);
            }
        }

        if (!row.isFieldEmpty(PRICE_IDX)) {
            try {
                uploadRow.setPrice(row.getDoubleFieldValue(PRICE_IDX));
            } catch (NumberFormatException nfe) {
                parseErrorFound = true;
            }
        } else {
            uploadRow.setPrice(0.0);
        }

        if (parseErrorFound) {
            throw new ParseRowException(uploadRow);
        }

        return uploadRow;
    }
}
