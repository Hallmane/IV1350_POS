package IV1350_seminar_3.view;

import IV1350_seminar_3.model.TotalRevenueObserver;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TotalRevenueFileOutput implements TotalRevenueObserver {
    float totalRevenue;
    private PrintWriter logStream;

    public TotalRevenueFileOutput() {
        try {
            logStream = new PrintWriter(new FileWriter("Revenue.txt"), true);
        }
        catch (IOException inputError) {
            System.out.println("Could not log.\t");
            inputError.printStackTrace();
        }
    }
    @Override
    public void newPayment(float totalPayment) {
        totalRevenue += totalPayment;
        logStream.println("Total revenue " + totalRevenue);
    }
}
