package controller.device;

import com.android.ddmlib.AndroidDebugBridge;
import com.android.ddmlib.IDevice;

public class AndroidFinder {
    private static final int MAX_WAIT_DEVICE_TIME = 5000;
    private static final String SERIAL_NUMBER = "379656517d84";

    public IDevice findAndroid(){
        AndroidDebugBridge.init(false);

        AndroidDebugBridge debugBridge = AndroidDebugBridge.createBridge("/usr/local/bin/adb", true);
        if (debugBridge == null) {
            System.err.println("Invalid ADB location.");
            System.exit(1);
        }
        NewDeviceListener listener = new NewDeviceListener(SERIAL_NUMBER);
        AndroidDebugBridge.addDeviceChangeListener(listener);
        IDevice device = listener.waitForDevice(MAX_WAIT_DEVICE_TIME);
        AndroidDebugBridge.removeDeviceChangeListener(listener);
        if (device == null) {
            return null;
        } else {
            return device;
        }
    }
}








