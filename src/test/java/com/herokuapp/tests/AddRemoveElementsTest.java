package com.herokuapp.tests;

import com.herokuapp.pages.AddRemoveElementsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddRemoveElementsTest extends BaseTest {

    private AddRemoveElementsPage page;

    @BeforeEach
    void openPage() {
        page = new AddRemoveElementsPage(driver, wait);
        page.open(BASE_URL);
    }

    @Test
    @DisplayName("Изначально кнопок Delete нет")
    void initially_noDeleteButtons() {
        assertEquals(0, page.getDeleteButtonsCount(), "На старте не должно быть ни одной кнопки Delete");
    }

    @Test
    @DisplayName("Добавление 2 элементов -> появляется 2 кнопки Delete")
    void addTwoElements_showsTwoDeleteButtons() {
        page.clickAddElement();
        page.clickAddElement();

        assertEquals(2, page.getDeleteButtonsCount(), "После двух кликов Add Element должно быть 2 кнопки Delete");
    }

    @Test
    @DisplayName("Удаление элемента уменьшает количество кнопок Delete")
    void deleteElement_decreasesCount() {
        page.clickAddElement();
        page.clickAddElement();
        page.clickFirstDelete();

        assertEquals(1, page.getDeleteButtonsCount(), "После удаления одного элемента должна остаться 1 кнопка Delete");
    }
}
