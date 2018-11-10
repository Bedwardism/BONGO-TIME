package com.team254.frc2018.controlboard;

import com.team254.frc2018.Constants;
import edu.wpi.first.wpilibj.Joystick;

public class MainDriveControlBoard implements IDriveControlBoard {
    private static MainDriveControlBoard mInstance = null;

    public static MainDriveControlBoard getInstance() {
        if (mInstance == null) {
            mInstance = new MainDriveControlBoard();
        }
        return mInstance;
    }

    private final Joystick mBongo;

    private MainDriveControlBoard() {
        mBongo = new Joystick(3);
    }

    @Override
    public double getThrottle() {
        if(mBongo.getRawButton(4))
        	return 0.7;
        if(mBongo.getRawButton(3))
        	return -0.7;
    	return 0;
    }

    @Override
    public double getTurn() {
    	if(mBongo.getRawButton(1))
        	return 0.6;
        if(mBongo.getRawButton(2))
        	return -0.6;
    	return 0;
    	//return -mTurnStick.getRawAxis(0);
    }

    @Override
    public boolean getPoopyShoot() {
        return mBongo.getRawButton(10);
    	//return mThrottleStick.getRawButton(1);
    }

    @Override
    public boolean getQuickTurn() {
         return ((mBongo.getRawButton(1) || mBongo.getRawButton(2)) && (!mBongo.getRawButton(3) && !mBongo.getRawButton(4)));
    	//return mTurnStick.getRawButton(1);
    }

    @Override
    public boolean getOpenJaw() {
        return false;
    	//return mTurnStick.getRawButton(2);
    }

    @Override
    public boolean getShoot() {
        return false;
    	//return mThrottleStick.getRawButton(2);
    }
}
