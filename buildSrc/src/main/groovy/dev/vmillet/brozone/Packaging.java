package dev.vmillet.brozone;

import com.badlogicgames.packr.Packr;
import com.badlogicgames.packr.PackrConfig;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Packaging extends DefaultTask {
    String os;

    @TaskAction
    public void execute() {
        File buildDir = getProject().getBuildDir();
        String windowsPackerFolder = "win-out";
        PackrConfig config = new PackrConfig();
        config.platform = PackrConfig.Platform.Windows64;
        config.jdk = getProp();
        config.executable = "simple-castle";
        config.classpath = List.of(buildDir + "/libs/simple-castle.jar");
        config.removePlatformLibs = config.classpath;
        config.mainClass = "castle.core.app.ServerLauncher";
        config.minimizeJre = "hard";
        config.vmArgs = new ArrayList<>();
        config.outDir = new File(buildDir, "libs/" + windowsPackerFolder);
        config.useZgcIfSupportedOs = true;
        try {
            new Packr().pack(config);
        } catch (Exception e) {

        }
    }


    private String getProp() {
        InputStream inputStream = Packaging.class.getClassLoader().getResourceAsStream("config.properties");
        Properties props = new Properties();
        try {
            props.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return props.getProperty("winJdkPath");
    }

}
