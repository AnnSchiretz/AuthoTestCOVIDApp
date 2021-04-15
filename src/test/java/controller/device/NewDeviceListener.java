package controller.device;

import com.android.ddmlib.AndroidDebugBridge;
import com.android.ddmlib.IDevice;

class NewDeviceListener implements AndroidDebugBridge.IDeviceChangeListener {

    private IDevice mDevice;
    private String mSerial;

    public NewDeviceListener(String serial) {
        mSerial = serial;
    }

    public void deviceChanged(IDevice device, int changeMask) {
    }

    public void deviceConnected(IDevice device) {
        if (mSerial == null) {
            setDevice(device);
        } else if (mSerial.equals(device.getSerialNumber())) {
            setDevice(device);
        }
    }

    private synchronized void setDevice(IDevice device) {
        mDevice = device;
        notify();
    }

    public void deviceDisconnected(IDevice device) {
    }

    public IDevice waitForDevice(long waitTime) {
        synchronized(this) {
            if (mDevice == null) {
                try {
                    wait(waitTime);
                } catch (InterruptedException e) {
                    System.out.println("Waiting for device interrupted");
                }
            }
        }
        return mDevice;
    }
}