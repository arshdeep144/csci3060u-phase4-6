/*
    The ErrorLog class is responsible for any errors that may occur when processing transactions.

    The two types of errors that it records are failed constraint errors and fatal errors.

    Failed constraint errors should log a message containing the type and description of the failed transaction.
    Fatal errors should log a message containing the type and description of the file that caused the failure.
*/

public class ErrorLog {
    public String errorType;
    public String description;
    public String transaction;
    public String file;

    /**
     * The printError() method will print an appropriate error message depending on the
     * type of error.
     * @param errorType - the type of error(failed constraint or file)
     * @param description - description of the nature of error
     * @param transaction - the transaction that caused the error
     * @param file - the file that caused the error
     */
    public static void printError(String errorType, String description, String transaction, String file) {
        if (errorType == "file"){
            System.out.println(file + " caused an error. " + description);
        }

        else if (errorType == "constraint") {
            System.out.println(transaction + " caused an error. " + description);
        }
    }
}
