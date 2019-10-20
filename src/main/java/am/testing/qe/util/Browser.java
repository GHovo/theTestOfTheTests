package am.testing.qe.util;

import java.util.HashMap;
import java.util.Map;

public enum Browser {
    SAFARI  (),
    CHROME  (),
    FIREFOX ();

    private Map<OS, String> path = new HashMap<>();

    private void init(){
        System.out.println(this.name());
        switch (this){
            case FIREFOX:
                path.put(OS.WINDOWS, "");
                path.put(OS.MAC, "/Applications/Firefox.app/Contents/MacOS/firefox");
                path.put(OS.LINUX, "/usr/bin/firefox");
                break;
            case SAFARI:
                path.put(OS.WINDOWS, "");
                path.put(OS.MAC, "");
                path.put(OS.LINUX, "");
                break;
            case CHROME:
                path.put(OS.WINDOWS, "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
                path.put(OS.MAC, "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
                path.put(OS.LINUX, "/usr/bin/google-chrome");
                break;
            default:
                throw new RuntimeException("TODO");

        }

    }

    public String getPath() {
        init();
        return  path.get(OS.current());
    }
}
