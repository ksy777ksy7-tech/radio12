import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    // --- СТАНЦИИ ---

    @Test
    void shouldSetValidStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetInvalidStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(15);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldGoToNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.next();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    void shouldLoopNextFromMaxToZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldGoToPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.prev();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void shouldLoopPrevFromZeroToMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    // --- НОВЫЕ ТЕСТЫ ДЛЯ КОЛИЧЕСТВА СТАНЦИЙ ---

    @Test
    void shouldRespectCustomStationsCount() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(29);
        assertEquals(29, radio.getCurrentStation());
    }

    @Test
    void shouldLoopWithCustomStationsCount() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(29);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationAboveCustomLimit() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(30);
        assertEquals(0, radio.getCurrentStation());
    }

    // --- ГРОМКОСТЬ ---

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    void shouldNotIncreaseAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseBelowZero() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
}