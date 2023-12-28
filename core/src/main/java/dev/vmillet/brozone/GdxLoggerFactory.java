package dev.vmillet.brozone;

import com.badlogic.gdx.Gdx;

public final class GdxLoggerFactory {
    private GdxLoggerFactory() {}

    public static GdxLogger getLogger(Class<?> clazz) {
        final String className = clazz.getName();
        final int size = 3;
        StringBuilder processedPath = new StringBuilder();
        String[] packages = className.split("\\.");

        for (int i = 0; i < size; i++) {
            String packageName = packages[i];
            processedPath.append(packageName.charAt(0));

            if (i < packages.length - 1) {
                processedPath.append('.');
            }
        }
        processedPath.append(className.substring(className.indexOf(packages[size])));

        return new GdxLogger(processedPath.toString());
    }
}
