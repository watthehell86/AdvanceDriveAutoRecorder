package org.usfirst.frc.team6544.robot.subsystems;

import java.io.Serializable;

public class Movements implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5773712956282741777L;
	private byte leftSpeeds;
    private byte rightSpeeds;
    private int duration;
   

    public Movements(byte leftSpeeds, byte rightSpeeds, int duration) {
    	this.leftSpeeds = leftSpeeds;
    	this.rightSpeeds = rightSpeeds;
    	this.duration = duration;
    }

    @Override
    public String toString() {
        return "L"+leftSpeeds+"R"+rightSpeeds+"D"+duration;
    }
}
