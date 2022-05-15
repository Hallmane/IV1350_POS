package IV1350_seminar_3.startup;

import IV1350_seminar_3.controller.Controller;
import IV1350_seminar_3.view.View;

/**
 * starts the application
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        View view = new View(controller);
        view.predeterminedView();
    }
}
