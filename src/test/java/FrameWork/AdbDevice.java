package FrameWork;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Pradeep Singh
 *
 */

public class AdbDevice {
    public volatile static AdbDevice DeviceINSTANCE = null;
    List<String> deviceList = new ArrayList<String>();
    public volatile  static BlockingQueue<String> FreeListDeviceQue = new LinkedBlockingQueue<String>();
    public volatile static BlockingQueue<String> UsedAccountDevice = new LinkedBlockingQueue<String>();

    public static synchronized AdbDevice getDeviceInstance() throws IOException {
        if (DeviceINSTANCE == null) {
            DeviceINSTANCE = new AdbDevice();
            DeviceINSTANCE.populateDevice();
        }
        return DeviceINSTANCE;
    }

    public void populateDevice() throws IOException {
        Framework frameWork = new Framework();
        //List<AccountData> deviceList = frameWork.getDataList(AccountData.class,"Devices");

        try{
            String cmd;
            System.out.println("Searching for Device");
            if(CommonConstant.Local_run()){
                cmd = "/home/cd-user/Android/Sdk/platform-tools/adb devices";
                System.out.println("Path for devices Get - "+cmd);
            }else {
                cmd = "/home/qa/Android/Sdk/platform-tools/adb devices";
                System.out.println("Path for devices Get - "+cmd);
            }
           // String cmd = "/home/cd-user/Android/Sdk/platform-tools/adb devices";
         //   String cmd = "/home/qa/Android/Sdk/platform-tools/adb devices";
           // String cmd = "/home/user/Android/Sdk/platform-tools/adb devices";

            Paths.get(cmd);

           //Process process = processBuilder.start();
            //File dir=new File("C:\\Program Files (x86)\\Android\\android-sdk\\platform-tools");
           // File fir = new File("/home/cd/Android/Sdk/platform-tools");
            //Process process = Runtime.getRuntime().exec("adb devices");

           // String ADB=System.getenv("$ANDROID_HOME");
           // String cmd1 = "/platform-tools/adb devices";
            Runtime run = Runtime.getRuntime();
            Process process = run.exec(cmd);
            process.waitFor();

            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;



            Pattern pattern = Pattern.compile("^([a-zA-Z0-9:.\\-]+)(\\s+)(device)");
            Matcher matcher;
            System.out.println(pattern);
            while ((line = in.readLine()) != null)
            {
                System.out.println(line);
                if (line.matches(pattern.pattern()))
                {
                    matcher = pattern.matcher(line);
                    if (matcher.find())
                        System.out.println(matcher.group(1));
                    deviceList.add(matcher.group(1));
                }
            }
            for(String deviceid:deviceList)
            {
               Runtime run1=Runtime.getRuntime();
//                String cmd1 ="adb -s "+ deviceid +" shell am start -n 'io.appium.unlock/.Unlock' -a 'android.intent.action.MAIN' -c 'android.intent.category.LAUNCHER' -f '0x10200000'";
//                Process process1 = run1.getRuntime().exec(cmd1);
//                process1.waitFor();
                run1.getRuntime().exec("adb -s "+deviceid+" shell am start -n 'io.appium.unlock/.Unlock' -a 'android.intent.action.MAIN' -c 'android.intent.category.LAUNCHER' -f '0x10200000'");
            }


        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        FreeListDeviceQue = new LinkedBlockingQueue<String>();
        for (String device : deviceList)
        {
            FreeListDeviceQue.add(device);

        }

    }
    public void clearDeviceLock() throws InterruptedException {
        String Device = UsedAccountDevice.take();

        FreeListDeviceQue.put(Device);


    }

    public String getDevice() throws InterruptedException {
        String device = FreeListDeviceQue.take();
        UsedAccountDevice.put(device);
        // UsedLoginque.put(login);

        return device;
    }
    public static void StopEmulator() throws IOException {
        try{
            System.out.println("System will Start Emulator");
            String cmd = "/home/qa/Android/Sdk/emulator";
            File file = new File(cmd);
            ProcessBuilder builder = new ProcessBuilder();
            builder.directory(file);
            builder.command("sh", "-c","adb emu kill");
            Process process = builder.start();

            // System.out.println("System will Start Emulator");
            // String cmd = "/home/qa/Android/Sdk/emulator";
            // File file = new File(cmd);
            ProcessBuilder builder1 = new ProcessBuilder();
            builder1.directory(file);
            builder1.command("sh", "-c","./emulator -avd Pixel_XL_API_34 -wipe-data");
            builder.start();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void StartEmulator() throws IOException {
        try{
            System.out.println("System will Start Emulator");
            String cmd = "/home/qa/Android/Sdk/emulator";
            File file = new File(cmd);
            ProcessBuilder builder = new ProcessBuilder();
            builder.directory(file);
            builder.command("sh", "-c","adb emu kill");
            Process process = builder.start();
            Thread.sleep(5000);
            // System.out.println("System will Start Emulator");
            // String cmd = "/home/qa/Android/Sdk/emulator";
            // File file = new File(cmd);
            ProcessBuilder builder1 = new ProcessBuilder();
            builder1.directory(file);
            builder1.command("sh", "-c","./emulator -avd Pixel_XL_API_34 -wipe-data");
            builder1.start();

            Thread.sleep(60000);
            // Paths.get(cmd);
            //  Runtime run = Runtime.getRuntime();
            // Process process = run.exec(cmd);
            //process.waitFor();
            //     Runtime run1=Runtime.getRuntime();
            //   run1.getRuntime().exec("emulator -avd Pixel_XL_API_34");
        } catch (Exception e )
        {
            e.printStackTrace();
        }
    }

}





