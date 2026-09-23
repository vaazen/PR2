package com.herokuapp.tests;

import com.herokuapp.pages.CheckboxesPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckboxesTest extends BaseTest {

    private CheckboxesPage page;

    @BeforeEach
    void openPage() {
        page = new CheckboxesPage(driver);
        page.open(BASE_URL);
    }

    @Test
    @DisplayName("Первый чекбокс изначально unchecked")
    void firstCheckbox_initiallyUnchecked() {
        assertFalse(page.isChecked(0), "Первый чекбокс должен быть изначально снят");
    }

    @Test
    @DisplayName("Второй чекбокс изначально checked")
    void secondCheckbox_initiallyChecked() {
        assertTrue(page.isChecked(1), "Второй чекбокс должен быть изначально отмечен");
    }

    @Test
    @DisplayName("Отметить первый чекбокс -> он становится checked")
    void checkFirstCheckbox_becomesChecked() {
        page.setChecked(0, true);
        assertTrue(page.isChecked(0), "После клика первый чекбокс должен стать отмеченным");
    }

    @Test
    @DisplayName("Снять второй чекбокс -> он становится unchecked")
    void uncheckSecondCheckbox_becomesUnchecked() {
        page.setChecked(1, false);
        assertFalse(page.isChecked(1), "После клика второй чекбокс должен стать снятым");
    }
}
