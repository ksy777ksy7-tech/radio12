public class Radio {

    private int currentStation;
    private int currentVolume;
    private int stationsCount;

    public Radio() {
        this.stationsCount = 10;
    }

    public Radio(int stationsCount) {
        if (stationsCount > 0) {
            this.stationsCount = stationsCount;
        } else {
            this.stationsCount = 10;
        }
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int newStation) {
        if (newStation >= 0 && newStation < stationsCount) {
            currentStation = newStation;
        }
    }

    public void next() {
        if (currentStation == stationsCount - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = stationsCount - 1;
        } else {
            currentStation--;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newVolume) {
        if (newVolume >= 0 && newVolume <= 100) {
            currentVolume = newVolume;
        }
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}