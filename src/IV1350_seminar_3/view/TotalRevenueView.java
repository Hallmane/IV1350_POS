package IV1350_seminar_3.view;

import IV1350_seminar_3.model.TotalRevenueObserver;

public class TotalRevenueView implements TotalRevenueObserver {
    private float totalRevenue;

    public TotalRevenueView() {
       totalRevenue = 0;
    }

    @Override
    public void newPayment(float payment){
        totalRevenue += payment;
        toDisplay(totalRevenue);
    }

    private void toDisplay(float total) {
        System.out.println("\n[TOTAL REVENUE] \nTotal revenue: " + total + ".\n_________________________\n");
    }
}
