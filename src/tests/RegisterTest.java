package tests;

import IV1350_seminar_3.model.Register;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTest {
    Register register;

    @BeforeEach
    void setUp() {
        register = new Register();
    }

    @AfterEach
    void tearDown() {
        register = null;
    }

    @Test
    void depositPayment() {
        float amountBefore = register.getBalance();
        float amountToAdd = 13;
        float expectedAmount = amountBefore + amountToAdd;

        register.depositPayment(amountToAdd);
        assertEquals(expectedAmount,register.getBalance());
    }
}