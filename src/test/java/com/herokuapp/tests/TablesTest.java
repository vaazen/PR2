package com.herokuapp.tests;

import com.herokuapp.pages.TablesPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Проверка содержимого нескольких ячеек первой таблицы на /tables.
 * Известные (стабильные) данные первой таблицы на the-internet.herokuapp.com:
 * Row1: Smith / John / jsmith@gmail.com / $50.00
 * Row2: Bach / Frank / fbach@yahoo.com / $51.00
 * Row3: Doe / John / jdoe@hotmail.com / $100.00
 */
class TablesTest extends BaseTest {

    private TablesPage page;

    @BeforeEach
    void openPage() {
        page = new TablesPage(driver);
        page.open(BASE_URL);
    }

    @Test
    @DisplayName("Первая ячейка первой строки — Last Name = Smith")
    void firstCell_isSmith() {
        assertEquals("Smith", page.getCellText(1, 1, 1));
    }

    @Test
    @DisplayName("Вторая ячейка первой строки — First Name = John")
    void secondCell_isJohn() {
        assertEquals("John", page.getCellText(1, 1, 2));
    }

    @Test
    @DisplayName("Первая ячейка третьей строки — Last Name = Doe")
    void thirdRowFirstCell_isDoe() {
        assertEquals("Doe", page.getCellText(1, 3, 1));
    }

    @Test
    @DisplayName("Email второй строки корректен")
    void secondRowEmail_isCorrect() {
        assertEquals("fbach@yahoo.com", page.getCellText(1, 2, 3));
    }
}
