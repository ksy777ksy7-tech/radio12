import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

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
    void shouldLoopNextFrom9To0() {
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
    void shouldLoopPrevFrom0To9() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);

        radio.prev();

        assertEquals(9, radio.getCurrentStation());
    }

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