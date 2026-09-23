package com.herokuapp.tests;

import com.herokuapp.pages.NotificationMessagesPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * /notification_message — текст нотификации случайный при каждом клике.
 * Известные варианты (см. подсказку в задании про нестабильность):
 */
class NotificationMessagesTest extends BaseTest {

    private static final List<String> ALLOWED_MESSAGES = List.of(
            "Action unsuccessful, please try again",
            "Action unsuccessfully please try again",
            "Action successful"
    );

    private NotificationMessagesPage page;

    @BeforeEach
    void openPage() {
        page = new NotificationMessagesPage(driver, wait);
        page.open(BASE_URL);
    }

    @Test
    @DisplayName("После клика появляется нотификация с одним из ожидаемых текстов")
    void clickingLink_showsExpectedNotification() {
        page.clickHere();
        String text = page.getNotificationText();

        assertFalse(text.isBlank(), "Текст нотификации не должен быть пустым");
        boolean matchesAny = ALLOWED_MESSAGES.stream().anyMatch(text::contains);
        assertTrue(matchesAny,
                "Текст нотификации не совпал ни с одним из ожидаемых вариантов. Получено: '" + text + "'");
    }
}
