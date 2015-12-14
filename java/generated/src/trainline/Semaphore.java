package trainline;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Semaphore {
    private Object semaphoreStatus = trainline.quotes.GreenQuote.getInstance();
    private Object sensorStatus = trainline.quotes.FreeQuote.getInstance();
    private Boolean semaphoreAvailable = true;
    private Boolean sensorAvailable = true;

    public Semaphore() {
    }

    public Object getColor() {
        return semaphoreStatus;
    }

    public Boolean isAvailable() {
        return semaphoreAvailable;
    }

    public Object getSensor() {
        return sensorStatus;
    }

    public Boolean isSensorAvailable() {
        return sensorAvailable;
    }

    public void setAvailability(final Boolean availability) {
        semaphoreAvailable = availability;
    }

    public void setSensorAvailability(final Boolean availability) {
        sensorAvailable = availability;
    }

    public void setColor(final Object color) {
        semaphoreStatus = color;
    }

    public void setColorAndSensor(final Object color, final Object sensor) {
        Object atomicTmp_1 = color;
        Object atomicTmp_2 = sensor;
        semaphoreStatus = atomicTmp_1;
        sensorStatus = atomicTmp_2;
    }

    public String toString() {
        return "Semaphore{" + "semaphoreStatus := " +
        Utils.toString(semaphoreStatus) + ", sensorStatus := " +
        Utils.toString(sensorStatus) + ", semaphoreAvailable := " +
        Utils.toString(semaphoreAvailable) + ", sensorAvailable := " +
        Utils.toString(sensorAvailable) + "}";
    }
}
