package client.MVC.roll;

import client.MVC.base.*;

/**
 * Interface for the roll result view, which displays the result of a roll
 */
public interface IRollResultView extends IOverlayView {

    /**
     * Sets the value rolled by the user
     *
     * @param value The value rolled by the user
     */
    void setRollValue(int value);

}

