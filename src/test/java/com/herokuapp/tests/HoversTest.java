package com.herokuapp.tests;

import com.herokuapp.pages.HoversPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HoversTest extends BaseTest {

    private HoversPage page;

    @BeforeEach
    void openPage() {
        page = new HoversPage(driver);
        page.open(BASE_URL);
    }

    @Test
    @DisplayName("На странице отображаются 3 профиля")
    void threeFiguresDisplayed() {
        assertEquals(3, page.getFiguresCount());
    }

    @ParameterizedTest(name = "Профиль #{0}: hover -> имя -> клик по ссылке -> нет 404")
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("Цепочка: наведение -> проверка имени -> клик по View profile -> проверка отсутствия 404")
    void hoverShowsNameAndLinkWorks(int index) throws Exception {
        page.hoverOverFigure(index);

        String expectedName = "name: user" + (index + 1);
        assertEquals(expectedName, page.getCaptionName(index),
                "После наведения должно отображаться корректное имя профиля");

        String profileUrl = page.getProfileLinkHref(index);

        // Проверяем реальный HTTP-статус ссылки (без открытия отдельной вкладки браузером)
        int statusCode = getHttpStatus(profileUrl);

        // ВНИМАНИЕ: по факту эти ссылки на сайте the-internet.herokuapp.com ведут на
        // несуществующие страницы /users/N и реально отдают 404 — это подтверждённое
        // поведение сайта, а не ошибка теста. Тест написан по заданию ("проверить,
        // что нет 404") и должен ПАДАТЬ — так документируется реальный баг/особенность сайта.
        assertTrue(statusCode != HttpURLConnection.HTTP_NOT_FOUND,
                "Ссылка 'View profile' профиля #" + (index + 1) + " ведёт на несуществующую страницу (404): " + profileUrl);
    }

    private int getHttpStatus(String urlString) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(urlString).openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int code = connection.getResponseCode();
        connection.disconnect();
        return code;
    }
}
