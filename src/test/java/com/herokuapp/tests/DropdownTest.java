package com.herokuapp.tests;

import com.herokuapp.pages.DropdownPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DropdownTest extends BaseTest {

    private DropdownPage page;

    @BeforeEach
    void openPage() {
        page = new DropdownPage(driver);
        page.open(BASE_URL);
    }

    @Test
    @DisplayName("Все опции дропдауна присутствуют")
    void allOptions_arePresent() {
        List<String> options = page.getAllOptionsText();

        assertTrue(options.contains("Option 1"), "Должна быть опция 'Option 1'");
        assertTrue(options.contains("Option 2"), "Должна быть опция 'Option 2'");
    }

    @Test
    @DisplayName("Выбор Option 1 -> он становится выбранным")
    void selectFirstOption_becomesSelected() {
        page.selectByIndex(1); // индекс 0 — заглушка "Please select an option"

        assertEquals("Option 1", page.getSelectedOptionText());
    }

    @Test
    @DisplayName("Выбор Option 2 -> он становится выбранным")
    void selectSecondOption_becomesSelected() {
        page.selectByIndex(2);

        assertEquals("Option 2", page.getSelectedOptionText());
    }
}
