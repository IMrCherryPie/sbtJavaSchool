import sun.plugin2.main.server.Plugin;

public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) {
        //todo
        return (Plugin) new PluginManager("");
    }

}
