package ru.niceone.youtube.tests

class AutoProp {
    public static void set() {
        String os = System.getProperty("os.name")

        if (os.startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", "c:/bin/selenium/chromedriver.exe");
        }
    }
}
