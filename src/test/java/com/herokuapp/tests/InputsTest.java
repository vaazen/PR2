package com.herokuapp.tests;

import com.herokuapp.pages.InputsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputsTest extends BaseTest {

    private InputsPage page;

    @BeforeEach
    void openPage() {
        page = new InputsPage(driver);
        page.open(BASE_URL);
    }

    @Test
    @DisplayName("Числовое значение вводится корректно")
    void numericValue_isAccepted() {
        page.enterValue("123");
        assertEquals("123", page.getValue());
    }

    /**
     * Негативный сценарий: поле type=number должно игнорировать буквы.
     */
    @Test
    @DisplayName("Нецифровое значение не вводится (поле type=number)")
    void nonNumericValue_isRejected() {
        page.enterValue("abc");
        assertEquals("", page.getValue(), "Поле типа number не должно принимать буквы");
    }

    @Test
    @DisplayName("Keys.ARROW_UP увеличивает значение на 1")
    void arrowUp_incrementsValue() {
        page.enterValue("5");
        page.pressArrowUp();

        assertEquals("6", page.getValue());
    }

    @Test
    @DisplayName("Keys.ARROW_DOWN уменьшает значение на 1")
    void arrowDown_decrementsValue() {
        page.enterValue("5");
        page.pressArrowDown();

        assertEquals("4", page.getValue());
    }
}
