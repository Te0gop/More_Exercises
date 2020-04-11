package task_04;

public class Smartphone implements Browsing, Calling {


    @Override
    public String browsing(String url) {
        if(url.matches(".*\\d+.*")) {
            throw new IllegalArgumentException("Invalid URL!");
        }
        return "Browsing: " + url + "!";
    }

    @Override
    public String calling(String phone) {
        if(!phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid number!");
        }
        return "Calling... " + phone;
    }
}
