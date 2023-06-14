package webauto.factoryBrowser;

public class FactoryBrowser {
    public static IBrowser make(String type, String connectionString){
        IBrowser browser;
        switch (type.toLowerCase()){
            case "chrome":
                browser = new Chrome(connectionString);
                break;
            case "firefox":
                browser = new Firefox();
                break;
            case "edge":
                browser = new Edge();
                break;
            default:
                browser = new Chrome(connectionString);
                break;
        }
        return browser;
    }
}
