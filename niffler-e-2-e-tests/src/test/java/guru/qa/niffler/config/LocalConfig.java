package guru.qa.niffler.config;

public enum LocalConfig implements Config{
    instance;

    @Override
    public String frontUrl() {
        return "http://127.0.0.1:9000/";
    }

    @Override
    public String spendUrl() {
        return "http://127.0.0.1:8093/";
    }
}
