package com.herokuapp.tests;

import com.herokuapp.pages.TyposPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Страница /typos специально нестабильна: при обновлении страницы иногда
 * "the" случайно подменяется на опечатку. Проверяем структуру текста,
 * а не жёстко зафиксированную строку — как советует задание.
 */
class TyposTest extends BaseTest {

    private TyposPage page;

    @BeforeEach
    void openPage() {
        page = new TyposPage(driver);
        page.open(BASE_URL);
    }

    @Test
    @DisplayName("Параграф не пустой и содержит ожидаемую тему текста")
    void paragraph_isNotEmpty() {
        String text = page.getParagraphText();

        assertFalse(text.isBlank(), "Параграф не должен быть пустым");
        assertTrue(text.toLowerCase().contains("paragraph"),
                "Текст должен быть про 'paragraph', независимо от случайной опечатки");
    }

    @Test
    @DisplayName("Длина параграфа стабильна (опечатка не должна ломать структуру текста)")
    void paragraph_hasStableLength() {
        String text = page.getParagraphText();

        // Опечатка — это замена одной буквы в одном слове, длина не должна сильно скакать.
        assertTrue(text.length() > 100, "Текст параграфа должен быть содержательным, не обрезанным");
    }
}
